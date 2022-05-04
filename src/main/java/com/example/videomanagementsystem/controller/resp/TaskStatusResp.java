package com.example.videomanagementsystem.controller.resp;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class TaskStatusResp {
    /**
     * 任务流转状态id
     */
    private Integer taskStatusIs;

    /**
     * 任务流转状态名称
     */
    private String taskStatusName;
}