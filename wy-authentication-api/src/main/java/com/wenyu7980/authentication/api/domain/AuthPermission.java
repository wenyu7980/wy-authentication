package com.wenyu7980.authentication.api.domain;

import java.util.Objects;

/**
 *
 * @author wenyu
 */
public class AuthPermission {
    private String name;
    private String method;
    private String path;
    private String requesterType;

    public AuthPermission(String name, String method, String path, String requesterType) {
        this.name = name;
        this.method = method;
        this.path = path;
        this.requesterType = requesterType;
    }

    public String getName() {
        return name;
    }

    public String getMethod() {
        return method;
    }

    public String getPath() {
        return path;
    }

    public String getRequesterType() {
        return requesterType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AuthPermission that = (AuthPermission) o;
        return Objects.equals(method, that.method) && Objects.equals(path, that.path);
    }

    @Override
    public int hashCode() {
        return Objects.hash(method, path);
    }
}
