package com.example.videomanagementsystem.controller;

import com.example.videomanagementsystem.constants.RestResult;
import com.example.videomanagementsystem.controller.resp.MediaScopeResp;
import com.example.videomanagementsystem.enums.MediaSourceEnum;
import com.example.videomanagementsystem.enums.RestEnum;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;
import java.util.List;

@RestController("/videoSystem/common")
public class CommonController {

    @GetMapping("/getTaskMediaScopeList")
    public RestResult<List<MediaScopeResp>> getTaskMediaScopeList() {
        List<MediaScopeResp> mediaScopeRespList = new LinkedList<>();
        for (MediaSourceEnum sourceEnum : MediaSourceEnum.values()) {
            mediaScopeRespList.add(new MediaScopeResp().setMediaId(sourceEnum.getCode()).setMediaName(sourceEnum.getName()));
        }
        return new RestResult(RestEnum.SUCCESS, mediaScopeRespList);
    }
}
