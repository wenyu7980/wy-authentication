package com.wenyu7980.authentication.user.entity;

import com.wenyu7980.authentication.PasswordUtil;
import com.wenyu7980.authentication.matrix.entity.MatrixPermissionEntity;
import com.wenyu7980.authentication.role.entity.RoleEntity;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

/**
 *
 * @author wenyu
 */
@Entity
@Table(name = "auth_user")
@EntityListeners(AuditingEntityListener.class)
public class UserEntity {
    @Id
    private String id;
    /** 用户名 */
    private String username;
    /** 手机号 */
    private String mobile;
    /** 邮箱 */
    private String email;
    /** 密码 */
    private String password;
    /** 密码盐 */
    private String salt;
    /** 有效标志 */
    private Boolean validFlag = true;
    @ManyToMany(mappedBy = "users")
    private Set<RoleEntity> roles;
    @OneToMany(mappedBy = "user")
    private Set<MatrixPermissionEntity> matrices;

    protected UserEntity() {
    }

    public UserEntity(String id, String username, String mobile, String email, String password, String salt) {
        this.id = id;
        this.username = username;
        this.mobile = mobile;
        this.email = email;
        this.password = PasswordUtil.encry(password, salt);
        this.salt = salt;
    }

    public boolean checkPassword(String password) {
        return Objects.equals(PasswordUtil.encry(password, salt), this.password);
    }

    public String getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getMobile() {
        return mobile;
    }

    public String getEmail() {
        return email;
    }

    public Boolean getValidFlag() {
        return validFlag;
    }

    public Set<RoleEntity> getRoles() {
        return roles;
    }

    public Set<MatrixPermissionEntity> getMatrices() {
        return matrices;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        UserEntity entity = (UserEntity) o;
        return id.equals(entity.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
