package com.wenyu7980.authentication.api.service;

import com.wenyu7980.authentication.api.domain.PermissionInternal;
import com.wenyu7980.authentication.api.domain.PermissionInternalManipulation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Set;

/**
 *
 * @author wenyu
 */
@FeignClient(name = "wy-authentication", path = "internal/permissions", contextId = "wy-auth-permissions")
public interface PermissionInternalService {
    /**
     * 维护
     * @param serviceName
     * @param permissions
     */
    @PutMapping
    void manipulation(@RequestParam("serviceName") String serviceName,
      @RequestBody Set<PermissionInternalManipulation> permissions);

    /**
     * 查询
     * @param check
     * @return
     */
    @GetMapping("list")
    List<PermissionInternal> getList(@RequestParam(value = "check", required = false) Boolean check);
}
