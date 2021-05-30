package com.wenyu7980.authentication.permission.internal.handler.impl;

import com.wenyu7980.authentication.api.domain.Permission;
import com.wenyu7980.authentication.permission.convert.PermissionInternalConverter;
import com.wenyu7980.authentication.permission.entity.PermissionEntity;
import com.wenyu7980.authentication.permission.internal.handler.PermissionFacadeQueryHandler;
import com.wenyu7980.data.jpa.query.AbstractQueryListHandler;
import org.springframework.stereotype.Component;

/**
 *
 * @author wenyu
 */
@Component
public class PermissionFacadeQueryHandlerImpl extends AbstractQueryListHandler<PermissionEntity, Permission>
  implements PermissionFacadeQueryHandler {

    @Override
    public Permission convertList(PermissionEntity entity) {
        Permission permission = new Permission();
        PermissionInternalConverter.convert(entity, permission);
        return permission;
    }
}
