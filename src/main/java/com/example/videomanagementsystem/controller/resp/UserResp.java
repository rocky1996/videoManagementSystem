package com.example.videomanagementsystem.controller.resp;

import com.example.videomanagementsystem.domain.VideoSystemRole;
import com.example.videomanagementsystem.domain.VideoSystemUser;
import com.example.videomanagementsystem.enums.StatusEnum;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserResp {

    private long userId;

    private String username;

    private String password;

    private String userDesc;

    private long userRoleId;

    private String userRoleName;

    private long statusId;

    private String statusName;

    public static UserResp convert(VideoSystemUser user, VideoSystemRole role) {
        if (user == null) {
            return null;
        }
        return UserResp.builder()
                .userId(user.getId())
                .username(user.getUsername())
                .password(user.getPassword())
                .userDesc(user.getUserDesc())
                .userRoleId(role.getId())
                .userRoleName(role.getRoleName())
                .statusId(user.getUserStatus())
                .statusName(StatusEnum.getStatusEnum(user.getUserStatus()).getName())
                .build();
    }
}
