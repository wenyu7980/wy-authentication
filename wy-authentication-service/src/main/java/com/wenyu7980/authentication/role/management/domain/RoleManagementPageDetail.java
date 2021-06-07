package com.wenyu7980.authentication.role.management.domain;

import com.wenyu7980.authentication.role.domain.Role;
import com.wenyu7980.organization.aggregation.UserAggregation;
import io.swagger.annotations.ApiModelProperty;

import java.time.LocalDateTime;

public class RoleManagementPageDetail extends Role {
    @ApiModelProperty(value = "创建者", accessMode = ApiModelProperty.AccessMode.READ_ONLY)
    private UserAggregation createdUser;
    @ApiModelProperty(value = "创建时间", accessMode = ApiModelProperty.AccessMode.READ_ONLY)
    private LocalDateTime createdDateTime;
    @ApiModelProperty(value = "更新者", accessMode = ApiModelProperty.AccessMode.READ_ONLY)
    private UserAggregation updatedUser;
    @ApiModelProperty(value = "更新时间", accessMode = ApiModelProperty.AccessMode.READ_ONLY)
    private LocalDateTime updatedDateTime;

    public UserAggregation getCreatedUser() {
        return createdUser;
    }

    public void setCreatedUser(UserAggregation createdUser) {
        this.createdUser = createdUser;
    }

    public LocalDateTime getCreatedDateTime() {
        return createdDateTime;
    }

    public void setCreatedDateTime(LocalDateTime createdDateTime) {
        this.createdDateTime = createdDateTime;
    }

    public UserAggregation getUpdatedUser() {
        return updatedUser;
    }

    public void setUpdatedUser(UserAggregation updatedUser) {
        this.updatedUser = updatedUser;
    }

    public LocalDateTime getUpdatedDateTime() {
        return updatedDateTime;
    }

    public void setUpdatedDateTime(LocalDateTime updatedDateTime) {
        this.updatedDateTime = updatedDateTime;
    }
}
