package com.example.videomanagementsystem.enums;

public enum RestEnum {

    SUCCESS(0, "成功"),
    UN_AUTHORIZED(401, "未登录"),
    FORBIDDEN(402, "没有权限"),
    SYSTEM_ERROR(402, "系统错误"),
    NO_HAVING_DATA(403, "没有搜索到任何相关数据"),
    FAILED(500, "失败"),
    ;

    private Integer code;
    private String msg;

    RestEnum() {
    }

    RestEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
