package com.wenyu7980.authentication.permission.internal.handler;

import com.wenyu7980.authentication.api.domain.PermissionManipulation;

import java.util.Collection;

/**
 *
 * @author wenyu
 */
public interface PermissionFacadeHandler {
    /**
     * 维护
     * @param applicationName
     * @param permissions
     */
    void manipulation(String applicationName, Collection<PermissionManipulation> permissions);
}
