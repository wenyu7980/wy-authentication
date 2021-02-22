package com.wenyu7980.authentication.role.service.impl;

import com.wenyu7980.authentication.role.entity.RoleEntity;
import com.wenyu7980.authentication.role.repository.RoleRepo;
import com.wenyu7980.authentication.role.service.RoleService;
import com.wenyu7980.common.exceptions.code404.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author wenyu
 */
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleRepo roleRepo;

    @Override
    public boolean existsByName(String name) {
        return roleRepo.existsByName(name);
    }

    @Override
    public RoleEntity save(RoleEntity entity) {
        return roleRepo.save(entity);
    }

    @Override
    public RoleEntity findById(String id) {
        return roleRepo.findById(id).orElseThrow(() -> new NotFoundException("角色{0}不存在", id));
    }
}
