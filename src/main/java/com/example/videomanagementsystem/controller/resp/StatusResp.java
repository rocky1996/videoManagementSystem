package com.example.videomanagementsystem.controller.resp;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class StatusResp {

    /**
     * 状态id
     */
    private Integer statusIs;

    /**
     * 状态名称
     */
    private String statusName;
}
