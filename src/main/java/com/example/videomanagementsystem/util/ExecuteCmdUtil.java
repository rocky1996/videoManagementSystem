package com.example.videomanagementsystem.util;

import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.omg.CORBA.INTERNAL;

import javax.print.DocFlavor;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class ExecuteCmdUtil {
    public static Integer executeCmdCommand(String cmd) throws Exception{
        try {
            List<String> commands = Lists.newArrayList();
            commands.add("cmd.exe");
            commands.add("/c");
            commands.add(cmd);
            ProcessBuilder builder = new ProcessBuilder(commands);
            Process process = builder.start();
            return process.waitFor();  // status为0，成功
        }catch (IOException e) {
            log.error("ExecuteCmdUtil.executeCmdCommand has error",e.getMessage());
            return null;
        }
    }

    public static void main(String[] args) throws Exception{
        Integer result = executeCmdCommand("java -version");
        log.info("result:{}",result);
    }
}
