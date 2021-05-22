package com.wenyu7980.auth.request.constant;

/**
 * 请求者类型
 * @author wenyu
 */
public enum AuthRequesterType {
    /** 根据path断定,management,client,common,除此之外全是internal */
    DETERMINE,
    /** 管理端 */
    MANAGEMENT,
    /** 客户端 */
    CLIENT,
    /** 通用 */
    COMMON;
}
