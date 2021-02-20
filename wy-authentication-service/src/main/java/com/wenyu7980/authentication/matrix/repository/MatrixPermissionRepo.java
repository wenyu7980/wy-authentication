package com.wenyu7980.authentication.matrix.repository;

import com.wenyu7980.authentication.matrix.entity.MatrixPermissionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 *
 * @author wenyu
 */
@Repository
public interface MatrixPermissionRepo
  extends JpaRepository<MatrixPermissionEntity, String>, JpaSpecificationExecutor<MatrixPermissionEntity> {
}
