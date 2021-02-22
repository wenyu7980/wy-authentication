package com.wenyu7980.authentication.role.service.impl;

import com.wenyu7980.authentication.role.entity.RoleEntity;
import com.wenyu7980.authentication.role.service.RoleQueryService;
import com.wenyu7980.data.jpa.query.AbstractQueryService;
import org.springframework.stereotype.Service;

/**
 *
 * @author wenyu
 */
@Service
public class RoleQueryServiceImpl extends AbstractQueryService<RoleEntity> implements RoleQueryService {
}
