package com.example.videomanagementsystem.service;

import com.example.videomanagementsystem.domain.VideoSystemTaskReqParam;

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
    void deleteTask(Long taskId);

    /**
     * 开启某个任务
     *
     * @param taskId 任务id
     */
    void openTask(Long taskId);

    /**
     * 创建任务
     *
     * @param entity 任务实体类
     */
    void createTask(VideoSystemTaskReqParam entity);

    VideoSystemTaskReqParam getTaskInfo(Long taskId);
}
