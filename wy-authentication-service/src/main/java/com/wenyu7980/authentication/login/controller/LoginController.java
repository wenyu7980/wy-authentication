package com.wenyu7980.authentication.login.controller;

import com.wenyu7980.authentication.common.AuthRequest;
import com.wenyu7980.authentication.common.AuthRequesterType;
import com.wenyu7980.authentication.login.domain.Login;
import com.wenyu7980.authentication.login.domain.LoginResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author wenyu
 */
@Api(tags = "登录")
@RestController
public class LoginController {
    @ApiOperation("登录")
    @PostMapping("login")
    @AuthRequest(required = false, check = false, requesterType = AuthRequesterType.COMMON)
    public LoginResult login(@RequestBody Login login) {
        return new LoginResult();
    }

}
