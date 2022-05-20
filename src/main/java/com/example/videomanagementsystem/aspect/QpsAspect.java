package com.example.videomanagementsystem.aspect;

import com.example.videomanagementsystem.util.QpsStatistics.HandlerQpsNodeExpiredCache;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
@Slf4j
public class QpsAspect {

    private HandlerQpsNodeExpiredCache handlerQpsNodeExpiredCache = new HandlerQpsNodeExpiredCache();

    @Pointcut("@annotation(org.springframework.web.bind.annotation.GetMapping)")
    public void getMapping() {}
    @Pointcut("@annotation(org.springframework.web.bind.annotation.PostMapping)")
    public void postMapping() {}

    @Before("getMapping() || postMapping()")
    public void beforeQpsAspect() throws Throwable{
        ServletRequestAttributes servletRequestAttributes =(ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest httpServletRequest = servletRequestAttributes.getRequest();
        String requestPath = httpServletRequest.getRequestURI();
        String cacheKey= requestPath.substring(requestPath.lastIndexOf("/") + 1, requestPath.length());
        //设置过期时间为1000ms
        handlerQpsNodeExpiredCache.setQpsNode(cacheKey, 300000L);
        return;
    }
}
