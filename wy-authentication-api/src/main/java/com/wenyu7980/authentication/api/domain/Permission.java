package com.wenyu7980.authentication.api.domain;

import com.wenyu7980.authentication.api.constant.RequesterType;

/**
 *
 * @author wenyu
 */
public class Permission {
    /** 服务名 */
    private String applicationName;
    /** 方法 */
    private String method;
    /** 路径 */
    private String path;
    /** 名称 */
    private String name;
    /** 请求者类型 */
    private RequesterType requesterType;
    /** 是否校验token */
    private boolean required;
    /** 是否校验接口 */
    private boolean check;

    public String getApplicationName() {
        return applicationName;
    }

    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName;
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

    public RequesterType getRequesterType() {
        return requesterType;
    }

    public void setRequesterType(RequesterType requesterType) {
        this.requesterType = requesterType;
    }

    public boolean isRequired() {
        return required;
    }

    public void setRequired(boolean required) {
        this.required = required;
    }

    public boolean isCheck() {
        return check;
    }

    public void setCheck(boolean check) {
        this.check = check;
    }
}
