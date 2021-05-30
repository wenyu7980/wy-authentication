package com.wenyu7980.authentication.api.service;

import com.wenyu7980.authentication.api.domain.AuthUserAdd;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 *
 * @author wenyu
 * name: wy-authentication
 * path: internal
 */
@FeignClient(name = "wy-authentication", path = "users", contextId = "wy-auth-users")
public interface UserAuthFacade {
    /**
     * 创建用户
     * @param user
     */
    @PostMapping
    void add(@RequestBody AuthUserAdd user);
}
