package com.example.videomanagementsystem.mapper;

import com.example.videomanagementsystem.domain.VideoSystemRole;
import com.example.videomanagementsystem.domain.VideoSystemRoleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface VideoSystemRoleMapper {
    long countByExample(VideoSystemRoleExample example);

    int deleteByExample(VideoSystemRoleExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(VideoSystemRole record);

    int insertSelective(VideoSystemRole record);

    List<VideoSystemRole> selectByExampleWithBLOBs(VideoSystemRoleExample example);

    List<VideoSystemRole> selectByExample(VideoSystemRoleExample example);

    VideoSystemRole selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") VideoSystemRole record, @Param("example") VideoSystemRoleExample example);

    int updateByExampleWithBLOBs(@Param("record") VideoSystemRole record, @Param("example") VideoSystemRoleExample example);

    int updateByExample(@Param("record") VideoSystemRole record, @Param("example") VideoSystemRoleExample example);

    int updateByPrimaryKeySelective(VideoSystemRole record);

    int updateByPrimaryKeyWithBLOBs(VideoSystemRole record);

    int updateByPrimaryKey(VideoSystemRole record);
}