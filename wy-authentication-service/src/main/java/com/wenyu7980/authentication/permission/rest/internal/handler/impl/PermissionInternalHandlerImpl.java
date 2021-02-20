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
    public void manipulation(String serviceName, Collection<PermissionInternalManipulation> permissions) {
        Set<PermissionEntity> entities = permissionService.findByServiceName(serviceName);
        Set<PermissionEntity> permissionSet = new HashSet<>();
        outer:
        for (PermissionInternalManipulation permission : permissions) {
            for (PermissionEntity entity : entities) {
                if (Objects.equals(permission.getMethod(), entity.getMethod()) && Objects
                  .equals(permission.getPath(), entity.getPath())) {
                    entity.modify(permission.getName(), permission.getResource(), permission.getRequesterType(),
                      permission.getRequired(), permission.getCheck());
                    permissionSet.add(entity);
                    continue outer;
                }
            }
            permissionSet.add(
              new PermissionEntity(serviceName, permission.getMethod(), permission.getPath(), permission.getName(),
                permission.getResource(), permission.getRequesterType(), permission.getRequired(),
                permission.getCheck()));
        }
        if (entities.removeAll(permissionSet)) {
            permissionService.delete(entities);
        }
        permissionService.save(permissionSet);
    }
}
