package com.example.videomanagementsystem.mapper;

import com.example.videomanagementsystem.domain.VideoSystemTaskConfig;
import com.example.videomanagementsystem.domain.VideoSystemTaskConfigExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface VideoSystemTaskConfigMapper {
    long countByExample(VideoSystemTaskConfigExample example);

    int deleteByExample(VideoSystemTaskConfigExample example);

    int deleteByPrimaryKey(Integer id);

    int deleteTaskConfig(@Param("taskId") Integer taskId);
    int insert(VideoSystemTaskConfig record);

    int insertSelective(VideoSystemTaskConfig record);

    List<VideoSystemTaskConfig> selectByExampleWithBLOBs(VideoSystemTaskConfigExample example);

    List<VideoSystemTaskConfig> selectByExample(VideoSystemTaskConfigExample example);

    VideoSystemTaskConfig selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") VideoSystemTaskConfig record, @Param("example") VideoSystemTaskConfigExample example);

    int updateByExampleWithBLOBs(@Param("record") VideoSystemTaskConfig record, @Param("example") VideoSystemTaskConfigExample example);

    int updateByExample(@Param("record") VideoSystemTaskConfig record, @Param("example") VideoSystemTaskConfigExample example);

    int updateByPrimaryKeySelective(VideoSystemTaskConfig record);

    int updateByPrimaryKeyWithBLOBs(VideoSystemTaskConfig record);

    int updateByPrimaryKey(VideoSystemTaskConfig record);

    /**
     * 创建任务配置
     * @param list list
     */
    void createTaskConfig(@Param("list")List<VideoSystemTaskConfig> list);

    List<VideoSystemTaskConfig> getTaskConfigs(@Param("id")Integer id, @Param("keyword")String keyword);
}