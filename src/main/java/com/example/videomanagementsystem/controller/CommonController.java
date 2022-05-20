package com.example.videomanagementsystem.controller;

import com.example.videomanagementsystem.aop.CostTime;
import com.example.videomanagementsystem.constants.RestResult;
import com.example.videomanagementsystem.constants.UrlConstants;
import com.example.videomanagementsystem.controller.auth.Menu;
import com.example.videomanagementsystem.controller.resp.*;
import com.example.videomanagementsystem.enums.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping(UrlConstants.COMMON_URL)
public class CommonController {

    @GetMapping("/getMenuList")
    @Menu(firstMenu = FirstMenuEnum.SYSTEM_MANAGEMENT, secondMenu = SecondMenuEnum.ROLE_MANAGEMENT)
    @CostTime(interfaceName = "getRoleMenus")
    public RestResult<List<RoleMenuResp>> getRoleMenus() {
        List<RoleMenuResp> roleMenuRespList = Arrays.stream(FirstMenuEnum.values())
                .map(menu -> new RoleMenuResp(menu.getCode(), menu.getName(),
                        menu.getSecondMenuEnumList().stream()
                                .map(secondMenu -> new RoleMenuResp.SecondMenu(secondMenu.getCode(), secondMenu.getName()))
                                .collect(Collectors.toList()))
                ).collect(Collectors.toList());
        return new RestResult<>(RestEnum.SUCCESS.getCode(), RestEnum.SUCCESS.getMsg(), roleMenuRespList);
    }

    @GetMapping("/getTaskMediaScopeList")
    @Menu(firstMenu = FirstMenuEnum.TASK_DISTRIBUTION)
    @CostTime(interfaceName = "getTaskMediaScopeList")
    public RestResult<List<MediaScopeResp>> getTaskMediaScopeList() {
        return new RestResult<>(RestEnum.SUCCESS, Arrays.stream(MediaSourceEnum.values()).map(e -> new MediaScopeResp().setMediaId(e.getCode()).setMediaName(e.getName())).collect(Collectors.toList()));
    }
    @GetMapping("/getTaskTypeList")
    @Menu(firstMenu = FirstMenuEnum.TASK_DISTRIBUTION)
    @CostTime(interfaceName = "getTaskTypeList")
    public RestResult<List<TaskTypeResp>> getTaskTypeList() {
        return new RestResult<>(RestEnum.SUCCESS, Arrays.stream(TaskTypeEnum.values()).map(e -> new TaskTypeResp().setTaskTypeId(e.getCode()).setTaskTypeName(e.getName())).collect(Collectors.toList()));
    }

    @GetMapping("/getTaskGatherList")
    @Menu(firstMenu = FirstMenuEnum.TASK_DISTRIBUTION)
    @CostTime(interfaceName = "getTaskGatherList")
    public RestResult<List<TaskGatherResp>> getTaskGatherList() {
        return new RestResult<>(RestEnum.SUCCESS, Arrays.stream(CollectionModeEnum.values()).map(e -> new TaskGatherResp().setTaskGatherTypeId(e.getCode()).setTaskGatherTypeName(e.getName())).collect(Collectors.toList()));
    }

    @GetMapping("/getGatherFieldList")
    @Menu(firstMenu = FirstMenuEnum.TASK_DISTRIBUTION)
    @CostTime(interfaceName = "getGatherFieldList")
    public RestResult<List<GatherFieldResp>> getGatherFieldList() {
        return new RestResult<>(RestEnum.SUCCESS, Arrays.stream(GatherFieldEnum.values()).map(e -> new GatherFieldResp().setGatherFieldId(e.getCode()).setGatherFieldName(e.getName())).collect(Collectors.toList()));
    }

    @GetMapping("/getStatusList")
    @Menu(firstMenu = FirstMenuEnum.TASK_DISTRIBUTION)
    @CostTime(interfaceName = "getStatusList")
    public RestResult<List<StatusResp>> getStatusList() {
        return new RestResult<>(RestEnum.SUCCESS, Arrays.stream(StatusEnum.values()).map(e -> new StatusResp().setStatusIs(e.getCode()).setStatusName(e.getName())).collect(Collectors.toList()));
    }

    @GetMapping("/getTaskStatusList")
    @Menu(firstMenu = FirstMenuEnum.TASK_DISTRIBUTION)
    @CostTime(interfaceName = "getTaskStatusList")
    public RestResult<List<TaskStatusResp>> getTaskStatusList() {
        return new RestResult<>(RestEnum.SUCCESS, Arrays.stream(TaskStatusEnum.values()).map(e -> new TaskStatusResp().setTaskStatusIs(e.getCode()).setTaskStatusName(e.getName())).collect(Collectors.toList()));
    }

    @GetMapping("/getLanguageTypeList")
    @Menu(firstMenu = FirstMenuEnum.TASK_DISTRIBUTION)
    @CostTime(interfaceName = "getLanguageTypeList")
    public RestResult<List<LanguageTypeResp>> getLanguageTypeList() {
        return new RestResult<>(RestEnum.SUCCESS, Arrays.stream(LanguagesTypeEnum.values()).map(e -> new LanguageTypeResp().setLanguageId(e.getCode()).setLanguageName(e.getName())).collect(Collectors.toList()));
    }

    @GetMapping("/getRuleTypeList")
    @Menu(firstMenu = FirstMenuEnum.TASK_DISTRIBUTION)
    @CostTime(interfaceName = "getRuleTypeList")
    public RestResult<List<RuleTypeResp>> getRuleTypeList() {
        return new RestResult<>(RestEnum.SUCCESS, Arrays.stream(RuleTypeEnum.values()).map(e -> new RuleTypeResp().setRuleTypeId(e.getCode()).setRuleTypeName(e.getName())).collect(Collectors.toList()));
    }
}
