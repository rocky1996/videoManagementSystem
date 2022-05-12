package com.example.videomanagementsystem.enums;

import java.util.HashMap;
import java.util.Map;

public enum LanguagesTypeEnum {

    Z_Y(0, "藏语"),
    Y_Y(1, "英语"),
    W_Y(2, "维语"),
    YUE_Y(3, "粤语"),
    P_T_H(4, "普通话"),
    ;

    private Integer code;
    private String name;

    LanguagesTypeEnum() {}

    LanguagesTypeEnum(Integer code, String name) {
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

    private static Map<Integer, LanguagesTypeEnum> enumMap = new HashMap<>();
    static {
        for (LanguagesTypeEnum languagesTypeEnum : values()) {
            enumMap.put(languagesTypeEnum.getCode(), languagesTypeEnum);
        }
    }

    public static LanguagesTypeEnum getLanguagesTypeEnum(Integer code) {
        return enumMap.get(code);
    }
}
