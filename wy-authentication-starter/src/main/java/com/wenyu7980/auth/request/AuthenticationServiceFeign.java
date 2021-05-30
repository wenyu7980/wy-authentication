package com.wenyu7980.auth.request;

import com.wenyu7980.authentication.api.constant.RequesterType;
import com.wenyu7980.authentication.api.domain.PermissionManipulation;
import com.wenyu7980.auth.request.feign.PermissionStarterService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;
import java.util.stream.Collectors;

/**
 *
 * @author wenyu
 */
public class AuthenticationServiceFeign implements AuthPermissionService {
    @Autowired
    private PermissionStarterService permissionStarterService;

    @Override
    public void manipulation(String serviceName, Collection<AuthRequestPermission> permissions) {
        permissionStarterService.manipulation(serviceName, permissions.stream().map(
          p -> new PermissionManipulation(p.getMethod(), p.getPath(), p.getName(), p.getResource(),
            RequesterType.valueOf(p.getRequesterType().name()), p.isRequired(), p.isCheck()))
          .collect(Collectors.toSet()));
    }
}
