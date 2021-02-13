package com.wenyu7980.authentication.login.rest.internal.controller;

import com.wenyu7980.authentication.api.domain.LoginInternal;
import com.wenyu7980.authentication.api.domain.LoginResultInternal;
import com.wenyu7980.authentication.api.service.LoginInternalService;
import com.wenyu7980.authentication.login.rest.internal.handler.LoginHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author wenyu
 */
@RestController
@RequestMapping("internal")
public class LoginController implements LoginInternalService {
    @Autowired
    private LoginHandler loginHandler;

    @Override
    @PostMapping("login")
    public LoginResultInternal login(@RequestBody LoginInternal login) {
        return loginHandler.login(login);
    }

}
