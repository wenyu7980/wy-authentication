package com.wenyu7980.authentication.api.domain;

import java.util.Set;

/**
 *
 * @author wenyu
 */
public class AuthLoginResult {
    /** 用户id */
    private String userId;
    /** token */
    private String token;
    /** 用户名 */
    private String username;
    /** 手机号 */
    private String mobile;
    /** 权限 */
    private Set<RolePermission> permissions;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Set<RolePermission> getPermissions() {
        return permissions;
    }

    public void setPermissions(Set<RolePermission> permissions) {
        this.permissions = permissions;
    }
}
