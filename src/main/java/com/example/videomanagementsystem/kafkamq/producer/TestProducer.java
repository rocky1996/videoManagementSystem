package com.example.videomanagementsystem.kafkamq.producer;

import com.example.videomanagementsystem.kafkamq.mqBean.TestLogMsg;
import com.example.videomanagementsystem.util.JacksonUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.UUID;

@Component
public class TestProducer {

    @Resource
    private KafkaTemplate kafkaTemplate;

    @Value("${kafka.test-topic}")
    private String topic;

    public void send(){
        TestLogMsg testLogMsg = TestLogMsg
                .builder()
                .id(System.currentTimeMillis())
                .msg(UUID.randomUUID().toString())
                .sendTime(LocalDateTime.now())
                .build();
        kafkaTemplate.send(topic, JacksonUtil.beanToStr(testLogMsg));
    }
}
