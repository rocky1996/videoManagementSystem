package com.example.videomanagementsystem.controller.req;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

@Data
public class UserPasswordResetReq {

    private int userId;

    private Integer roleId;

    @NotEmpty
    private String newPassword;

    @NotEmpty
    private String replaceNewPassword;
}
