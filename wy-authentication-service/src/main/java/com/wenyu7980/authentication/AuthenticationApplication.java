package com.wenyu7980.authentication;

import com.wenyu7980.authentication.common.EnableWYAuthentication;
import com.wenyu7980.common.EnableWYCommon;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 *
 * @author wenyu
 */
@SpringBootApplication
@EnableWYAuthentication
@EnableDiscoveryClient
@EnableFeignClients
@EnableWYCommon
public class AuthenticationApplication {
    public static void main(String[] args) {
        SpringApplication.run(AuthenticationApplication.class, args);
    }
}
