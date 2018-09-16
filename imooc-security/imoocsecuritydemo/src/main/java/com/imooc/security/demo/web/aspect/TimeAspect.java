package com.imooc.security.demo.web.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import java.util.Arrays;

/**
 * zhshl  2018/9/16
 */
@Aspect
@Component
public class TimeAspect {
    @Around("execution(* com.imooc.security.demo.web.controller.*.*(..))")
    public Object handleControllerMethod(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("time aspect start");
        Object[] args = pjp.getArgs();
        Arrays.stream(args).forEach(arg ->{
            System.out.println("arg is:" + arg);
        });
        long start = System.currentTimeMillis();
        Object object =   pjp.proceed();
        System.out.println("time aspect end");
        System.out.println("耗时:" + (System.currentTimeMillis()-start));
        return  object;
    }
}
