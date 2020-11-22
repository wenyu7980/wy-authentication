package com.wenyu7980.authentication.common;

import java.util.Collection;

/**
 *
 * @author wenyu
 */
public interface AuthPermissionService {
    /**
     * 保存
     * @param permissions
     */
    void save(Collection<AuthRequestPermission> permissions);
}
