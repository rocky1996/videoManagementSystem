package com.example.videomanagementsystem.enums;

import com.example.videomanagementsystem.constants.AuthMap;

import java.util.*;

public enum AuthEnum {

    SUPER_ADMIN(0, "超级管理员权限", AuthMap.getSuperAdminMap()),
    ORDER_ADMIN(1, "下单平台管理员权限", AuthMap.getOrderAdminMap()),
    APPROVE_ADMIN(2, "审核平台管理员权限", AuthMap.getApproveAdminMap()),
    ORDER_PERSON(3, "下单人员权限", AuthMap.getOrderMap()),
    APPROVE_PERSON(4, "审核人员权限", AuthMap.getApproveMap())
    ;

    private Integer code;
    private String name;
    private Map relaMap;

    AuthEnum() {}

    AuthEnum(Integer code, String name, Map relaMap) {
        this.code = code;
        this.name = name;
        this.relaMap = relaMap;
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

    public Map getRelaMap() {
        return relaMap;
    }

    public void setRelaMap(Map relaMap) {
        this.relaMap = relaMap;
    }

    private static Map<Integer, AuthEnum> enumMap = new HashMap<>();
    static {
        for (AuthEnum authEnum : values()) {
            enumMap.put(authEnum.getCode(), authEnum);
        }
    }

    public static AuthEnum getAuthEnum(Integer code) {
        return enumMap.get(code);
    }
}
