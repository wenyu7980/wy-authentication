package com.wenyu7980.authentication.common;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.context.annotation.ImportAware;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.StandardAnnotationMetadata;
import org.springframework.core.type.filter.AnnotationTypeFilter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.text.MessageFormat;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 *
 * @author wenyu
 */
public class AuthenticationStarter implements CommandLineRunner, ImportAware {
    private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationStarter.class);
    @Autowired
    private AuthPermissionService authPermissionService;
    @Value("${spring.application.name:''}")
    private String applicationName;
    private String basePackage;

    @Override
    public void run(String... args) throws Exception {
        if (Objects.isNull(this.basePackage)) {
            LOGGER.warn("没有设定basePackage");
            return;
        }
        ClassPathScanningCandidateComponentProvider provider = new ClassPathScanningCandidateComponentProvider(false);
        // 筛选RestController
        provider.addIncludeFilter(new AnnotationTypeFilter(RestController.class));
        final Set<BeanDefinition> definitions = provider.findCandidateComponents(this.basePackage);
        Set<AuthRequestPermission> permissions = new HashSet<>();
        for (BeanDefinition definition : definitions) {
            final Class<?> clazz = Class.forName(definition.getBeanClassName());
            // 请求
            String controllerPath = "";
            RequestMapping requestMapping = clazz.getAnnotation(RequestMapping.class);
            if (Objects.nonNull(requestMapping)) {
                // 将类上的RequestMapping的path取出
                controllerPath = this.getPath(requestMapping.value(), requestMapping.path());
            }
            // swagger api
            String controllerName = "";
            Api api = clazz.getAnnotation(Api.class);
            if (Objects.nonNull(api) && api.tags().length > 0) {
                controllerName = api.tags()[0];
            }
            // auth request
            AuthRequesterType controllerRequestType = AuthRequesterType.DETERMINE;
            boolean controllerCheck = true;
            boolean controllerRequired = true;
            AuthRequest authRequest = clazz.getAnnotation(AuthRequest.class);
            if (Objects.nonNull(authRequest)) {
                controllerRequestType = authRequest.requesterType();
                controllerCheck = authRequest.check();
                controllerRequired = authRequest.required();
            }
            // controller类中所有方法
            for (Method method : clazz.getDeclaredMethods()) {
                String methodMethod = null;
                String methodName = controllerName;
                StringBuilder methodPath = new StringBuilder();
                methodPath.append(controllerPath);
                for (Annotation annotation : method.getAnnotations()) {
                    if (annotation instanceof RequestMapping) {
                        RequestMapping mapping = (RequestMapping) annotation;
                        methodPath.append(getPath(mapping.value(), mapping.path()));
                        methodMethod = mapping.method()[0].name();
                    } else if (null != annotation.annotationType().getAnnotation(RequestMapping.class)) {
                        Method value = annotation.getClass().getMethod("value");
                        Method path = annotation.getClass().getMethod("path");
                        methodMethod = annotation.annotationType().getAnnotation(RequestMapping.class).method()[0]
                          .toString();
                        methodPath
                          .append(getPath((String[]) value.invoke(annotation), (String[]) path.invoke(annotation)));
                    } else {
                        continue;
                    }
                    ApiOperation operation = method.getAnnotation(ApiOperation.class);
                    if (Objects.nonNull(operation)) {
                        methodName = methodName + operation.value();
                    }
                    AuthRequest methodRequest = method.getAnnotation(AuthRequest.class);
                    boolean methodRequired = controllerRequired;
                    boolean methodCheck = controllerCheck;
                    AuthRequesterType methodRequesterType = controllerRequestType;
                    if (Objects.nonNull(methodRequest)) {
                        methodRequired = methodRequest.required();
                        methodCheck = methodRequest.check();
                        methodRequesterType = methodRequest.requesterType() == AuthRequesterType.DETERMINE ?
                          methodRequesterType :
                          methodRequest.requesterType();
                    }
                    String path = handlerPath(methodPath.toString());
                    if (methodRequesterType == AuthRequesterType.DETERMINE) {
                        if (path.startsWith("/admin/")) {
                            methodRequesterType = AuthRequesterType.ADMIN;
                        } else if (path.startsWith("/internal/")) {
                            methodRequesterType = AuthRequesterType.INTERNAL;
                        } else if (path.startsWith("/client/")) {
                            methodRequesterType = AuthRequesterType.CLIENT;
                        } else if (path.startsWith("/common/")) {
                            methodRequesterType = AuthRequesterType.COMMON;
                        } else {
                            throw new RuntimeException(
                              MessageFormat.format("路径前缀不符合默认规则，请设置{0}的{1}的AuthRequest", clazz, method));
                        }
                    }
                    AuthRequestPermission permission = new AuthRequestPermission(methodMethod, path, methodName,
                      methodRequesterType, methodRequired, methodCheck);
                    permissions.add(permission);
                    LOGGER.debug("REST请求:{}", permission);
                }
            }
        }
        this.authPermissionService.manipulation(this.applicationName, permissions);
        LOGGER.info("REST请求共{}个", permissions.size());
    }

    private String getPath(String[] value, String[] path) {
        StringBuilder builder = new StringBuilder();
        for (String p : value) {
            builder.append("/" + p);
        }
        for (String p : path) {
            builder.append("/" + p);
        }
        return builder.toString();
    }

    private String handlerPath(String path) {
        return path.replaceAll("\\{[^{]*\\}", "*");
    }

    @Override
    public void setImportMetadata(AnnotationMetadata annotationMetadata) {
        StandardAnnotationMetadata metadata = (StandardAnnotationMetadata) annotationMetadata;
        Map<String, Object> attributes = metadata.getAnnotationAttributes(EnableWYAuthentication.class.getName());
        this.basePackage = attributes.get("value").toString();
        if ("".equals(basePackage)) {
            this.basePackage = metadata.getIntrospectedClass().getPackage().getName();
        }
        if (!"".equals(attributes.getOrDefault("name", ""))) {
            this.applicationName = attributes.get("name").toString();
        }
    }
}
