package com.example.videomanagementsystem.enums;

import java.util.HashMap;
import java.util.Map;

public enum MediaSourceEnum {

    WEBSITE(0, "网站"),
    YOUTUBE(1, "YouTube"),
    FACEBOOK(2, "FaceBook"),
    TWITTER(3, "Twitter"),
    ;

    private Integer code;
    private String name;

    MediaSourceEnum() {}

    MediaSourceEnum(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private static Map<Integer, MediaSourceEnum> enumMap = new HashMap<>();
    static {
        for (MediaSourceEnum mediaSourceEnum : values()) {
            enumMap.put(mediaSourceEnum.getCode(), mediaSourceEnum);
        }
    }

    public static MediaSourceEnum getMediaSourceEnum(Integer code) {
        return enumMap.get(code);
    }
}
