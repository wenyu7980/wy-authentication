package com.wenyu7980.authentication.api.domain;

import com.wenyu7980.authentication.api.constant.RequesterType;

/**
 *
 * @author wenyu
 */
public class Permission {
    /** 服务名 */
    private String serviceName;
    /** 方法 */
    private String method;
    /** 路径 */
    private String path;
    /** 名称 */
    private String name;
    /** 资源名 */
    private String resource;
    /** 请求分类 */
    private RequesterType requesterType;
    /** 是否校验token */
    private Boolean required;
    /** 是否校验接口 */
    private Boolean check;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

    public RequesterType getRequesterType() {
        return requesterType;
    }

    public void setRequesterType(RequesterType requesterType) {
        this.requesterType = requesterType;
    }

    public Boolean getRequired() {
        return required;
    }

    public void setRequired(Boolean required) {
        this.required = required;
    }

    public Boolean getCheck() {
        return check;
    }

    public void setCheck(Boolean check) {
        this.check = check;
    }
    
}
