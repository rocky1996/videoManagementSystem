package com.example.videomanagementsystem.config.kafka;

import com.google.common.collect.Maps;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableKafka
public class KafkaProducerConfig {

    @Value("${kafka.bootstrap-servers}")
    private String servers;
    @Value("${kafka.producer.retries}")
    private int retries;
    @Value("${kafka.producer.batch-size}")
    private int batchSize;
    @Value("${kafka.producer.buffer-memory}")
    private int bufferMemory;

    public Map<String,Object> producerConfigs(){
        Map<String,Object> propsMap = Maps.newHashMap();
        propsMap.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,servers);
        propsMap.put(ProducerConfig.RETRIES_CONFIG, retries);
        propsMap.put(ProducerConfig.BATCH_SIZE_CONFIG, batchSize);
        propsMap.put(ProducerConfig.BUFFER_MEMORY_CONFIG, bufferMemory);
        propsMap.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        propsMap.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        return propsMap;
    }

    public ProducerFactory<String,String> producerFactory(){
        return new DefaultKafkaProducerFactory<>(producerConfigs());
    }

    @Bean
    public KafkaTemplate<String,String> kafkaTemplate(){
        return new KafkaTemplate<String,String>(producerFactory());
    }
}
