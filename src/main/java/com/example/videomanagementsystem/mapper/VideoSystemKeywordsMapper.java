package com.example.videomanagementsystem.mapper;

import com.example.videomanagementsystem.domain.VideoSystemKeywords;
import com.example.videomanagementsystem.domain.VideoSystemKeywordsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface VideoSystemKeywordsMapper {
    long countByExample(VideoSystemKeywordsExample example);

    int deleteByExample(VideoSystemKeywordsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(VideoSystemKeywords record);

    int insertSelective(VideoSystemKeywords record);

    List<VideoSystemKeywords> selectByExampleWithBLOBs(VideoSystemKeywordsExample example);

    List<VideoSystemKeywords> selectByExample(VideoSystemKeywordsExample example);

    VideoSystemKeywords selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") VideoSystemKeywords record, @Param("example") VideoSystemKeywordsExample example);

    int updateByExampleWithBLOBs(@Param("record") VideoSystemKeywords record, @Param("example") VideoSystemKeywordsExample example);

    int updateByExample(@Param("record") VideoSystemKeywords record, @Param("example") VideoSystemKeywordsExample example);

    int updateByPrimaryKeySelective(VideoSystemKeywords record);

    int updateByPrimaryKeyWithBLOBs(VideoSystemKeywords record);

    int updateByPrimaryKey(VideoSystemKeywords record);
}