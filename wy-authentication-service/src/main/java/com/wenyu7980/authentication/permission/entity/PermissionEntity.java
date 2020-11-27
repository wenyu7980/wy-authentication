package com.wenyu7980.authentication.permission.entity;

import com.wenyu7980.authentication.api.constant.RequesterType;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author wenyu
 */
@Table(name = "auth_permission")
@Entity
public class PermissionEntity {
    @EmbeddedId
    private PermissionKey key;
    /** 名称 */
    private String name;
    /** 类型 */
    @Enumerated(EnumType.STRING)
    private RequesterType requesterType;
    /** 是否需要登录 */
    private Boolean requiredFlag;
    /** 是否进行校验 */
    private Boolean checkFlag;

    protected PermissionEntity() {
    }

    public PermissionEntity(String serviceName, String method, String path, String name, RequesterType requesterType,
      boolean requiredFlag, boolean checkFlag) {
        this.key = new PermissionKey(serviceName, method, path);
        this.name = name;
        this.requesterType = requesterType;
        this.requiredFlag = requiredFlag;
        this.checkFlag = this.requiredFlag && checkFlag;
    }

    public void modify(String name, RequesterType requesterType, boolean required, boolean check) {
        this.name = name;
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
        return this.key.serviceName;
    }

    public String getName() {
        return name;
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

    @Embeddable
    public static class PermissionKey implements Serializable {
        private String method;
        private String path;
        /** 应用名称 */
        private String serviceName;

        protected PermissionKey() {
        }

        public PermissionKey(String serviceName, String method, String path) {
            this.serviceName = serviceName;
            this.method = method;
            this.path = path;
        }

        public String getServiceName() {
            return serviceName;
        }

        public String getMethod() {
            return method;
        }

        public String getPath() {
            return path;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            PermissionKey that = (PermissionKey) o;
            return Objects.equals(method, that.method) && Objects.equals(path, that.path);
        }

        @Override
        public int hashCode() {
            return Objects.hash(method, path);
        }
    }
}


