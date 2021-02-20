package com.wenyu7980.authentication.common;

import java.util.Objects;

/**
 *
 * @author wenyu
 */
public class AuthRequestPermission {
    private String method;
    private String path;
    private String name;
    private AuthRequesterType requesterType;
    private boolean required;
    private boolean check;
    private String resource;

    public AuthRequestPermission(String method, String path, String name, String resource,
      AuthRequesterType requesterType, boolean required, boolean check) {
        this.method = method;
        this.path = path;
        this.name = name;
        this.requesterType = requesterType;
        this.required = required;
        this.check = check;
        this.resource = resource;
    }

    public String getMethod() {
        return method;
    }

    public String getPath() {
        return path;
    }

    public String getName() {
        return name;
    }

    public AuthRequesterType getRequesterType() {
        return requesterType;
    }

    public boolean isRequired() {
        return required;
    }

    public boolean isCheck() {
        return check;
    }

    public String getResource() {
        return resource;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AuthRequestPermission that = (AuthRequestPermission) o;
        return method.equals(that.method) && path.equals(that.path);
    }

    @Override
    public int hashCode() {
        return Objects.hash(method, path);
    }

    @Override
    public String toString() {
        return "AuthRequestPermission{" + "method='" + method + '\'' + ", path='" + path + '\'' + ", name='" + name
          + '\'' + ", requesterType=" + requesterType + ", required=" + required + ", check=" + check + ", resource='"
          + resource + '\'' + '}';
    }
}
