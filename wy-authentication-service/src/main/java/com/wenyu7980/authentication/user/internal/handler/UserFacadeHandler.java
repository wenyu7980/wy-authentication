package com.wenyu7980.authentication.user.internal.handler;

import com.wenyu7980.authentication.api.domain.AuthUserAdd;

/**
 *
 * @author wenyu
 */
public interface UserFacadeHandler {
    /**
     * 创建用户
     * @param user
     */
    void add(AuthUserAdd user);

}
