package com.example.videomanagementsystem.dao;

import com.example.videomanagementsystem.domain.VideoSystemUser;

import java.util.List;

public interface UserDao {

    List<VideoSystemUser> getAllUsers();
}
