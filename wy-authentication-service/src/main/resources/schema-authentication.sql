DROP TABLE IF EXISTS `auth_user`;
DROP TABLE IF EXISTS `auth_permission`;
DROP TABLE IF EXISTS `auth_token`;
DROP TABLE IF EXISTS `auth_role`;
DROP TABLE IF EXISTS `auth_user_role`;
DROP TABLE IF EXISTS `auth_role_permission`;
DROP TABLE IF EXISTS `auth_matrix_permission`;
DROP TABLE IF EXISTS `auth_matrix_permission_permission`;


-- 用户表
CREATE TABLE `auth_user`(
  `id` varchar(32) NOT NULL COMMENT '用户id',
  `username` varchar(128) NOT NULL COMMENT '用户名',
  `mobile` varchar(45) COMMENT '手机号',
  `email` varchar(128) COMMENT '邮箱',
  `password` varchar(128) NOT NULL COMMENT '密码',
  `salt` varchar(128) NOT NULL COMMENT '密码盐',
  `valid_flag` bit(1) NOT NULL DEFAULT 0 COMMENT '有效标志',
  primary key(`id`)
)
ENGINE=innodb DEFAULT CHARACTER SET utf8mb4
COMMENT '用户表';

-- 权限表
CREATE TABLE `auth_permission`(
  `service_name` varchar(128) NOT NULL COMMENT '服务名',
  `method` varchar(45) NOT NULL COMMENT '方法',
  `path` varchar(128) NOT NULL COMMENT '路径',
  `name` varchar(128) NOT NULL COMMENT '接口名',
  `resource` varchar(128) COMMENT '资源名',
  `requester_type` varchar(45) NOT NULL COMMENT '请求者类型',
  `required_flag` bit(1) NOT NULL DEFAULT 0 COMMENT '是否需要登录',
  `check_flag` bit(1) NOT NULL DEFAULT 0 COMMENT '是否进行校验',
  primary key(`service_name`,`method`,`path`)
)
ENGINE=innodb DEFAULT CHARACTER SET utf8mb4
COMMENT '权限表';

-- token表
CREATE TABLE `auth_token`(
  `token` varchar(36) NOT NULL COMMENT 'token',
  `user_id` varchar(45) NOT NULL COMMENT '用户id',
  `login_date_time` datetime NOT NULL COMMENT '登录时间',
  primary key(`token`)
)
ENGINE=innodb DEFAULT CHARACTER SET utf8mb4
COMMENT 'token表';

-- 角色表
CREATE TABLE `auth_role`(
  `id` varchar(32) NOT NULL COMMENT 'id',
  `name` varchar(128) NOT NULL COMMENT '角色名',
  `created_date_time` datetime COMMENT '创建时间',
  `created_user_id` varchar(32) COMMENT '创建者id',
  `updated_date_time` datetime COMMENT '更新时间',
  `updated_user_id` varchar(32) COMMENT '更新者id',
  primary key(`id`)
)
ENGINE=innodb DEFAULT CHARACTER SET utf8mb4
COMMENT '角色表';

-- 用户-角色表
CREATE TABLE `auth_user_role`(
  `user_id` varchar(32) NOT NULL COMMENT '角色id',
  `role_id` varchar(32) NOT NULL COMMENT '用户id',
  primary key(`user_id`,`role_id`)
)
ENGINE=innodb DEFAULT CHARACTER SET utf8mb4
COMMENT '用户-角色表';

-- 角色-权限表
CREATE TABLE `auth_role_permission`(
  `role_id` varchar(32) NOT NULL COMMENT '角色id',
  `service_name` varchar(128) NOT NULL COMMENT '服务名',
  `method` varchar(45) NOT NULL COMMENT '方法',
  `path` varchar(128) NOT NULL COMMENT '路径',
  primary key(`role_id`,`service_name`,`method`,`path`)
)
ENGINE=innodb DEFAULT CHARACTER SET utf8mb4
COMMENT '角色-权限表';

-- 矩阵权限表
CREATE TABLE `auth_matrix_permission`(
  `id` varchar(32) NOT NULL COMMENT '矩阵权限id',
  `user_id` varchar(32) NOT NULL COMMENT '用户id',
  `department_id` varchar(32) NOT NULL COMMENT '部门id',
  primary key(`id`)
)
ENGINE=innodb DEFAULT CHARACTER SET utf8mb4
COMMENT '矩阵权限表';

-- 矩阵权限-权限表
CREATE TABLE `auth_matrix_permission_permission`(
  `matrix_id` varchar(32) NOT NULL COMMENT '矩阵权限id',
  `service_name` varchar(128) NOT NULL COMMENT '服务名',
  `method` varchar(45) NOT NULL COMMENT '方法',
  `path` varchar(128) NOT NULL COMMENT '路径',
  primary key(`matrix_id`,`service_name`,`method`,`path`)
)
ENGINE=innodb DEFAULT CHARACTER SET utf8mb4
COMMENT '矩阵权限-权限表';