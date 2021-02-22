package com.wenyu7980.authentication.permission.internal.handler;

import com.wenyu7980.authentication.api.domain.PermissionInternalManipulation;

import java.util.Collection;

/**
 *
 * @author wenyu
 */
public interface PermissionInternalHandler {
    /**
     * 维护
     * @param applicationName
     * @param permissions
     */
    void manipulation(String applicationName, Collection<PermissionInternalManipulation> permissions);
}
