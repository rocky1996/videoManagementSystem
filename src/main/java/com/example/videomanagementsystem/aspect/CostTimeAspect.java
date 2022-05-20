package com.example.videomanagementsystem.aspect;

import com.example.videomanagementsystem.aop.CostTime;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Aspect
@Slf4j
public class CostTimeAspect {

    /**
     * @param proceedingJoinPoint
     * @return
     */
    @Around("@annotation(com.example.videomanagementsystem.aop.CostTime)")
    public Object aroundCostTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        //方法签名
        MethodSignature signature = (MethodSignature) proceedingJoinPoint.getSignature();
        //从签名注解中获取注解内容配置项
        CostTime costTime = signature.getMethod().getAnnotation(CostTime.class);
        //方法中文名称[注解中获取 不填写 为""]
        String methodCName = costTime.interfaceName();
        //拦截class
        Class clazz = proceedingJoinPoint.getTarget().getClass();
        long startTime = System.currentTimeMillis();
        //若开关为 true
        if (costTime.enablePrint()){
            long endTime = System.currentTimeMillis();
            long diffTime = endTime - startTime;
            log.info(clazz.getName()+methodCName+"的耗时是:{},当前时间是:{}",diffTime,new Date());
        }
        return proceedingJoinPoint.proceed(proceedingJoinPoint.getArgs());
    }
}
