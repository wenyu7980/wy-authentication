package com.wenyu7980.authentication.login.internal.handler;

import com.wenyu7980.authentication.api.domain.AuthLogin;
import com.wenyu7980.authentication.api.domain.AuthLoginResult;

/**
 *
 * @author wenyu
 */
public interface LoginHandler {
    /**
     * 登录
     * @param login
     * @return
     */
    AuthLoginResult login(AuthLogin login);
}
