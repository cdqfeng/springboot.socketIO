package com.socketIO.demo.controller;

import com.socketIO.demo.DTO.MessageDTO;
import com.socketIO.demo.config.SocketIOHandle;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@Api(tags = "消息推送中心")
@RestController
public class IndexController {

    /**
     * 向客户端发送消息
     * @param messageDTO
     */
    @ApiOperation(value = "订阅消息")
    @RequestMapping(value = "/updateMsg", method = RequestMethod.POST)
    public void updateMsg(@RequestBody MessageDTO messageDTO) {
        SocketIOHandle.pushMessage(messageDTO);
    }
}
