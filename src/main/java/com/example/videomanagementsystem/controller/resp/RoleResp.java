package com.example.videomanagementsystem.controller.resp;

import com.example.videomanagementsystem.domain.VideoSystemRole;
import com.example.videomanagementsystem.enums.FirstMenuEnum;
import com.example.videomanagementsystem.enums.SecondMenuEnum;
import com.example.videomanagementsystem.enums.StatusEnum;
import com.example.videomanagementsystem.util.RoleMenuUtils;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
public class RoleResp {

    private long roleId;

    private String roleName;

    private String roleDesc;

    private int roleStatusId;

    private String roleStatusName;

    private List<RoleMenu> roleMenu;

    @Data
    @AllArgsConstructor
    private static class RoleMenu {

        private int firstMenuId;

        private String firstMenuName;

        private List<SecondMenu> secondMenu;

        @Data
        @AllArgsConstructor
        private static class SecondMenu {

            private int secondMenuId;

            private String secondMenuName;
        }
    }

    public static RoleResp convert(VideoSystemRole role) {
        List<RoleMenu> roleMenu = RoleMenuUtils.jsonToMenu(role.getRoleHavingMenu()).entrySet().stream()
                .map(menu -> new RoleMenu(menu.getKey(), FirstMenuEnum.getFirstMenuEnum(menu.getKey()).getName(),
                        menu.getValue().stream()
                                .map(secondMenu -> new RoleMenu.SecondMenu(secondMenu, SecondMenuEnum.getSecondMenuEnum(secondMenu).getName()))
                                .collect(Collectors.toList())
                        )
                ).collect(Collectors.toList());
        return RoleResp.builder()
                .roleId(role.getId())
                .roleName(role.getRoleName())
                .roleDesc(role.getRoleDesc())
                .roleStatusId(role.getRoleStatus())
                .roleStatusName(StatusEnum.getStatusEnum(role.getRoleStatus()).getName())
                .roleMenu(roleMenu)
                .build();
    }
}
