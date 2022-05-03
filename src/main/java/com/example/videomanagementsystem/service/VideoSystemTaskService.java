package com.example.videomanagementsystem.service;

import com.example.videomanagementsystem.domain.TaskQueryParam;
import com.example.videomanagementsystem.domain.VideoSystemTaskReqParam;

import java.util.List;

/**
 * 系统任务service
 */
public interface VideoSystemTaskService {

    /**
     * 删除某个任务
     *
     * @param taskId 任务id
     * @return int
     */
    void deleteTask(Integer taskId);

    /**
     * 开启某个任务
     *
     * @param taskId 任务id
     */
    void openTask(Integer taskId);

    /**
     * 创建任务
     *
     * @param entity 任务实体类
     */
    void createTask(VideoSystemTaskReqParam entity);

    VideoSystemTaskReqParam getTaskInfo(Integer taskId);

    List<VideoSystemTaskReqParam> getTaskInfoList(TaskQueryParam taskQueryParam);
}
