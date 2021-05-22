package com.wenyu7980.auth.data.annotation;

import java.lang.annotation.*;

/**
 * @author wenyu
 */
@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AuthResource {
    String value();
}
