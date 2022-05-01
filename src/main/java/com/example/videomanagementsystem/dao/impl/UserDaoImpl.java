package com.example.videomanagementsystem.dao.impl;

import com.example.videomanagementsystem.dao.UserDao;
import com.example.videomanagementsystem.dao.params.UserQueryParam;
import com.example.videomanagementsystem.domain.VideoSystemUser;
import com.example.videomanagementsystem.domain.VideoSystemUserExample;
import com.example.videomanagementsystem.mapper.VideoSystemUserMapper;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private VideoSystemUserMapper videoSystemUserMapper;

    @Override
    public List<VideoSystemUser> getUsers(UserQueryParam param) {
        VideoSystemUserExample example = new VideoSystemUserExample();
        PageHelper.offsetPage(param.getOffset(), param.getSize(), true);
        PageHelper.orderBy("id desc");
        return videoSystemUserMapper.selectByExample(example);
    }
}
