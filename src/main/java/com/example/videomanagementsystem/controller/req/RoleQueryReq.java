package com.example.videomanagementsystem.controller.req;

import com.example.videomanagementsystem.dao.params.UserRoleQueryParam;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

@Data
public class RoleQueryReq {

    private String roleName;

    private int statusId;

    @Range(min = 1)
    private int pageNum = 1;

    @Range(min = 1, max = 1000)
    private int pageSize = 10;

    public UserRoleQueryParam convert() {
        UserRoleQueryParam param = new UserRoleQueryParam();
        param.setRoleName(roleName);
        param.setStatusId(statusId);
        param.setOffset((pageNum - 1) * pageSize);
        param.setSize(pageSize);
        return param;
    }
}
