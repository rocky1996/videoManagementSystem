package com.example.videomanagementsystem.domain;

import java.util.Date;

public class VideoSystemFeedback {
    private Integer id;

    private Integer taskId;

    private Integer titleId;

    private Integer userId;

    private Date feedbackTime;

    private Integer isDelete;

    private Date createTime;

    private Date updateTime;

    private String feedbackSecretKey;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTaskId() {
        return taskId;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

    public Integer getTitleId() {
        return titleId;
    }

    public void setTitleId(Integer titleId) {
        this.titleId = titleId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getFeedbackTime() {
        return feedbackTime;
    }

    public void setFeedbackTime(Date feedbackTime) {
        this.feedbackTime = feedbackTime;
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

    public String getFeedbackSecretKey() {
        return feedbackSecretKey;
    }

    public void setFeedbackSecretKey(String feedbackSecretKey) {
        this.feedbackSecretKey = feedbackSecretKey;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", taskId=").append(taskId);
        sb.append(", titleId=").append(titleId);
        sb.append(", userId=").append(userId);
        sb.append(", feedbackTime=").append(feedbackTime);
        sb.append(", isDelete=").append(isDelete);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", feedbackSecretKey=").append(feedbackSecretKey);
        sb.append("]");
        return sb.toString();
    }
}