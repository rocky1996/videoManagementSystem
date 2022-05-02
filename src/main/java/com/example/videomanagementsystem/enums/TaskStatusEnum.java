package com.example.videomanagementsystem.enums;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public enum TaskStatusEnum {

    NOT_STARTED(0, "未开始") {
        @Override
        public List<TaskStatusEnum> nextStatus() {
            List<TaskStatusEnum> notStartedList = new LinkedList<>();
            notStartedList.add(TaskStatusEnum.RUNNING);
            notStartedList.add(TaskStatusEnum.OVER);
            notStartedList.add(TaskStatusEnum.STOPPED);
            return notStartedList;
        }
    },
    RUNNING(1, "运行中") {
        @Override
        public List<TaskStatusEnum> nextStatus() {
            List<TaskStatusEnum> runningList = new LinkedList<>();
            runningList.add(TaskStatusEnum.RUNNING);
            runningList.add(TaskStatusEnum.STOPPED);
            return runningList;
        }
    },
    OVER(2, "已结束") {
        @Override
        public List<TaskStatusEnum> nextStatus() {
            return new LinkedList<>();
        }
    },
    STOPPED(3, "已停止") {
        @Override
        public List<TaskStatusEnum> nextStatus() {
            return new LinkedList<>();
        }
    },
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

    public abstract List<TaskStatusEnum> nextStatus();

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
