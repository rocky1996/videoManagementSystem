package com.example.videomanagementsystem.constants;

import com.google.common.collect.ImmutableList;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class AuthMap {
    private static Map<String, List> superAdminMap = new LinkedHashMap<>();
    private static Map<String, List> orderAdminMap = new LinkedHashMap<>();
    private static Map<String, List> approveAdminMap = new LinkedHashMap<>();
    private static Map<String, List> orderMap = new LinkedHashMap<>();
    private static Map<String, List> approveMap = new LinkedHashMap<>();
    static {
        superAdminMap.put("任务下发", ImmutableList.of());
        superAdminMap.put("推送记录", ImmutableList.of());
        superAdminMap.put("审核下发", ImmutableList.of("待审核", "已审核", "全部"));
        superAdminMap.put("任务监控", ImmutableList.of());
        superAdminMap.put("系统管理", ImmutableList.of("用户管理", "角色管理", "客户管理", "意见反馈"));

        orderAdminMap.put("任务下发", ImmutableList.of());
        orderAdminMap.put("推送记录", ImmutableList.of());
        orderAdminMap.put("系统管理", ImmutableList.of("用户管理", "角色管理"));

        approveAdminMap.put("审核下发", ImmutableList.of("待审核", "已审核", "全部"));
        approveAdminMap.put("任务监控", ImmutableList.of());
        approveAdminMap.put("系统管理", ImmutableList.of("用户管理", "角色管理", "客户管理", "意见反馈"));

        orderMap.put("任务下发", ImmutableList.of());
        orderMap.put("推送记录", ImmutableList.of());

        approveMap.put("审核下发", ImmutableList.of("待审核", "已审核"));
    }

    public static Map<String, List> getSuperAdminMap() { return superAdminMap;}
    public static Map<String, List> getOrderAdminMap() { return orderAdminMap;}
    public static Map<String, List> getApproveAdminMap() { return approveAdminMap;}
    public static Map<String, List> getOrderMap() { return orderMap;}
    public static Map<String, List> getApproveMap() { return approveMap;}
}
