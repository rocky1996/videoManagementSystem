package com.example.videomanagementsystem.dao.impl;

import com.example.videomanagementsystem.dao.UserRoleDao;
import com.example.videomanagementsystem.dao.params.UserRoleQueryParam;
import com.example.videomanagementsystem.domain.VideoSystemRole;
import com.example.videomanagementsystem.domain.VideoSystemRoleExample;
import com.example.videomanagementsystem.enums.IsDeleteEnum;
import com.example.videomanagementsystem.enums.StatusEnum;
import com.example.videomanagementsystem.mapper.VideoSystemRoleMapper;
import com.example.videomanagementsystem.util.RoleMenuUtils;
import com.github.pagehelper.PageHelper;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Repository
public class UserRoleDaoImpl implements UserRoleDao {

    @Autowired
    private VideoSystemRoleMapper videoSystemRoleMapper;

    @Override
    public VideoSystemRole selectRole(int id) {
        VideoSystemRoleExample example = new VideoSystemRoleExample();
        example.createCriteria()
                .andIdEqualTo(id)
                .andIsDeleteEqualTo(IsDeleteEnum.NOT_DELETE.getCode());
        return videoSystemRoleMapper.selectByExampleWithBLOBs(example).stream()
                .findFirst().orElse(null);
    }

    @Override
    public List<VideoSystemRole> selectRoles(List<Integer> ids) {
        VideoSystemRoleExample example = new VideoSystemRoleExample();
        example.createCriteria()
                .andIdIn(ids)
                .andIsDeleteEqualTo(IsDeleteEnum.NOT_DELETE.getCode());
        return videoSystemRoleMapper.selectByExampleWithBLOBs(example);
    }

    @Override
    public List<VideoSystemRole> selectRoles(UserRoleQueryParam param) {
        VideoSystemRoleExample example = new VideoSystemRoleExample();
        VideoSystemRoleExample.Criteria criteria = example.createCriteria();
        if (!Strings.isBlank(param.getRoleName())) {
            criteria.andRoleNameLike("%" + param.getRoleName() + "%");
        }
        if (param.getStatusId() != null) {
            criteria.andRoleStatusEqualTo(param.getStatusId());
        }
        criteria.andIsDeleteEqualTo(IsDeleteEnum.NOT_DELETE.getCode());
        PageHelper.offsetPage(param.getOffset(), param.getSize(), true);
        PageHelper.orderBy("id desc");
        return videoSystemRoleMapper.selectByExampleWithBLOBs(example);
    }

    @Override
    public List<VideoSystemRole> selectOpenEffectiveRoles() {
        VideoSystemRoleExample example = new VideoSystemRoleExample();
        example.createCriteria()
                .andRoleStatusEqualTo(StatusEnum.OPEN_EFFECTIVE.getCode())
                .andIsDeleteEqualTo(IsDeleteEnum.NOT_DELETE.getCode());
        return videoSystemRoleMapper.selectByExampleWithBLOBs(example);
    }

    @Override
    public VideoSystemRole selectRole(String roleName) {
        VideoSystemRoleExample example = new VideoSystemRoleExample();
        example.createCriteria()
                .andRoleNameEqualTo(roleName)
                .andIsDeleteEqualTo(IsDeleteEnum.NOT_DELETE.getCode());
        return videoSystemRoleMapper.selectByExampleWithBLOBs(example).stream()
                .findFirst().orElse(null);
    }

    @Override
    public void insertRole(String roleName, String roleDesc, Integer status, Map<Integer, List<Integer>> roleHavingMenu) {
        VideoSystemRole role = new VideoSystemRole();
        role.setRoleName(roleName);
        role.setRoleDesc(roleDesc);
        role.setRoleStatus(status);
        role.setRoleHavingMenu(RoleMenuUtils.menuToJson(roleHavingMenu));
        role.setIsDelete(IsDeleteEnum.NOT_DELETE.getCode());
        role.setCreateTime(new Date());
        role.setUpdateTime(new Date());
        videoSystemRoleMapper.insertSelective(role);
    }

    @Override
    public void updateRole(int roleId, String roleDesc, Integer status, Map<Integer, List<Integer>> roleHavingMenu) {
        VideoSystemRole updateRole = new VideoSystemRole();
        updateRole.setId(roleId);
        if (!Strings.isBlank(roleDesc)) {
            updateRole.setRoleDesc(roleDesc);
        }
        if (status != null) {
            updateRole.setRoleStatus(status);
        }
        if (!CollectionUtils.isEmpty(roleHavingMenu)) {
            updateRole.setRoleHavingMenu(RoleMenuUtils.menuToJson(roleHavingMenu));
        }
        updateRole.setUpdateTime(new Date());
        videoSystemRoleMapper.updateByPrimaryKeySelective(updateRole);
    }

    @Override
    public void deleteRole(int roleId) {
        VideoSystemRole deleteRole = new VideoSystemRole();
        deleteRole.setId(roleId);
        deleteRole.setIsDelete(IsDeleteEnum.DELETED.getCode());
        deleteRole.setUpdateTime(new Date());
        videoSystemRoleMapper.updateByPrimaryKeySelective(deleteRole);
    }
}
