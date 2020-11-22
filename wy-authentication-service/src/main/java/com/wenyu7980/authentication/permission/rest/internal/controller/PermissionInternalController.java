package com.wenyu7980.authentication.permission.rest.internal.controller;

import com.wenyu7980.authentication.api.domain.PermissionInternalManipulation;
import com.wenyu7980.authentication.api.service.PermissionInternalService;
import com.wenyu7980.authentication.permission.rest.internal.handler.PermissionInternalHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.Set;

/**
 *
 * @author wenyu
 */
@ApiIgnore
@RequestMapping("internal/permissions")
@RestController
public class PermissionInternalController implements PermissionInternalService {
    @Autowired
    private PermissionInternalHandler internalHandler;

    @PutMapping
    @Override
    public void manipulation(@RequestParam String applicationName,
      @RequestBody Set<PermissionInternalManipulation> permissions) {
        internalHandler.manipulation(applicationName, permissions);
    }
}
