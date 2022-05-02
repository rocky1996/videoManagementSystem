package com.example.videomanagementsystem.domain;

import java.util.List;

public class VideoGatherKeyWord {
    //0:ALL,1:网站,2:YouTube,3:FaceBook,4:Twitter
    private Integer mediaScope;

    //包含以下任一关键字,多个的话逗号隔开
    private String includeArbitrarilyKw;
    //包含以下全部关键字,多个的话逗号隔开
    private String includeAllKw;
    //屏蔽以下任一关键字,多个的话逗号隔开
    private String shieldArbitrarilyKw;

    private String bloggerIdStr;

    private List<WebsiteInfo> websiteInfo;

    public Integer getMediaScope() {
        return mediaScope;
    }

    public void setMediaScope(Integer mediaScope) {
        this.mediaScope = mediaScope;
    }

    public String getIncludeArbitrarilyKw() {
        return includeArbitrarilyKw;
    }

    public void setIncludeArbitrarilyKw(String includeArbitrarilyKw) {
        this.includeArbitrarilyKw = includeArbitrarilyKw;
    }

    public String getIncludeAllKw() {
        return includeAllKw;
    }

    public void setIncludeAllKw(String includeAllKw) {
        this.includeAllKw = includeAllKw;
    }

    public String getShieldArbitrarilyKw() {
        return shieldArbitrarilyKw;
    }

    public void setShieldArbitrarilyKw(String shieldArbitrarilyKw) {
        this.shieldArbitrarilyKw = shieldArbitrarilyKw;
    }

    public String getBloggerIdStr() {
        return bloggerIdStr;
    }

    public void setBloggerIdStr(String bloggerIdStr) {
        this.bloggerIdStr = bloggerIdStr;
    }

    public List<WebsiteInfo> getWebsiteInfo() {
        return websiteInfo;
    }

    public void setWebsiteInfo(List<WebsiteInfo> websiteInfo) {
        this.websiteInfo = websiteInfo;
    }
}
