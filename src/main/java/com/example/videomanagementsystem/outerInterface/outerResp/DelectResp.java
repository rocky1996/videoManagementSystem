package com.example.videomanagementsystem.outerInterface.outerResp;

import lombok.Data;

@Data
public class DelectResp {

    private Integer responseStatus;
    private String responseDetails;
    private ResponseData responseData;

    @Data
    public static class ResponseData{
        private Integer confidence;
        private String language;
    }
}
