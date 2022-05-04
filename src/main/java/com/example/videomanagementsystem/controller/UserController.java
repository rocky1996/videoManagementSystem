package com.example.videomanagementsystem.controller;

import com.example.videomanagementsystem.constants.PageResult;
import com.example.videomanagementsystem.constants.RestResult;
import com.example.videomanagementsystem.controller.req.UserLoginReq;
import com.example.videomanagementsystem.controller.req.UserPasswordResetReq;
import com.example.videomanagementsystem.controller.req.UserQueryReq;
import com.example.videomanagementsystem.controller.req.UserReq;
import com.example.videomanagementsystem.controller.resp.UserResp;
import com.example.videomanagementsystem.dao.UserDao;
import com.example.videomanagementsystem.domain.VideoSystemRole;
import com.example.videomanagementsystem.domain.VideoSystemUser;
import com.example.videomanagementsystem.enums.RestEnum;
import com.example.videomanagementsystem.enums.StatusEnum;
import com.example.videomanagementsystem.service.UserRoleService;
import com.example.videomanagementsystem.service.UserService;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping("/videoSystem/user")
public class UserController {

    @Autowired
    private UserDao userDao;

    @Autowired
    private UserService userService;

    @Autowired
    private UserRoleService userRoleService;

    @PostMapping("/searchUserList")
    public RestResult<PageResult<UserResp>> getUsers(@RequestBody @Valid UserQueryReq req) {
        List<VideoSystemUser> users = userDao.selectUsers(req.convert());
        PageInfo<VideoSystemUser> pageInfo = new PageInfo<>(users);
        List<Integer> roleIds = users.stream().map(VideoSystemUser::getRoleId).distinct().collect(Collectors.toList());
        Map<Integer, VideoSystemRole> roleMap = userRoleService.getRoles(roleIds);

        List<UserResp> userRespList = users.stream()
                .map(user -> UserResp.convert(user, roleMap.get(user.getRoleId())))
                .collect(Collectors.toList());
        PageResult<UserResp> pageResult = PageResult.create(pageInfo, userRespList);
        return new RestResult<>(RestEnum.SUCCESS.getCode(), RestEnum.SUCCESS.getMsg(), pageResult);
    }

    @PostMapping("/loginUser")
    public RestResult<UserResp> login(@RequestBody @Valid UserLoginReq req) {
        try {
            VideoSystemUser user = userService.login(req.getUsername(), req.getPassword());
            VideoSystemRole role = userRoleService.getRole(user.getRoleId());
            UserResp userResp = UserResp.convert(user, role);
            return new RestResult<>(RestEnum.SUCCESS.getCode(), RestEnum.SUCCESS.getMsg(), userResp);
        } catch (Exception e) {
            return new RestResult<>(RestEnum.FAILED.getCode(), e.getMessage(), null);
        }
    }

    @PostMapping("/createOrUpdateUser")
    public RestResult<Void> createOrUpdateUser(@RequestBody @Valid UserReq req) {
        //创建
        if (req.getUserId() == null) {
            //确认password
            if (!req.getPassword().equals(req.getRePassword())) {
                return new RestResult<>(RestEnum.FAILED.getCode(), "创建用户失败，请再次确认密码", null);
            }
            if (req.getStatus() == null || StatusEnum.getStatusEnum(req.getStatus()) == null) {
                return new RestResult<>(RestEnum.FAILED.getCode(), "创建用户失败，用户状态不符合要求", null);
            }
            VideoSystemRole role = userRoleService.getRole(req.getRoleId());
            if (role == null) {
                return new RestResult<>(RestEnum.FAILED.getCode(), "创建用户失败，角色不符合要求", null);
            }
            try {
                userService.addUser(req.getUsername(), req.getPassword(), req.getUserDesc(), req.getStatus(), req.getRoleId());
            } catch (Exception e) {
                return new RestResult<>(RestEnum.FAILED.getCode(), e.getMessage(), null);
            }
        } else {
            //更新
            if (req.getStatus() != null && StatusEnum.getStatusEnum(req.getStatus()) == null) {
                return new RestResult<>(RestEnum.FAILED.getCode(), "更新用户失败，用户状态不符合要求", null);
            }
            if (req.getRoleId() != null && userRoleService.getRole(req.getRoleId()) == null) {
                return new RestResult<>(RestEnum.FAILED.getCode(), "更新用户失败，角色不符合要求", null);
            }
            try {
                userService.updateUser(req.getUserId(), req.getUserDesc(), req.getStatus(), req.getRoleId());
            } catch (Exception e) {
                return new RestResult<>(RestEnum.FAILED.getCode(), e.getMessage(), null);
            }
        }
        return new RestResult<>(RestEnum.SUCCESS.getCode(), RestEnum.SUCCESS.getMsg(), null);
    }

    @GetMapping("/deleteUser/{id}")
    public RestResult<Void> deleteUser(@PathVariable int id) {
        try {
            userService.deleteUser(id);
        } catch (Exception e) {
            return new RestResult<>(RestEnum.FAILED.getCode(), e.getMessage(), null);
        }
        return new RestResult<>(RestEnum.SUCCESS.getCode(), RestEnum.SUCCESS.getMsg(), null);
    }

    @PostMapping("/updateUserPassword")
    public RestResult<Void> updateUserPassword(@RequestBody @Valid UserPasswordResetReq req) {
        try {
            //确认newPassword
            if (!req.getNewPassword().equals(req.getReplaceNewPassword())) {
                return new RestResult<>(RestEnum.FAILED.getCode(), "重置用户密码失败，请再次确认密码", null);
            }
            userService.updateUserPassword(req.getUserId(), req.getNewPassword());
        } catch (Exception e) {
            return new RestResult<>(RestEnum.FAILED.getCode(), e.getMessage(), null);
        }
        return new RestResult<>(RestEnum.SUCCESS.getCode(), RestEnum.SUCCESS.getMsg(), null);
    }
}
