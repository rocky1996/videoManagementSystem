package com.example.videomanagementsystem.dao.params;

import lombok.Data;

@Data
public class UserQueryParam {

    private String username;

    private Integer roleId;

    private Integer statusId;

    private int offset;

    private int size;
}
