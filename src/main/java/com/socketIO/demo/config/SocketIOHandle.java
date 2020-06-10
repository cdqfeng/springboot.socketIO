package com.socketIO.demo.config;

import com.alibaba.fastjson.JSONObject;
import com.corundumstudio.socketio.AckRequest;
import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.annotation.OnConnect;
import com.corundumstudio.socketio.annotation.OnDisconnect;
import com.corundumstudio.socketio.annotation.OnEvent;
import com.socketIO.demo.DTO.MessageDTO;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * socketIO连接初始化类
 */
@Component
public class SocketIOHandle {

    private static Map<String, SocketIOClient> clientMap = new ConcurrentHashMap<>();

    //客户端连上socket服务器时执行此事件
    @OnConnect
    public void onConnect(SocketIOClient client) {
        String userId = client.getHandshakeData().getSingleUrlParam("userId");
        if (userId != null) {
            clientMap.put(userId, client);
        }
    }

    //客户端断开socket服务器时执行此事件
    @OnDisconnect
    public void onDisconnect(SocketIOClient client) {
        String userId = client.getHandshakeData().getSingleUrlParam("userId");
        if (userId != null) {
            clientMap.remove(userId);
            client.disconnect();
        }
    }

    // 服务器向客户端发送事件
    public static void pushMessage(MessageDTO messageDTO) {
        String userId = messageDTO.getUserId();
        if (!StringUtils.isEmpty(userId)) {
            SocketIOClient client = clientMap.get(userId);
            if (client != null) {
                client.sendEvent(messageDTO.getMessage(), messageDTO);
            }
        }
    }

    // 监听消息
    @OnEvent(value = "toServer")
    public void onEvent(SocketIOClient client, AckRequest request, JSONObject data) {
        String toUserId = String.valueOf(data.get("toUserId"));
        String message = String.valueOf(data.get("message"));
        MessageDTO messageDTO = new MessageDTO<String>(toUserId, "updateMsg", message);
        pushMessage(messageDTO);
    }
}
