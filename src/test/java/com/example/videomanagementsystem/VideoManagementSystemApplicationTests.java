package com.example.videomanagementsystem;

import com.example.videomanagementsystem.kafkamq.producer.Producer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class VideoManagementSystemApplicationTests {

    @Autowired
    private Producer producer;

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
//        System.out.println(servers);
//        System.out.println(enableAutoCommit);
//        System.out.println(sessionTimeout);
//        System.out.println(autoCommitInterval);
//        System.out.println(groupId);
//        System.out.println(autoOffsetReset);
//        System.out.println(concurrency);
        System.out.println(topicName);
    }
}
