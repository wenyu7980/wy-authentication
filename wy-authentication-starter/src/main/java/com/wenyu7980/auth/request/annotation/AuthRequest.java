package com.wenyu7980.auth.request.annotation;

import com.wenyu7980.auth.request.constant.AuthRequesterType;

import java.lang.annotation.*;

/**
 * 接口注解
 * |------------------------------------------------------------------------------|
 * |   requesterType   |   required   |   check  |  效果                           |
 * |------------------------------------------------------------------------------|
 * |   INTERNAL        |   -          |   -      |  内部访问不可外部访问              |
 * |   MANAGEMENT      |   true       |   true   |  管理端用户可用，需要校验token和接口 |
 * |   MANAGEMENT      |   true       |   false  |  管理端用户可用，需要校验token      |
 * |   CLIENT          |   true       |   true   |  客户端用户可用，需要校验token和接口 |
 * |   CLIENT          |   true       |   false  |  客户端用户可用，需要校验token      |
 * |   COMMON          |   true       |   -      |  所有端用户可用，需要校验token      |
 * |   COMMON          |   false      |   -      |  所有端用户可用，不需要校验token    |
 * |------------------------------------------------------------------------------|
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
