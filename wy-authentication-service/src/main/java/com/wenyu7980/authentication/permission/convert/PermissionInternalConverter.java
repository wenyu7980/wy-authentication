package com.wenyu7980.authentication.permission.convert;

import com.wenyu7980.authentication.api.domain.Permission;
import com.wenyu7980.authentication.permission.entity.PermissionEntity;

/**
 *
 * @author wenyu
 */
public class PermissionInternalConverter {
    private PermissionInternalConverter() {
    }

    public static void convert(PermissionEntity entity, Permission permission) {
        permission.setServiceName(entity.getServiceName());
        permission.setCheck(entity.getCheckFlag());
        permission.setMethod(entity.getMethod());
        permission.setPath(entity.getPath());
        permission.setName(entity.getName());
        permission.setRequesterType(entity.getRequesterType());
        permission.setRequired(entity.getRequiredFlag());
        permission.setResource(entity.getResource());
    }

    public static Permission convert(PermissionEntity entity) {
        Permission permission = new Permission();
        convert(entity, permission);
        return permission;
    }
}
