package com.example.videomanagementsystem.dao.impl;

import com.example.videomanagementsystem.dao.UserDao;
import com.example.videomanagementsystem.domain.VideoSystemUser;
import com.example.videomanagementsystem.domain.VideoSystemUserExample;
import com.example.videomanagementsystem.mapper.VideoSystemUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private VideoSystemUserMapper videoSystemUserMapper;

    @Override
    public List<VideoSystemUser> getAllUsers() {
        VideoSystemUserExample example = new VideoSystemUserExample();
        return videoSystemUserMapper.selectByExample(example);
    }
}
