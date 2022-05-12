package com.example.videomanagementsystem.controller;

import com.example.videomanagementsystem.outerInterface.KnowledgeOuterInterface;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController("/videoSystem/knowLedge")
public class KnowLedgeController {

    @Resource
    private KnowledgeOuterInterface knowledgeOuterInterface;

//    @PostMapping("/getKnowLedgeInfoList")
//    private Object getKnowLedgeInfoList(@RequestBody ){
//
//    }
}
