package com.example.videomanagementsystem.dao.impl;

import com.example.videomanagementsystem.dao.UserRoleDao;
import com.example.videomanagementsystem.domain.VideoSystemRole;
import com.example.videomanagementsystem.domain.VideoSystemRoleExample;
import com.example.videomanagementsystem.mapper.VideoSystemRoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRoleDaoImpl implements UserRoleDao {

    @Autowired
    private VideoSystemRoleMapper videoSystemRoleMapper;

    @Override
    public VideoSystemRole selectRole(int id) {
        return videoSystemRoleMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<VideoSystemRole> selectRoles(List<Integer> ids) {
        VideoSystemRoleExample example = new VideoSystemRoleExample();
        example.createCriteria().andIdIn(ids);
        return videoSystemRoleMapper.selectByExample(example);
    }
}
