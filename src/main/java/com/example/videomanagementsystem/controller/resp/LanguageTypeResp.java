package com.example.videomanagementsystem.controller.resp;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class LanguageTypeResp {

    /**
     * 语种id
     */
    private Integer languageId;

    /**
     * 语种名称
     */
    private String languageName;
}