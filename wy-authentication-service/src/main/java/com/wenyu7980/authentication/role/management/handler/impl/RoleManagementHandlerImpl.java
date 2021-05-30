package com.wenyu7980.authentication.role.management.handler.impl;

import com.wenyu7980.authentication.permission.service.PermissionService;
import com.wenyu7980.authentication.role.convert.RoleConverter;
import com.wenyu7980.authentication.role.domain.Role;
import com.wenyu7980.authentication.role.entity.RoleEntity;
import com.wenyu7980.authentication.role.entity.RolePermissionEntity;
import com.wenyu7980.authentication.role.management.domain.RoleManagementManipulation;
import com.wenyu7980.authentication.role.management.handler.RoleManagementHandler;
import com.wenyu7980.authentication.role.service.RoleService;
import com.wenyu7980.common.exceptions.code409.ExistedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 *
 * @author wenyu
 */
@Component
public class RoleManagementHandlerImpl implements RoleManagementHandler {
    @Autowired
    private RoleService roleService;
    @Autowired
    private PermissionService permissionService;

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = RuntimeException.class)
    public Role add(RoleManagementManipulation role) {
        if (roleService.existsByName(role.getName())) {
            throw new ExistedException("角色{0}已存在");
        }
        RoleEntity entity = new RoleEntity(role.getName(), getPermissions(role.getPermissions()));
        return RoleConverter.convert(roleService.save(entity));
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = RuntimeException.class)
    public Role modify(String id, RoleManagementManipulation role) {
        RoleEntity entity = roleService.findById(id);
        if (!Objects.equals(entity.getName(), role.getName()) && roleService.existsByName(role.getName())) {
            throw new ExistedException("角色{0}已存在");
        }
        entity.modify(role.getName(), getPermissions(role.getPermissions()));
        return RoleConverter.convert(roleService.save(entity));
    }

    private List<RolePermissionEntity> getPermissions(
      Collection<RoleManagementManipulation.RolePermission> permissions) {
        return permissions.stream().map(p -> new RolePermissionEntity(p.getCode(),
          permissionService.findBYKey(getServiceName(p.getPath()), p.getMethod(), getPath(p.getPath())),
          p.getResource(), p.getResourceId(), p.getDepartmentId(), p.isCurrentFlag(), p.isChildFlag()))
          .collect(Collectors.toList());
    }

    private String getServiceName(String path) {
        return path.split("/")[1];
    }

    private String getPath(String path) {
        String[] split = path.split("/");
        String p = "/";
        for (int i = 2; i < split.length; i++) {
            p = p + "/" + split[i];
        }
        return p;
    }
}
