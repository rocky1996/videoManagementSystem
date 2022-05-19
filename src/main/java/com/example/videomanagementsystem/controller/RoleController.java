package com.example.videomanagementsystem.controller;

import com.example.videomanagementsystem.aop.CostTime;
import com.example.videomanagementsystem.constants.PageResult;
import com.example.videomanagementsystem.constants.RestResult;
import com.example.videomanagementsystem.controller.auth.Menu;
import com.example.videomanagementsystem.controller.req.RoleQueryReq;
import com.example.videomanagementsystem.controller.req.RoleReq;
import com.example.videomanagementsystem.controller.resp.RoleMenuResp;
import com.example.videomanagementsystem.controller.resp.RoleResp;
import com.example.videomanagementsystem.dao.UserRoleDao;
import com.example.videomanagementsystem.domain.VideoSystemRole;
import com.example.videomanagementsystem.enums.FirstMenuEnum;
import com.example.videomanagementsystem.enums.RestEnum;
import com.example.videomanagementsystem.enums.SecondMenuEnum;
import com.example.videomanagementsystem.enums.StatusEnum;
import com.example.videomanagementsystem.service.UserRoleService;
import com.example.videomanagementsystem.util.RoleMenuUtils;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping("/videoSystem/role")
public class RoleController {

    @Autowired
    private UserRoleDao userRoleDao;

    @Autowired
    private UserRoleService userRoleService;

    private final Function<List<RoleReq.RoleHavingMenu>, Boolean> checkMenuIncorrectFunction = menus -> menus.stream()
            .anyMatch(menu -> FirstMenuEnum.getFirstMenuEnum(menu.getFirstMenuId()) == null ||
                    menu.getSecondMenu().stream().anyMatch(secondMenu -> SecondMenuEnum.getSecondMenuEnum(secondMenu.getSecondMenuId()) == null ||
                            !FirstMenuEnum.getFirstMenuEnum(menu.getFirstMenuId()).getSecondMenuEnumList().contains(SecondMenuEnum.getSecondMenuEnum(secondMenu.getSecondMenuId()))));

    @PostMapping("/searchRoleList")
    @Menu(firstMenu = FirstMenuEnum.SYSTEM_MANAGEMENT, secondMenu = SecondMenuEnum.ROLE_MANAGEMENT)
    @CostTime(interfaceName = "getRoles")
    public RestResult<PageResult<RoleResp>> getRoles(@RequestBody @Valid RoleQueryReq req) {
        List<VideoSystemRole> roles = userRoleDao.selectRoles(req.convert());
        PageInfo<VideoSystemRole> pageInfo = new PageInfo<>(roles);

        List<RoleResp> roleRespList = roles.stream()
                .map(RoleResp::convert)
                .collect(Collectors.toList());
        PageResult<RoleResp> pageResult = PageResult.create(pageInfo, roleRespList);
        return new RestResult<>(RestEnum.SUCCESS.getCode(), RestEnum.SUCCESS.getMsg(), pageResult);
    }

    @GetMapping("/getRoleList")
    @Menu(firstMenu = FirstMenuEnum.SYSTEM_MANAGEMENT, secondMenu = SecondMenuEnum.ROLE_MANAGEMENT)
    @CostTime(interfaceName = "getOpenEffectiveRoles")
    public RestResult<List<RoleResp>> getOpenEffectiveRoles() {
        List<RoleResp> roleRespList = userRoleDao.selectOpenEffectiveRoles().stream()
                .map(RoleResp::convert)
                .collect(Collectors.toList());
        return new RestResult<>(RestEnum.SUCCESS.getCode(), RestEnum.SUCCESS.getMsg(), roleRespList);
    }

