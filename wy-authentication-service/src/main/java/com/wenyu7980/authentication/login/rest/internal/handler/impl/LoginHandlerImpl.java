package com.wenyu7980.authentication.login.rest.internal.handler.impl;

import com.wenyu7980.authentication.api.domain.LoginInternal;
import com.wenyu7980.authentication.api.domain.LoginResultInternal;
import com.wenyu7980.authentication.login.entity.TokenEntity;
import com.wenyu7980.authentication.login.rest.internal.handler.LoginHandler;
import com.wenyu7980.authentication.login.service.TokenService;
import com.wenyu7980.authentication.user.entity.UserEntity;
import com.wenyu7980.authentication.user.service.UserService;
import com.wenyu7980.common.exceptions.code400.BadBodyException;
import com.wenyu7980.common.exceptions.code403.LoginFailException;
import com.wenyu7980.decisiontable.DecisionTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.function.Function;

import static com.wenyu7980.decisiontable.DecisionMatches.ANY;
import static com.wenyu7980.decisiontable.DecisionMatches.NOT_NULL;

/**
 *
 * @author wenyu
 */
@Component
public class LoginHandlerImpl implements LoginHandler {

    private UserService userService;
    private final DecisionTable<Function<LoginInternal, UserEntity>> TABLE = DecisionTable.of();

    @Autowired
    private TokenService tokenService;

    @Autowired
    public LoginHandlerImpl(UserService userService) {
        this.userService = userService;
        // username,mobile,email,password
        this.TABLE.add(this::usernameAndPassword, NOT_NULL(), ANY(), ANY(), NOT_NULL());
        // this.TABLE.add(this::usernameAndPassword, ANY(), NOT_NULL(), ANY(), NOT_NULL());
        //        this.TABLE.add(this::usernameAndPassword, ANY(), ANY(), NOT_NULL(), NOT_NULL());
    }

    @Override
    public LoginResultInternal login(LoginInternal login) {
        UserEntity entity = this.TABLE
          .get(login.getUsername(), login.getMobile(), login.getEmail(), login.getPassword())
          .orElseThrow(() -> new BadBodyException("请求参数组合不正确")).apply(login);
        LoginResultInternal result = new LoginResultInternal();
        TokenEntity token = tokenService.save(new TokenEntity(entity.getId()));
        result.setUserId(entity.getId());
        result.setUsername(entity.getUsername());
        result.setEmail(entity.getEmail());
        result.setMobile(entity.getMobile());
        result.setToken(token.getToken());
        return result;
    }

    private UserEntity usernameAndPassword(LoginInternal login) {
        UserEntity entity = userService.findOptionalByUsername(login.getUsername())
          .orElseThrow(() -> new LoginFailException("用户名或者密码错误"));
        if (!entity.getValidFlag() || entity.checkPassword(login.getPassword())) {
            throw new LoginFailException("用户名或者密码错误");
        }
        return entity;
    }
}
