DROP TABLE IF EXISTS `auth_permission`;

-- 用户表
CREATE TABLE `auth_permission`(
  `application_name` varchar(128) NOT NULL COMMENT '服务名',
  `method` varchar(45) NOT NULL COMMENT '方法',
  `path` varchar(128) NOT NULL COMMENT '路径',
  `name` varchar(128) NOT NULL COMMENT '接口名',
  `requester_type` varchar(45) NOT NULL COMMENT '请求者类型',
  `required_flag` int(1) NOT NULL DEFAULT 0 COMMENT '是否需要登录',
  `check_flag` int(1) NOT NULL DEFAULT 0 COMMENT '是否进行校验',
  primary key(`application_name`,`method`,`path`)
)
ENGINE=innodb DEFAULT CHARACTER SET utf8mb4
COMMENT '用户表';
