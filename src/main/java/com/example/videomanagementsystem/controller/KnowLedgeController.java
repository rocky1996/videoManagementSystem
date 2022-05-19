package com.example.videomanagementsystem.controller;

import com.example.videomanagementsystem.aop.CostTime;
import com.example.videomanagementsystem.constants.RestResult;
import com.example.videomanagementsystem.controller.req.KnowLedgeReq;
import com.example.videomanagementsystem.controller.resp.KnowLedgeResp;
import com.example.videomanagementsystem.enums.RestEnum;
import com.example.videomanagementsystem.outerInterface.impl.KnowledgeOuterInterface;
import com.example.videomanagementsystem.util.DateUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.*;

@Slf4j
@RestController
@RequestMapping("/videoSystem/knowLedge")
public class KnowLedgeController {

    @Resource
    private KnowledgeOuterInterface knowledgeOuterInterface;

    @PostMapping("/getKnowLedgeInfoList")
    @CostTime(interfaceName = "getKnowLedgeInfoList")
    private RestResult<KnowLedgeResp> getKnowLedgeInfoList(@RequestBody @Valid KnowLedgeReq knowLedgeReq){
        Map<String, Object> knowMap = knowledgeOuterInterface.getKnowLedgeInfo(knowLedgeReq);
        if (Objects.isNull(knowMap)) {
            return new RestResult(RestEnum.SYSTEM_ERROR);
        }

        List<Map<String, Object>> itemList = (List<Map<String, Object>>) knowMap.get("items");
        if (CollectionUtils.isEmpty(itemList)) {
            return new RestResult(RestEnum.NO_HAVING_DATA);
        }

        Integer total = (Integer) knowMap.get("total");
        List<KnowLedgeResp.ItemDetail> itemDetailList = new ArrayList<>();
        for (Map<String, Object> itemMap : itemList) {
            String url = Objects.isNull(itemMap.get("entity_id")) ? "" : knowledgeOuterInterface.getKnowledgeDetailUrl((String) itemMap.get("entity_id"));
            String entityName = Objects.isNull(itemMap.get("entity_name")) ? "" : (String) itemMap.get("entity_name");
            String entityTypeName = Objects.isNull(itemMap.get("entity_type_name")) ? "" : (String) itemMap.get("entity_type_name");
            String includeTime = Objects.isNull(itemMap.get("last_update")) ? "" : DateUtils.timeStampToDate((Long) itemMap.get("last_update"));

            Map<String, Object> ite = (Map<String, Object>) itemMap.get("props");
            String nation = Objects.isNull(ite.get("nation")) ? "" : (String) ite.get("nation");
            String description = Objects.isNull(ite.get("description")) ? "" : (String) ite.get("description");

            itemDetailList.add(
                    new KnowLedgeResp.ItemDetail()
                            .setUrl(url)
                            .setEntityName(entityName)
                            .setEntityTypeName(entityTypeName)
                            .setNation(nation)
                            .setDescription(description)
                            .setIncludeTime(includeTime)
            );
        }

        return new RestResult(RestEnum.SUCCESS, new KnowLedgeResp()
                .setTotal(total)
                .setItems(itemDetailList)
        );
    }
}
