package com.wenyu7980.authentication.common.feign;

import com.wenyu7980.authentication.api.service.PermissionRestInternalService;
import com.wenyu7980.authentication.common.feign.fallback.PermissionFallbackService;
import org.springframework.cloud.openfeign.FeignClient;

/**
 *
 * @author wenyu
 */
@FeignClient(name = "wy-authentication", path = "internal/permissions", contextId = "wy-auth-permissions-rest", fallback = PermissionFallbackService.class)
public interface PermissionRestService extends PermissionRestInternalService {
}
