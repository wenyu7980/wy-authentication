package com.wenyu7980.authentication.role.entity;

import com.wenyu7980.authentication.permission.entity.PermissionEntity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author wenyu
 */
@Table(name = "auth_role_permission_matrix")
@Entity
public class RolePermissionMatrixEntity {
    @EmbeddedId
    private PermissionMatrixKey key = new PermissionMatrixKey();

    protected RolePermissionMatrixEntity() {
    }

    public RolePermissionMatrixEntity(RoleEntity role, PermissionEntity permission, String departmentId) {
        this.key = new PermissionMatrixKey(role, permission, departmentId);
    }

    public RoleEntity getRole() {
        return key.getRole();
    }

    public PermissionEntity getPermission() {
        return key.getPermission();
    }

    public String getDepartmentId() {
        return key.getDepartmentId();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        RolePermissionMatrixEntity that = (RolePermissionMatrixEntity) o;
        return Objects.equals(key, that.key);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key);
    }

    @Embeddable
    public static class PermissionMatrixKey implements Serializable {
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

        protected PermissionMatrixKey() {
        }

        public PermissionMatrixKey(RoleEntity role, PermissionEntity permission, String departmentId) {
            this.role = role;
            this.permission = permission;
            this.departmentId = departmentId;
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

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            PermissionMatrixKey that = (PermissionMatrixKey) o;
            return Objects.equals(role, that.role) && Objects.equals(permission, that.permission) && Objects
              .equals(departmentId, that.departmentId);
        }

        @Override
        public int hashCode() {
            return Objects.hash(role, permission, departmentId);
        }
    }
}
