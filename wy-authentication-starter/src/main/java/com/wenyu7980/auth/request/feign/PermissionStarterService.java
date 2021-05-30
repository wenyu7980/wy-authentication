package com.wenyu7980.auth.request.feign;

import com.wenyu7980.authentication.api.service.PermissionStarterFacade;
import com.wenyu7980.common.feign.config.FeignClientStarterConfig;
import org.springframework.cloud.openfeign.FeignClient;

/**
 *
 * @author wenyu
 */
@FeignClient(name = "wy-authentication", contextId = "wy-auth-permissions-starter", configuration = FeignClientStarterConfig.class, fallback = PermissionFallbackService.class)
public interface PermissionStarterService extends PermissionStarterFacade {
}
