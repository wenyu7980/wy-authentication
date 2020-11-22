package com.wenyu7980.authentication.common;

/**
 * 请求者类型
 * @author wenyu
 */
public enum AuthRequesterType {
    /**
     * 根据path断定,internal,admin,client,common
     */
    DETERMINE,
    INTERNAL,
    ADMIN,
    CLIENT,
    COMMON;
}
