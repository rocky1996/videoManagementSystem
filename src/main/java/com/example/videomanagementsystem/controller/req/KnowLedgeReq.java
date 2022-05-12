package com.example.videomanagementsystem.controller.req;

import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.NotBlank;

@Data
@Accessors(chain = true)
public class KnowLedgeReq {

    @NotBlank
    private String keyWord;

    private Integer page;

    private Integer pageSize;
}
