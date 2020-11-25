package com.wenyu7980.authentication;

import com.wenyu7980.authentication.api.constant.RequesterType;
import com.wenyu7980.authentication.api.domain.PermissionInternalManipulation;
import com.wenyu7980.authentication.common.AuthPermissionService;
import com.wenyu7980.authentication.common.AuthRequestPermission;
import com.wenyu7980.authentication.permission.rest.internal.handler.PermissionInternalHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

/**
 *
 * @author wenyu
 */
@Service
public class AuthPermissionServiceImpl implements AuthPermissionService {
    @Autowired
    private PermissionInternalHandler permissionInternalHandler;

    @Override
    public void manipulation(String applicationName, Collection<AuthRequestPermission> permissions) {
        permissionInternalHandler.manipulation(applicationName, permissions.stream().map(
          p -> new PermissionInternalManipulation(p.getMethod(), p.getPath(), p.getName(),
            RequesterType.valueOf(p.getRequesterType().name()), p.isRequired(), p.isCheck()))
          .collect(Collectors.toList()));
    }
}
