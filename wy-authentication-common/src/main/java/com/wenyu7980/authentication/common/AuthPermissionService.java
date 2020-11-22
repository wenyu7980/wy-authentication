package com.wenyu7980.authentication.common;

import java.util.Collection;

/**
 *
 * @author wenyu
 */
public interface AuthPermissionService {
    void save(Collection<AuthRequestPermission> permissions);
}
