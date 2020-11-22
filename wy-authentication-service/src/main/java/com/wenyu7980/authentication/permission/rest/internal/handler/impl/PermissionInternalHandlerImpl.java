package com.wenyu7980.authentication.permission.rest.internal.handler.impl;

import com.wenyu7980.authentication.api.domain.PermissionInternalManipulation;
import com.wenyu7980.authentication.permission.entity.PermissionEntity;
import com.wenyu7980.authentication.permission.rest.internal.handler.PermissionInternalHandler;
import com.wenyu7980.authentication.permission.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 *
 * @author wenyu
 */
@Component
public class PermissionInternalHandlerImpl implements PermissionInternalHandler {
    @Autowired
    private PermissionService permissionService;

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = RuntimeException.class)
    public void manipulation(String applicationName, Collection<PermissionInternalManipulation> permissions) {
        Set<PermissionEntity> entities = permissionService.findByApplicationName(applicationName);
        Set<PermissionEntity> permissionSet = new HashSet<>();
        outer:
        for (PermissionInternalManipulation permission : permissions) {
            for (PermissionEntity entity : entities) {
                if (Objects.equals(permission.getMethod(), entity.getMethod()) && Objects
                  .equals(permission.getPath(), entity.getPath())) {
                    entity.modify(permission.getName(), permission.getRequesterType(), permission.isRequired(),
                      permission.isCheck());
                    permissionSet.add(entity);
                    continue outer;
                }
            }
            permissionSet.add(
              new PermissionEntity(applicationName, permission.getMethod(), permission.getPath(), permission.getName(),
                permission.getRequesterType(), permission.isRequired(), permission.isCheck()));
        }
        if (entities.removeAll(permissionSet)) {
            permissionService.delete(entities);
        }
        permissionService.save(permissionSet);
    }
}
