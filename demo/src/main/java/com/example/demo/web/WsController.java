package com.example.demo.web;

import com.example.demo.bo.WiselyResponse;
import com.example.demo.entity.WiselyMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * zhshl  2018/9/7
 */
@Controller
public class WsController {
    @Autowired
    private SimpMessagingTemplate mssagingTemplate;
    @MessageMapping("/send") // 当浏览器向服务端发送请求时，通过/welcome这个地址，类似于RequestMapping
    @SendTo("/topic/send") //当服务端有消息时，会对订阅了@SendTo中的路劲的浏览器发送消息
    public WiselyResponse say(WiselyMessage message) throws InterruptedException {
        Thread.sleep(3000);
        WiselyResponse wiselyResponse = new WiselyResponse();
        wiselyResponse.setMessage(message.getName());
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        wiselyResponse.setDate(df.format(new Date()));
        return wiselyResponse;
    }
    @Scheduled(fixedRate = 1000)
    @SendTo("/topic/callback")
    public Object callback() throws Exception{
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        mssagingTemplate.convertAndSend("/topic/callback",df.format(new Date()));
        return  "callback";
    }
    @GetMapping("/")
    public String index(){
        return  "index";
    }
}
