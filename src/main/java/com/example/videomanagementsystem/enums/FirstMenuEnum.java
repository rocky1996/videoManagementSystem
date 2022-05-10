package com.example.videomanagementsystem.enums;

import com.example.videomanagementsystem.constants.MenuResult;

import java.util.*;

public enum FirstMenuEnum {

    TASK_DISTRIBUTION(0, "任务下发", MenuResult.getTaskDistributionList()),
    PUSH_RECORD(1, "推送记录", MenuResult.getPushRecordList()),
    ISSUE_DISTRIBUTION(2, "审核下发", MenuResult.getIssueList()),
    TASK_MONITORING(3, "任务监控", MenuResult.getTaskMonitoringList()),
    SYSTEM_MANAGEMENT(4, "系统设置", MenuResult.getSystemList()),
    ;

    private Integer code;
    private String name;
    private List<SecondMenuEnum> secondMenuEnumList;

    FirstMenuEnum() {}

    FirstMenuEnum(Integer code, String name, List<SecondMenuEnum> secondMenuEnumList) {
        this.code = code;
        this.name = name;
        this.secondMenuEnumList = secondMenuEnumList;
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

    public List<SecondMenuEnum> getSecondMenuEnumList() {
        return secondMenuEnumList;
    }

    public void setSecondMenuEnumList(List<SecondMenuEnum> secondMenuEnumList) {
        this.secondMenuEnumList = secondMenuEnumList;
    }

    private static Map<Integer, FirstMenuEnum> enumMap = new HashMap<>();
    static {
        for (FirstMenuEnum firstMenuEnum : values()) {
            enumMap.put(firstMenuEnum.getCode(), firstMenuEnum);
        }
    }

    public static FirstMenuEnum getFirstMenuEnum(Integer code) {
        return enumMap.get(code);
    }
}
