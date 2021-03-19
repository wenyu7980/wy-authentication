package com.wenyu7980.authentication.user.internal.handler;

import com.wenyu7980.authentication.api.domain.UserInternalAdd;
import com.wenyu7980.authentication.api.domain.UserPermissionMatrixInternal;

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

    /**
     * 查询
     * @param id
     * @return
     */
    UserPermissionMatrixInternal getMatrix(String id);

}
