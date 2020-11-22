package com.wenyu7980.authentication.permission.rest.internal;

import com.wenyu7980.authentication.api.domain.PermissionInternalManipulation;
import com.wenyu7980.authentication.api.service.PermissionInternalService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import java.util.Collection;

/**
 *
 * @author wenyu
 */
@ApiIgnore
@RequestMapping("internal/permissions")
@RestController
public class PermissionInternalController implements PermissionInternalService {
    @PostMapping
    @Override
    public void manipulation(@RequestBody Collection<PermissionInternalManipulation> permissions) {
        System.out.println(permissions);
    }
}
