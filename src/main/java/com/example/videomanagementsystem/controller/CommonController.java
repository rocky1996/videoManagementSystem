package com.example.videomanagementsystem.controller;

import com.example.videomanagementsystem.constants.RestResult;
import com.example.videomanagementsystem.controller.resp.RoleMenuResp;
import com.example.videomanagementsystem.enums.FirstMenuEnum;
import com.example.videomanagementsystem.enums.RestEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping("/videoSystem/common")
public class CommonController {

    @GetMapping("/getMenuList")
    public RestResult<List<RoleMenuResp>> getRoleMenus() {
        List<RoleMenuResp> roleMenuRespList = Arrays.stream(FirstMenuEnum.values())
                .map(menu -> new RoleMenuResp(menu.getCode(), menu.getName(),
                        menu.getSecondMenuEnumList().stream()
                                .map(secondMenu -> new RoleMenuResp.SecondMenu(secondMenu.getCode(), secondMenu.getName()))
                                .collect(Collectors.toList()))
                ).collect(Collectors.toList());
        return new RestResult<>(RestEnum.SUCCESS.getCode(), RestEnum.SUCCESS.getMsg(), roleMenuRespList);
    }
}
