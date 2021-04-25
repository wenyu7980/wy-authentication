package com.wenyu7980.authentication.common.feign;

import com.wenyu7980.authentication.api.constant.RequesterType;
import com.wenyu7980.authentication.api.domain.PermissionInternalManipulation;
import com.wenyu7980.authentication.common.AuthPermissionService;
import com.wenyu7980.authentication.common.AuthRequestPermission;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;
import java.util.stream.Collectors;

/**
 *
 * @author wenyu
 */
public class AuthenticationServiceFeign implements AuthPermissionService {
    @Autowired
    private PermissionStarterService internalService;

    @Override
    public void manipulation(String serviceName, Collection<AuthRequestPermission> permissions) {
        internalService.manipulation(serviceName, permissions.stream().map(
          p -> new PermissionInternalManipulation(p.getMethod(), p.getPath(), p.getName(), p.getResource(),
            RequesterType.valueOf(p.getRequesterType().name()), p.isRequired(), p.isCheck()))
          .collect(Collectors.toSet()));
    }
}
