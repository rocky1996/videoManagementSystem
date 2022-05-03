package com.example.videomanagementsystem.mapper;

import com.example.videomanagementsystem.domain.VideoSystemTask;
import com.example.videomanagementsystem.domain.VideoSystemTaskConfig;
import com.example.videomanagementsystem.domain.VideoSystemTaskExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface VideoSystemTaskMapper {
    long countByExample(VideoSystemTaskExample example);

    int deleteByExample(VideoSystemTaskExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(VideoSystemTask record);

    int insertSelective(VideoSystemTask record);

    List<VideoSystemTask> selectByExampleWithBLOBs(VideoSystemTaskExample example);

    List<VideoSystemTask> selectByExample(VideoSystemTaskExample example);

    VideoSystemTask selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") VideoSystemTask record, @Param("example") VideoSystemTaskExample example);

    int updateByExampleWithBLOBs(@Param("record") VideoSystemTask record, @Param("example") VideoSystemTaskExample example);

    int updateByExample(@Param("record") VideoSystemTask record, @Param("example") VideoSystemTaskExample example);

    int updateByPrimaryKeySelective(VideoSystemTask record);

    int updateByPrimaryKeyWithBLOBs(VideoSystemTask record);

    int updateByPrimaryKey(VideoSystemTask record);


    void updateTaskOpenStatus(@Param("taskId")Integer taskId, @Param("code")Integer code);
}