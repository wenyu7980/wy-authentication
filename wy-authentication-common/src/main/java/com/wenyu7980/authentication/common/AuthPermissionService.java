package com.wenyu7980.authentication.common;

import java.util.Collection;

/**
 *
 * @author wenyu
 */
public interface AuthPermissionService {
    /**
     * 保存
     * @param applicationName
     * @param permissions
     */
    void manipulation(String applicationName, Collection<AuthRequestPermission> permissions);
}
