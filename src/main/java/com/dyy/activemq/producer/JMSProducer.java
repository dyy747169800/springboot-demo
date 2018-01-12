package com.dyy.activemq.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import javax.jms.Destination;

/**
 * 消息生产者
 *
 * @author 段杨宇
 * @create 2017-12-25 14:44
 **/
@Service
public class JMSProducer {
    @Autowired
    private JmsTemplate jmsTemplate; //JmsMessagingTemplate
    // 发送消息，destination是发送到的队列，message是待发送的消息
    public void sendMessage(Destination destination, final String message){
        System.out.println(jmsTemplate.getDeliveryMode());
        jmsTemplate.convertAndSend(destination, message);
    }
}
