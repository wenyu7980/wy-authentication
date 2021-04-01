package com.wenyu7980.authentication.role.management.handler;

import com.wenyu7980.authentication.role.management.domain.RoleManagementManipulation;
import com.wenyu7980.authentication.role.domain.Role;

/**
 *
 * @author wenyu
 */
public interface RoleManagementHandler {
    /**
     * 创建
     * @param role
     * @return
     */
    Role add(RoleManagementManipulation role);

    /**
     * 修改
     * @param id
     * @param role
     * @return
     */
    Role modify(String id, RoleManagementManipulation role);
}
