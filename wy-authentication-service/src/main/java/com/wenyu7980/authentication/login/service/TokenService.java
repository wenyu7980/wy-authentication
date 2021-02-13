package com.wenyu7980.authentication.login.service;

import com.wenyu7980.authentication.login.entity.TokenEntity;

/**
 *
 * @author wenyu
 */
public interface TokenService {
    /**
     * 保存
     * @param entity
     * @return
     */
    TokenEntity save(TokenEntity entity);
}
