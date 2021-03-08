package com.wenyu7980.authentication.common.feign;

import com.wenyu7980.authentication.common.EnableWYAuthenticationConfiguration;
import org.springframework.context.annotation.Import;
import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.*;

/**
 * @author wenyu
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@EnableWYAuthenticationConfiguration
@Import(AuthenticationServiceFeign.class)
public @interface EnableWYAuthentication {
    @AliasFor(annotation = EnableWYAuthenticationConfiguration.class) String value() default "";

    @AliasFor(annotation = EnableWYAuthenticationConfiguration.class) String name() default "";
}
