package com.example.videomanagementsystem.enums;

import java.util.HashMap;
import java.util.Map;

public enum ProofreadingEnum {

    YES(0, "是"),
    NO(1, "否"),
    ;

    private Integer code;
    private String name;

    ProofreadingEnum() {}

    ProofreadingEnum(Integer code, String name) {
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

    private static Map<Integer, ProofreadingEnum> enumMap = new HashMap<>();
    static {
        for (ProofreadingEnum proofreadingEnum : values()) {
            enumMap.put(proofreadingEnum.getCode(), proofreadingEnum);
        }
    }

    public static ProofreadingEnum getProofreadingEnum(Integer code) {
        return enumMap.get(code);
    }
}
