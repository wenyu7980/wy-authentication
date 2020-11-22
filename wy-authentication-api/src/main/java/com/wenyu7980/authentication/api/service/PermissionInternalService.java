package com.wenyu7980.authentication.api.service;

import com.wenyu7980.authentication.api.domain.PermissionInternalManipulation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Collection;

/**
 *
 * @author wenyu
 */
@FeignClient(name = "wy-authentication", path = "internal/permissions")
public interface PermissionInternalService {
    /**
     * 维护
     * @param permissions
     */
    @PostMapping
    void manipulation(@RequestBody Collection<PermissionInternalManipulation> permissions);
}
