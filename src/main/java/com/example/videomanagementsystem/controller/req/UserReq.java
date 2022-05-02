package com.example.videomanagementsystem.controller.req;

import lombok.Data;

@Data
public class UserReq {

    private Integer userId;

    private String username;

    private String password;

    private String rePassword;

    private String userDesc;

    private Integer status;

    private Integer roleId;
}
