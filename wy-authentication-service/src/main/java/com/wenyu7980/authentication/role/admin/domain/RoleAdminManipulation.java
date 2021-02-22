package com.wenyu7980.authentication.role.admin.domain;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotEmpty;
import java.util.Objects;
import java.util.Set;

/**
 *
 * @author wenyu
 */
public class RoleAdminManipulation {
    @ApiModelProperty(value = "名称", required = true)
    @NotEmpty
    private String name;
    @ApiModelProperty(value = "权限", required = true)
    @NotEmpty
    private Set<RolePermission> permissions;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<RolePermission> getPermissions() {
        return permissions;
    }

    public void setPermissions(Set<RolePermission> permissions) {
        this.permissions = permissions;
    }

    public static class RolePermission {
        @ApiModelProperty(value = "方法", required = true)
        @NotEmpty
        private String method;
        @ApiModelProperty(value = "路径", required = true)
        @NotEmpty
        private String path;

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

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            RolePermission that = (RolePermission) o;
            return Objects.equals(method, that.method) && Objects.equals(path, that.path);
        }

        @Override
        public int hashCode() {
            return Objects.hash(method, path);
        }
    }
}
