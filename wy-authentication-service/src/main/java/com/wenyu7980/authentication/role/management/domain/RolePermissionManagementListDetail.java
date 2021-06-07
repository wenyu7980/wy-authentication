package com.wenyu7980.authentication.role.management.domain;

import io.swagger.annotations.ApiModelProperty;

public class RolePermissionManagementListDetail {
    @ApiModelProperty(value = "code", accessMode = ApiModelProperty.AccessMode.READ_ONLY)
    private String code;
    @ApiModelProperty(value = "服务名", accessMode = ApiModelProperty.AccessMode.READ_ONLY)
    private String serviceName;
    @ApiModelProperty(value = "方法", accessMode = ApiModelProperty.AccessMode.READ_ONLY)
    private String method;
    @ApiModelProperty(value = "路径", accessMode = ApiModelProperty.AccessMode.READ_ONLY)
    private String path;
    @ApiModelProperty(value = "部门id", accessMode = ApiModelProperty.AccessMode.READ_ONLY)
    private String departmentId;
    @ApiModelProperty(value = "资源", accessMode = ApiModelProperty.AccessMode.READ_ONLY)
    private String resource;
    @ApiModelProperty(value = "资源id", accessMode = ApiModelProperty.AccessMode.READ_ONLY)
    private String resourceId;
    @ApiModelProperty(value = "当前部门", accessMode = ApiModelProperty.AccessMode.READ_ONLY)
    private boolean currentFlag;
    @ApiModelProperty(value = "下级部门", accessMode = ApiModelProperty.AccessMode.READ_ONLY)
    private boolean childFlag;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
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

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
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

    public boolean isCurrentFlag() {
        return currentFlag;
    }

    public void setCurrentFlag(boolean currentFlag) {
        this.currentFlag = currentFlag;
    }

    public boolean isChildFlag() {
        return childFlag;
    }

    public void setChildFlag(boolean childFlag) {
        this.childFlag = childFlag;
    }
}
