package com.wenyu7980.authentication.api.service;

import com.wenyu7980.authentication.api.domain.PermissionInternalManipulation;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Set;

/**
 *
 * @author wenyu
 */
public interface PermissionRestInternalService {
    /**
     * 维护
     * @param serviceName
     * @param permissions
     */
    @PutMapping
    void manipulation(@RequestParam("serviceName") String serviceName,
      @RequestBody Set<PermissionInternalManipulation> permissions);
}
