package com.wenyu7980.auth.request;

import java.util.Collection;

/**
 *
 * @author wenyu
 */
public interface AuthPermissionService {
    /**
     * 保存
     * @param serviceName
     * @param permissions
     */
    void manipulation(String serviceName, Collection<AuthRequestPermission> permissions);
}
