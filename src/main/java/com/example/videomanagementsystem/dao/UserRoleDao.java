package com.example.videomanagementsystem.dao;

import com.example.videomanagementsystem.domain.VideoSystemRole;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Validated
public interface UserRoleDao {

    VideoSystemRole selectRole(int id);

    List<VideoSystemRole> selectRoles(@NotEmpty List<Integer> ids);
}
