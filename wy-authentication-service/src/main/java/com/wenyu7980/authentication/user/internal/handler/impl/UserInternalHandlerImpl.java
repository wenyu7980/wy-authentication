package com.wenyu7980.authentication.user.internal.handler.impl;

import com.wenyu7980.authentication.api.domain.MatrixInternal;
import com.wenyu7980.authentication.api.domain.PermissionInternal;
import com.wenyu7980.authentication.api.domain.UserInternalAdd;
import com.wenyu7980.authentication.permission.convert.PermissionInternalConverter;
import com.wenyu7980.authentication.user.entity.UserEntity;
import com.wenyu7980.authentication.user.internal.handler.UserInternalHandler;
import com.wenyu7980.authentication.user.service.UserService;
import com.wenyu7980.common.exceptions.code409.ExistedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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
        UserEntity entity = new UserEntity(user.getId(), user.getUsername(), null, null, user.getPassword(), salt);
        userService.save(entity);
    }

    @Override
    public List<PermissionInternal> getPermissions(String id) {
        UserEntity entity = userService.findById(id);
        return entity.getRoles().stream().flatMap(role -> role.getPermissions().stream())
          .map(PermissionInternalConverter::convert).collect(Collectors.toList());
    }

    @Override
    public List<MatrixInternal> gerMatrices(String id) {
        UserEntity entity = userService.findById(id);
        return entity.getMatrices().stream().map(m -> {
            MatrixInternal matrix = new MatrixInternal();
            matrix.setDepartmentId(m.getDepartmentId());
            matrix.setMethod(m.getPermission().getPath());
            matrix.setPath(m.getPermission().getPath());
            matrix.setResource(m.getPermission().getResource());
            matrix.setServiceName(m.getPermission().getServiceName());
            return matrix;
        }).collect(Collectors.toList());
    }
}
