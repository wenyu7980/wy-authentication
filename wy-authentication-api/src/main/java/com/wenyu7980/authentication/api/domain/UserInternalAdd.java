package com.wenyu7980.authentication.api.domain;

/**
 *
 * @author wenyu
 */
public class UserInternalAdd {
    /** 用户id */
    private String id;
    /** 用户名 */
    private String username;
    /** 密码 */
    private String password;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
