package com.example.videomanagementsystem.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;
import java.io.InputStreamReader;

@Slf4j
public class ExecuteCmdUtil {
    public static String executeCmdCommand(String cmd) {
        if (StringUtils.isNotBlank(cmd)) {
            StringBuffer sBuffer = new StringBuffer();
            try {
                Process process = Runtime.getRuntime().exec(cmd);
                BufferedReader bufferedReader = new BufferedReader(
                        new InputStreamReader(process.getInputStream(), "GBK"));

                String strLine = null;
                while ((strLine = bufferedReader.readLine()) != null) {
                    sBuffer.append(strLine).append(" ");
                }
                return sBuffer.toString();
            } catch (Exception e) {
                log.error("ExecuteCmdUtil.executeCmdCommand has error",e.getMessage());
            }
        }
        return null;
    }

    public static void main(String[] args) {
        String str = executeCmdCommand("java -version");
        log.info("str:{}",str);
    }
}
