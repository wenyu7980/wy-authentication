package com.wenyu7980.auth.data.annotation;

import com.wenyu7980.auth.data.constant.AuthType;

import java.lang.annotation.*;

/**
 * @author wenyu
 */
@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AuthMeta {
    AuthType value();
}
