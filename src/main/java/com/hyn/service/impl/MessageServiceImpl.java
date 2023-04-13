package com.hyn.service.impl;

import com.hyn.service.MessageService;
import lombok.SneakyThrows;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author hyn
 * @version 1.0.0
 * @description 消息服务实现类
 * @date 2023/4/11
 */
@Service
public class MessageServiceImpl implements MessageService {
    @Resource
    private DefaultMQProducer defaultMQProducer;
    @SneakyThrows
    @Override
    public void sendMessage(String topic, String msg) {
        Message message = new Message(topic,msg.getBytes());
        SendResult send = defaultMQProducer.send(message);
    }
}
