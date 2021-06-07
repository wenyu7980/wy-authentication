package com.wenyu7980.authentication.role.management.controller;

import com.wenyu7980.authentication.role.management.domain.RoleManagementListDetail;
import com.wenyu7980.authentication.role.management.domain.RoleManagementPageDetail;
import com.wenyu7980.authentication.role.management.handler.RoleManagementQueryHandler;
import com.wenyu7980.data.jpa.query.PageBody;
import com.wenyu7980.query.QueryLogic;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 *
 * @author wenyu
 */
@Api(tags = "角色管理(管理端)")
@RestController
@RequestMapping("management/roles")
public class RoleManagementQueryController {
    @Autowired
    private RoleManagementQueryHandler queryHandler;

    @ApiOperation("列表查询")
    @GetMapping()
    public PageBody<RoleManagementPageDetail> getPage(@ApiParam("页码") @RequestParam(defaultValue = "0") int page,
      @ApiParam("页大小") @RequestParam(defaultValue = "10") int size) {
        return queryHandler.getPage(QueryLogic.and(), PageRequest.of(page, size));
    }

    @ApiOperation("列表查询")
    @GetMapping("list")
    public List<RoleManagementListDetail> getList() {
        return queryHandler.getList(QueryLogic.and());
    }
}
