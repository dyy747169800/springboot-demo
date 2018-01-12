package com.dyy.activemq.consumer;

import com.dyy.constant.Constant;
import org.apache.log4j.Logger;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.connection.JmsTransactionManager;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.jms.JMSException;
import javax.jms.Session;
import javax.jms.TextMessage;
import java.util.ArrayList;
import java.util.List;

/**
 * 消息消费者
 *
 * @author 段杨宇
 * @create 2017-12-25 14:53
 **/
@Component
@EnableTransactionManagement
public class JMSConsumer {

    private final static Logger logger = Logger.getLogger(JMSConsumer.class);

//    // 使用JmsListener配置消费者监听的队列，其中text是接收到的消息
//    @JmsListener(destination = Constant.TEST_QUEUE)
//    public void receiveQueue(String text) {
//        System.out.println("consumer收到的报文为: "+text);
//    }

    @JmsListener(destination = Constant.TEST_QUEUE, containerFactory = "jmsQueueListener")
    public void receiveQueue(final TextMessage text, Session session)
            throws JMSException {
        try {
            logger.info("info收到的报文为:" + text.getText());
            text.acknowledge();// 使用手动签收模式，需要手动的调用，如果不在catch中调用session.recover()消息只会在重启服务后重发
        } catch (Exception e) {
            session.recover();// 此不可省略 重发信息使用
        }
    }
}
