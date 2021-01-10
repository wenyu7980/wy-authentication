package com.wenyu7980.authentication.api.service;

import com.wenyu7980.authentication.api.domain.UserInternalAdd;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 *
 * @author wenyu
 */
@FeignClient(name = "wy-authentication", path = "internal/users", contextId = "wy-auth-users")
public interface UserInternalService {
    /**
     * 创建用户
     * @param user
     */
    @PostMapping
    void add(@RequestBody UserInternalAdd user);
}
