package com.example.videomanagementsystem.controller.resp;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class TaskTypeResp {
    /**
     * 任务类型id
     */
    private Integer taskTypeId;

    /**
     * 任务类型名称
     */
    private String taskTypeName;
}
