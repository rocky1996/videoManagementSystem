package com.example.videomanagementsystem;

import com.example.videomanagementsystem.controller.req.KnowLedgeReq;
import com.example.videomanagementsystem.kafkamq.producer.TestProducer;
import com.example.videomanagementsystem.outerInterface.outImpl.KnowledgeOuterServiceImpl;
import com.example.videomanagementsystem.outerInterface.outImpl.TranslateOuterServiceImpl;
import com.example.videomanagementsystem.util.JacksonUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.Map;

@SpringBootTest
class VideoManagementSystemApplicationTests {

    @Resource
    private TestProducer testProducer;
    @Resource
    private KnowledgeOuterServiceImpl knowledgeOuterServiceImpl;
    @Resource
    private TranslateOuterServiceImpl translateOuterService;

    @Test
    void contextLoads() {
        testProducer.send();
    }

    @Test
    public void test02(){
        Map<String, Object> map = knowledgeOuterServiceImpl.getKnowLedgeInfo(new KnowLedgeReq().setKeyWord("拜登").setPage(null).setPageSize(null));
        System.out.println(JacksonUtil.beanToStr(map));
    }

    @Test
    public void test03() {
        String str = "There was nothing casual about this";
        String result = translateOuterService.getTranslateValue(str);
        System.out.println("result:" + result);
    }
}
