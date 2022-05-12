package com.example.videomanagementsystem.controller.resp;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class GatherFieldResp {
    /**
     * 采集字段id
     */
    private Integer gatherFieldId;

    /**
     * 采集字段名称
     */
    private String gatherFieldName;
}
