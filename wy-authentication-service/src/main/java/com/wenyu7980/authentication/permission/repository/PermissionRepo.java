package com.wenyu7980.authentication.permission.repository;

import com.wenyu7980.authentication.permission.entity.PermissionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Set;

/**
 *
 * @author wenyu
 */
@Repository
public interface PermissionRepo
  extends JpaRepository<PermissionEntity, PermissionEntity.PermissionKey>, JpaSpecificationExecutor<PermissionEntity> {
    /**
     * 查询
     * @param applicationName
     * @return
     */
    Set<PermissionEntity> findByKeyApplicationName(String applicationName);
}
