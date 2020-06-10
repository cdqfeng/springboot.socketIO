package com.socketIO.demo.controller;

import com.socketIO.demo.DTO.MessageDTO;
import com.socketIO.demo.config.SocketIOHandle;
import org.springframework.web.bind.annotation.*;

@RestController
public class IndexController {

    /**
     * 向客户端发送消息
     * @param messageDTO
     */
    @RequestMapping(value = "/updateMsg", method = RequestMethod.POST)
    public void updateMsg(@RequestBody MessageDTO messageDTO) {
        SocketIOHandle.pushMessage(messageDTO);
    }
}
