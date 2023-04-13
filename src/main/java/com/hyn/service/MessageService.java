package com.hyn.service;

/**
 * @author hyn
 * @version 1.0.0
 * @description 消息服务
 * @date 2023/4/11
 */
public interface MessageService {
    public void sendMessage(String topic,String msg);
}
