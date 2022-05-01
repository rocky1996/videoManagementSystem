package com.example.videomanagementsystem.controller.resp;

import com.example.videomanagementsystem.domain.VideoSystemUser;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserResp {

    private long id;

    private String userName;

    public static UserResp convert(VideoSystemUser videoSystemUser) {
        return UserResp.builder()
                .id(videoSystemUser.getId())
                .userName(videoSystemUser.getUsername())
                .build();
    }
}
