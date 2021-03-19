package com.wenyu7980.authentication.api.domain;

/**
 *
 * @author wenyu
 */
public class ResourceMatrixInternal {
    /** 方法名 */
    private String method;
    /** 路径名 */
    private String path;
    /** 应用名称 */
    private String serviceName;
    /** 部门id */
    private String departmentId;
    /** 资源名 */
    private String resource;
    /** 资源id */
    private String resourceId;

    public ResourceMatrixInternal() {
    }

    public ResourceMatrixInternal(String method, String path, String serviceName, String departmentId, String resource,
      String resourceId) {
        this.method = method;
        this.path = path;
        this.serviceName = serviceName;
        this.departmentId = departmentId;
        this.resource = resource;
        this.resourceId = resourceId;
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

    public String getResourceId() {
        return resourceId;
    }

    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }
}
