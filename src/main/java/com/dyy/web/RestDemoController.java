package com.dyy.web;

import com.dyy.activemq.producer.JMSProducer;
import com.dyy.constant.Constant;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


/**
 * 控制器
 *
 * @author 段杨宇
 * @create 2017-12-26 15:17
 **/
@RestController
public class RestDemoController {

    @Autowired
    private JMSProducer jmsProducer;

    @Resource(name = Constant.TEST_QUEUE)
    private ActiveMQQueue testQueue;


    @RequestMapping("/")
    public String index(){
        return "success";
    }

    @RequestMapping("/sendMsg")
    public String sendMsg(String message){
        for (int i = 0; i<100;i++){
            jmsProducer.sendMessage(testQueue,message + i);
        }
        return "success send : " + message;
    }
}
