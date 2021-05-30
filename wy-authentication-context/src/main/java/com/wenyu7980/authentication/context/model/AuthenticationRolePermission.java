package com.wenyu7980.authentication.context.model;

import java.util.Objects;

/**
 *
 * @author wenyu
 */
public class AuthenticationRolePermission {
    /** code */
    private String code;
    /** 服务名 */
    private String serviceName;
    /** 方法 */
    private String method;
    /** 路径 */
    private String path;
    /** 资源名 */
    private String resource;
    /** 资源id */
    private String resourceId;
    /** 部门id */
    private String departmentId;

    private AuthenticationRolePermission() {
    }

    public AuthenticationRolePermission(String code, String serviceName, String method, String path, String resource,
      String resourceId, String departmentId) {
        this.code = code;
        this.serviceName = serviceName;
        this.method = method;
        this.path = path;
        this.resource = resource;
        this.resourceId = resourceId;
        this.departmentId = departmentId;
    }

    public String getCode() {
        return code;
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

    public String getResource() {
        return resource;
    }

    public String getResourceId() {
        return resourceId;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AuthenticationRolePermission that = (AuthenticationRolePermission) o;
        return Objects.equals(code, that.code) && Objects.equals(serviceName, that.serviceName) && Objects
          .equals(method, that.method) && Objects.equals(path, that.path) && Objects.equals(resource, that.resource)
          && Objects.equals(resourceId, that.resourceId) && Objects.equals(departmentId, that.departmentId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, serviceName, method, path, resource, resourceId, departmentId);
    }
}
