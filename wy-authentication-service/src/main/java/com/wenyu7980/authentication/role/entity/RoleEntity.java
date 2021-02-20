package com.wenyu7980.authentication.role.entity;

import com.wenyu7980.authentication.permission.entity.PermissionEntity;
import com.wenyu7980.authentication.user.entity.UserEntity;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Set;

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
    @ManyToMany()
    @JoinTable(name = "auth_user_role", joinColumns = {
      @JoinColumn(name = "role_id")
    }, inverseJoinColumns = { @JoinColumn(name = "user_id") })
    private Set<UserEntity> users;
    @ManyToMany
    @JoinTable(name = "auth_role_permission", joinColumns = {
      @JoinColumn(name = "role_id")
    }, inverseJoinColumns = {
      @JoinColumn(name = "service_name"), @JoinColumn(name = "method"), @JoinColumn(name = "path")
    })
    private Set<PermissionEntity> permissions;
    @CreatedDate
    private LocalDateTime createdDateTime;
    @CreatedBy
    private String createdUserId;
    @LastModifiedDate
    private LocalDateTime updatedDateTime;
    @LastModifiedBy
    private String updatedUserId;

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