    @PostMapping("/createOrUpdateMenu")
    @Menu(firstMenu = FirstMenuEnum.SYSTEM_MANAGEMENT, secondMenu = SecondMenuEnum.ROLE_MANAGEMENT)
    @CostTime(interfaceName = "createOrUpdateRole")
    public RestResult<Void> createOrUpdateRole(@RequestBody @Valid RoleReq req) {
        //创建
        if (req.getRoleId() == null) {
            if (req.getStatus() == null || StatusEnum.getStatusEnum(req.getStatus()) == null) {
                return new RestResult<>(RestEnum.FAILED.getCode(), "创建角色失败，状态不符合要求", null);
            }
            if (CollectionUtils.isEmpty(req.getRoleHavingMenu()) || checkMenuIncorrectFunction.apply(req.getRoleHavingMenu())) {
                return new RestResult<>(RestEnum.FAILED.getCode(), "创建角色失败，菜单权限不符合要求", null);
            }
            try {
                Map<Integer, List<Integer>> roleHavingMenu = RoleMenuUtils.reqToMenu(req.getRoleHavingMenu());
                userRoleService.addRole(req.getRoleName(), req.getRoleDesc(), req.getStatus(), roleHavingMenu);
            } catch (Exception e) {
                return new RestResult<>(RestEnum.FAILED.getCode(), e.getMessage(), null);
            }
        } else {
            //更新
            if (req.getStatus() != null && StatusEnum.getStatusEnum(req.getStatus()) == null) {
                return new RestResult<>(RestEnum.FAILED.getCode(), "更新角色失败，状态不符合要求", null);
            }
            if (!CollectionUtils.isEmpty(req.getRoleHavingMenu()) && checkMenuIncorrectFunction.apply(req.getRoleHavingMenu())) {
                return new RestResult<>(RestEnum.FAILED.getCode(), "更新角色失败，菜单权限不符合要求", null);
            }
            Map<Integer, List<Integer>> roleHavingMenu = RoleMenuUtils.reqToMenu(req.getRoleHavingMenu());;
            try {
                userRoleService.updateRole(req.getRoleId(), req.getRoleDesc(), req.getStatus(), roleHavingMenu);
            } catch (Exception e) {
                return new RestResult<>(RestEnum.FAILED.getCode(), e.getMessage(), null);
            }
        }
        return new RestResult<>(RestEnum.SUCCESS.getCode(), RestEnum.SUCCESS.getMsg(), null);
    }

    @GetMapping("/deleteRole/{id}")
    @Menu(firstMenu = FirstMenuEnum.SYSTEM_MANAGEMENT, secondMenu = SecondMenuEnum.ROLE_MANAGEMENT)
    @CostTime(interfaceName = "deleteRole")
    public RestResult<Void> deleteRole(@PathVariable int id) {
        try {
            userRoleService.deleteRole(id);
        } catch (Exception e) {
            return new RestResult<>(RestEnum.FAILED.getCode(), e.getMessage(), null);
        }
        return new RestResult<>(RestEnum.SUCCESS.getCode(), RestEnum.SUCCESS.getMsg(), null);
    }

    @GetMapping("/getRoleMenuList/{id}")
    @Menu(firstMenu = FirstMenuEnum.SYSTEM_MANAGEMENT, secondMenu = SecondMenuEnum.ROLE_MANAGEMENT)
    @CostTime(interfaceName = "getRoleMenus")
    public RestResult<List<RoleMenuResp>> getRoleMenus(@PathVariable int id) {
        VideoSystemRole role = userRoleService.getRole(id);
        if (role == null) {
            return new RestResult<>(RestEnum.FAILED.getCode(), "获取菜单权限失败，角色不存在", null);
        }
        List<RoleMenuResp> roleMenuRespList = Lists.newArrayList();
        if (role.getRoleStatus().equals(StatusEnum.OPEN_EFFECTIVE.getCode())) {
            roleMenuRespList = RoleMenuResp.convert(role.getRoleHavingMenu());
        }
        return new RestResult<>(RestEnum.SUCCESS.getCode(), RestEnum.SUCCESS.getMsg(), roleMenuRespList);
    }
}
