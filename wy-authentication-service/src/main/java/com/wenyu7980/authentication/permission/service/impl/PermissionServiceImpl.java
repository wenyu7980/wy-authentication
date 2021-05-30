package com.wenyu7980.authentication.permission.service.impl;

import com.wenyu7980.authentication.permission.entity.PermissionEntity;
import com.wenyu7980.authentication.permission.entity.PermissionKey;
import com.wenyu7980.authentication.permission.repository.PermissionRepo;
import com.wenyu7980.authentication.permission.service.PermissionService;
import com.wenyu7980.common.exceptions.code404.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Set;

/**
 *
 * @author wenyu
 */
@Service
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    private PermissionRepo permissionRepo;

    @Override
    public PermissionEntity save(PermissionEntity entity) {
        return permissionRepo.save(entity);
    }

    @Override
    public void save(Collection<PermissionEntity> entities) {
        permissionRepo.saveAll(entities);
    }

    @Override
    public Set<PermissionEntity> findByServiceName(String serviceName) {
        return permissionRepo.findByKeyServiceName(serviceName);
    }

    @Override
    public void delete(PermissionEntity entity) {
        permissionRepo.delete(entity);
    }

    @Override
    public void delete(Collection<PermissionEntity> entities) {
        permissionRepo.deleteAll(entities);
    }

    @Override
    public PermissionEntity findBYKey(String serviceName, String method, String path) {
        return permissionRepo.findById(new PermissionKey(serviceName, method, path))
          .orElseThrow(() -> new NotFoundException("权限{0}-{1}-{2}不存在", serviceName, method, path));
    }
}
