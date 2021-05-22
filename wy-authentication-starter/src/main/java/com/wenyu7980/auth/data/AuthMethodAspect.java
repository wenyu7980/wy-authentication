package com.wenyu7980.auth.data;

import com.wenyu7980.auth.data.annotation.AuthData;
import com.wenyu7980.auth.data.annotation.AuthMeta;
import com.wenyu7980.auth.data.annotation.AuthResource;
import com.wenyu7980.auth.data.constant.AuthType;
import com.wenyu7980.authentication.context.model.ContextInfo;
import com.wenyu7980.authentication.context.model.ContextUtils;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Aspect
@Component
@EnableAspectJAutoProxy
public class AuthMethodAspect {
    @Pointcut("@annotation(com.wenyu7980.auth.data.annotation.AuthMethod)")
    public void authMethod() {
    }

    @AfterReturning(pointcut = "authMethod()", returning = "result")
    public void handler(Object result) throws IllegalAccessException {
        if (ContextUtils.isPresent() && ContextUtils.isSystemScript()) {
            return;
        }
        if (!check(result)) {
            throw new RuntimeException("hahah");
        }
    }

    private boolean check(Object value) throws IllegalAccessException {
        if (value == null) {
            return false;
        }
        if (Collection.class.isAssignableFrom(value.getClass())) {
            // 处理集合类型
            Collection<?> collection = (Collection<?>) value;
            for (Object v : collection) {
                if (check(v)) {
                    return true;
                }
            }
        } else {
            // 可访问的部门
            Set<String> departments = new HashSet<>();
            ContextInfo contextInfo = ContextUtils.get();
            departments.addAll(contextInfo.getPermissionDepartments().get(contextInfo.getDepartments()));
            for (Field field : value.getClass().getDeclaredFields()) {
                field.setAccessible(true);
                AuthResource resource = field.getAnnotation(AuthResource.class);
                if (resource != null) {
                    Object v = field.get(value);
                    if (v != null) {
                        departments.addAll(contextInfo.getDepartments(resource.value(), String.valueOf(v)));
                    }
                }
            }
            for (Field field : value.getClass().getDeclaredFields()) {
                field.setAccessible(true);
                AuthMeta meta = field.getAnnotation(AuthMeta.class);
                Object v = field.get(value);
                if (meta != null) {
                    AuthType type = meta.value();
                    if (type == AuthType.U && Objects.equals(v, contextInfo.getUserId())) {
                        return true;
                    } else if (type == AuthType.D && departments.contains(v)) {
                        return true;
                    }
                }
                if (field.getAnnotation(AuthData.class) != null && check(v)) {
                    return true;
                }
            }
        }
        return false;
    }
}
