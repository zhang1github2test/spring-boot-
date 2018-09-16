package com.imooc.security.demo.service.impl;

import com.imooc.security.demo.service.IHelloService;
import org.springframework.stereotype.Service;

/**
 * zhshl  2018/9/16
 */
@Service
public class HelloServiceImpl  implements IHelloService {
    @Override
    public String hello() {
        System.out.println("喝了咯！");
        return null;
    }
}
