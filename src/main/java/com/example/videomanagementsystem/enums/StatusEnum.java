package com.example.videomanagementsystem.enums;

import java.util.HashMap;
import java.util.Map;

public enum StatusEnum {

    OPEN_EFFECTIVE(0, "开启"),
    CLOSE_EFFECTIVE(1, "关闭")
    ;

    private Integer code;
    private String name;

    StatusEnum() {
    }

    StatusEnum(Integer code, String name) {
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

    private static Map<Integer, StatusEnum> enumMap = new HashMap<>();
    static {
        for (StatusEnum statusEnum : values()) {
            enumMap.put(statusEnum.getCode(), statusEnum);
        }
    }

    public static StatusEnum getStatusEnum(Integer code) {
        return enumMap.get(code);
    }
}
