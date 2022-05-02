package com.example.videomanagementsystem.service.impl;

import com.example.videomanagementsystem.domain.VideoGatherKeyWord;
import com.example.videomanagementsystem.domain.VideoSystemTask;
import com.example.videomanagementsystem.domain.VideoSystemTaskConfig;
import com.example.videomanagementsystem.domain.VideoSystemTaskReqParam;
import com.example.videomanagementsystem.enums.*;
import com.example.videomanagementsystem.mapper.VideoSystemTaskMapper;
import com.example.videomanagementsystem.service.VideoSystemTaskService;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * 系统任务service
 */
@Service
public class VideoSystemTaskServiceImpl implements VideoSystemTaskService {

    @Autowired
    private VideoSystemTaskMapper videoSystemTaskMapper;


    @Override
    @Transactional
    public void createTask(VideoSystemTaskReqParam entity) {
        //创建系统任务
        long taskId = this.createSystemTask(entity);
        crateTaskConfig(entity, taskId);

    }

    private void crateTaskConfig(VideoSystemTaskReqParam entity, long taskId) {
        List<VideoSystemTaskConfig> list = Lists.newArrayList();
        //关键字采集
        if (CollectionModeEnum.COLLECTION_KEY_WORD.getCode().equals(entity.getGatherType())) {

            list.add(getTaskConfigEntity(entity, taskId, MediaSourceEnum.WEBSITE.getCode()));
            list.add(getTaskConfigEntity(entity, taskId, MediaSourceEnum.YOUTUBE.getCode()));
            list.add(getTaskConfigEntity(entity, taskId, MediaSourceEnum.FACEBOOK.getCode()));
            list.add(getTaskConfigEntity(entity, taskId, MediaSourceEnum.TWITTER.getCode()));
        } else {
            VideoGatherKeyWord gatherKeyWord = entity.getGatherKeyWord();
            if (gatherKeyWord.getMediaScope().equals(MediaSourceEnum.WEBSITE.getCode())) {
                gatherKeyWord.getWebsiteInfo().forEach(item -> {
                    VideoSystemTaskConfig taskConfigEntity = getTaskConfigEntity(entity, taskId, gatherKeyWord.getMediaScope());
                    taskConfigEntity.setWebsiteName(item.getWebsiteName());
                    taskConfigEntity.setWebsiteUrl(item.getWebsiteUrl());
                    list.add(taskConfigEntity);
                });

            } else {
                list.add(getTaskConfigEntity(entity, taskId, gatherKeyWord.getMediaScope()));
            }
        }

        videoSystemTaskMapper.createTaskConfig(list);

    }

    private VideoSystemTaskConfig getTaskConfigEntity(VideoSystemTaskReqParam entity, long taskId, Integer code) {
        VideoSystemTaskConfig videoSystemTaskConfig = new VideoSystemTaskConfig();
        videoSystemTaskConfig.setVideoSystemTaskId(taskId);
        VideoGatherKeyWord gatherKeyWord = entity.getGatherKeyWord();
        videoSystemTaskConfig.setBloggerIdStr(gatherKeyWord.getBloggerIdStr());
        videoSystemTaskConfig.setCreateTime(new Date());
        videoSystemTaskConfig.setUserId(entity.getUserId());
        videoSystemTaskConfig.setIdDelete(IsDeleteEnum.NOT_DELETE.getCode());
        videoSystemTaskConfig.setIncludeAllKw(gatherKeyWord.getIncludeAllKw());
        videoSystemTaskConfig.setIncludeArbitrarilyKw(gatherKeyWord.getIncludeArbitrarilyKw());
        videoSystemTaskConfig.setUpdateTime(new Date());
        videoSystemTaskConfig.setShieldArbitrarilyKw(gatherKeyWord.getShieldArbitrarilyKw());
        videoSystemTaskConfig.setMediaScope(code);
        return videoSystemTaskConfig;
    }

    /**
     * 创建系统任务
     *
     * @param entity 任务实体类
     */
    private Long createSystemTask(VideoSystemTaskReqParam entity) {
        VideoSystemTask videoSystemTask = new VideoSystemTask();
        videoSystemTask.setTaskType(entity.getTaskType());
        videoSystemTask.setTaskName(entity.getTaskName());
        videoSystemTask.setGatherField(StringUtils.join(entity.getGatherField(), ","));
        videoSystemTask.setIsDelete(IsDeleteEnum.NOT_DELETE.getCode());
        videoSystemTask.setIsProofreading(entity.getIsProofreading());
        videoSystemTask.setUserId(entity.getUserId());
        videoSystemTask.setTaskOpenStatus(StatusEnum.CLOSE_EFFECTIVE.getCode());
        videoSystemTask.setCreateTime(new Date());
        videoSystemTask.setUpdateTime(new Date());
        videoSystemTask.setGatherTime(entity.getGatherTime());
        videoSystemTask.setGatherStartTime(entity.getGatherStartTime());
        videoSystemTask.setGatherEndTime(entity.getGatherEndTime());
        videoSystemTask.setPushTime(entity.getPushTime());
        videoSystemTask.setGatherType(entity.getGatherType());
        videoSystemTask.setTaskStatus(TaskStatusEnum.NOT_STARTED.getCode());
        videoSystemTaskMapper.createSystemTask(videoSystemTask);
        return videoSystemTask.getId();
    }

    /**
     * 删除某个任务
     *
     * @param taskId 任务id
     * @return int
     */
    @Transactional
    @Override
    public void deleteTask(Long taskId) {
        videoSystemTaskMapper.deleteTask(taskId);
        videoSystemTaskMapper.deleteTaskConfig(taskId);
    }


    /**
     * 开启某个任务
     *
     * @param taskId 任务id
     */
    @Transactional
    @Override
    public void openTask(Long taskId) {
        videoSystemTaskMapper.updateTaskOpenStatus(taskId, StatusEnum.OPEN_EFFECTIVE.getCode());
    }


    @Override
    public VideoSystemTaskReqParam getTaskInfo(Long taskId) {
        return null;
    }
}
