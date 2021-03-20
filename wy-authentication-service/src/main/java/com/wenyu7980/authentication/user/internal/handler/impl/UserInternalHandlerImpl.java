package com.wenyu7980.authentication.user.internal.handler.impl;

import com.wenyu7980.authentication.api.domain.PermissionMatrixInternal;
import com.wenyu7980.authentication.api.domain.ResourceMatrixInternal;
import com.wenyu7980.authentication.api.domain.UserInternalAdd;
import com.wenyu7980.authentication.api.domain.UserPermissionMatrixInternal;
import com.wenyu7980.authentication.role.entity.RoleEntity;
import com.wenyu7980.authentication.user.entity.UserEntity;
import com.wenyu7980.authentication.user.internal.handler.UserInternalHandler;
import com.wenyu7980.authentication.user.service.UserService;
import com.wenyu7980.common.exceptions.code409.ExistedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 *
 * @author wenyu
 */
@Component
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = RuntimeException.class)
public class UserInternalHandlerImpl implements UserInternalHandler {
    @Autowired
    private UserService userService;

    @Override
    public void add(UserInternalAdd user) {
        Optional<UserEntity> optional = userService.findOptionalByUsername(user.getUsername());
        if (optional.isPresent()) {
            throw new ExistedException("用户{0}已存在", user.getUsername());
        }
        String salt = UUID.randomUUID().toString();
        UserEntity entity = new UserEntity(user.getId(), user.getUsername(), user.getMobile(), user.getPassword(),
          salt);
        userService.save(entity);
    }

    @Override
    public UserPermissionMatrixInternal getMatrix(String id) {
        UserPermissionMatrixInternal matrix = new UserPermissionMatrixInternal();
        List<PermissionMatrixInternal> permissions = new ArrayList<>();
        List<ResourceMatrixInternal> resources = new ArrayList<>();
        UserEntity entity = userService.findById(id);
        for (RoleEntity role : entity.getRoles()) {
            // 权限-部门矩阵
            permissions.addAll(role.getPermissionMatrices().stream().map(
              p -> new PermissionMatrixInternal(p.getPermission().getMethod(), p.getPermission().getPath(),
                p.getPermission().getServiceName(), p.getPermission().getResource(), p.getDepartmentId()))
              .collect(Collectors.toList()));
            // 资源-权限-部门矩阵
            resources.addAll(role.getResourceMatrices().stream().map(
              r -> new ResourceMatrixInternal(r.getPermission().getMethod(), r.getPermission().getPath(),
                r.getPermission().getServiceName(), r.getDepartmentId(), r.getResourceName(), r.getResourceId()))
              .collect(Collectors.toList()));
        }
        matrix.setPermissions(permissions);
        matrix.setResources(resources);
        return matrix;
    }

}
