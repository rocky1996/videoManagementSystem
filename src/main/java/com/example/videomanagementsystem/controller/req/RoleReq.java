package com.example.videomanagementsystem.controller.req;

import lombok.Data;

import java.util.List;

@Data
public class RoleReq {

    private Integer roleId;

    private String roleName;

    private String roleDesc;

    private Integer status;

    private List<RoleHavingMenu> roleHavingMenu;

    @Data
    public static class RoleHavingMenu {

        private int firstMenuId;

        private List<SecondMenu> secondMenu;

        @Data
        public static class SecondMenu {

            private int secondMenuId;
        }
    }
}
