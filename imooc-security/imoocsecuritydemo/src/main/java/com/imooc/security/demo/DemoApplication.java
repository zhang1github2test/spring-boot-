package com.imooc.security.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * zhshl  2018/9/8
 */
@SpringBootApplication()
@RestController
@EnableSwagger2
@ComponentScan({"com.imooc.security.demo","com.imooc.security.borowser"})
public class DemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class);
    }
    @GetMapping("/hello")
    public String hello(){
        return "hello spring security";
    }
}
