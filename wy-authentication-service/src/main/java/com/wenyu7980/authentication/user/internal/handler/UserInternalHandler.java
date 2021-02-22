package com.wenyu7980.authentication.user.internal.handler;

import com.wenyu7980.authentication.api.domain.MatrixInternal;
import com.wenyu7980.authentication.api.domain.PermissionInternal;
import com.wenyu7980.authentication.api.domain.UserInternalAdd;

import java.util.List;

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
    List<PermissionInternal> getPermissions(String id);

    /**
     * 查询
     * @param id
     * @return
     */
    List<MatrixInternal> gerMatrices(String id);
}
