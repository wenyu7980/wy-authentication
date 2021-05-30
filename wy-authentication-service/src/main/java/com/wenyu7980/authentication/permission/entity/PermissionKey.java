package com.wenyu7980.authentication.permission.entity;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class PermissionKey implements Serializable {
    /** 方法名 */
    private String method;
    /** 路径名 */
    private String path;
    /** 应用名称 */
    private String serviceName;

    protected PermissionKey() {
    }

    public PermissionKey(String serviceName, String method, String path) {
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

    protected void setMethod(String method) {
        this.method = method;
    }

    protected void setPath(String path) {
        this.path = path;
    }

    protected void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PermissionKey that = (PermissionKey) o;
        return Objects.equals(method, that.method) && Objects.equals(path, that.path) && Objects
          .equals(serviceName, that.serviceName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(method, path, serviceName);
    }
}
