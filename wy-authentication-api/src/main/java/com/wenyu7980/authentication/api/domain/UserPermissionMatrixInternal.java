package com.wenyu7980.authentication.api.domain;

import java.util.List;

/**
 *
 * @author wenyu
 */
public class UserPermissionMatrixInternal {
    private List<PermissionMatrixInternal> permissions;
    private List<ResourceMatrixInternal> resources;

    public List<PermissionMatrixInternal> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<PermissionMatrixInternal> permissions) {
        this.permissions = permissions;
    }

    public List<ResourceMatrixInternal> getResources() {
        return resources;
    }

    public void setResources(List<ResourceMatrixInternal> resources) {
        this.resources = resources;
    }
}
