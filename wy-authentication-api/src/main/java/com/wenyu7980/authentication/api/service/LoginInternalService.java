package com.wenyu7980.authentication.api.service;

import com.wenyu7980.authentication.api.domain.LoginInternal;
import com.wenyu7980.authentication.api.domain.LoginResultInternal;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 *
 * @author wenyu
 */
@FeignClient(name = "wy-authentication", path = "internal", contextId = "wy-auth-login")
public interface LoginInternalService {

    @PostMapping("login")
    LoginResultInternal login(@RequestBody LoginInternal login);
}
