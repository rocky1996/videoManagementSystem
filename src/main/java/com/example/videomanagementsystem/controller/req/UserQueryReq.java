package com.example.videomanagementsystem.controller.req;

import com.example.videomanagementsystem.dao.params.UserQueryParam;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

@Data
public class UserQueryReq {

    @Range(min = 1)
    private int page_num = 1;

    @Range(min = 1, max = 1000)
    private int page_size = 10;

    public UserQueryParam convert() {
        UserQueryParam param = new UserQueryParam();
        param.setOffset((page_num - 1) * page_size);
        param.setSize(page_size);
        return param;
    }
}
