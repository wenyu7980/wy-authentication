package com.wenyu7980.authentication.login.repository;

import com.wenyu7980.authentication.login.entity.TokenEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author wenyu
 */
@Repository
public interface TokenRepo extends JpaRepository<TokenEntity, String> {
}
