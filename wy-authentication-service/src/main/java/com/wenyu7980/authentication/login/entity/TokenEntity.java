package com.wenyu7980.authentication.login.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 *
 * @author wenyu
 */
@Table(name = "auth_token")
@Entity
public class TokenEntity {
    @Id
    private String token;
    private String userId;
    private LocalDateTime loginDateTime;

    protected TokenEntity() {
    }

    public TokenEntity(String userId) {
        this.token = UUID.randomUUID().toString();
        this.userId = userId;
        this.loginDateTime = LocalDateTime.now();
    }

    public String getToken() {
        return token;
    }

    public String getUserId() {
        return userId;
    }

    public LocalDateTime getLoginDateTime() {
        return loginDateTime;
    }
}
