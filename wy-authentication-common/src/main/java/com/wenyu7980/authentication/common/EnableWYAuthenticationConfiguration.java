package com.wenyu7980.authentication.common;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author wenyu
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(AuthenticationStarter.class)
public @interface EnableWYAuthenticationConfiguration {
    /**
     * basePackage
     * @return
     */
    String value() default "";

    /**
     * 应用名称
     * @return
     */
    String name() default "";
}
