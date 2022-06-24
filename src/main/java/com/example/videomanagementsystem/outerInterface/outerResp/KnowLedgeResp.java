package com.example.videomanagementsystem.outerInterface.outerResp;

import lombok.Data;

@Data
public class KnowLedgeResp {

    private boolean success;
    private int code;
    private String message;
    private Object data;
}
