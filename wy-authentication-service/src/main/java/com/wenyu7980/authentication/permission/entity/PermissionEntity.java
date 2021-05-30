package com.wenyu7980.authentication.permission.entity;

import com.wenyu7980.authentication.api.constant.RequesterType;
import com.wenyu7980.authentication.role.entity.RolePermissionEntity;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

/**
 * 接口权限
 * @author wenyu
 */
@Table(name = "auth_permission")
@Entity
public class PermissionEntity {
    @EmbeddedId
    private PermissionKey key;
    /** 名称 */
    private String name;
    /** 资源名称 */
    private String resource;
    /** 类型 */
    @Enumerated(EnumType.STRING)
    private RequesterType requesterType;
    /** 是否需要登录 */
    private Boolean requiredFlag;
    /** 是否进行校验 */
    private Boolean checkFlag;
    @OneToMany(mappedBy = "permission")
    private List<RolePermissionEntity> permissions;

    protected PermissionEntity() {
    }

    public PermissionEntity(String serviceName, String method, String path, String name, String resource,
      RequesterType requesterType, boolean requiredFlag, boolean checkFlag) {
        this.key = new PermissionKey(serviceName, method, path);
        this.name = name;
        this.resource = resource;
        this.requesterType = requesterType;
        this.requiredFlag = requiredFlag;
        this.checkFlag = this.requiredFlag && checkFlag;
    }

    public void modify(String name, String resource, RequesterType requesterType, boolean required, boolean check) {
        this.name = name;
        this.resource = resource;
        this.requesterType = requesterType;
        this.requiredFlag = required;
        this.checkFlag = this.requiredFlag && check;
    }

    public String getMethod() {
        return key.getMethod();
    }

    public String getPath() {
        return key.getPath();
    }

    public String getServiceName() {
        return this.key.getServiceName();
    }

    public String getName() {
        return name;
    }

    public String getResource() {
        return resource;
    }

    public RequesterType getRequesterType() {
        return requesterType;
    }

    public boolean getRequiredFlag() {
        return requiredFlag;
    }

    public boolean getCheckFlag() {
        return checkFlag;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PermissionEntity that = (PermissionEntity) o;
        return Objects.equals(key, that.key);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key);
    }

}


