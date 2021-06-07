package com.wenyu7980.authentication.role.management.handler.impl;

import com.wenyu7980.authentication.role.convert.RoleConverter;
import com.wenyu7980.authentication.role.entity.RoleEntity;
import com.wenyu7980.authentication.role.management.domain.RoleManagementListDetail;
import com.wenyu7980.authentication.role.management.domain.RoleManagementPageDetail;
import com.wenyu7980.authentication.role.management.handler.RoleManagementQueryHandler;
import com.wenyu7980.data.jpa.query.AbstractQueryHandler;
import com.wenyu7980.organization.aggregation.UserAggregation;
import org.springframework.stereotype.Component;

@Component
public class RoleManagementQueryHandlerImpl
  extends AbstractQueryHandler<RoleEntity, RoleManagementListDetail, RoleManagementPageDetail>
  implements RoleManagementQueryHandler {
    @Override
    public RoleManagementListDetail convertList(RoleEntity entity) {
        RoleManagementListDetail detail = new RoleManagementListDetail();
        RoleConverter.convert(entity, detail);
        return detail;
    }

    @Override
    public RoleManagementPageDetail convertPage(RoleEntity entity) {
        RoleManagementPageDetail detail = new RoleManagementPageDetail();
        RoleConverter.convert(entity, detail);
        detail.setCreatedUser(UserAggregation.of(entity.getCreatedUserId()));
        detail.setCreatedDateTime(entity.getCreatedDateTime());
        detail.setUpdatedUser(UserAggregation.of(entity.getCreatedUserId()));
        detail.setUpdatedDateTime(entity.getUpdatedDateTime());
        return detail;
    }
}
