package com.wenyu7980.authentication.context.model;

import java.util.Objects;
import java.util.Set;

/**
 *
 * @author wenyu
 */
public class AuthenticationMatrix {
    private AuthPermission permission;
    private AuthResource authResource;
    private Set<String> departments;

    private AuthenticationMatrix() {
    }

    public AuthenticationMatrix(AuthPermission permission, AuthResource authResource, Set<String> departments) {
        this.permission = permission;
        this.authResource = authResource;
        this.departments = departments;
    }

    public AuthPermission getPermission() {
        return permission;
    }

    public AuthResource getAuthResource() {
        return authResource;
    }

    public Set<String> getDepartments() {
        return departments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AuthenticationMatrix that = (AuthenticationMatrix) o;
        return Objects.equals(permission, that.permission) && Objects.equals(authResource, that.authResource);
    }

    @Override
    public int hashCode() {
        return Objects.hash(permission, authResource);
    }
}
