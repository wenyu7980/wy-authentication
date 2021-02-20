package com.wenyu7980.authentication.api.domain;

import com.wenyu7980.authentication.api.constant.RequesterType;

/**
 *
 * @author wenyu
 */
public class PermissionInternalManipulation {
    private String method;
    private String path;
    private String name;
    private String resource;
    private RequesterType requesterType;
    private Boolean required;
    private Boolean check;

    public PermissionInternalManipulation() {
    }

    public PermissionInternalManipulation(String method, String path, String name, String resource,
      RequesterType requesterType, boolean required, boolean check) {
        this.method = method;
        this.path = path;
        this.name = name;
        this.resource = resource;
        this.requesterType = requesterType;
        this.required = required;
        this.check = check;
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

    public RequesterType getRequesterType() {
        return requesterType;
    }

    public Boolean getRequired() {
        return required;
    }

    public Boolean getCheck() {
        return check;
    }

    public String getResource() {
        return resource;
    }

    @Override
    public String toString() {
        return "PermissionInternalManipulation{" + "method='" + method + '\'' + ", path='" + path + '\'' + ", name='"
          + name + '\'' + ", resource='" + resource + '\'' + ", requesterType=" + requesterType + ", required="
          + required + ", check=" + check + '}';
    }
}
