package com.example.videomanagementsystem.service.impl;

import com.example.videomanagementsystem.dao.UserDao;
import com.example.videomanagementsystem.domain.VideoSystemRole;
import com.example.videomanagementsystem.domain.VideoSystemUser;
import com.example.videomanagementsystem.enums.StatusEnum;
import com.example.videomanagementsystem.service.UserRoleService;
import com.example.videomanagementsystem.service.UserService;
import com.example.videomanagementsystem.util.RoleMenuUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private UserRoleService userRoleService;

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

    @Override
    public Map<Integer, List<Integer>> getUserRoleMenus(int userId) {
        VideoSystemUser user = userDao.selectUser(userId);
        if (user != null && user.getUserStatus().equals(StatusEnum.OPEN_EFFECTIVE.getCode())) {
            int roleId = user.getRoleId();
            VideoSystemRole role = userRoleService.getRole(roleId);
            if (role.getRoleStatus().equals(StatusEnum.OPEN_EFFECTIVE.getCode())) {
                return RoleMenuUtils.jsonToMenu(role.getRoleHavingMenu());
            }
        }
        return null;
    }
}
