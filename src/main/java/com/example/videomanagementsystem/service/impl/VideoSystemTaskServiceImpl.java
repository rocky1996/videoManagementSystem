package com.example.videomanagementsystem.service.impl;

import com.example.videomanagementsystem.domain.*;
import com.example.videomanagementsystem.enums.*;
import com.example.videomanagementsystem.mapper.VideoSystemTaskConfigMapper;
import com.example.videomanagementsystem.mapper.VideoSystemTaskMapper;
import com.example.videomanagementsystem.service.VideoSystemTaskService;
import com.example.videomanagementsystem.util.DateUtils;
import com.github.pagehelper.PageHelper;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

/**
 * 系统任务service
 */
@Service
@Slf4j
public class VideoSystemTaskServiceImpl implements VideoSystemTaskService {

    private static final String DATE_FORMAT = "yyyy-MM-dd";

    @Autowired
    private VideoSystemTaskMapper videoSystemTaskMapper;
    @Autowired
    private VideoSystemTaskConfigMapper videoSystemTaskConfigMapper;


    @Override
    @Transactional
    public void createTask(VideoSystemTaskReqParam entity) {
        try {
            //创建系统任务
            Integer taskId = this.createSystemTask(entity);
            this.crateTaskConfig(entity, taskId);
        } catch (Exception e) {
            log.info("创建任务失败", e);
        }


    }

    private void crateTaskConfig(VideoSystemTaskReqParam entity, Integer taskId) {
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

        videoSystemTaskConfigMapper.createTaskConfig(list);

    }

    private VideoSystemTaskConfig getTaskConfigEntity(VideoSystemTaskReqParam entity, Integer taskId, Integer code) {
        VideoSystemTaskConfig videoSystemTaskConfig = new VideoSystemTaskConfig();
        videoSystemTaskConfig.setVideoSystemTaskId(taskId);
        VideoGatherKeyWord gatherKeyWord = entity.getGatherKeyWord();
        videoSystemTaskConfig.setBloggerIdStr(gatherKeyWord.getBloggerIdStr());
        videoSystemTaskConfig.setCreateTime(new Date());
        videoSystemTaskConfig.setUserId(entity.getUserId());
        videoSystemTaskConfig.setIsDelete(IsDeleteEnum.NOT_DELETE.getCode());
        videoSystemTaskConfig.setIncludeAllKeyword(gatherKeyWord.getIncludeAllKw());
        videoSystemTaskConfig.setIncludeArbitrarilyKeyword(gatherKeyWord.getIncludeArbitrarilyKw());
        videoSystemTaskConfig.setUpdateTime(new Date());
        videoSystemTaskConfig.setShieldArbitrarilyKeyword(gatherKeyWord.getShieldArbitrarilyKw());
        videoSystemTaskConfig.setMediaScope(code);
        return videoSystemTaskConfig;
    }

