package com.example.videomanagementsystem.controller;


import com.example.videomanagementsystem.constants.RestResult;
import com.example.videomanagementsystem.domain.VideoSystemTaskReqParam;
import com.example.videomanagementsystem.enums.RestEnum;
import com.example.videomanagementsystem.service.VideoSystemTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 任务controller
 */
@RestController
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
    public RestResult createTask(@RequestBody VideoSystemTaskReqParam entity) {

        videoSystemTaskService.createTask(entity);
        return new RestResult(RestEnum.SUCCESS.getCode(), RestEnum.SUCCESS.getMsg());
    }

}
