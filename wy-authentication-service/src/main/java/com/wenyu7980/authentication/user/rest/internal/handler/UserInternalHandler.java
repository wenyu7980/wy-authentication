package com.wenyu7980.authentication.user.rest.internal.handler;

import com.wenyu7980.authentication.api.domain.UserInternalAdd;

/**
 *
 * @author wenyu
 */
public interface UserInternalHandler {
    /**
     * 创建用户
     * @param user
     */
    void add(UserInternalAdd user);
}
