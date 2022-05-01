package com.example.videomanagementsystem.controller;

import com.example.videomanagementsystem.constants.RestResult;
import com.example.videomanagementsystem.controller.resp.UserResp;
import com.example.videomanagementsystem.dao.UserDao;
import com.example.videomanagementsystem.enums.RestEnum;
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
    public RestResult<List<UserResp>> getAllUsers() {
        List<UserResp> userRespList = userDao.getAllUsers().stream()
                .map(UserResp::convert)
                .collect(Collectors.toList());
        return new RestResult<>(RestEnum.SUCCESS.getCode(), RestEnum.SUCCESS.getMsg(), userRespList);
    }
}
