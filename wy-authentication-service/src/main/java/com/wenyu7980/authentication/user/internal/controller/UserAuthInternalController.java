package com.wenyu7980.authentication.user.internal.controller;

import com.wenyu7980.authentication.api.domain.UserInternalAdd;
import com.wenyu7980.authentication.api.domain.UserPermissionMatrixInternal;
import com.wenyu7980.authentication.api.service.UserAuthInternalService;
import com.wenyu7980.authentication.user.internal.handler.UserInternalHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

/**
 *
 * @author wenyu
 */
@ApiIgnore
@RestController
@RequestMapping("internal/users")
public class UserAuthInternalController implements UserAuthInternalService {
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
