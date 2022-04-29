package com.example.videomanagementsystem.enums;

import java.util.HashMap;
import java.util.Map;

public enum RolePermissionsEnum {

    ADMIN(0,"admin", "管理员"),
    TASK_ADMIN(1, "任务管理员", "任务管理员"),
    VIDEO_ADMIN(2, "视频管理员", "视频管理员"),
    PUSH_ADMIN(3, "推送管理员", "推送管理员"),
    ;

    private Integer code;
    private String name;
    private String desc;

    RolePermissionsEnum() {

    }

    RolePermissionsEnum(Integer code, String name, String desc) {
        this.code = code;
        this.name = name;
        this.desc = desc;
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

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    private static Map<Integer, RolePermissionsEnum> enumMap = new HashMap<>();
    static {
        for (RolePermissionsEnum rolePermissionsEnum : values()) {
            enumMap.put(rolePermissionsEnum.getCode(), rolePermissionsEnum);
        }
    }

    public static RolePermissionsEnum getRolePermissionsEnum(Integer code) {
        return enumMap.get(code);
    }
}
