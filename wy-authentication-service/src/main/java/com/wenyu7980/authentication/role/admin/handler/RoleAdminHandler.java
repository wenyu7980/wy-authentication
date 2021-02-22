package com.wenyu7980.authentication.role.admin.handler;

import com.wenyu7980.authentication.role.admin.domain.RoleAdminManipulation;
import com.wenyu7980.authentication.role.domain.Role;

/**
 *
 * @author wenyu
 */
public interface RoleAdminHandler {
    /**
     * 创建
     * @param role
     * @return
     */
    Role add(RoleAdminManipulation role);

    /**
     * 修改
     * @param id
     * @param role
     * @return
     */
    Role modify(String id, RoleAdminManipulation role);
}
