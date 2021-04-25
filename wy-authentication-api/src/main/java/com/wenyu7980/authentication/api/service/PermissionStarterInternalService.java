package com.wenyu7980.authentication.api.service;

import com.wenyu7980.authentication.api.domain.PermissionInternalManipulation;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Set;

/**
 *
 * @author wenyu
 * name: wy-authentication
 * path: internal
 */
public interface PermissionStarterInternalService {
    /**
     * 维护
     * @param serviceName
     * @param permissions
     */
    @PutMapping("permissions")
    void manipulation(@RequestParam("serviceName") String serviceName,
      @RequestBody Set<PermissionInternalManipulation> permissions);
}
