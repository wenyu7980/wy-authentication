package com.wenyu7980.authentication.context.model;

import java.util.Objects;

/**
 *
 * @author wenyu
 */
public class AuthPermission {
    /** 服务名 */
    private String serviceName;
    /** 方法 */
    private String method;
    /** 路径 */
    private String path;

    private AuthPermission() {
    }

    public AuthPermission(String serviceName, String method, String path) {
        this.serviceName = serviceName;
        this.method = method;
        this.path = path;
    }

    public String getServiceName() {
        return serviceName;
    }

    public String getMethod() {
        return method;
    }

    public String getPath() {
        return path;
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
        return Objects.equals(serviceName, that.serviceName) && Objects.equals(method, that.method) && Objects
          .equals(path, that.path);
    }

    @Override
    public int hashCode() {
        return Objects.hash(serviceName, method, path);
    }
}
