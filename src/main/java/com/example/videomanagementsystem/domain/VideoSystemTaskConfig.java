package com.example.videomanagementsystem.domain;

import java.util.Date;

public class VideoSystemTaskConfig {
    //主键id
    private Long id;
    //用户id
    private Long userId;
    //任务id
    private Long videoSystemTaskId;
    //包含以下任一关键字,多个的话逗号隔开
    private String includeArbitrarilyKw;
    //包含以下全部关键字,多个的话逗号隔开
    private String includeAllKw;
    //屏蔽以下任一关键字,多个的话逗号隔开
    private String shieldArbitrarilyKw;
    //网站名称
    private String websiteName;
    //网站url
    private String websiteUrl;
    //逻辑删除,0:未删除,1:已删除
    private Integer idDelete;
    //创建时间
    private Date createTime;
    //更新时间
    private Date updateTime;
    //0:ALL,1:网站,2:YouTube,3:FaceBook,4:Twitter
    private Integer mediaScope;

    private String bloggerIdStr;

    public Integer getMediaScope() {
        return mediaScope;
    }

    public void setMediaScope(Integer mediaScope) {
        this.mediaScope = mediaScope;
    }

    public String getBloggerIdStr() {
        return bloggerIdStr;
    }

    public void setBloggerIdStr(String bloggerIdStr) {
        this.bloggerIdStr = bloggerIdStr;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getVideoSystemTaskId() {
        return videoSystemTaskId;
    }

    public void setVideoSystemTaskId(Long videoSystemTaskId) {
        this.videoSystemTaskId = videoSystemTaskId;
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

    public String getWebsiteName() {
        return websiteName;
    }

    public void setWebsiteName(String websiteName) {
        this.websiteName = websiteName;
    }

    public String getWebsiteUrl() {
        return websiteUrl;
    }

    public void setWebsiteUrl(String websiteUrl) {
        this.websiteUrl = websiteUrl;
    }


    public Integer getIdDelete() {
        return idDelete;
    }

    public void setIdDelete(Integer idDelete) {
        this.idDelete = idDelete;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
