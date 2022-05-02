package com.example.videomanagementsystem.domain;

import java.util.Date;

public class VideoSystemTask {


    /**
     * 主键id
     */
    private Long id;
    //用户id
    private Long userId;
    //任务名称
    private String taskName;
    //0:日更任务,1:一次性任务
    private Long taskType;
    //采集视频开始时间
    private Date gatherStartTime;
    //采集视频结束时间
    private Date gatherEndTime;
    //采集视频时间
    private Date gatherTime;
    //推送时间
    private Date pushTime;

    //0:关键字采集,1:定源采集,2:关键字+定源采集
    private Integer gatherType;
    //是否需要校审,0:是,1:否
    private Long isProofreading;
    //该用户的采集权限,可以为空,例如1,2,3,4,  以逗号隔开
    private String gatherField;
    //0:开启,1:关闭
    private Integer taskOpenStatus;
    //逻辑删除,0:未删除,1:已删除
    private  Integer isDelete;
    //创建时间
    private Date createTime;
    //更新时间
    private Date updateTime;

    private Integer taskStatus;

    public Integer getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(Integer taskStatus) {
        this.taskStatus = taskStatus;
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

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public Long getTaskType() {
        return taskType;
    }

    public void setTaskType(Long taskType) {
        this.taskType = taskType;
    }

    public Date getGatherStartTime() {
        return gatherStartTime;
    }

    public void setGatherStartTime(Date gatherStartTime) {
        this.gatherStartTime = gatherStartTime;
    }

    public Date getGatherEndTime() {
        return gatherEndTime;
    }

    public void setGatherEndTime(Date gatherEndTime) {
        this.gatherEndTime = gatherEndTime;
    }

    public Date getGatherTime() {
        return gatherTime;
    }

    public void setGatherTime(Date gatherTime) {
        this.gatherTime = gatherTime;
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

    public Long getIsProofreading() {
        return isProofreading;
    }

    public void setIsProofreading(Long isProofreading) {
        this.isProofreading = isProofreading;
    }

    public String getGatherField() {
        return gatherField;
    }

    public void setGatherField(String gatherField) {
        this.gatherField = gatherField;
    }

    public Integer getTaskOpenStatus() {
        return taskOpenStatus;
    }

    public void setTaskOpenStatus(Integer taskOpenStatus) {
        this.taskOpenStatus = taskOpenStatus;
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
}
