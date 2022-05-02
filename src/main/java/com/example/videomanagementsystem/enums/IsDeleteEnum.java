package com.example.videomanagementsystem.enums;

import java.util.HashMap;
import java.util.Map;

public enum IsDeleteEnum {

    NOT_DELETE(0, "未删除"),
    DELETED(1, "已删除")
    ;

    private Integer code;
    private String name;

    IsDeleteEnum() {
    }

    IsDeleteEnum(Integer code, String name) {
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

    private static Map<Integer, IsDeleteEnum> enumMap = new HashMap<>();
    static {
        for (IsDeleteEnum isDeleteEnum : values()) {
            enumMap.put(isDeleteEnum.getCode(), isDeleteEnum);
        }
    }

    public static IsDeleteEnum getIsDeleteEnum(Integer code) {
        return enumMap.get(code);
    }
}
