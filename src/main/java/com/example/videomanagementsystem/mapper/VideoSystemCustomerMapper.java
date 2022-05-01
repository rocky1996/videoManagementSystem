package com.example.videomanagementsystem.mapper;

import com.example.videomanagementsystem.domain.VideoSystemCustomer;
import com.example.videomanagementsystem.domain.VideoSystemCustomerExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface VideoSystemCustomerMapper {
    long countByExample(VideoSystemCustomerExample example);

    int deleteByExample(VideoSystemCustomerExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(VideoSystemCustomer record);

    int insertSelective(VideoSystemCustomer record);

    List<VideoSystemCustomer> selectByExampleWithBLOBs(VideoSystemCustomerExample example);

    List<VideoSystemCustomer> selectByExample(VideoSystemCustomerExample example);

    VideoSystemCustomer selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") VideoSystemCustomer record, @Param("example") VideoSystemCustomerExample example);

    int updateByExampleWithBLOBs(@Param("record") VideoSystemCustomer record, @Param("example") VideoSystemCustomerExample example);

    int updateByExample(@Param("record") VideoSystemCustomer record, @Param("example") VideoSystemCustomerExample example);

    int updateByPrimaryKeySelective(VideoSystemCustomer record);

    int updateByPrimaryKeyWithBLOBs(VideoSystemCustomer record);

    int updateByPrimaryKey(VideoSystemCustomer record);
}