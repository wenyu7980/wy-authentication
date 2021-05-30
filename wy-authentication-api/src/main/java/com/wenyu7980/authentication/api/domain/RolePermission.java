package com.wenyu7980.authentication.api.domain;

import java.util.Objects;

public class RolePermission {
    /** code */
    private String code;
    /** 方法名 */
    private String method;
    /** 路径名 */
    private String path;
    /** 应用名 */
    private String serviceName;
    /** 资源名 */
    private String resource;
    /** 资源id */
    private String resourceId;
    /** 部门id */
    private String departmentId;
    /** 当前部门 */
    private Boolean currentFlag;
    /** 下级部门 */
    private Boolean childFlag;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

    public String getResourceId() {
        return resourceId;
    }

    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public Boolean getCurrentFlag() {
        return currentFlag;
    }

    public void setCurrentFlag(Boolean currentFlag) {
        this.currentFlag = currentFlag;
    }

    public Boolean getChildFlag() {
        return childFlag;
    }

    public void setChildFlag(Boolean childFlag) {
        this.childFlag = childFlag;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        RolePermission that = (RolePermission) o;
        return Objects.equals(code, that.code) && Objects.equals(method, that.method) && Objects.equals(path, that.path)
          && Objects.equals(serviceName, that.serviceName) && Objects.equals(resource, that.resource) && Objects
          .equals(resourceId, that.resourceId) && Objects.equals(departmentId, that.departmentId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, method, path, serviceName, resource, resourceId, departmentId);
    }
}
