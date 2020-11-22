package com.wenyu7980.authentication.api.service;

import com.wenyu7980.authentication.api.domain.PermissionInternalManipulation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Set;

/**
 *
 * @author wenyu
 */
@FeignClient(name = "wy-authentication", path = "internal/permissions")
public interface PermissionInternalService {
    /**
     * 维护
     * @param applicationName
     * @param permissions
     */
    @PutMapping
    void manipulation(@RequestParam("applicationName") String applicationName,
      @RequestBody Set<PermissionInternalManipulation> permissions);
}
