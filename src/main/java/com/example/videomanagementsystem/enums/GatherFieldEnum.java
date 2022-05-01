package com.example.videomanagementsystem.enums;

import java.util.HashMap;
import java.util.Map;

public enum GatherFieldEnum {

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
    private String name;

    GatherFieldEnum() {}

    GatherFieldEnum(Integer code, String name) {
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

    private static Map<Integer, GatherFieldEnum> enumMap = new HashMap<>();
    static {
        for (GatherFieldEnum gatherFieldEnum : values()) {
            enumMap.put(gatherFieldEnum.getCode(), gatherFieldEnum);
        }
    }

    public static GatherFieldEnum getGatherFieldEnum(Integer code) {
        return enumMap.get(code);
    }
}
