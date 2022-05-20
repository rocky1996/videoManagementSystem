package com.example.videomanagementsystem;

import com.example.videomanagementsystem.controller.req.KnowLedgeReq;
import com.example.videomanagementsystem.kafkamq.producer.Producer;
import com.example.videomanagementsystem.outerInterface.outImpl.KnowledgeOuterServiceImpl;
import com.example.videomanagementsystem.util.JacksonUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.Map;

@SpringBootTest
class VideoManagementSystemApplicationTests {

    @Resource
    private Producer producer;
    @Resource
    private KnowledgeOuterServiceImpl knowledgeOuterServiceImpl;

    @Value("${kafka.bootstrap-servers}")
    private String servers;
    @Value("${kafka.consumer.enable.auto.commit}")
    private boolean enableAutoCommit;
    @Value("${kafka.consumer.session.timeout}")
    private String sessionTimeout;
    @Value("${kafka.consumer.auto.commit.interval}")
    private String autoCommitInterval;
    @Value("${kafka.consumer.group.id}")
    private String groupId;
    @Value("${kafka.consumer.auto.offset.reset}")
    private String autoOffsetReset;
    @Value("${kafka.consumer.concurrency}")
    private int concurrency;
    @Value("${kafka.topic}")
    private String topicName;

    @Test
    void contextLoads() {
        producer.send();
    }

    @Test
    public void test01(){
        System.out.println(servers);
        System.out.println(enableAutoCommit);
        System.out.println(sessionTimeout);
        System.out.println(autoCommitInterval);
        System.out.println(groupId);
        System.out.println(autoOffsetReset);
        System.out.println(concurrency);
        System.out.println(topicName);
    }

    @Test
    public void test02(){
        Map<String, Object> map = knowledgeOuterServiceImpl.getKnowLedgeInfo(new KnowLedgeReq().setKeyWord("拜登").setPage(null).setPageSize(null));
        System.out.println(JacksonUtil.beanToStr(map));
    }
}
