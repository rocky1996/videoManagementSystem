package com.example.videomanagementsystem.service.impl;

import com.example.videomanagementsystem.dao.UserDao;
import com.example.videomanagementsystem.domain.VideoSystemUser;
import com.example.videomanagementsystem.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public VideoSystemUser login(String userName, String password) {
        VideoSystemUser user = userDao.selectUser(userName, password);
        if (user == null) {
            throw new RuntimeException("登录失败，用户不存在");
        }
        return user;
    }

    @Override
    public void addUser(String username, String password, String userDesc, Integer status, Integer roleId) {
        if (userDao.selectUser(username, password) != null) {
            throw new RuntimeException("创建用户失败，用户已存在");
        }
        userDao.insertUser(username, password, userDesc, status, roleId);
    }

    @Override
    public void updateUser(int userId, String userDesc, Integer status, Integer roleId) {
        VideoSystemUser user = userDao.selectUser(userId);
        if (user == null) {
            throw new RuntimeException("更新用户失败，用户不存在");
        }
        userDao.updateUser(userId, userDesc, status, roleId);
    }

    @Override
    public void deleteUser(int userId) {
        VideoSystemUser user = userDao.selectUser(userId);
        if (user == null) {
            throw new RuntimeException("删除用户失败，用户不存在");
        }
        userDao.deleteUser(userId);
    }

    @Override
    public void updateUserPassword(int userId, String newPassword) {
        VideoSystemUser user = userDao.selectUser(userId);
        if (user == null) {
            throw new RuntimeException("重置用户密码失败，用户不存在");
        }
        userDao.updateUser(userId, newPassword);
    }
}
