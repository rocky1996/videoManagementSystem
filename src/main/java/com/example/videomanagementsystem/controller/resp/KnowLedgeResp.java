package com.example.videomanagementsystem.controller.resp;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
public class KnowLedgeResp {

    /**
     * 总数
     */
    private Integer total;

    /**
     * 详情list
     */
    private List<ItemDetail> items;

    @Data
    @Accessors(chain = true)
    public static class ItemDetail{

        /**
         * url
         */
        private String url;

        /**
         * 名称
         */
        private String entityName;

        /**
         * 类别
         */
        private String entityTypeName;

        /**
         * 描述
         */
        private String description;

        /**
         * 国家
         */
        private String nation;

        /**
         * 收录时间
         */
        private String includeTime;
    }
}
