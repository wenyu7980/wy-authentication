package com.wenyu7980.authentication.permission.internal.handler.impl;

import com.wenyu7980.authentication.api.domain.PermissionInternal;
import com.wenyu7980.authentication.permission.convert.PermissionInternalConverter;
import com.wenyu7980.authentication.permission.entity.PermissionEntity;
import com.wenyu7980.authentication.permission.internal.handler.PermissionInternalQueryHandler;
import com.wenyu7980.data.jpa.query.AbstractQueryListHandler;
import org.springframework.stereotype.Component;

/**
 *
 * @author wenyu
 */
@Component
public class PermissionInternalQueryHandlerImpl extends AbstractQueryListHandler<PermissionEntity, PermissionInternal>
  implements PermissionInternalQueryHandler {

    @Override
    public PermissionInternal convertList(PermissionEntity entity) {
        PermissionInternal permissionInternal = new PermissionInternal();
        PermissionInternalConverter.convert(entity, permissionInternal);
        return permissionInternal;
    }
}
