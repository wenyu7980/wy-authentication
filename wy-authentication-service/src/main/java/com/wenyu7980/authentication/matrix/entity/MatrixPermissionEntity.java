package com.wenyu7980.authentication.matrix.entity;

import com.wenyu7980.authentication.permission.entity.PermissionEntity;
import com.wenyu7980.authentication.user.entity.UserEntity;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 *
 * @author wenyu
 */
@Table(name = "auth_matrix_permission")
@Entity
public class MatrixPermissionEntity {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "uuid32")
    private String id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;
    /** 部门id */
    private String departmentId;
    /** 权限 */
    @ManyToOne()
    @JoinColumns({ @JoinColumn(name = "service_name"), @JoinColumn(name = "method"), @JoinColumn(name = "path") })
    private PermissionEntity permission;

    public String getId() {
        return id;
    }

    public UserEntity getUser() {
        return user;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public PermissionEntity getPermission() {
        return permission;
    }
}
