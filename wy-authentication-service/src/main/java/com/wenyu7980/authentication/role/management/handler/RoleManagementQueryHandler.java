package com.wenyu7980.authentication.role.management.handler;

import com.wenyu7980.authentication.role.management.domain.RoleManagementDetail;
import com.wenyu7980.authentication.role.management.domain.RoleManagementListDetail;
import com.wenyu7980.authentication.role.management.domain.RoleManagementPageDetail;
import com.wenyu7980.data.jpa.query.QueryListHandler;
import com.wenyu7980.data.jpa.query.QueryPageHandler;

public interface RoleManagementQueryHandler
  extends QueryListHandler<RoleManagementListDetail>, QueryPageHandler<RoleManagementPageDetail> {
    /**
     * 详情查询
     * @param id
     * @return
     */
    RoleManagementDetail getDetail(String id);
}
