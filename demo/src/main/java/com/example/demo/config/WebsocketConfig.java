package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

/**
 * zhshl  2018/9/7
 */
@Configuration
@EnableWebSocketMessageBroker  //开始使用stomp协议来传输基于代理的消息，
//这时控制器支持使用@MessageMapping,就像使用@RequestMapping一样
public class WebsocketConfig extends AbstractWebSocketMessageBrokerConfigurer {
    /**
     * Register STOMP endpoints mapping each to a specific URL and (optionally)
     * enabling and configuring SockJS fallback options.
     *
     * @param registry
     */
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {//注册STOMP协议的节点，并映射的指定的URL
        registry.addEndpoint("/my-websocket").withSockJS();//注册STOMP的endPoint，并指定使用SockJs协议
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {//配置消息代理
        registry.enableSimpleBroker("/topic");//广播式应配置一个/topic消息代理
        registry.setApplicationDestinationPrefixes("/app");
    }
}
