package com.example.videomanagementsystem.kafkamq.consumer;

import com.example.videomanagementsystem.dao.KeywordsDao;
import com.example.videomanagementsystem.domain.VideoSystemKeywords;
import com.example.videomanagementsystem.enums.IsDeleteEnum;
import com.example.videomanagementsystem.kafkamq.mqBean.ObjRecognitionToSystemBean;
import com.example.videomanagementsystem.util.JacksonUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Date;
import java.util.Optional;

@Component
@Slf4j
public class ObjRecognitionToSystemListener {

    @Value("${kafka.objRecognition2System-topic}")
    private String topicName;

    @Resource
    private KeywordsDao keywordsDao;

    /**
     * 监听消费
     * @param record
     * @throws IOException
     */
    @KafkaListener(topics = "${kafka.objRecognition2System-topic}")
    public void listen(ConsumerRecord<?, ?> record) throws IOException {
        if (!topicName.equals(record.topic())) {
            return;
        }

        Optional<?> kafkaMessage = Optional.ofNullable(record.value());
        if (!kafkaMessage.isPresent()) {
            return;
        }

        ObjRecognitionToSystemBean objRecognitionToSystemBean = JacksonUtil.strToBean((String) kafkaMessage.get(), ObjRecognitionToSystemBean.class);
        if (objRecognitionToSystemBean == null) {
            return;
        }
        VideoSystemKeywords keywords = assembleBean(objRecognitionToSystemBean);
        keywordsDao.insert(keywords);
    }

    /**
     * 组装参数
     * @return
     */
    private VideoSystemKeywords assembleBean(ObjRecognitionToSystemBean objRecognitionToSystemBean) {
        Date nowDate = new Date();
        VideoSystemKeywords keywords = VideoSystemKeywords
                .builder()
                .onlyCode(objRecognitionToSystemBean.getOnlyCode())
                .videoUrl(objRecognitionToSystemBean.getVideoUrl())
                .msgBody(JacksonUtil.beanToStr(objRecognitionToSystemBean.getMsgBody()))
                .isDelete(IsDeleteEnum.NOT_DELETE.getCode())
                .createTime(nowDate)
                .updateTime(nowDate)
                .build();
        return keywords;
    }
}
