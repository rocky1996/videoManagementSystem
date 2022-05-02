package com.example.videomanagementsystem.controller.req;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

@Data
public class UserLoginReq {

    @NotBlank
    private String username;

    @NotBlank
    private String password;
}
