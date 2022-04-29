package com.example.videomanagementsystem.enums;

import java.util.HashMap;
import java.util.Map;

public enum GatherAuthEnum {

    GATHER_VIDEO(0, "采集视频"),
    COMMENT_VOLUME(1, "评论量"),
    PRAISE_QUANTITY(2, "点赞量"),
    VIDEO_DESCRIPTION(3, "视频描述"),
    FORWARDING_VOLUME(4, "转发量"),
    SOURCE(5, "来源"),
    VIEWS(6, "浏览量"),
    ORIGINAL_ADDRESS(7, "原文地址"),
    RELEASE_TIME(8, "发布时间"),
    COUNTRY(9, "国家"),
    LANGUAGES(10, "语种"),
    TITLE(11, "标题"),
    COMMENT_LIST(12, "评论列表"),
    ;

    private Integer code;
    private String desc;

    GatherAuthEnum() {}

    GatherAuthEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    private static Map<Integer, GatherAuthEnum> enumMap = new HashMap<>();
    static {
        for (GatherAuthEnum gatherAuthEnum : values()) {
            enumMap.put(gatherAuthEnum.getCode(), gatherAuthEnum);
        }
    }

    public static GatherAuthEnum getGatherAuthEnum(Integer code) {
        return enumMap.get(code);
    }
}
