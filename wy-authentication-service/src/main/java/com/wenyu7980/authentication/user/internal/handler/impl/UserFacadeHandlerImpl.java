package com.wenyu7980.authentication.user.internal.handler.impl;

import com.wenyu7980.authentication.api.domain.AuthUserAdd;
import com.wenyu7980.authentication.user.entity.UserEntity;
import com.wenyu7980.authentication.user.internal.handler.UserFacadeHandler;
import com.wenyu7980.authentication.user.service.UserService;
import com.wenyu7980.common.exceptions.code409.ExistedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

/**
 *
 * @author wenyu
 */
@Component
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = RuntimeException.class)
public class UserFacadeHandlerImpl implements UserFacadeHandler {
    @Autowired
    private UserService userService;

    @Override
    public void add(AuthUserAdd user) {
        Optional<UserEntity> optional = userService.findOptionalByUsername(user.getUsername());
        if (optional.isPresent()) {
            throw new ExistedException("用户{0}已存在", user.getUsername());
        }
        String salt = UUID.randomUUID().toString();
        UserEntity entity = new UserEntity(user.getId(), user.getUsername(), user.getMobile(), user.getPassword(),
          salt);
        userService.save(entity);
    }
}
