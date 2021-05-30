package com.wenyu7980.authentication.role.entity;

import com.wenyu7980.authentication.user.entity.UserEntity;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.*;

/**
 *
 * @author wenyu
 */
@Table(name = "auth_role")
@Entity
@EntityListeners(AuditingEntityListener.class)
public class RoleEntity {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "uuid32")
    private String id;
    /** 角色名称 */
    private String name;
    /** 用户 */
    @ManyToMany()
    @JoinTable(name = "auth_user_role", joinColumns = {
      @JoinColumn(name = "role_id")
    }, inverseJoinColumns = { @JoinColumn(name = "user_id") })
    private Set<UserEntity> users;
    @OneToMany(mappedBy = "role", cascade = CascadeType.ALL)
    private List<RolePermissionEntity> permissions;
    @CreatedDate
    private LocalDateTime createdDateTime;
    @CreatedBy
    private String createdUserId;
    @LastModifiedDate
    private LocalDateTime updatedDateTime;
    @LastModifiedBy
    private String updatedUserId;

    protected RoleEntity() {
    }

    public RoleEntity(String name, Collection<RolePermissionEntity> permissions) {
        this.name = name;
        this.permissions = new ArrayList<>(permissions);
    }

    /**
     * 修改
     * @param name
     * @param permissions
     */
    public void modify(String name, Collection<RolePermissionEntity> permissions) {
        this.name = name;
        this.permissions.clear();
        this.permissions.addAll(permissions);
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Set<UserEntity> getUsers() {
        return users;
    }

    public List<RolePermissionEntity> getPermissions() {
        return permissions;
    }

    public LocalDateTime getCreatedDateTime() {
        return createdDateTime;
    }

    public String getCreatedUserId() {
        return createdUserId;
    }

    public LocalDateTime getUpdatedDateTime() {
        return updatedDateTime;
    }

    public String getUpdatedUserId() {
        return updatedUserId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        RoleEntity that = (RoleEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
