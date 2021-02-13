package com.wenyu7980.authentication.role.rest.admin;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author wenyu
 */
@Api(tags = "角色管理(管理端)")
@RestController
@RequestMapping("admin/roles")
public class RoleAdminController {
    @ApiOperation("分页查询")
    @GetMapping()
    public List<String> getPage() {
        return new ArrayList<>();
    }
}
