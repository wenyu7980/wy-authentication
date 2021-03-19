package com.wenyu7980.authentication.user.internal.controller;

import com.wenyu7980.authentication.api.domain.UserInternalAdd;
import com.wenyu7980.authentication.api.domain.UserPermissionMatrixInternal;
import com.wenyu7980.authentication.api.service.UserInternalService;
import com.wenyu7980.authentication.user.internal.handler.UserInternalHandler;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author wenyu
 */
@Api(tags = "登录用户")
@RestController
@RequestMapping("internal/users")
public class UserInternalController implements UserInternalService {
    @Autowired
    private UserInternalHandler userInternalHandler;

    @Override
    @PostMapping
    public void add(@RequestBody UserInternalAdd user) {
        userInternalHandler.add(user);
    }

    @Override
    @GetMapping("{id}/matrix")
    public UserPermissionMatrixInternal getMatrix(@PathVariable("id") String id) {
        return userInternalHandler.getMatrix(id);
    }

}
