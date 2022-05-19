package com.example.videomanagementsystem.aop;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CostTime {

    /**
     * 接口名称
     * @return
     */
    String interfaceName() default "";

    /**
     * 接口超时时间,默认100ms
     * @return 超时时间
     */
    int timeout() default 100;

    /**
     * 是否开启日志监控功能默认开
     * @return
     */
    boolean enablePrint() default true;

}