    /**
     * 创建系统任务
     *
     * @param entity 任务实体类
     */
    private Integer createSystemTask(VideoSystemTaskReqParam entity) throws ParseException {
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
        videoSystemTask.setGatherVideoTime(DateUtils.StrToDate(entity.getGatherTime(), DATE_FORMAT));
        videoSystemTask.setGatherVideoStartTime(DateUtils.StrToDate(entity.getGatherStartTime(), DATE_FORMAT));
        videoSystemTask.setGatherVideoEndTime(DateUtils.StrToDate(entity.getGatherEndTime(), DATE_FORMAT));
        videoSystemTask.setPushTime(DateUtils.StrToDate(entity.getPushTime(), DATE_FORMAT));
        videoSystemTask.setGatherType(entity.getGatherType());
        videoSystemTask.setTaskStatus(TaskStatusEnum.NOT_STARTED.getCode());
        videoSystemTaskMapper.insert(videoSystemTask);
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
    public void deleteTask(Integer taskId) {
        videoSystemTaskMapper.deleteByPrimaryKey(taskId);
        videoSystemTaskConfigMapper.deleteTaskConfig(taskId);
    }


    /**
     * 开启某个任务
     *
     * @param taskId 任务id
     */
    @Transactional
    @Override
    public void openTask(Integer taskId) {
        videoSystemTaskMapper.updateTaskOpenStatus(taskId, StatusEnum.OPEN_EFFECTIVE.getCode());
    }


    @Override
    public VideoSystemTaskReqParam getTaskInfo(Integer taskId) {
        VideoSystemTask videoSystemTask = videoSystemTaskMapper.selectByPrimaryKey(taskId);
        VideoSystemTaskReqParam videoSystemTaskReqParam = getVideoSystemTaskReqParam(videoSystemTask);
        VideoSystemTaskConfigExample example = new VideoSystemTaskConfigExample();
        example.createCriteria().andVideoSystemTaskIdEqualTo(taskId);
        List<VideoSystemTaskConfig> videoSystemTaskConfigs = videoSystemTaskConfigMapper.selectByExampleWithBLOBs(example);
        getVideoSystemTaskReqParam(videoSystemTask, videoSystemTaskReqParam, videoSystemTaskConfigs);
        return videoSystemTaskReqParam;
    }

    @Override
    public List<VideoSystemTaskReqParam> getTaskInfoList(TaskQueryParam taskQueryParam) {
        List<VideoSystemTaskReqParam> result = Lists.newArrayList();
        try {
            VideoSystemTaskExample example = new VideoSystemTaskExample();
            VideoSystemTaskExample.Criteria criteria = example.createCriteria();
            if (!Strings.isBlank(taskQueryParam.getTaskName())) {
                criteria.andTaskNameLike("%" + taskQueryParam.getTaskName() + "%");
            }
            if (taskQueryParam.getTaskType() != null) {
                criteria.andTaskTypeEqualTo(taskQueryParam.getTaskType());
            }
            if (taskQueryParam.getStatus() != null) {
                criteria.andTaskStatusEqualTo(taskQueryParam.getStatus());
            }
            criteria.andIsDeleteEqualTo(IsDeleteEnum.NOT_DELETE.getCode());
            PageHelper.offsetPage(taskQueryParam.getOffset(), taskQueryParam.getSize());
            PageHelper.orderBy("id desc");
            List<VideoSystemTask> videoSystemTasks = videoSystemTaskMapper.selectByExampleWithBLOBs(example);


            for (VideoSystemTask videoSystemTask : videoSystemTasks) {
                VideoSystemTaskReqParam videoSystemTaskReqParam = getVideoSystemTaskReqParam(videoSystemTask);
                List<VideoSystemTaskConfig> videoSystemTaskConfigs = videoSystemTaskConfigMapper.getTaskConfigs(videoSystemTask.getId(), taskQueryParam.getKeyword());
                if (!videoSystemTaskConfigs.isEmpty()) {
                    getVideoSystemTaskReqParam(videoSystemTask, videoSystemTaskReqParam, videoSystemTaskConfigs);
                    result.add(videoSystemTaskReqParam);
                }


            }
        } catch (Exception e) {
            log.info("获取任务列表失败", e);
        }

        return result;
    }

    private void getVideoSystemTaskReqParam(VideoSystemTask videoSystemTask, VideoSystemTaskReqParam videoSystemTaskReqParam, List<VideoSystemTaskConfig> videoSystemTaskConfigs) {
        VideoGatherKeyWord videoGatherKeyWord = new VideoGatherKeyWord();
        List<WebsiteInfo> websiteInfos = Lists.newArrayList();
        for (VideoSystemTaskConfig item : videoSystemTaskConfigs) {
            videoGatherKeyWord.setIncludeAllKw(item.getIncludeAllKeyword());
            videoGatherKeyWord.setIncludeArbitrarilyKw(item.getIncludeArbitrarilyKeyword());
            videoGatherKeyWord.setShieldArbitrarilyKw(item.getShieldArbitrarilyKeyword());
            //如果是关键字采集，则循环一次直接退出
            if (videoSystemTask.getGatherType().equals(CollectionModeEnum.COLLECTION_KEY_WORD.getCode())) {

                videoGatherKeyWord.setMediaScope(MediaSourceEnum.ALL.getCode());
                break;

            } else {
                //如果媒体范围为网站
                if (item.getMediaScope().equals(MediaSourceEnum.WEBSITE.getCode())) {
                    WebsiteInfo websiteInfo = new WebsiteInfo();
                    websiteInfo.setWebsiteName(item.getWebsiteName());
                    websiteInfo.setWebsiteUrl(item.getWebsiteUrl());
                    websiteInfos.add(websiteInfo);
                } else {
                    videoGatherKeyWord.setBloggerIdStr(item.getBloggerIdStr());
                }
            }
        }
        videoGatherKeyWord.setWebsiteInfo(websiteInfos);
        videoSystemTaskReqParam.setGatherKeyWord(videoGatherKeyWord);
    }

    private VideoSystemTaskReqParam getVideoSystemTaskReqParam(VideoSystemTask videoSystemTask) {
        VideoSystemTaskReqParam videoSystemTaskReqParam = new VideoSystemTaskReqParam();
        videoSystemTaskReqParam.setTaskType(videoSystemTask.getTaskType());
        videoSystemTaskReqParam.setTaskId(videoSystemTask.getId());
        videoSystemTaskReqParam.setTaskName(videoSystemTask.getTaskName());
        videoSystemTaskReqParam.setGatherType(videoSystemTask.getGatherType());
        videoSystemTaskReqParam.setIsProofreading(videoSystemTask.getIsProofreading());
        videoSystemTaskReqParam.setGatherEndTime(DateUtils.DateToStr(videoSystemTask.getGatherVideoEndTime(), DATE_FORMAT));
        videoSystemTaskReqParam.setGatherStartTime(DateUtils.DateToStr(videoSystemTask.getGatherVideoEndTime(), DATE_FORMAT));
        videoSystemTaskReqParam.setPushTime(DateUtils.DateToStr(videoSystemTask.getPushTime(), DATE_FORMAT));
        videoSystemTaskReqParam.setGatherTime(DateUtils.DateToStr(videoSystemTask.getGatherVideoTime(), DATE_FORMAT));
        videoSystemTaskReqParam.setGatherField(videoSystemTask.getGatherField().split(","));
        return videoSystemTaskReqParam;
    }
}
