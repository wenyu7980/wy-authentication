package com.wenyu7980.authentication.common;

import java.lang.annotation.*;

/**
 * @author wenyu
 */
@Target({ ElementType.METHOD, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AuthRequest {

    /**
     * 是否需要登录
     * 缺省是需要token
     * @return
     */
    boolean required() default true;

    /**
     * 是否需要权限校验
     * @return
     */
    boolean check() default true;

    /**
     * 请求者类型
     * @return
     */
    AuthRequesterType requesterType() default AuthRequesterType.DETERMINE;

    /**
     * 资源名称
     * @return
     */
    String resource() default "";
}
