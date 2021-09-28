package com.tanjr.demo.controller.demo.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.groups.Default;

@Data
public class DemoVO {
    public interface CreateGroup extends Default {}
    public interface GetGroup extends Default {}

    @Null(message = "id必须为空", groups = CreateGroup.class)
    @NotNull(message = "id不能为空",groups = GetGroup.class)
    @ApiModelProperty(value = "demoId")
    private Integer demoId;

    @NotNull(message = "id不能为空",groups = GetGroup.class)
    @ApiModelProperty(value = "demo名称")
    private String name;

    @ApiModelProperty(value = "demo描述")
    private String description;
}
