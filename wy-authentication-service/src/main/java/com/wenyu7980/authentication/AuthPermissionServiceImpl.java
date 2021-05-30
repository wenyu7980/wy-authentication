package com.wenyu7980.authentication;

import com.wenyu7980.authentication.api.constant.RequesterType;
import com.wenyu7980.authentication.api.domain.PermissionManipulation;
import com.wenyu7980.authentication.permission.internal.handler.PermissionFacadeHandler;
import com.wenyu7980.auth.request.AuthPermissionService;
import com.wenyu7980.auth.request.AuthRequestPermission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

/**
 *
 * @author wenyu
 */
@Service
@Primary
public class AuthPermissionServiceImpl implements AuthPermissionService {
    @Autowired
    private PermissionFacadeHandler permissionFacadeHandler;

    @Override
    public void manipulation(String serviceName, Collection<AuthRequestPermission> permissions) {
        permissionFacadeHandler.manipulation(serviceName, permissions.stream().map(
          p -> new PermissionManipulation(p.getMethod(), p.getPath(), p.getName(), p.getResource(),
            RequesterType.valueOf(p.getRequesterType().name()), p.isRequired(), p.isCheck()))
          .collect(Collectors.toList()));
    }
}
