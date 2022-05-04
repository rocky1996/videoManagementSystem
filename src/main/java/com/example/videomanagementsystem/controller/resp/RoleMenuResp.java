package com.example.videomanagementsystem.controller.resp;

import com.example.videomanagementsystem.enums.FirstMenuEnum;
import com.example.videomanagementsystem.enums.SecondMenuEnum;
import com.example.videomanagementsystem.util.RoleMenuUtils;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
public class RoleMenuResp {

    private int firstMenuId;

    private String firstMenuName;

    private List<SecondMenu> havingSecondMenu;

    @Data
    @AllArgsConstructor
    public static class SecondMenu {

        private int secondMenuId;

        private String secondMenuName;
    }

    public static List<RoleMenuResp> convert(String menuJson) {
        return RoleMenuUtils.jsonToMenu(menuJson).entrySet().stream()
                .map(menu -> new RoleMenuResp(menu.getKey(), FirstMenuEnum.getFirstMenuEnum(menu.getKey()).getName(),
                                menu.getValue().stream()
                                        .map(secondMenu -> new SecondMenu(secondMenu, SecondMenuEnum.getSecondMenuEnum(secondMenu).getName()))
                                        .collect(Collectors.toList())
                        )
                ).collect(Collectors.toList());
    }
}
