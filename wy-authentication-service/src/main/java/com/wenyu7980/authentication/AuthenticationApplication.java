package com.wenyu7980.authentication;

import com.wenyu7980.aggregation.EnableWYAggregation;
import com.wenyu7980.authentication.common.EnableWYAuthentication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 *
 * @author wenyu
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients("com.wenyu7980")
@EnableWYAuthentication
@EnableWYAggregation
public class AuthenticationApplication {
    public static void main(String[] args) {
        SpringApplication.run(AuthenticationApplication.class, args);
    }
}
