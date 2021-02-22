package com.wenyu7980.authentication.permission.service;

import com.wenyu7980.authentication.permission.entity.PermissionEntity;

import java.util.Collection;
import java.util.Set;

/**
 *
 * @author wenyu
 */
public interface PermissionService {
    /**
     * 保存
     * @param entity
     * @return
     */
    PermissionEntity save(PermissionEntity entity);

    /**
     * 保存
     * @param entities
     */
    void save(Collection<PermissionEntity> entities);

    /**
     * 查询
     * @param serviceName
     * @return
     */
    Set<PermissionEntity> findByServiceName(String serviceName);

    /**
     * 删除
     * @param entity
     */
    void delete(PermissionEntity entity);

    /**
     * 删除
     * @param entities
     */
    void delete(Collection<PermissionEntity> entities);

    /**
     * 查询
     * @param serviceName
     * @param method
     * @param path
     * @return
     */
    PermissionEntity findBYKey(String serviceName, String method, String path);
}
