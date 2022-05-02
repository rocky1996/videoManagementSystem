package com.example.videomanagementsystem.dao;

import com.example.videomanagementsystem.dao.params.UserQueryParam;
import com.example.videomanagementsystem.domain.VideoSystemUser;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import java.util.List;

@Validated
public interface UserDao {

    List<VideoSystemUser> selectUsers(UserQueryParam param);

    VideoSystemUser selectUser(@NotBlank String userName, @NotBlank String password);

    VideoSystemUser selectUser(int userId);

    void insertUser(@NotBlank String username, @NotBlank String password, @NotBlank String userDesc, @NotNull Integer status, @NotNull Integer roleId);

    void updateUser(int userId, String userDesc, Integer status, Integer roleId);

    void updateUser(int userId, @NotBlank String password);

    void deleteUser(int userId);
}
