package com.example.videomanagementsystem.controller.req;

import com.example.videomanagementsystem.dao.params.UserQueryParam;
import lombok.Data;

@Data
public class UserQueryReq {

    private int page_num = 1;

    private int page_size = 10;

    public UserQueryParam convert() {
        UserQueryParam param = new UserQueryParam();
        param.setOffset((page_num - 1) * page_size);
        param.setSize(page_size);
        return param;
    }
}
