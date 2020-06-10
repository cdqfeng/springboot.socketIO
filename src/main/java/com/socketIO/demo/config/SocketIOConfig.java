package com.socketIO.demo.config;

import com.corundumstudio.socketio.SocketConfig;
import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.annotation.SpringAnnotationScanner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * socketIO配置类
 */
@Configuration
public class SocketIOConfig {

    @Bean
    public SocketIOServer socketIOServer() {
        SocketConfig socketConfig = new SocketConfig();
        socketConfig.setTcpNoDelay(true);
        socketConfig.setSoLinger(0);
        com.corundumstudio.socketio.Configuration config = new com.corundumstudio.socketio.Configuration();
        config.setSocketConfig(socketConfig);
        config.setHostname("localhost");
        config.setPort(8091);
        config.setBossThreads(100);
        config.setWorkerThreads(100);
        config.setAllowCustomRequests(true);
        config.setUpgradeTimeout(1000000);
        config.setPingTimeout(6000000);
        config.setPingInterval(25000);
        return new SocketIOServer(config);
    }

    @Bean
    public SpringAnnotationScanner springAnnotationScanner() {
        return new SpringAnnotationScanner(socketIOServer());
    }

}
