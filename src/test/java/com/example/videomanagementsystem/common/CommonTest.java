package com.example.videomanagementsystem.common;

import com.example.videomanagementsystem.constants.RestResult;
import com.example.videomanagementsystem.controller.CommonController;
import com.example.videomanagementsystem.controller.resp.GatherFieldResp;
import com.example.videomanagementsystem.util.JacksonUtil;
import com.example.videomanagementsystem.util.QpsStatistics.HandlerQpsNodeExpiredCache;
import com.example.videomanagementsystem.util.QpsStatistics.QpsNode;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@SpringBootTest
@Slf4j
@Component
public class CommonTest {

    @Resource
    private CommonController commonController;

    private HandlerQpsNodeExpiredCache handlerQpsNodeExpiredCache = new HandlerQpsNodeExpiredCache();

    @Test
    public void test01() {
        RestResult<List<GatherFieldResp>> restResult = commonController.getGatherFieldList();
        System.out.println(JacksonUtil.beanToStr(restResult));
    }

    @Test
    public void test02() {
        Map<String, QpsNode> map = handlerQpsNodeExpiredCache.getQpsNodeLocalCache();
        for (String key : map.keySet()) {
            System.out.println(key);
            System.out.println(JacksonUtil.beanToStr(map.get(key)));
        }
    }
}
