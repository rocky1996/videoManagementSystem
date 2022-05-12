package com.example.videomanagementsystem.dao.params;

import lombok.Data;

@Data
public class UserRoleQueryParam {

    private String roleName;

    private Integer statusId;

    private int offset;

    private int size;
}
