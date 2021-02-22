package com.wenyu7980.authentication.role.service;

import com.wenyu7980.authentication.role.entity.RoleEntity;

/**
 *
 * @author wenyu
 */
public interface RoleService {
    /**
     * 查询名称是否存在
     * @param name
     * @return
     */
    boolean existsByName(String name);

    /**
     * 保存
     * @param entity
     * @return
     */
    RoleEntity save(RoleEntity entity);

    /**
     * 查询
     * @param id
     * @return
     */
    RoleEntity findById(String id);
}
