package com.example.videomanagementsystem.service;

import com.example.videomanagementsystem.domain.VideoSystemRole;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Map;

@Validated
public interface UserRoleService {

    VideoSystemRole getRole(int id);

    Map<Integer, VideoSystemRole> getRoles(List<Integer> ids);

    void addRole(@NotBlank String roleName, @NotBlank String roleDesc, @NotNull Integer status, @NotEmpty Map<Integer, List<Integer>> roleHavingMenu);

    void updateRole(int roleId, String roleDesc, Integer status, Map<Integer, List<Integer>> roleHavingMenu);

    void deleteRole(int roleId);
}
