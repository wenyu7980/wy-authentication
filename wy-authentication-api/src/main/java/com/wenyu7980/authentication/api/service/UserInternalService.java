package com.wenyu7980.authentication.api.service;

import com.wenyu7980.authentication.api.domain.MatrixInternal;
import com.wenyu7980.authentication.api.domain.PermissionInternal;
import com.wenyu7980.authentication.api.domain.UserInternalAdd;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

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
    @GetMapping("{id}/permissions")
    List<PermissionInternal> getPermissions(@PathVariable("id") String id);

    /**
     * 获取矩阵
     * @param id
     * @return
     */
    @GetMapping("{id}/matrices")
    List<MatrixInternal> getMatrices(@PathVariable("id") String id);
}
