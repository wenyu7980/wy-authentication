package com.wenyu7980.authentication.permission.internal.controller;

import com.wenyu7980.authentication.api.domain.Permission;
import com.wenyu7980.authentication.api.domain.PermissionManipulation;
import com.wenyu7980.authentication.api.service.PermissionFacade;
import com.wenyu7980.authentication.api.service.PermissionStarterFacade;
import com.wenyu7980.authentication.permission.internal.handler.PermissionFacadeHandler;
import com.wenyu7980.authentication.permission.internal.handler.PermissionFacadeQueryHandler;
import com.wenyu7980.query.QueryLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;
import java.util.Set;

/**
 *
 * @author wenyu
 */
@ApiIgnore
@RequestMapping("permissions")
@RestController
public class PermissionFacadeController implements PermissionFacade, PermissionStarterFacade {
    @Autowired
    private PermissionFacadeHandler internalHandler;
    @Autowired
    private PermissionFacadeQueryHandler queryHandler;

    @PutMapping
    @Override
    public void manipulation(@RequestParam String serviceName,
      @RequestBody Set<PermissionManipulation> permissions) {
        internalHandler.manipulation(serviceName, permissions);
    }

    @GetMapping("list")
    @Override
    public List<Permission> getList() {
        return queryHandler.getList(QueryLogic.and());
    }
}
