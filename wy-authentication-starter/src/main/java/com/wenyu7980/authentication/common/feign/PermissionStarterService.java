package com.wenyu7980.authentication.common.feign;

import com.wenyu7980.authentication.api.service.PermissionStarterInternalService;
import org.springframework.cloud.openfeign.FeignClient;

/**
 *
 * @author wenyu
 */
@FeignClient(name = "wy-authentication", path = "internal", contextId = "wy-auth-permissions-starter", fallback = PermissionFallbackService.class)
public interface PermissionStarterService extends PermissionStarterInternalService {
}
