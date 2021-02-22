package com.wenyu7980.authentication.role.admin.controller;

import com.wenyu7980.authentication.role.admin.domain.RoleAdminManipulation;
import com.wenyu7980.authentication.role.admin.handler.RoleAdminHandler;
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
@RequestMapping("admin/roles")
public class RoleAdminController {
    @Autowired
    private RoleAdminHandler roleAdminHandler;

    @ApiOperation("创建角色")
    @PostMapping()
    public Role add(@RequestBody @Valid RoleAdminManipulation role) {
        return roleAdminHandler.add(role);
    }

    @ApiOperation("修改角色")
    @PutMapping("{id}")
    public Role modify(@PathVariable("id") String id, @RequestBody @Valid RoleAdminManipulation role) {
        return roleAdminHandler.modify(id, role);
    }
}
