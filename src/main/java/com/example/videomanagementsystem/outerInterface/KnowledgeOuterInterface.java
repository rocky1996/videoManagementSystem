package com.example.videomanagementsystem.outerInterface;

import com.example.videomanagementsystem.util.JacksonUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Component
@Slf4j
@Service
public class KnowledgeOuterInterface {

    @Resource
    private RestTemplate restTemplate;

    //图谱实例key,固定值kg_base
    private static String KEY_KEY = "key";
    private static String KEY_VALUE = "kg_base";
    //图谱实例id,固定值10
    private static String KG_KEY = "kg";
    private static Integer KG_VALUE = 10;

    //实体名,默认为空
    private static String ENTITY_NAME_KEY = "entityName";
    private static String ENTITY_NAME_VALUE = "";

    //实体类型,默认为空
    private static String ENTITY_TYPE_KEY = "entityType";
    private static String ENTITY_TYPE_VALUE = "";

    private static String KEY_WORD_KEY = "keyword";

    //检索模式，[1:关键词检索，2:语义检索],固定值1
    private static String MODE_KEY = "mode";
    private static Integer MODE_VALUE = 1;

    //国家,汉字,默认为空
    private static String NATION_KEY = "nation";
    private static String NATION_VALUE = "";

    //分页
    private static String PAGE_KEY = "page";
    private static Integer PAGE_VALUE = 1;
    private static String PAGE_SIZE_KEY = "pageSize";
    private static Integer PAGE_SIZE_VALUE = 20;

    private static String KNOWLEDGE_URL = "http://101.42.105.86/gateway/api/api/v1/search?kg={kg}&key={key}&keyword={keyword}&page={page}&pageSize={pageSize}&entityType={entityType}&nation={nation}&mode={mode}";
    private static String KNOWLEDGE_DETAIL_URL = "http://101.42.105.86/graph/#/Entity/Entity?graphKey=kg_base&id=";

    /**
     * 获取知识库
     * @param keyWordValue
     * @return
     */
    public Map<String, Object> getKnowLedgeInfo(String keyWordValue, Integer page, Integer pageSize) {

        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put(KEY_KEY, KEY_VALUE);
        paramMap.put(KG_KEY, KG_VALUE);
        paramMap.put(ENTITY_NAME_KEY, ENTITY_NAME_VALUE);
        paramMap.put(ENTITY_TYPE_KEY, ENTITY_TYPE_VALUE);
        paramMap.put(KEY_WORD_KEY, keyWordValue);
        paramMap.put(MODE_KEY, MODE_VALUE);
        paramMap.put(NATION_KEY, NATION_VALUE);
        paramMap.put(PAGE_KEY, page != null ? page : PAGE_VALUE);
        paramMap.put(PAGE_SIZE_KEY, pageSize != null ? pageSize : PAGE_SIZE_VALUE);
        OuterResp outerResp = restTemplate.getForObject(KNOWLEDGE_URL, OuterResp.class, paramMap);
        stopWatch.stop();
        log.info("获取知识图谱远程接口数据,paramMap:{},outerResp:{},time:{}", JacksonUtil.beanToStr(paramMap), JacksonUtil.beanToStr(outerResp), stopWatch.getTotalTimeMillis());

        if (outerResp.getCode() == 200 && outerResp.isSuccess()) {
            Map<String, Object> resultMap = (Map<String, Object>)outerResp.getData();
            return Objects.isNull(resultMap) ? null : resultMap;
        }
        return null;
    }

    /**
     * 获取知识库详情页
     * @param entityId
     * @return
     */
    public String getKnowledgeDetailUrl(String entityId) {
        return StringUtils.isNotBlank(entityId) ? KNOWLEDGE_DETAIL_URL + entityId : "";
    }
}
