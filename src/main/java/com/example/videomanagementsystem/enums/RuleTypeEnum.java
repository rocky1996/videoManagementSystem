package com.example.videomanagementsystem.enums;

import java.util.HashMap;
import java.util.Map;

public enum RuleTypeEnum {

    AVERAGE_DISTRIBUTION(0, "按平均分配"),
    PROPORTIONAL_DISTRIBUTION(1, "按比例分配"),
    ;

    private Integer code;
    private String name;

    RuleTypeEnum() {}

    RuleTypeEnum(Integer code, String name) {
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

    private static Map<Integer, RuleTypeEnum> enumMap = new HashMap<>();
    static {
        for (RuleTypeEnum ruleTypeEnum : values()) {
            enumMap.put(ruleTypeEnum.getCode(), ruleTypeEnum);
        }
    }

    public static RuleTypeEnum getRuleTypeEnum(Integer code) {
        return enumMap.get(code);
    }
}
