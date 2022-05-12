package com.example.videomanagementsystem.util;

import cn.hutool.core.lang.TypeReference;
import com.example.videomanagementsystem.controller.req.RoleReq;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RoleMenuUtils {

    public static Map<Integer, List<Integer>> jsonToMenu(String json) {
        return JacksonUtil.strToBean(json, new TypeReference<Map<Integer, List<Integer>>>(){});
    }

    public static Map<Integer, List<Integer>> reqToMenu(List<RoleReq.RoleHavingMenu> roleHavingMenus) {
        if (CollectionUtils.isEmpty(roleHavingMenus)) {
            return null;
        }
        return roleHavingMenus.stream()
                .collect(Collectors.toMap(RoleReq.RoleHavingMenu::getFirstMenuId, menu -> menu.getSecondMenu().stream().map(RoleReq.RoleHavingMenu.SecondMenu::getSecondMenuId).collect(Collectors.toList())));
    }


    public static String menuToJson(Map<Integer, List<Integer>> menu) {
        return JacksonUtil.beanToStr(menu);
    }
}
