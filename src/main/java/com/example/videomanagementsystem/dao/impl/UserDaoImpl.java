package com.example.videomanagementsystem.dao.impl;

import com.example.videomanagementsystem.dao.UserDao;
import com.example.videomanagementsystem.dao.params.UserQueryParam;
import com.example.videomanagementsystem.domain.VideoSystemUser;
import com.example.videomanagementsystem.domain.VideoSystemUserExample;
import com.example.videomanagementsystem.enums.IsDeleteEnum;
import com.example.videomanagementsystem.mapper.VideoSystemUserMapper;
import com.github.pagehelper.PageHelper;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private VideoSystemUserMapper videoSystemUserMapper;

    @Override
    public List<VideoSystemUser> selectUsers(UserQueryParam param) {
        VideoSystemUserExample example = new VideoSystemUserExample();
        VideoSystemUserExample.Criteria criteria = example.createCriteria();
        if (!Strings.isBlank(param.getUsername())) {
            criteria.andUsernameLike("%" + param.getUsername() + "%");
        }
        if (param.getRoleId() != null) {
            criteria.andRoleIdEqualTo(param.getRoleId());
        }
        if (param.getStatusId() != null) {
            criteria.andUserStatusEqualTo(param.getStatusId());
        }
        criteria.andIsDeleteEqualTo(IsDeleteEnum.NOT_DELETE.getCode());
        PageHelper.offsetPage(param.getOffset(), param.getSize(), true);
        PageHelper.orderBy("id desc");
        return videoSystemUserMapper.selectByExampleWithBLOBs(example);
    }

    @Override
    public VideoSystemUser selectUser(String userName, String password) {
        VideoSystemUserExample example = new VideoSystemUserExample();
        example.createCriteria()
                .andUsernameEqualTo(userName)
                .andPasswordEqualTo(password)
                .andIsDeleteEqualTo(IsDeleteEnum.NOT_DELETE.getCode());
        return videoSystemUserMapper.selectByExampleWithBLOBs(example).stream()
                .findFirst().orElse(null);
    }

    @Override
    public VideoSystemUser selectUser(int userId) {
        VideoSystemUserExample example = new VideoSystemUserExample();
        example.createCriteria()
                .andIdEqualTo(userId)
                .andIsDeleteEqualTo(IsDeleteEnum.NOT_DELETE.getCode());
        return videoSystemUserMapper.selectByExampleWithBLOBs(example).stream()
                .findFirst().orElse(null);
    }

    @Override
    public void insertUser(String username, String password, String userDesc, Integer status, Integer roleId) {
        VideoSystemUser user = new VideoSystemUser();
        user.setUsername(username);
        user.setPassword(password);
        user.setUserDesc(userDesc);
        user.setUserStatus(status);
        user.setRoleId(roleId);
        user.setIsDelete(IsDeleteEnum.NOT_DELETE.getCode());
        user.setCreateTime(new Date());
        user.setUpdateTime(new Date());
        videoSystemUserMapper.insertSelective(user);
    }

    @Override
    public void updateUser(int userId, String userDesc, Integer status, Integer roleId) {
        VideoSystemUser updateUser = new VideoSystemUser();
        updateUser.setId(userId);
        if (!Strings.isBlank(userDesc)) {
            updateUser.setUserDesc(userDesc);
        }
        if (status != null) {
            updateUser.setUserStatus(status);
        }
        if (roleId != null) {
            updateUser.setRoleId(roleId);
        }
        updateUser.setUpdateTime(new Date());
        videoSystemUserMapper.updateByPrimaryKeySelective(updateUser);
    }

    @Override
    public void updateUser(int userId, String password) {
        VideoSystemUser updateUser = new VideoSystemUser();
        updateUser.setId(userId);
        updateUser.setPassword(password);
        updateUser.setUpdateTime(new Date());
        videoSystemUserMapper.updateByPrimaryKeySelective(updateUser);
    }

    @Override
    public void updateStatusByRoleId(int status, int roleId) {
        VideoSystemUser updateUser = new VideoSystemUser();
        updateUser.setUserStatus(status);
        updateUser.setUpdateTime(new Date());
        VideoSystemUserExample example = new VideoSystemUserExample();
        example.createCriteria()
                .andRoleIdEqualTo(roleId)
                .andIsDeleteEqualTo(IsDeleteEnum.NOT_DELETE.getCode());
        videoSystemUserMapper.updateByExampleSelective(updateUser, example);
    }

    @Override
    public void deleteUser(int userId) {
        VideoSystemUser deleteUser = new VideoSystemUser();
        deleteUser.setId(userId);
        deleteUser.setIsDelete(IsDeleteEnum.DELETED.getCode());
        deleteUser.setUpdateTime(new Date());
        videoSystemUserMapper.updateByPrimaryKeySelective(deleteUser);
    }

    @Override
    public List<VideoSystemUser> selectUsers(int roleId) {
        VideoSystemUserExample example = new VideoSystemUserExample();
        example.createCriteria()
                .andRoleIdEqualTo(roleId)
                .andIsDeleteEqualTo(IsDeleteEnum.NOT_DELETE.getCode());
        return videoSystemUserMapper.selectByExampleWithBLOBs(example);
    }
}
