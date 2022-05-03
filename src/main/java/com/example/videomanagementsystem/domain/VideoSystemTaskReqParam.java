package com.example.videomanagementsystem.domain;

import java.util.Date;

public class VideoSystemTaskReqParam {

    private Integer userId;

    private String taskName;
    //0:日更任务,1:一次性任务
    private Integer taskType;
    //采集视频开始时间
    private String gatherStartTime;
    //采集视频结束时间
    private String gatherEndTime;
    //采集视频时间
    private String gatherTime;
    //推送时间
    private String pushTime;

    //0:关键字采集,1:定源采集,2:关键字+定源采集
    private Integer gatherType;
    //是否需要校审,0:是,1:否
    private Integer isProofreading;
    //该用户的采集权限,可以为空,例如1,2,3,4,  以逗号隔开
    private String[] gatherField;

    private Integer taskId;
    private VideoGatherKeyWord gatherKeyWord;

    public Integer getTaskId() {
        return taskId;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }




    public Integer getGatherType() {
        return gatherType;
    }

    public void setGatherType(Integer gatherType) {
        this.gatherType = gatherType;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getTaskType() {
        return taskType;
    }

    public void setTaskType(Integer taskType) {
        this.taskType = taskType;
    }

    public String getGatherStartTime() {
        return gatherStartTime;
    }

    public void setGatherStartTime(String gatherStartTime) {
        this.gatherStartTime = gatherStartTime;
    }

    public String getGatherEndTime() {
        return gatherEndTime;
    }

    public void setGatherEndTime(String gatherEndTime) {
        this.gatherEndTime = gatherEndTime;
    }

    public String getGatherTime() {
        return gatherTime;
    }

    public void setGatherTime(String gatherTime) {
        this.gatherTime = gatherTime;
    }

    public String getPushTime() {
        return pushTime;
    }

    public void setPushTime(String pushTime) {
        this.pushTime = pushTime;
    }

    public Integer getIsProofreading() {
        return isProofreading;
    }

    public void setIsProofreading(Integer isProofreading) {
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
