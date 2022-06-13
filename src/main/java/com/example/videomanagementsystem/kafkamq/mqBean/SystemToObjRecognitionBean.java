package com.example.videomanagementsystem.kafkamq.mqBean;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class SystemToObjRecognitionBean {

    /**
     * 唯一标识
     */
    private String onlyCode;

    /**
     * url
     */
    private String videoUrl;

    /**
     * nowTime
     */
    private Date nowTime;
}
