package com.wenyu7980.authentication.matrix.service.impl;

import com.wenyu7980.authentication.matrix.entity.MatrixPermissionEntity;
import com.wenyu7980.authentication.matrix.service.MatrixPermissionQueryService;
import com.wenyu7980.authentication.matrix.service.MatrixPermissionService;
import com.wenyu7980.data.jpa.query.AbstractQueryService;
import org.springframework.stereotype.Service;

/**
 *
 * @author wenyu
 */
@Service
public class MatrixPermissionServiceImpl extends AbstractQueryService<MatrixPermissionEntity>
  implements MatrixPermissionService, MatrixPermissionQueryService {
}
