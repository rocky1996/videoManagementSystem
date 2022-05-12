package com.example.videomanagementsystem.controller.req;

import com.example.videomanagementsystem.dao.params.UserQueryParam;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

@Data
public class UserQueryReq {

    private String username;

    private Integer roleId;

    private Integer statusId;

    @Range(min = 1)
    private int pageNum = 1;

    @Range(min = 1, max = 1000)
    private int pageSize = 10;

    public UserQueryParam convert() {
        UserQueryParam param = new UserQueryParam();
        param.setUsername(username);
        param.setRoleId(roleId);
        param.setStatusId(statusId);
        param.setOffset((pageNum - 1) * pageSize);
        param.setSize(pageSize);
        return param;
    }
}
