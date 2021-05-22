package com.wenyu7980.authentication;

import com.wenyu7980.aggregation.EnableWYAggregation;
import com.wenyu7980.auth.request.EnableWYAuthentication;
import com.wenyu7980.common.feign.config.FeignClientConfig;
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
@EnableFeignClients(value = "com.wenyu7980", defaultConfiguration = FeignClientConfig.class)
@EnableWYAuthentication
@EnableWYAggregation
public class AuthenticationApplication {
    public static void main(String[] args) {
        SpringApplication.run(AuthenticationApplication.class, args);
    }
}
