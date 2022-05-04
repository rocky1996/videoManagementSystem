package com.example.videomanagementsystem.controller;


import com.example.videomanagementsystem.constants.PageResult;
import com.example.videomanagementsystem.constants.RestResult;
import com.example.videomanagementsystem.controller.resp.UserResp;
import com.example.videomanagementsystem.domain.*;
import com.example.videomanagementsystem.enums.RestEnum;
import com.example.videomanagementsystem.service.VideoSystemTaskService;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 任务controller
 */
@RestController
@Slf4j
@RequestMapping("videoSystem/task")
public class TaskController {

    @Autowired
    private VideoSystemTaskService videoSystemTaskService;

    /**
     * 创建任务
     *
     * @return RestResult
     */
    @PostMapping("createTask")
    public RestResult<Void> createTask(@RequestBody VideoSystemTaskReqParam entity) {
        try {
            videoSystemTaskService.createTask(entity);

        } catch (Exception e) {
            return new RestResult<>(RestEnum.FAILED.getCode(), " 创建任务失败 !");
        }
        return new RestResult<>(RestEnum.SUCCESS.getCode(), RestEnum.SUCCESS.getMsg());
    }

    /**
     * 删除任务
     *
     * @param taskId 任务id
     * @return RestResult
     */
    @GetMapping("deleteTask/{taskId}")
    public RestResult<Void> deleteTask(@PathVariable("taskId") Integer taskId) {
        try {
            videoSystemTaskService.deleteTask(taskId);

        } catch (Exception e) {

            return new RestResult<>(RestEnum.FAILED.getCode(), "删除任务 失败");
        }
        return new RestResult<>(RestEnum.SUCCESS.getCode(), RestEnum.SUCCESS.getMsg());

    }

    /**
     * 开启某个任务
     *
     * @param taskId 任务id
     * @return RestResult
     */
    @GetMapping("openTask/{taskId}")
    public RestResult<Void> openTask(@PathVariable("taskId") Integer taskId) {
        try {
            videoSystemTaskService.openTask(taskId);

        } catch (Exception e) {
            return new RestResult<>(RestEnum.FAILED.getCode(), "开启任务失败");
        }
        return new RestResult<>(RestEnum.SUCCESS.getCode(), RestEnum.SUCCESS.getMsg());
    }

    /**
     * 获取某个任务的信息
     *
     * @param taskId 任务id
     * @return RestResult
     */
    @GetMapping("getTaskInfo/{taskId}")
    public RestResult<VideoSystemTaskReqParam> getTaskInfo(@PathVariable("taskId") Integer taskId) {
        VideoSystemTaskReqParam taskInfo = null;
        try {
            taskInfo = videoSystemTaskService.getTaskInfo(taskId);
        } catch (Exception e) {
            return new RestResult<>(RestEnum.FAILED.getCode(), "获取任务信息失败", null);
        }
        return new RestResult<>(RestEnum.SUCCESS.getCode(), RestEnum.SUCCESS.getMsg(), taskInfo);

    }

    @PostMapping("getTaskInfoList")
    public RestResult<PageResult<VideoSystemTaskReqParam>> getTaskInfoList(@RequestBody TaskQueryParamReq taskQueryParam) {
        try {
            List<VideoSystemTaskReqParam> list = videoSystemTaskService.getTaskInfoList(taskQueryParam.convert());
            PageInfo<VideoSystemTaskReqParam> pageInfo = new PageInfo<>(list);
            PageResult<VideoSystemTaskReqParam> pageResult = PageResult.create(pageInfo, list);
            return new RestResult<>(RestEnum.SUCCESS.getCode(), RestEnum.SUCCESS.getMsg(), pageResult);
        } catch (Exception e) {
            return new RestResult<>(RestEnum.FAILED.getCode(), "获取任务列表失败", null);
        }

    }

}
