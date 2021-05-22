package com.wenyu7980.auth.request;

import com.wenyu7980.auth.request.feign.PermissionFallbackService;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author wenyu
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import({ AuthenticationServiceFeign.class, PermissionFallbackService.class, AuthenticationStarter.class })
public @interface EnableWYAuthentication {

    /**
     * 扫描目录
     * @return
     */
    String value() default "";

    /**
     * 服务名
     * @return
     */
    String name() default "";
}
