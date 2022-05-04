package com.example.videomanagementsystem.domain;

import lombok.Data;
import org.hibernate.validator.constraints.Range;
@Data
public class TaskQueryParamReq {

    private Integer userId;
    private String taskName;

    private String keyword;

    private Integer taskType;

    private Integer status;
    @Range(min = 1)
    private int pageNum = 1;
    @Range(min = 1, max = 1000)
    private int pageSize = 10;

    public TaskQueryParam convert() {
        TaskQueryParam param = new TaskQueryParam();
        param.setTaskName(taskName);
        param.setTaskType(taskType);
        param.setStatus(status);
        param.setKeyword(keyword);
        param.setUserId(userId);
        param.setOffset((pageNum - 1) * pageSize);
        param.setSize(pageSize);
        return param;
    }
}
