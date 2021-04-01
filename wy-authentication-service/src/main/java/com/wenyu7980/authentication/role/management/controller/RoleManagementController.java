package com.wenyu7980.authentication.role.management.controller;

import com.wenyu7980.authentication.role.management.domain.RoleManagementManipulation;
import com.wenyu7980.authentication.role.management.handler.RoleManagementHandler;
import com.wenyu7980.authentication.role.domain.Role;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 *
 * @author wenyu
 */
@Api(tags = "角色管理(管理端)")
@RestController
@RequestMapping("management/roles")
public class RoleManagementController {
    @Autowired
    private RoleManagementHandler roleManagementHandler;

    @ApiOperation("创建角色")
    @PostMapping()
    public Role add(@RequestBody @Valid RoleManagementManipulation role) {
        return roleManagementHandler.add(role);
    }

    @ApiOperation("修改角色")
    @PutMapping("{id}")
    public Role modify(@PathVariable("id") String id, @RequestBody @Valid RoleManagementManipulation role) {
        return roleManagementHandler.modify(id, role);
    }
}
