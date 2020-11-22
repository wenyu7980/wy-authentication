package com.wenyu7980.authentication.api.domain;

/**
 *
 * @author wenyu
 */
public class PermissionInternalManipulation {
    private String method;
    private String path;
    private String name;
    private String requesterType;
    private boolean required;
    private boolean check;

    public PermissionInternalManipulation() {
    }

    public PermissionInternalManipulation(String method, String path, String name, String requesterType,
      boolean required, boolean check) {
        this.method = method;
        this.path = path;
        this.name = name;
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

    public String getRequesterType() {
        return requesterType;
    }

    public boolean isRequired() {
        return required;
    }

    public boolean isCheck() {
        return check;
    }
}
