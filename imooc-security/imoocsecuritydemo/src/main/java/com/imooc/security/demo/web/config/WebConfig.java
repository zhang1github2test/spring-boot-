package com.imooc.security.demo.web.config;

import com.imooc.security.demo.web.filter.TimeFilter;
import com.imooc.security.demo.web.intcepter.TimeInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * zhshl  2018/9/16
 */
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {
    @Autowired
    private TimeInterceptor timeInterceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        super.addInterceptors(registry);
     //   registry.addInterceptor(timeInterceptor);
    }

   // @Bean
    public FilterRegistrationBean timeFilter(){
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        TimeFilter timeFilter = new TimeFilter();
        registrationBean.setFilter(timeFilter);
        List<String> urls = new ArrayList<>();
        urls.add("/*");
        return  registrationBean;
    }
}
