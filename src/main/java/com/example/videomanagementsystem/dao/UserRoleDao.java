package com.example.videomanagementsystem.dao;

import com.example.videomanagementsystem.dao.params.UserRoleQueryParam;
import com.example.videomanagementsystem.domain.VideoSystemRole;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Map;

@Validated
public interface UserRoleDao {

    VideoSystemRole selectRole(int id);

    List<VideoSystemRole> selectRoles(@NotEmpty List<Integer> ids);

    List<VideoSystemRole> selectRoles(UserRoleQueryParam param);

    List<VideoSystemRole> selectOpenEffectiveRoles();

    VideoSystemRole selectRole(@NotBlank String roleName);

    void insertRole(@NotBlank String roleName, @NotBlank String roleDesc, @NotNull Integer status, @NotEmpty Map<Integer, List<Integer>> roleHavingMenu);

    void updateRole(int roleId, String roleDesc, Integer status, Map<Integer, List<Integer>> roleHavingMenu);

    void deleteRole(int roleId);
}
