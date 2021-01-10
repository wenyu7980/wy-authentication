package com.wenyu7980.authentication.user.repository;

import com.wenyu7980.authentication.user.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 *
 * @author wenyu
 */
@Repository
public interface UserRepo extends JpaRepository<UserEntity, String>, JpaSpecificationExecutor<UserEntity> {
    /**
     * 查询
     * @param username
     * @return
     */
    Optional<UserEntity> findByUsername(String username);
}
