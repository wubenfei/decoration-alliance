package com.ours.userapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 * @ClassName: WebSocketConfig
 * @Description: websocket的bean的配置
 * @author: WLJ
 * @date ：Created in 2019/12/30 11:58
 */
@Configuration
public class WebSocketConfig {
    //获取一个服务器的bean
    @Bean
    public ServerEndpointExporter serverEndpointExporter(){
        return new ServerEndpointExporter();
    }
}
