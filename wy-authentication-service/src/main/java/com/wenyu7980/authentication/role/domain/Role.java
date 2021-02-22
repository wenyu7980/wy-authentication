package com.wenyu7980.authentication.role.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 *
 * @author wenyu
 */
@ApiModel(description = "角色")
public class Role {
    @ApiModelProperty(value = "角色id", accessMode = ApiModelProperty.AccessMode.READ_ONLY)
    private String id;
    @ApiModelProperty(value = "角色名称", accessMode = ApiModelProperty.AccessMode.READ_ONLY)
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
