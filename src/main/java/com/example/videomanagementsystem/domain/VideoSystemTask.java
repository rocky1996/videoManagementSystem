package com.example.videomanagementsystem.domain;

import java.util.Date;

public class VideoSystemTask {
    private Integer id;

    private Integer userId;

    private String taskName;

    private Integer taskType;

    private Date gatherVideoStartTime;

    private Date gatherVideoEndTime;

    private Date gatherVideoTime;

    private Date pushTime;

    private Integer gatherType;

    private Integer isProofreading;

    private Integer taskOpenStatus;

    private Integer taskStatus;

    private Integer isDelete;

    private Date createTime;

    private Date updateTime;

    private String gatherField;

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

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public Integer getTaskType() {
        return taskType;
    }

    public void setTaskType(Integer taskType) {
        this.taskType = taskType;
    }

    public Date getGatherVideoStartTime() {
        return gatherVideoStartTime;
    }

    public void setGatherVideoStartTime(Date gatherVideoStartTime) {
        this.gatherVideoStartTime = gatherVideoStartTime;
    }

    public Date getGatherVideoEndTime() {
        return gatherVideoEndTime;
    }

    public void setGatherVideoEndTime(Date gatherVideoEndTime) {
        this.gatherVideoEndTime = gatherVideoEndTime;
    }

    public Date getGatherVideoTime() {
        return gatherVideoTime;
    }

    public void setGatherVideoTime(Date gatherVideoTime) {
        this.gatherVideoTime = gatherVideoTime;
    }

    public Date getPushTime() {
        return pushTime;
    }

    public void setPushTime(Date pushTime) {
        this.pushTime = pushTime;
    }

    public Integer getGatherType() {
        return gatherType;
    }

    public void setGatherType(Integer gatherType) {
        this.gatherType = gatherType;
    }

    public Integer getIsProofreading() {
        return isProofreading;
    }

    public void setIsProofreading(Integer isProofreading) {
        this.isProofreading = isProofreading;
    }

    public Integer getTaskOpenStatus() {
        return taskOpenStatus;
    }

    public void setTaskOpenStatus(Integer taskOpenStatus) {
        this.taskOpenStatus = taskOpenStatus;
    }

    public Integer getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(Integer taskStatus) {
        this.taskStatus = taskStatus;
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

    public String getGatherField() {
        return gatherField;
    }

    public void setGatherField(String gatherField) {
        this.gatherField = gatherField;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userId=").append(userId);
        sb.append(", taskName=").append(taskName);
        sb.append(", taskType=").append(taskType);
        sb.append(", gatherVideoStartTime=").append(gatherVideoStartTime);
        sb.append(", gatherVideoEndTime=").append(gatherVideoEndTime);
        sb.append(", gatherVideoTime=").append(gatherVideoTime);
        sb.append(", pushTime=").append(pushTime);
        sb.append(", gatherType=").append(gatherType);
        sb.append(", isProofreading=").append(isProofreading);
        sb.append(", taskOpenStatus=").append(taskOpenStatus);
        sb.append(", taskStatus=").append(taskStatus);
        sb.append(", isDelete=").append(isDelete);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", gatherField=").append(gatherField);
        sb.append("]");
        return sb.toString();
    }
}