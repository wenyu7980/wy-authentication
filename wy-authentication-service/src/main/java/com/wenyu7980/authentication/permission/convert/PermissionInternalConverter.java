package com.wenyu7980.authentication.permission.convert;

import com.wenyu7980.authentication.api.domain.PermissionInternal;
import com.wenyu7980.authentication.permission.entity.PermissionEntity;

/**
 *
 * @author wenyu
 */
public class PermissionInternalConverter {
    private PermissionInternalConverter() {
    }

    public static void convert(PermissionEntity entity, PermissionInternal permission) {
        permission.setServiceName(entity.getServiceName());
        permission.setCheck(entity.getCheckFlag());
        permission.setMethod(entity.getMethod());
        permission.setPath(entity.getPath());
        permission.setName(entity.getName());
        permission.setRequesterType(entity.getRequesterType());
        permission.setRequired(entity.getRequiredFlag());
        permission.setResource(entity.getResource());
    }

    public static PermissionInternal convert(PermissionEntity entity) {
        PermissionInternal permission = new PermissionInternal();
        convert(entity, permission);
        return permission;
    }
}
