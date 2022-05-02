package com.example.videomanagementsystem.domain;

import java.util.Date;
import java.util.List;

public class VideoSystemTaskReqParam {

    private Long userId;

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
    private String[] gatherField;

    private VideoGatherKeyWord gatherKeyWord;

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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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

    public String[] getGatherField() {
        return gatherField;
    }

    public void setGatherField(String[] gatherField) {
        this.gatherField = gatherField;
    }

    public VideoGatherKeyWord getGatherKeyWord() {
        return gatherKeyWord;
    }

    public void setGatherKeyWord(VideoGatherKeyWord gatherKeyWord) {
        this.gatherKeyWord = gatherKeyWord;
    }
}
