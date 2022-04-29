package com.example.videomanagementsystem.enums;

import java.util.HashMap;
import java.util.Map;

public enum EffectiveEnum {

    OPEN_EFFECTIVE(0, "已生效(开)"),
    CLOSE_EFFECTIVE(1, "未生效(关)")
    ;

    private Integer code;
    private String desc;

    EffectiveEnum() {
    }

    EffectiveEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    private static Map<Integer, EffectiveEnum> enumMap = new HashMap<>();
    static {
        for (EffectiveEnum effectiveEnum : values()) {
            enumMap.put(effectiveEnum.getCode(), effectiveEnum);
        }
    }

    public static EffectiveEnum getEffectiveEnum(Integer code) {
        return enumMap.get(code);
    }
}
