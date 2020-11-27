package com.wenyu7980.authentication.permission.rest.internal.handler.impl;

import com.wenyu7980.authentication.api.domain.Permission;
import com.wenyu7980.authentication.permission.entity.PermissionEntity;
import com.wenyu7980.authentication.permission.rest.internal.handler.PermissionInternalQueryHandler;
import com.wenyu7980.data.jpa.query.AbstractQueryListHandler;
import org.springframework.stereotype.Component;

/**
 *
 * @author wenyu
 */
@Component
public class PermissionInternalQueryHandlerImpl extends AbstractQueryListHandler<PermissionEntity, Permission>
  implements PermissionInternalQueryHandler {

    @Override
    public Permission convertList(PermissionEntity entity) {
        Permission permission = new Permission();
        permission.setServiceName(entity.getServiceName());
        permission.setCheck(entity.getCheckFlag());
        permission.setMethod(entity.getMethod());
        permission.setPath(entity.getPath());
        permission.setName(entity.getName());
        permission.setRequesterType(entity.getRequesterType());
        permission.setRequired(entity.getRequiredFlag());
        return permission;
    }
}
