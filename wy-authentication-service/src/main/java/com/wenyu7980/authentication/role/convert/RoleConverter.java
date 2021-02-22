package com.wenyu7980.authentication.role.convert;

import com.wenyu7980.authentication.role.domain.Role;
import com.wenyu7980.authentication.role.entity.RoleEntity;

/**
 *
 * @author wenyu
 */
public class RoleConverter {
    private RoleConverter() {
    }

    public static void convert(RoleEntity entity, Role role) {
        role.setId(entity.getId());
        role.setName(entity.getName());
    }

    public static Role convert(RoleEntity entity) {
        Role role = new Role();
        convert(entity, role);
        return role;
    }
}
