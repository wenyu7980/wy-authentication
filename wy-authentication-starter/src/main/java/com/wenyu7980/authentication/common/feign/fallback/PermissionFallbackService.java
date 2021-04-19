package com.wenyu7980.authentication.common.feign.fallback;

import com.wenyu7980.authentication.api.domain.PermissionInternalManipulation;
import com.wenyu7980.authentication.common.feign.PermissionRestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Set;

/**
 *
 * @author wenyu
 */
public class PermissionFallbackService implements PermissionRestService {
    private static final Logger LOGGER = LoggerFactory.getLogger(PermissionRestService.class);

    @Override
    public void manipulation(String serviceName, Set<PermissionInternalManipulation> permissions) {
        LOGGER.error("PermissionInternalService-manipulation调用失败,参数serviceName:{},permissions:{}", serviceName,
          permissions);
    }

}
