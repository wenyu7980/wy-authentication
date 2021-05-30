package com.wenyu7980.authentication.api.service;

import com.wenyu7980.authentication.api.domain.Permission;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 *
 * @author wenyu
 */
@FeignClient(name = "wy-authentication", path = "permissions", contextId = "wy-auth-permissions")
public interface PermissionFacade {
    /**
     * 查询
     * @return
     */
    @GetMapping("list")
    List<Permission> getList();
}
