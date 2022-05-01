package com.example.videomanagementsystem.mapper;

import com.example.videomanagementsystem.domain.VideoSystemUser;
import com.example.videomanagementsystem.domain.VideoSystemUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface VideoSystemUserMapper {
    long countByExample(VideoSystemUserExample example);

    int deleteByExample(VideoSystemUserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(VideoSystemUser record);

    int insertSelective(VideoSystemUser record);

    List<VideoSystemUser> selectByExampleWithBLOBs(VideoSystemUserExample example);

    List<VideoSystemUser> selectByExample(VideoSystemUserExample example);

    VideoSystemUser selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") VideoSystemUser record, @Param("example") VideoSystemUserExample example);

    int updateByExampleWithBLOBs(@Param("record") VideoSystemUser record, @Param("example") VideoSystemUserExample example);

    int updateByExample(@Param("record") VideoSystemUser record, @Param("example") VideoSystemUserExample example);

    int updateByPrimaryKeySelective(VideoSystemUser record);

    int updateByPrimaryKeyWithBLOBs(VideoSystemUser record);

    int updateByPrimaryKey(VideoSystemUser record);
}