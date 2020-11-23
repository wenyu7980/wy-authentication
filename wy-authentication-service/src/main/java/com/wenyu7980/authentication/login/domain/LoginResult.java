package com.wenyu7980.authentication.login.domain;

import io.swagger.annotations.ApiModelProperty;

/**
 *
 * @author wenyu
 */
public class LoginResult {
    @ApiModelProperty(value = "token", accessMode = ApiModelProperty.AccessMode.READ_ONLY)
    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
