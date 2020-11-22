package com.wenyu7980.authentication.common.feign;

import com.wenyu7980.authentication.common.EnableWYAuthentication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.*;

/**
 * @author wenyu
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@EnableWYAuthentication("")
@ComponentScan
public @interface EnableWYAuthenticationFeign {
    @AliasFor(annotation = EnableWYAuthentication.class) String value();
}
