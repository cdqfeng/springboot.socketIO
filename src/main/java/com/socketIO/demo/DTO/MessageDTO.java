package com.socketIO.demo.DTO;

/**
 * 消息实体类
 * @param <T>
 */
public class MessageDTO<T> {

    private String userId;

    private String message;

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
