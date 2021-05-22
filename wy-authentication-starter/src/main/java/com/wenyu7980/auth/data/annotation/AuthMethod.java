package com.wenyu7980.auth.data.annotation;

import java.lang.annotation.*;

/**
 * @author wenyu
 */
@Target({ ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AuthMethod {
    String value() default "";
}
