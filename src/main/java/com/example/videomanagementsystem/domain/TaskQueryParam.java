package com.example.videomanagementsystem.domain;

import lombok.Data;

@Data
public class TaskQueryParam {

    private String taskName;

    private String keyword;

    private Integer taskType;

    private Integer status;
    private Integer userId;
    private int offset;

    private int size;


}
