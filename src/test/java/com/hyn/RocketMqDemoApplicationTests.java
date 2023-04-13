package com.hyn;

import com.hyn.listen.RocketMQConsumeMsgListenerProcessor;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
class RocketMqDemoApplicationTests {
    @Autowired
    private DefaultMQProducer defaultMQProducer;

    @Autowired
    private RocketMQConsumeMsgListenerProcessor listenerProcessor;

    @Test
    void contextLoads() {

    }
    @Test
    public void send() throws MQClientException, RemotingException, MQBrokerException, InterruptedException{
        String msg = "demo msg test";
        System.out.println("开始发送消息："+msg);
        Message sendMsg = new Message("hyn_topic","*",msg.getBytes());
        //默认3秒超时
        SendResult sendResult = defaultMQProducer.send(sendMsg);
        System.out.println("消息发送响应信息："+sendResult.toString());
    }

}
