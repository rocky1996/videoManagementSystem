package com.example.videomanagementsystem.enums;

import java.util.HashMap;
import java.util.Map;

public enum SecondMenuEnum {

    PENDING_REVIEW(0, "待审核"),
    HAVING_REVIEW(1, "已审核"),
    ALL_REVIEW(2, "全部"),
    USER_MANAGEMENT(3, "用户管理"),
    ROLE_MANAGEMENT(4, "角色管理"),
    CUSTOMER_MANAGEMENT(5, "客户管理"),
    FEEDBACK(6, "反馈意见");
    ;

    private Integer code;
    private String name;

    SecondMenuEnum() {}

    SecondMenuEnum(Integer code, String name) {
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

    private static Map<Integer, SecondMenuEnum> enumMap = new HashMap<>();
    static {
        for (SecondMenuEnum secondMenuEnum : values()) {
            enumMap.put(secondMenuEnum.getCode(), secondMenuEnum);
        }
    }

    public static SecondMenuEnum getSecondMenuEnum(Integer code) {
        return enumMap.get(code);
    }
}
