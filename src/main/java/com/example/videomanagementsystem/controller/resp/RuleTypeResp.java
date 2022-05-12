package com.example.videomanagementsystem.controller.resp;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class RuleTypeResp {

    /**
     * 分配方式id
     */
    private Integer ruleTypeId;

    /**
     * 分配方式名称
     */
    private String ruleTypeName;
}
