package com.wenyu7980.authentication.user.service.impl;

import com.wenyu7980.authentication.user.entity.UserEntity;
import com.wenyu7980.authentication.user.repository.UserRepo;
import com.wenyu7980.authentication.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 *
 * @author wenyu
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepo userRepo;

    @Override
    public UserEntity save(UserEntity entity) {
        return userRepo.save(entity);
    }

    @Override
    public Optional<UserEntity> findOptionalByUsername(String username) {
        return userRepo.findByUsername(username);
    }
}
