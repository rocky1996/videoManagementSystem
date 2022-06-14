package com.example.videomanagementsystem.kafkamq.mqBean;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class CollectToSystemBean {

    /**
     * 视频url
     */
    private String videoUrl;

    /**
     * nowTime
     */
    private Date nowTime;
}
