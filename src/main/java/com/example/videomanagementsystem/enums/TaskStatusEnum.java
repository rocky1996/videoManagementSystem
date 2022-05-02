package com.example.videomanagementsystem.enums;

import java.util.HashMap;
import java.util.Map;

public enum TaskStatusEnum {

    NOT_STARTED(0, "未开始"),
    RUNNING(1, "运行中"),
    OVER(2, "已结束"),
    STOPPED(3, "已停止"),
    ;

    private Integer code;
    private String name;

    TaskStatusEnum() {}

    TaskStatusEnum(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private static Map<Integer, TaskStatusEnum> enumMap = new HashMap<>();
    static {
        for (TaskStatusEnum taskStatusEnum : values()) {
            enumMap.put(taskStatusEnum.getCode(), taskStatusEnum);
        }
    }

    public static TaskStatusEnum getTaskStatusEnum(Integer code) {
        return enumMap.get(code);
    }
}
