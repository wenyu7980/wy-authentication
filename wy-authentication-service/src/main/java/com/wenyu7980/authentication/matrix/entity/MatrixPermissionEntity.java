package com.wenyu7980.authentication.matrix.entity;

import com.wenyu7980.authentication.permission.entity.PermissionEntity;
import com.wenyu7980.authentication.user.entity.UserEntity;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;

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
    @ManyToMany
    @JoinTable(name = "auth_matrix_permission_permission", joinColumns = {
      @JoinColumn(name = "matrix_id")
    }, inverseJoinColumns = {
      @JoinColumn(name = "service_name"), @JoinColumn(name = "method"), @JoinColumn(name = "path")
    })
    private Set<PermissionEntity> permission;
}
