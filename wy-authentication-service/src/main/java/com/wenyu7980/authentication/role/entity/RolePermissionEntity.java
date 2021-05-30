package com.wenyu7980.authentication.role.entity;

import com.wenyu7980.authentication.permission.entity.PermissionEntity;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Table(name = "auth_role_permission")
@Entity
public class RolePermissionEntity {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "uuid32")
    private String id;
    /** code */
    private String code;
    @ManyToOne
    @JoinColumns({
      @JoinColumn(name = "method"), @JoinColumn(name = "path"), @JoinColumn(name = "service_name")
    })
    private PermissionEntity permission;
    /** 资源 */
    private String resource;
    /** 资源id */
    private String resourceId;
    /** 部门id */
    private String departmentId;
    /** 当前部门 */
    private Boolean currentFlag;
    /** 下级部门 */
    private Boolean childFlag;
    @ManyToOne
    @JoinColumn(name = "role_id")
    private RoleEntity role;

    protected RolePermissionEntity() {
    }

    public RolePermissionEntity(String code, PermissionEntity permission, String resource, String resourceId,
      String departmentId, Boolean currentFlag, Boolean childFlag) {
        this.code = code;
        this.permission = permission;
        this.resource = resource;
        this.resourceId = resourceId;
        this.departmentId = departmentId;
        this.currentFlag = currentFlag;
        this.childFlag = childFlag;
    }

    public String getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public PermissionEntity getPermission() {
        return permission;
    }

    public String getResource() {
        return resource;
    }

    public String getResourceId() {
        return resourceId;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public Boolean getCurrentFlag() {
        return currentFlag;
    }

    public Boolean getChildFlag() {
        return childFlag;
    }

    public RoleEntity getRole() {
        return role;
    }
}
