package com.wenyu7980.authentication.login.service.impl;

import com.wenyu7980.authentication.login.entity.TokenEntity;
import com.wenyu7980.authentication.login.repository.TokenRepo;
import com.wenyu7980.authentication.login.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author wenyu
 */
@Service
public class TokenServiceImpl implements TokenService {
    @Autowired
    private TokenRepo tokenRepo;

    @Override
    public TokenEntity save(TokenEntity entity) {
        return tokenRepo.save(entity);
    }
}
