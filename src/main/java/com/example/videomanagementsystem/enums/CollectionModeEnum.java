package com.example.videomanagementsystem.enums;

import java.util.HashMap;
import java.util.Map;

public enum CollectionModeEnum {

    COLLECTION_KEY_WORD(0, "关键字采集"),
    COLLECTION_FIXED_SOURCE(1, "定源采集"),
    COLLECTION_KEY_WORD_AND_FIXED_SOURCE(2, "关键字采集 + 定源采集"),
    ;

    private Integer code;
    private String name;

    CollectionModeEnum() {}

    CollectionModeEnum(Integer code, String name) {
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

    private static Map<Integer, CollectionModeEnum> enumMap = new HashMap<>();
    static {
        for (CollectionModeEnum collectionModeEnum : values()) {
            enumMap.put(collectionModeEnum.getCode(), collectionModeEnum);
        }
    }

    public static CollectionModeEnum getCollectionModeEnum(Integer code) {
        return enumMap.get(code);
    }
}
