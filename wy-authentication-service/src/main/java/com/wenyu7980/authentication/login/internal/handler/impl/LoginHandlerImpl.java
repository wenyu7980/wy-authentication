package com.wenyu7980.authentication.login.internal.handler.impl;

import com.wenyu7980.authentication.api.domain.AuthLogin;
import com.wenyu7980.authentication.api.domain.AuthLoginResult;
import com.wenyu7980.authentication.api.domain.RolePermission;
import com.wenyu7980.authentication.login.entity.TokenEntity;
import com.wenyu7980.authentication.login.internal.handler.LoginHandler;
import com.wenyu7980.authentication.login.service.TokenService;
import com.wenyu7980.authentication.user.entity.UserEntity;
import com.wenyu7980.authentication.user.service.UserService;
import com.wenyu7980.common.exceptions.code400.BadBodyException;
import com.wenyu7980.common.exceptions.code403.LoginFailException;
import com.wenyu7980.decisiontable.DecisionTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.function.Function;
import java.util.stream.Collectors;

import static com.wenyu7980.decisiontable.DecisionMatches.ANY;
import static com.wenyu7980.decisiontable.DecisionMatches.NOT_NULL;

/**
 *
 * @author wenyu
 */
@Component
public class LoginHandlerImpl implements LoginHandler {

    private UserService userService;
    private final DecisionTable<Function<AuthLogin, UserEntity>> TABLE = DecisionTable.of();

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
    public AuthLoginResult login(AuthLogin login) {
        UserEntity entity = this.TABLE
          .get(login.getUsername(), login.getMobile(), login.getEmail(), login.getPassword())
          .orElseThrow(() -> new BadBodyException("请求参数组合不正确")).apply(login);
        AuthLoginResult result = new AuthLoginResult();
        TokenEntity token = tokenService.save(new TokenEntity(entity.getId()));
        result.setUserId(entity.getId());
        result.setUsername(entity.getUsername());
        result.setMobile(entity.getMobile());
        result.setSystemFlag(entity.getSystemFlag());
        result.setToken(token.getToken());

        result.setPermissions(entity.getRoles().stream().flatMap(r -> r.getPermissions().stream()).map(p -> {
            RolePermission permission = new RolePermission();
            permission.setCode(p.getCode());
            permission.setMethod(p.getPermission().getMethod());
            permission.setPath(p.getPermission().getPath());
            permission.setServiceName(p.getPermission().getServiceName());
            permission.setResource(p.getResource());
            permission.setResourceId(p.getResourceId());
            permission.setDepartmentId(p.getDepartmentId());
            permission.setChildFlag(p.getChildFlag());
            permission.setCurrentFlag(p.getCurrentFlag());
            return permission;
        }).collect(Collectors.toSet()));
        return result;
    }

    private UserEntity usernameAndPassword(AuthLogin login) {
        UserEntity entity = userService.findOptionalByUsername(login.getUsername())
          .orElseThrow(() -> new LoginFailException("用户名或者密码错误"));
        if (!entity.getValidFlag() || entity.checkPassword(login.getPassword())) {
            throw new LoginFailException("用户名或者密码错误");
        }
        return entity;
    }
}
