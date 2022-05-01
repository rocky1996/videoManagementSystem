package com.example.videomanagementsystem.enums;

import java.util.HashMap;
import java.util.Map;

public enum TaskTypeEnum {

    TASK_DAY_SHIFT(0, "日更任务"),
    TASK_ONE_TIME(1, "一次性任务"),
    ;

    private Integer code;
    private String name;

    TaskTypeEnum() {}

    TaskTypeEnum(Integer code, String name) {
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

    private static Map<Integer, TaskTypeEnum> enumMap = new HashMap<>();
    static {
        for (TaskTypeEnum taskTypeEnum : values()) {
            enumMap.put(taskTypeEnum.getCode(), taskTypeEnum);
        }
    }

    public static TaskTypeEnum getTaskTypeEnum(Integer code) {
        return enumMap.get(code);
    }
}
