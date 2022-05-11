package com.example.videomanagementsystem.kafkamq.consumer;


import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@Slf4j
public class RawDataListener {

    @Value("${kafka.topic}")
    private String topicName;
    @Value("${kafka.consumer.group.id}")
    private String groupId;

    /**
     * 实时获取kafka数据(生产一条，监听生产topic自动消费一条)
     * @param record
     * @throws IOException
     */
    @KafkaListener(topics = {"${kafka.topic}"})
    public void listen(ConsumerRecord<?, ?> record) throws IOException {
        String value = (String) record.value();
        String topic = record.topic();
        if(topicName.equals(topic)){
            System.out.println("接收到的信息为："+ value);
        }else {
            System.out.println("没有监听到消息");
        }
    }
}
