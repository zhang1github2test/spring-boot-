package com.example.demo.web;

import com.example.demo.Entity.WiselyMessage;
import com.example.demo.Entity.WiselyResponse;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * zhshl  2018/9/8
 */
@Controller
public class WsController {
    @MessageMapping("/welcome")
    @SendTo("/topic/getResponse")
    public WiselyResponse say(WiselyMessage message){
        return new WiselyResponse("welcome, " + message.getName() + "!");
    }
    @GetMapping("/show/{message}")
    @ResponseBody
    public String getString(@PathVariable String message){
        return message;
    }
}
