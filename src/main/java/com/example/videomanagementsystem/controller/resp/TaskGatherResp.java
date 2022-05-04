package com.example.videomanagementsystem.controller.resp;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class TaskGatherResp {
    /**
     * 任务采集方式id
     */
    private Integer taskGatherTypeId;

    /**
     * 任务采集方式名称
     */
    private String taskGatherTypeName;
}
