package com.imooc.security.demo.web.controller;

import com.imooc.security.demo.dto.User;
import com.imooc.security.demo.dto.UserQueryCondition;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * zhshl  2018/9/12
 */
@RestController
public class UserController {
    @RequestMapping(value="/user",method = RequestMethod.GET)
    public List<User> query(UserQueryCondition conditon,
                            @PageableDefault(page=2,size=15,sort="name,desc")Pageable  pageable){
        System.out.println(ReflectionToStringBuilder.
                toString(conditon, ToStringStyle.MULTI_LINE_STYLE));
        System.out.println(pageable.getPageSize());
        System.out.println(pageable.getPageNumber());
        System.out.println(pageable.getSort());
        List<User> users = new ArrayList<>();
        users.add(new User());
        users.add(new User());
        users.add(new User());
        return users;
    }
    @RequestMapping(value = "/user/{id:\\d+}")
    public User getInfo(@PathVariable String id){
        User user = new User();
        user.setUsername("tom");
        return user;
    }
}
