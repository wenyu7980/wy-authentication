package com.wenyu7980.authentication;

import com.wenyu7980.authentication.common.EnableWYAuthentication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *
 * @author wenyu
 */
@SpringBootApplication
@EnableWYAuthentication("com.wenyu7980.authentication")
public class AuthenticationApplication {
    public static void main(String[] args) {
        SpringApplication.run(AuthenticationApplication.class, args);
    }
}
