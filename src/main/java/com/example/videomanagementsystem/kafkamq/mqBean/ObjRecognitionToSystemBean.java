package com.example.videomanagementsystem.kafkamq.mqBean;

import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Builder
public class ObjRecognitionToSystemBean {

    /**
     * 唯一标识
     */
    private Integer onlyCode;

    /**
     * url
     */
    private String videoUrl;

    /**
     * nowTime
     */
    private Date nowTime;

    /**
     * msgCode
     */
    private String msgCode;

    /**
     * MsgBody
     */
    private MsgBody msgBody;

    @Data
    @Builder
    public static class MsgBody {

        /**
         * 人物
         */
        private List<String> personInfo;

        /**
         * 武器
         */
        private List<String> weaponInfo;

        /**
         * 地點
         */
        private List<String> locationInfo;
    }
}
