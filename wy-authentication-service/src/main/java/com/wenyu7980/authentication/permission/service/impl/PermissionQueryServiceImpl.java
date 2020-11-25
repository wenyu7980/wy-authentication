package com.wenyu7980.authentication.permission.service.impl;

import com.wenyu7980.authentication.permission.entity.PermissionEntity;
import com.wenyu7980.authentication.permission.service.PermissionQueryService;
import com.wenyu7980.data.jpa.query.AbstractQueryService;
import org.springframework.stereotype.Service;

/**
 *
 * @author wenyu
 */
@Service
public class PermissionQueryServiceImpl extends AbstractQueryService<PermissionEntity>
  implements PermissionQueryService {
}
