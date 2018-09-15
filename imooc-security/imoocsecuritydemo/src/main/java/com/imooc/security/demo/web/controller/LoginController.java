package com.imooc.security.demo.web.controller;

import com.imooc.security.demo.img.VerifiCode;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * zhshl  2018/9/14
 */
@RequestMapping
@Controller
public class LoginController {

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping("/SessionTest/VerificodeServlet")
    public void getimage(HttpServletRequest request, HttpServletResponse response) throws IOException {
        VerifiCode v = new VerifiCode();     //用我们的验证码类，生成验证码类对象
        BufferedImage image = v.getImage();  //获取验证码
        request.getSession().setAttribute("text", v.getText()); //将验证码的文本存在session中
        v.output(image, response.getOutputStream());//
    }

    @GetMapping("/login")
    @ResponseBody
    public Boolean login(HttpServletRequest request, String username, String password, String code) {
        String preCode = (String) request.getSession().getAttribute("text");
        if(code.equalsIgnoreCase(preCode)){
            return true;
        }
        return false;
    }
}
