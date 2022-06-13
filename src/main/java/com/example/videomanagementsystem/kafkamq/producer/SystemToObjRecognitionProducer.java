package com.example.videomanagementsystem.kafkamq.producer;

import com.example.videomanagementsystem.kafkamq.mqBean.SystemToObjRecognitionBean;
import com.example.videomanagementsystem.util.JacksonUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class SystemToObjRecognitionProducer {

    @Resource
    private KafkaTemplate kafkaTemplate;

    @Value("${kafka.system2objRecognition-topic}")
    private String topic;

    public void send(SystemToObjRecognitionBean systemToObjRecognitionBean){
        kafkaTemplate.send(topic, JacksonUtil.beanToStr(systemToObjRecognitionBean));
    }
}
