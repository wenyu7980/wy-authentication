package com.wenyu7980.authentication.api.domain;

import javax.annotation.Nullable;

/**
 *
 * @author wenyu
 */
public class AuthLogin {
    private String username;
    private String mobile;
    private String email;
    private String password;

    private AuthLogin() {
    }

    public AuthLogin(@Nullable String username, @Nullable String mobile, @Nullable String email,
      @Nullable String password) {
        this.username = username;
        this.mobile = mobile;
        this.email = email;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getMobile() {
        return mobile;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
