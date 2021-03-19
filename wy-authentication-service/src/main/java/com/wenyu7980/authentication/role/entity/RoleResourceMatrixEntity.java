package com.wenyu7980.authentication.role.entity;

import com.wenyu7980.authentication.permission.entity.PermissionEntity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author wenyu
 */
@Table(name = "auth_role_resource_matrix")
@Entity
public class RoleResourceMatrixEntity {
    @EmbeddedId
    private RoleResourceMatrixKey key = new RoleResourceMatrixKey();

    protected RoleResourceMatrixEntity() {
    }

    public RoleResourceMatrixEntity(RoleEntity role, PermissionEntity permission, String departmentId,
      String resourceName, String resourceId) {
        this.key = new RoleResourceMatrixKey(role, permission, departmentId, resourceName, resourceId);
    }

    public RoleEntity getRole() {
        return key.role;
    }

    public PermissionEntity getPermission() {
        return key.permission;
    }

    public String getDepartmentId() {
        return key.departmentId;
    }

    public String getResourceName() {
        return key.resource;
    }

    public String getResourceId() {
        return key.resourceId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        RoleResourceMatrixEntity that = (RoleResourceMatrixEntity) o;
        return Objects.equals(key, that.key);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key);
    }

    @Embeddable
    public static class RoleResourceMatrixKey implements Serializable {
        /** 角色id */
        @ManyToOne
        @JoinColumn(name = "role_id")
        private RoleEntity role;
        @ManyToOne
        @JoinColumns({
          @JoinColumn(name = "method", referencedColumnName = "method"),
          @JoinColumn(name = "path", referencedColumnName = "path"),
          @JoinColumn(name = "service_name", referencedColumnName = "serviceName")
        })
        private PermissionEntity permission;
        /** 部门id */
        private String departmentId;
        /** 资源名 */
        private String resource;
        /** 资源id */
        private String resourceId;

        protected RoleResourceMatrixKey() {
        }

        public RoleResourceMatrixKey(RoleEntity role, PermissionEntity permission, String departmentId,
          String resource, String resourceId) {
            this.role = role;
            this.permission = permission;
            this.departmentId = departmentId;
            this.resource = resource;
            this.resourceId = resourceId;
        }

        public RoleEntity getRole() {
            return role;
        }

        public PermissionEntity getPermission() {
            return permission;
        }

        public String getDepartmentId() {
            return departmentId;
        }

        public String getResource() {
            return resource;
        }

        public String getResourceId() {
            return resourceId;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            RoleResourceMatrixKey that = (RoleResourceMatrixKey) o;
            return Objects.equals(role, that.role) && Objects.equals(permission, that.permission) && Objects
              .equals(departmentId, that.departmentId) && Objects.equals(resource, that.resource) && Objects
              .equals(resourceId, that.resourceId);
        }

        @Override
        public int hashCode() {
            return Objects.hash(role, permission, departmentId, resource, resourceId);
        }
    }
}
