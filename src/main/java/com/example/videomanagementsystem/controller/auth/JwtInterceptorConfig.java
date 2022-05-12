package com.example.videomanagementsystem.controller.auth;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class JwtInterceptorConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //默认拦截所有路径
        registry.addInterceptor(authenticationInterceptor()).addPathPatterns("/videoSystem/**");
    }

    @Bean
    public HandlerInterceptor authenticationInterceptor() {
        return new JwtAuthenticationInterceptor();
    }
}
