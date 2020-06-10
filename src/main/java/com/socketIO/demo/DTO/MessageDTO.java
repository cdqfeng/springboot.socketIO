package com.socketIO.demo.DTO;

import io.swagger.annotations.ApiModelProperty;

/**
 * 消息实体类
 * @param <T>
 */
public class MessageDTO<T> {

    @ApiModelProperty(value = "目标用户id", required = true)
    private String userId;

    @ApiModelProperty(value = "消息名称", required = true)
    private String message;

    @ApiModelProperty(value = "消息内容")
    private T data;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public MessageDTO(String userId, String message, T data) {
        this.userId = userId;
        this.message = message;
        this.data = data;
    }

    @Override
    public String toString() {
        return "MessageDTO{" +
                "userId='" + userId + '\'' +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
