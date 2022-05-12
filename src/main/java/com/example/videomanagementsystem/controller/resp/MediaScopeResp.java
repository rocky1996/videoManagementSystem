package com.example.videomanagementsystem.controller.resp;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class MediaScopeResp {

    /**
     * 媒体id
     */
    private Integer mediaId;

    /**
     * 媒体名称
     */
    private String mediaName;
}