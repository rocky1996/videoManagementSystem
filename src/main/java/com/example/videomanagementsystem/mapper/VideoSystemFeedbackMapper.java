package com.example.videomanagementsystem.mapper;

import com.example.videomanagementsystem.domain.VideoSystemFeedback;
import com.example.videomanagementsystem.domain.VideoSystemFeedbackExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface VideoSystemFeedbackMapper {
    long countByExample(VideoSystemFeedbackExample example);

    int deleteByExample(VideoSystemFeedbackExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(VideoSystemFeedback record);

    int insertSelective(VideoSystemFeedback record);

    List<VideoSystemFeedback> selectByExampleWithBLOBs(VideoSystemFeedbackExample example);

    List<VideoSystemFeedback> selectByExample(VideoSystemFeedbackExample example);

    VideoSystemFeedback selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") VideoSystemFeedback record, @Param("example") VideoSystemFeedbackExample example);

    int updateByExampleWithBLOBs(@Param("record") VideoSystemFeedback record, @Param("example") VideoSystemFeedbackExample example);

    int updateByExample(@Param("record") VideoSystemFeedback record, @Param("example") VideoSystemFeedbackExample example);

    int updateByPrimaryKeySelective(VideoSystemFeedback record);

    int updateByPrimaryKeyWithBLOBs(VideoSystemFeedback record);

    int updateByPrimaryKey(VideoSystemFeedback record);
}