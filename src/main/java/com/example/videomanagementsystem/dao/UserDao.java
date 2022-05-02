package com.example.videomanagementsystem.dao;

import com.example.videomanagementsystem.dao.params.UserQueryParam;
import com.example.videomanagementsystem.domain.VideoSystemUser;

import java.util.List;

public interface UserDao {

    List<VideoSystemUser> getUsers(UserQueryParam param);
}
