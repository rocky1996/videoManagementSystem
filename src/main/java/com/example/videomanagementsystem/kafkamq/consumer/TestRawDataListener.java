package com.example.videomanagementsystem.kafkamq.consumer;


import com.example.videomanagementsystem.util.JacksonUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Optional;

@Component
@Slf4j
public class TestRawDataListener {

    @Value("${kafka.topic}")
    private String topicName;
    @Value("${kafka.consumer.group.id}")
    private String groupId;

    /**
     * 监听消费
     * @param record
     * @throws IOException
     */
    @KafkaListener(topics = "${kafka.topic}")
    public void listen(ConsumerRecord<?, ?> record) throws IOException {
        if (topicName.equals(record.topic())) {
            Optional<?> kafkaMessage = Optional.ofNullable(record.value());
            if (kafkaMessage.isPresent()) {
                Object message = kafkaMessage.get();
                log.info("record:{}", JacksonUtil.beanToStr(record));
                log.info("message:{}", JacksonUtil.beanToStr(message));
            }
        }
    }
}
