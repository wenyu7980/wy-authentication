package com.wenyu7980.authentication.role.repository;

import com.wenyu7980.authentication.role.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 *
 * @author wenyu
 */
@Repository
public interface RoleRepo extends JpaRepository<RoleEntity, String>, JpaSpecificationExecutor<RoleEntity> {
    /**
     * 名字是否存在
     * @param name
     * @return
     */
    boolean existsByName(String name);
}
