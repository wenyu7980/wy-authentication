package com.wenyu7980.authentication.api.service;

import com.wenyu7980.authentication.api.domain.PermissionManipulation;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Set;

/**
 *
 * @author wenyu
 * name: wy-authentication
 */
public interface PermissionStarterFacade {
    /**
     * 维护
     * @param serviceName
     * @param permissions
     */
    @PutMapping("permissions")
    void manipulation(@RequestParam("serviceName") String serviceName,
      @RequestBody Set<PermissionManipulation> permissions);
}
