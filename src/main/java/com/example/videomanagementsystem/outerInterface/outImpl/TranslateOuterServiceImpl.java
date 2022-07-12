package com.example.videomanagementsystem.outerInterface.outImpl;

import com.example.videomanagementsystem.outerInterface.outerConstants.OutUrlConstants;
import com.example.videomanagementsystem.outerInterface.outerResp.DelectResp;
import com.example.videomanagementsystem.util.JacksonUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StopWatch;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@Component
@Slf4j
@Service
public class TranslateOuterServiceImpl {

    private static String ENGLISH_PARAM_KEY = "srcl";
    private static String ENGLISH_PARAM_VALUE = "nen";
    private static String CHINESE_PARAM_KEY = "tgtl";
    private static String CHINESE_PARAM_VALUE = "nzh";
    private static String TEXT_KEY = "text";
    private static String APP_SOURCE = "app_source";
    private static String APP_SOURCE_4003 = "4003";

    @Resource
    private RestTemplate restTemplate;

    /**
     * 中译语音翻译
     * @param textValue
     * @return
     */
    public String getTranslateValue(String textValue) {
        try{
            if (StringUtils.isBlank(textValue)) {
                log.info("TranslateOuterServiceImpl.getTranslateValue,textValue is null");
                return null;
            }

            StopWatch stopWatch = new StopWatch();
            stopWatch.start();
            HttpHeaders httpHeader = new HttpHeaders();
            httpHeader.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
            MultiValueMap<String, Object> paramMap = new LinkedMultiValueMap<>();
            paramMap.add(ENGLISH_PARAM_KEY, ENGLISH_PARAM_VALUE);
            paramMap.add(CHINESE_PARAM_KEY, CHINESE_PARAM_VALUE);
            paramMap.add(APP_SOURCE, APP_SOURCE_4003);
            paramMap.add(TEXT_KEY, textValue);
            HttpEntity<MultiValueMap<String, Object>> requestParam = new HttpEntity<>(paramMap, httpHeader);
            ResponseEntity<String> outerResp = restTemplate.postForEntity(OutUrlConstants.VIDEO_TRANSLATE_URL, requestParam, String.class);
            stopWatch.stop();
            log.info("获取中译语音翻译数据,requestParam:{},outerResp:{},time:{}", JacksonUtil.beanToStr(requestParam), JacksonUtil.beanToStr(outerResp), stopWatch.getTotalTimeMillis());

            DelectResp delectResp = JacksonUtil.strToBean(outerResp.getBody(), DelectResp.class);
            if (200 != delectResp.getResponseStatus()) {
                log.info("TranslateOuterServiceImpl.getTranslateValue,translate failed!!!");
                return null;
            }
            return delectResp.getResponseData().getLanguage();
        }catch (Exception e) {
            log.error("TranslateOuterServiceImpl.getTranslateValue has error",e.getMessage());
            return null;
        }
    }
}
