package com.example.videomanagementsystem.service;

import com.example.videomanagementsystem.domain.VideoSystemRole;

import java.util.List;
import java.util.Map;

public interface UserRoleService {

    VideoSystemRole getRole(int id);

    Map<Integer, VideoSystemRole> getRoles(List<Integer> ids);
}
