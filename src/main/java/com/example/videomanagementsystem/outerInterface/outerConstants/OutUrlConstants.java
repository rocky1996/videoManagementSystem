package com.example.videomanagementsystem.outerInterface.outerConstants;

public class OutUrlConstants {

    /*************任务下发**************/
    //TODO
    public static String TASK_ISSUE_URL = "http://localhost:port/social_task_api";

    /*************中译语音翻译**************/
    public static String VIDEO_TRANSLATE_URL = "http://translateport.yeekit.com/translate";

    /*************物体识别**************/
    public static String KNOWLEDGE_URL = "http://101.42.105.86/gateway/api/api/v1/search?kg={kg}&key={key}&keyword={keyword}&page={page}&pageSize={pageSize}&entityType={entityType}&nation={nation}&mode={mode}";
    public static String KNOWLEDGE_DETAIL_URL = "http://101.42.105.86/graph/#/Entity/Entity?graphKey=kg_base&id=";
}
