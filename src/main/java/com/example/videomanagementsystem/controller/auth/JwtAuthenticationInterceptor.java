package com.example.videomanagementsystem.controller.auth;

import com.example.videomanagementsystem.enums.FirstMenuEnum;
import com.example.videomanagementsystem.enums.RestEnum;
import com.example.videomanagementsystem.enums.SecondMenuEnum;
import com.example.videomanagementsystem.service.UserService;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

@Slf4j
public class JwtAuthenticationInterceptor implements HandlerInterceptor {

    @Autowired
    private UserService userService;

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object handler) throws Exception {
        //如果不是映射到方法直接通过
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        //检查是否不需要认证
        if (method.isAnnotationPresent(Auth.class)) {
            Auth auth = method.getAnnotation(Auth.class);
            if (!auth.required()) {
                return true;
            }
        }

        String token = httpServletRequest.getSession().getAttribute("token") != null ? httpServletRequest.getSession().getAttribute("token").toString() : null;
        if (token != null) {
            try {
                //权限验证
                //todo 支持接口统一设置权限
                Menu menu = method.getAnnotation(Menu.class);
                if (menu == null) {
                    return true;
                } else {
                    FirstMenuEnum firstMenu = menu.firstMenu();
                    SecondMenuEnum[] secondMenu = menu.secondMenu();
                    UserInfo userInfo = JwtUtils.checkRS256Token(token);
                    Map<Integer, List<Integer>> userRoleMenus =  userService.getUserRoleMenus(userInfo.getUserId());
                    if (userRoleMenus.containsKey(firstMenu.getCode())) {
                        if (secondMenu.length == 0 || userRoleMenus.getOrDefault(firstMenu.getCode(), Lists.newArrayList()).contains(secondMenu[0].getCode())) {
                            log.debug("用户{}通过url: {}权限验证", userInfo.getUserId(), httpServletRequest.getRequestURI());
                            return true;
                        }
                    }
                    httpServletResponse.sendError(RestEnum.FORBIDDEN.getCode(), RestEnum.FORBIDDEN.getMsg());
                }
            } catch (Exception e) {
                httpServletResponse.sendError(RestEnum.FORBIDDEN.getCode(), RestEnum.FORBIDDEN.getMsg() + "-" + e.getMessage());
            }
        } else {
            //未登录
            httpServletResponse.sendError(RestEnum.UN_AUTHORIZED.getCode(), RestEnum.UN_AUTHORIZED.getMsg());
        }
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest,
                           HttpServletResponse httpServletResponse,
                           Object handler,
                           ModelAndView modelAndView) {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest,
                                HttpServletResponse httpServletResponse,
                                Object handler,
                                Exception e) {
    }
}
