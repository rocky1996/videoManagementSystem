package com.example.videomanagementsystem.constants;

import com.example.videomanagementsystem.enums.RestEnum;

public class RestResult<T> {
    private Integer code;
    private String msg;
    private T data;

    public RestResult(RestEnum restEnum) {
        this.code = restEnum.getCode();
        this.msg = restEnum.getMsg();
    }
    public RestResult(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public RestResult(RestEnum restEnum, T data) {
        this.code = restEnum.getCode();
        this.msg = restEnum.getMsg();
        this.data = data;
    }
    public RestResult(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

//    public RestResult getResult(RestEnum restEnum) {
//        return new RestResult(restEnum.getCode(), restEnum.getMsg());
//    }
//
//    public RestResult getResult(RestEnum restEnum, T data){
//        return new RestResult(restEnum.getCode(), restEnum.getMsg(), data);
//    }
//
//    public RestResult getResult(Integer code, String msg) {
//        return new RestResult(code, msg);
//    }
//
//    public RestResult getResult(Integer code, String msg, T data){
//        return new RestResult(code, msg, data);
//    }
}
