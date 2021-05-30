package com.wenyu7980.authentication.api.service;

import com.wenyu7980.authentication.api.domain.AuthLogin;
import com.wenyu7980.authentication.api.domain.AuthLoginResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 *
 * @author wenyu
 */
@FeignClient(name = "wy-authentication", contextId = "wy-auth-login")
public interface LoginFacade {

    @PostMapping("login")
    AuthLoginResult login(@RequestBody AuthLogin login);
}
