package com.example.videomanagementsystem.domain;

import java.util.Date;

public class VideoSystemTaskConfig {
    private Integer id;

    private Integer userId;

    private Integer videoSystemTaskId;

    private Integer mediaScope;

    private String websiteName;

    private Integer isDelete;

    private Date createTime;

    private Date updateTime;

    private String includeArbitrarilyKeyword;

    private String includeAllKeyword;

    private String shieldArbitrarilyKeyword;

    private String websiteUrl;

    private String bloggerIdStr;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getVideoSystemTaskId() {
        return videoSystemTaskId;
    }

    public void setVideoSystemTaskId(Integer videoSystemTaskId) {
        this.videoSystemTaskId = videoSystemTaskId;
    }

    public Integer getMediaScope() {
        return mediaScope;
    }

    public void setMediaScope(Integer mediaScope) {
        this.mediaScope = mediaScope;
    }

    public String getWebsiteName() {
        return websiteName;
    }

    public void setWebsiteName(String websiteName) {
        this.websiteName = websiteName;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
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

    public String getIncludeArbitrarilyKeyword() {
        return includeArbitrarilyKeyword;
    }

    public void setIncludeArbitrarilyKeyword(String includeArbitrarilyKeyword) {
        this.includeArbitrarilyKeyword = includeArbitrarilyKeyword;
    }

    public String getIncludeAllKeyword() {
        return includeAllKeyword;
    }

    public void setIncludeAllKeyword(String includeAllKeyword) {
        this.includeAllKeyword = includeAllKeyword;
    }

    public String getShieldArbitrarilyKeyword() {
        return shieldArbitrarilyKeyword;
    }

    public void setShieldArbitrarilyKeyword(String shieldArbitrarilyKeyword) {
        this.shieldArbitrarilyKeyword = shieldArbitrarilyKeyword;
    }

    public String getWebsiteUrl() {
        return websiteUrl;
    }

    public void setWebsiteUrl(String websiteUrl) {
        this.websiteUrl = websiteUrl;
    }

    public String getBloggerIdStr() {
        return bloggerIdStr;
    }

    public void setBloggerIdStr(String bloggerIdStr) {
        this.bloggerIdStr = bloggerIdStr;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userId=").append(userId);
        sb.append(", videoSystemTaskId=").append(videoSystemTaskId);
        sb.append(", mediaScope=").append(mediaScope);
        sb.append(", websiteName=").append(websiteName);
        sb.append(", isDelete=").append(isDelete);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", includeArbitrarilyKeyword=").append(includeArbitrarilyKeyword);
        sb.append(", includeAllKeyword=").append(includeAllKeyword);
        sb.append(", shieldArbitrarilyKeyword=").append(shieldArbitrarilyKeyword);
        sb.append(", websiteUrl=").append(websiteUrl);
        sb.append(", bloggerIdStr=").append(bloggerIdStr);
        sb.append("]");
        return sb.toString();
    }

}