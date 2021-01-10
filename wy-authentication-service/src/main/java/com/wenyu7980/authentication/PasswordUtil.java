package com.wenyu7980.authentication;

import org.springframework.util.DigestUtils;

/**
 *
 * @author wenyu
 */
public class PasswordUtil {
    private PasswordUtil() {
    }

    /**
     * 加密
     * @param password
     * @param salt
     * @return
     */
    public static String encry(String password, String salt) {
        return DigestUtils.md5DigestAsHex((password + salt).getBytes());
    }
}
