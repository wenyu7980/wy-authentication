package com.wenyu7980.authentication.login.handler;

import com.wenyu7980.authentication.api.domain.LoginInternal;
import com.wenyu7980.authentication.api.domain.LoginResultInternal;

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
    LoginResultInternal login(LoginInternal login);
}
