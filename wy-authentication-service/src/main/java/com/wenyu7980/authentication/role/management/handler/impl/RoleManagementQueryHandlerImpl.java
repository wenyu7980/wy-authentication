package com.wenyu7980.authentication.role.management.handler.impl;

import com.wenyu7980.authentication.role.convert.RoleConverter;
import com.wenyu7980.authentication.role.entity.RoleEntity;
import com.wenyu7980.authentication.role.entity.RolePermissionEntity;
import com.wenyu7980.authentication.role.management.domain.RoleManagementDetail;
import com.wenyu7980.authentication.role.management.domain.RoleManagementListDetail;
import com.wenyu7980.authentication.role.management.domain.RoleManagementPageDetail;
import com.wenyu7980.authentication.role.management.domain.RolePermissionManagementListDetail;
import com.wenyu7980.authentication.role.management.handler.RoleManagementQueryHandler;
import com.wenyu7980.authentication.role.service.RoleService;
import com.wenyu7980.data.jpa.query.AbstractQueryHandler;
import com.wenyu7980.organization.aggregation.UserAggregation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class RoleManagementQueryHandlerImpl
  extends AbstractQueryHandler<RoleEntity, RoleManagementListDetail, RoleManagementPageDetail>
  implements RoleManagementQueryHandler {
    @Autowired
    private RoleService roleService;

    @Override
    public RoleManagementListDetail convertList(RoleEntity entity) {
        RoleManagementListDetail detail = new RoleManagementListDetail();
        RoleConverter.convert(entity, detail);
        return detail;
    }

    @Override
    public RoleManagementPageDetail convertPage(RoleEntity entity) {
        RoleManagementPageDetail detail = new RoleManagementPageDetail();
        RoleConverter.convert(entity, detail);
        detail.setCreatedUser(UserAggregation.of(entity.getCreatedUserId()));
        detail.setCreatedDateTime(entity.getCreatedDateTime());
        detail.setUpdatedUser(UserAggregation.of(entity.getCreatedUserId()));
        detail.setUpdatedDateTime(entity.getUpdatedDateTime());
        return detail;
    }

    @Override
    public RoleManagementDetail getDetail(String id) {
        RoleEntity entity = roleService.findById(id);
        RoleManagementDetail detail = new RoleManagementDetail();
        RoleConverter.convert(entity, detail);
        detail.setCreatedUser(UserAggregation.of(entity.getCreatedUserId()));
        detail.setCreatedDateTime(entity.getCreatedDateTime());
        detail.setUpdatedUser(UserAggregation.of(entity.getCreatedUserId()));
        detail.setUpdatedDateTime(entity.getUpdatedDateTime());
        detail.setPermissions(entity.getPermissions().stream().map(this::convert).collect(Collectors.toList()));
        return detail;
    }

    private RolePermissionManagementListDetail convert(RolePermissionEntity entity) {
        RolePermissionManagementListDetail detail = new RolePermissionManagementListDetail();
        detail.setCode(entity.getCode());
        detail.setChildFlag(entity.getChildFlag());
        detail.setCurrentFlag(entity.getCurrentFlag());
        detail.setDepartmentId(entity.getDepartmentId());
        detail.setMethod(entity.getPermission().getMethod());
        detail.setPath(entity.getPermission().getPath());
        detail.setServiceName(entity.getPermission().getServiceName());
        detail.setResource(entity.getResource());
        detail.setResourceId(entity.getResourceId());
        return detail;
    }
}
