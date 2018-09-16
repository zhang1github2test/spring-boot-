package com.imooc.security.demo.dto;

import com.imooc.security.demo.validator.MyConstraint;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.util.Date;

/**
 * zhshl  2018/9/12
 */
public class User {
    private Integer id;
    @Past(message = "生日必须是过去时间")
    private Date birthday;
    @MyConstraint(message = "用户名必须存在")
    private String username;
    @NotBlank(message = "密码不能为空")
    private String  password;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
