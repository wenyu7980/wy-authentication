package com.wenyu7980.authentication.user.rest.internal.controller;

import com.wenyu7980.authentication.api.domain.UserInternalAdd;
import com.wenyu7980.authentication.api.service.UserInternalService;
import com.wenyu7980.authentication.user.rest.internal.handler.UserInternalHandler;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public void add(UserInternalAdd user) {
        userInternalHandler.add(user);
    }
}
