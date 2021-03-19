package com.wenyu7980.authentication.api.service;

import com.wenyu7980.authentication.api.domain.UserInternalAdd;
import com.wenyu7980.authentication.api.domain.UserPermissionMatrixInternal;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    /**
     * 查询用户的权限
     * @param id
     * @return
     */
    @GetMapping("{id}/matrix")
    UserPermissionMatrixInternal getMatrix(@PathVariable("id") String id);
}
