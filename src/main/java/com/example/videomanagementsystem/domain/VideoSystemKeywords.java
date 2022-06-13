package com.example.videomanagementsystem.domain;

import lombok.Builder;

import java.util.Date;

@Builder
public class VideoSystemKeywords {
    private Integer id;

    private Integer onlyCode;

    private Integer isDelete;

    private Date createTime;

    private Date updateTime;

    private String videoUrl;

    private String msgBody;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOnlyCode() {
        return onlyCode;
    }

    public void setOnlyCode(Integer onlyCode) {
        this.onlyCode = onlyCode;
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

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public String getMsgBody() {
        return msgBody;
    }

    public void setMsgBody(String msgBody) {
        this.msgBody = msgBody;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", onlyCode=").append(onlyCode);
        sb.append(", isDelete=").append(isDelete);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", videoUrl=").append(videoUrl);
        sb.append(", msgBody=").append(msgBody);
        sb.append("]");
        return sb.toString();
    }
}