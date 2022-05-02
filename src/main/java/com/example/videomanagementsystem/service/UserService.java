package com.example.videomanagementsystem.service;

import com.example.videomanagementsystem.domain.VideoSystemUser;

public interface UserService {

    VideoSystemUser login(String userName, String password);

    void addUser(String username, String password, String userDesc, Integer status, Integer roleId);

    void updateUser(int userId, String userDesc, Integer status, Integer roleId);

    void deleteUser(int userId);

    void updateUserPassword(int userId, String newPassword);
}
