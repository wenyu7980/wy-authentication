package com.wenyu7980.authentication.role.admin.handler.impl;

import com.wenyu7980.authentication.permission.service.PermissionService;
import com.wenyu7980.authentication.role.admin.domain.RoleAdminManipulation;
import com.wenyu7980.authentication.role.admin.handler.RoleAdminHandler;
import com.wenyu7980.authentication.role.convert.RoleConverter;
import com.wenyu7980.authentication.role.domain.Role;
import com.wenyu7980.authentication.role.entity.RoleEntity;
import com.wenyu7980.authentication.role.service.RoleService;
import com.wenyu7980.common.exceptions.code409.ExistedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;
import java.util.stream.Collectors;

/**
 *
 * @author wenyu
 */
@Component
public class RoleAdminHandlerImpl implements RoleAdminHandler {
    @Autowired
    private RoleService roleService;
    @Autowired
    private PermissionService permissionService;

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = RuntimeException.class)
    public Role add(RoleAdminManipulation role) {
        if (roleService.existsByName(role.getName())) {
            throw new ExistedException("角色{0}已存在");
        }
        RoleEntity entity = new RoleEntity(role.getName(), role.getPermissions().stream()
          .map(p -> permissionService.findBYKey(getServiceName(p.getPath()), p.getMethod(), getPath(p.getPath())))
          .collect(Collectors.toSet()));
        return RoleConverter.convert(roleService.save(entity));
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = RuntimeException.class)
    public Role modify(String id, RoleAdminManipulation role) {
        RoleEntity entity = roleService.findById(id);
        if (!Objects.equals(entity.getName(), role.getName()) && roleService.existsByName(role.getName())) {
            throw new ExistedException("角色{0}已存在");
        }
        entity.modify(role.getName(), role.getPermissions().stream()
          .map(p -> permissionService.findBYKey(getServiceName(p.getPath()), p.getMethod(), getPath(p.getPath())))
          .collect(Collectors.toSet()));
        return RoleConverter.convert(roleService.save(entity));
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
