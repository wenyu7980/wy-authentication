package com.wenyu7980.authentication.api.domain;

/**
 *
 * @author wenyu
 */
public class PermissionMatrixInternal {
    /** 方法名 */
    private String method;
    /** 路径名 */
    private String path;
    /** 应用名称 */
    private String serviceName;
    /** 资源名 */
    private String resource;
    /** 部门id */
    private String departmentId;

    public PermissionMatrixInternal() {
    }

    public PermissionMatrixInternal(String method, String path, String serviceName, String resource,
      String departmentId) {
        this.method = method;
        this.path = path;
        this.serviceName = serviceName;
        this.resource = resource;
        this.departmentId = departmentId;
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

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }
}
