package com.imooc.security.demo.web.intcepter;

import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * zhshl  2018/9/16
 */
@Component
public class TimeInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("perHandle");
        request.setAttribute("start",System.currentTimeMillis());
        System.out.println(((HandlerMethod)handler).getMethod().getName());
        System.out.println(((HandlerMethod)handler).getBean().getClass().getName());
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle");
        Long start =(Long) request.getAttribute("start");
        System.out.println("方法耗时:"+ (System.currentTimeMillis()-start));
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("afterCompletion");
        Long start = (Long) request.getAttribute("start");
        System.out.println("time interceptor 耗时:"+ (System.currentTimeMillis()-start));
        System.out.println("ex is "+ex);
    }
}
