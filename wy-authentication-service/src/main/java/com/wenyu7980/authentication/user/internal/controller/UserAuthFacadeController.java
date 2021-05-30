package com.wenyu7980.authentication.user.internal.controller;

import com.wenyu7980.authentication.api.domain.AuthUserAdd;
import com.wenyu7980.authentication.api.service.UserAuthFacade;
import com.wenyu7980.authentication.user.internal.handler.UserFacadeHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

/**
 *
 * @author wenyu
 */
@ApiIgnore
@RestController
@RequestMapping("users")
public class UserAuthFacadeController implements UserAuthFacade {
    @Autowired
    private UserFacadeHandler userFacadeHandler;

    @Override
    @PostMapping
    public void add(@RequestBody AuthUserAdd user) {
        userFacadeHandler.add(user);
    }
}
