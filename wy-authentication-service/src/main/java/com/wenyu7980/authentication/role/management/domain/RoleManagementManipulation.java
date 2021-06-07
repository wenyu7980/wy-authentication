package com.wenyu7980.authentication.role.management.domain;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author wenyu
 */
public class RoleManagementManipulation {
    @ApiModelProperty(value = "名称", required = true)
    @NotEmpty
    private String name;
    @ApiModelProperty(value = "权限", required = true)
    @NotEmpty
    @Valid
    private List<RolePermission> permissions;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<RolePermission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<RolePermission> permissions) {
        this.permissions = permissions;
    }

    public static class RolePermission {
        @ApiModelProperty(value = "code")
        @Size(max = 128)
        private String code;
        @ApiModelProperty(value = "服务名", required = true)
        @NotEmpty
        private String serviceName;
        @ApiModelProperty(value = "方法", required = true)
        @NotEmpty
        private String method;
        @ApiModelProperty(value = "路径", required = true)
        @NotEmpty
        private String path;
        @ApiModelProperty(value = "部门id")
        private String departmentId;
        @ApiModelProperty(value = "资源")
        @Size(max = 128)
        private String resource;
        @ApiModelProperty(value = "资源id")
        @Size(max = 128)
        private String resourceId;
        @ApiModelProperty(value = "当前部门", required = true)
        private boolean currentFlag;
        @ApiModelProperty(value = "下级部门", required = true)
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

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            RolePermission that = (RolePermission) o;
            return Objects.equals(code, that.code) && Objects.equals(method, that.method) && Objects
              .equals(path, that.path) && Objects.equals(departmentId, that.departmentId) && Objects
              .equals(resource, that.resource) && Objects.equals(resourceId, that.resourceId);
        }

        @Override
        public int hashCode() {
            return Objects.hash(code, method, path, departmentId, resource, resourceId);
        }
    }
}
