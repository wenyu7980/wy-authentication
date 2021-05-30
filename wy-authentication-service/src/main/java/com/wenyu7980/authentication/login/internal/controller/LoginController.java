package com.wenyu7980.authentication.login.internal.controller;

import com.wenyu7980.authentication.api.domain.AuthLogin;
import com.wenyu7980.authentication.api.domain.AuthLoginResult;
import com.wenyu7980.authentication.api.service.LoginFacade;
import com.wenyu7980.authentication.login.internal.handler.LoginHandler;
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
@RequestMapping()
public class LoginController implements LoginFacade {
    @Autowired
    private LoginHandler loginHandler;

    @Override
    @PostMapping("login")
    public AuthLoginResult login(@RequestBody AuthLogin login) {
        return loginHandler.login(login);
    }

}
