package com.wenyu7980.authentication.permission.rest.internal.controller;

import com.wenyu7980.authentication.api.domain.Permission;
import com.wenyu7980.authentication.api.domain.PermissionInternalManipulation;
import com.wenyu7980.authentication.api.service.PermissionInternalService;
import com.wenyu7980.authentication.permission.rest.internal.handler.PermissionInternalHandler;
import com.wenyu7980.authentication.permission.rest.internal.handler.PermissionInternalQueryHandler;
import com.wenyu7980.query.QueryCompare;
import com.wenyu7980.query.QueryCondition;
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
@RequestMapping("internal/permissions")
@RestController
public class PermissionInternalController implements PermissionInternalService {
    @Autowired
    private PermissionInternalHandler internalHandler;
    @Autowired
    private PermissionInternalQueryHandler queryHandler;

    @PutMapping
    @Override
    public void manipulation(@RequestParam String serviceName,
      @RequestBody Set<PermissionInternalManipulation> permissions) {
        internalHandler.manipulation(serviceName, permissions);
    }

    @GetMapping("list")
    @Override
    public List<Permission> getList(@RequestParam(required = false) Boolean check) {
        return queryHandler.getList(QueryLogic.and(QueryCondition.of("checkFlag", QueryCompare.EQ, check)));
    }
}
