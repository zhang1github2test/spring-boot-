package com.imooc.security.demo.web.controller;

import com.imooc.security.demo.dto.User;
import com.imooc.security.demo.dto.UserQueryCondition;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    @RequestMapping(value = "/user/{id:\\d+}",method = RequestMethod.GET)
    public User getInfo(@PathVariable String id){
        User user = new User();
        user.setUsername("tom");
        return user;
    }

    @PostMapping("/user")
    public User create(@Valid @RequestBody User user,BindingResult errors){
        if(errors.hasErrors()){
            errors.getAllErrors().stream().forEach(error -> System.out.println(error.getDefaultMessage()));
        }
        System.out.println(user.getId());
        System.out.println(user.getBirthday());
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
        user.setId(1);
        return user;
    }

    @PutMapping("/user/{id:\\d+}")
    public User udpate(@Valid @RequestBody User user,BindingResult errors){
        if(errors.hasErrors()){
            errors.getAllErrors().stream().forEach(error -> System.out.println(error.getDefaultMessage()));
        }
        System.out.println(user.getId());
        System.out.println(user.getBirthday());
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
        user.setId(1);
        return user;
    }

}
