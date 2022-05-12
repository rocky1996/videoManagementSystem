package com.example.videomanagementsystem.constants;

import com.example.videomanagementsystem.enums.SecondMenuEnum;

import java.util.LinkedList;
import java.util.List;

public class MenuResult {
    private static List<SecondMenuEnum> taskDistributionList = new LinkedList<>();
    private static List<SecondMenuEnum> pushRecordList = new LinkedList<>();
    private static List<SecondMenuEnum> issueList = new LinkedList<>();
    private static List<SecondMenuEnum> taskMonitoringList = new LinkedList<>();
    private static List<SecondMenuEnum> systemList = new LinkedList<>();
    static {
        issueList.add(SecondMenuEnum.PENDING_REVIEW);
        issueList.add(SecondMenuEnum.HAVING_REVIEW);
        issueList.add(SecondMenuEnum.ALL_REVIEW);
        systemList.add(SecondMenuEnum.USER_MANAGEMENT);
        systemList.add(SecondMenuEnum.ROLE_MANAGEMENT);
        systemList.add(SecondMenuEnum.CUSTOMER_MANAGEMENT);
        systemList.add(SecondMenuEnum.FEEDBACK);
        systemList.add(SecondMenuEnum.AUTO_ALLOCATION_RULES);
    }

    public static List<SecondMenuEnum> getTaskDistributionList() {return taskDistributionList;}
    public static List<SecondMenuEnum> getPushRecordList() {return pushRecordList;}
    public static List<SecondMenuEnum> getIssueList() { return issueList;}
    public static List<SecondMenuEnum> getTaskMonitoringList() {return taskMonitoringList;}
    public static List<SecondMenuEnum> getSystemList() { return systemList;}
}
