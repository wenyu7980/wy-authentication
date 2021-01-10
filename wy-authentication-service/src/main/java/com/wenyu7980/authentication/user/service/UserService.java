package com.wenyu7980.authentication.user.service;

import com.wenyu7980.authentication.user.entity.UserEntity;

import java.util.Optional;

/**
 *
 * @author wenyu
 */
public interface UserService {
    /**
     * 保存
     * @param entity
     * @return
     */
    UserEntity save(UserEntity entity);

    /**
     * 通过用户名查询
     * @param username
     * @return
     */
    Optional<UserEntity> findOptionalByUsername(String username);
}
