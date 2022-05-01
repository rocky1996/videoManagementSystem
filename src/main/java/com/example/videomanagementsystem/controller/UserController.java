package com.example.videomanagementsystem.controller;

import com.example.videomanagementsystem.constants.PageResult;
import com.example.videomanagementsystem.constants.RestResult;
import com.example.videomanagementsystem.controller.req.UserQueryReq;
import com.example.videomanagementsystem.controller.resp.UserResp;
import com.example.videomanagementsystem.dao.UserDao;
import com.example.videomanagementsystem.domain.VideoSystemUser;
import com.example.videomanagementsystem.enums.RestEnum;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping("/videoSystem/user")
public class UserController {

    @Autowired
    private UserDao userDao;

    @GetMapping
    public RestResult<PageResult<UserResp>> getUsers(UserQueryReq req) {
        List<VideoSystemUser> users = userDao.getUsers(req.convert());
        PageInfo<VideoSystemUser> pageInfo = new PageInfo<>(users);
        List<UserResp> userRespList = users.stream()
                .map(UserResp::convert)
                .collect(Collectors.toList());
        PageResult<UserResp> pageResult = PageResult.create(pageInfo, userRespList);
        return new RestResult<>(RestEnum.SUCCESS.getCode(), RestEnum.SUCCESS.getMsg(), pageResult);
    }
}
