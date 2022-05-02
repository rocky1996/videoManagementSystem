package com.example.videomanagementsystem.mapper;

import com.example.videomanagementsystem.domain.VideoSystemTask;
import com.example.videomanagementsystem.domain.VideoSystemTaskConfig;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface VideoSystemTaskMapper {


    /**
     * 更新任务开启状态
     *
     * @param taskId 任务id
     * @param code   任务状态
     */
    void updateTaskOpenStatus(@Param("taskId") Long taskId, @Param("code") Integer code);

    /**
     * 删除某个任务
     *
     * @param taskId 任务id
     * @return int
     */
    int deleteTask(@Param("taskId") Long taskId);

    /**
     * 创建任务
     * @param videoSystemTask 创建任务实体类
     */
    int createSystemTask(@Param("videoSystemTask") VideoSystemTask videoSystemTask);

    /**
     * 创建任务配置
     * @param list list
     */
    void createTaskConfig(@Param("list")List<VideoSystemTaskConfig> list);

    int deleteTaskConfig(@Param("taskId") Long taskId);
}
