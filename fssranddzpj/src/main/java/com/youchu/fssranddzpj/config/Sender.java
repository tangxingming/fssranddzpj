package com.youchu.fssranddzpj.config;


import lombok.extern.slf4j.Slf4j;


import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.UUID;

@Slf4j
@Component
public class Sender implements RabbitTemplate.ConfirmCallback, RabbitTemplate.ReturnCallback {
    // 注入rabbitTemplate
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @PostConstruct
    public void init() {
        rabbitTemplate.setConfirmCallback(this);
        rabbitTemplate.setReturnCallback(this);
    }

    @Override
    public void confirm(CorrelationData correlationData, boolean ack, String cause) {
        if (ack) {
            log.info("confirm 消息发送成功:" + correlationData);
        } else {
            log.info("confirm 消息发送失败:" + correlationData + ":" + cause);
        }
    }

    @Override
    public void returnedMessage(Message message, int replyCode, String replyText, String exchange, String routingKey) {
        log.warn("returnedMessage 消息发送失败: " + message.getMessageProperties().getCorrelationId() + " replyCode=" + replyCode + " replyText=" + replyText + " exchange=" + exchange + " routingKey=" + routingKey);
    }

    public void sendQueue(String str) {
        log.info(str);
        CorrelationData correlationId = new CorrelationData(UUID.randomUUID().toString());


        log.info("【发送可被路由到的消息】" + str);
        // 第一个参数是指要发送到哪个队列里面， 第二个参数是指要发送的内容
        rabbitTemplate.convertSendAndReceive(RabbitMQConfig.EXCHANGE, RabbitMQConfig.ROUTING_KEY, str, correlationId);
        //log.info("【发送了一条能够正确被路由的消息】,exchange:[{}],routingKey:[{}],message:[{}]", RabbitMQConfig.EXCHANGE, RabbitMQConfig.ROUTING_KEY, pay);
        //log.info("sendAndReceive 结束发送消息，消费者响应 : " + response + " 消息处理完成");

        //不可以正确被路由的消息
        //log.info("【发送1条不可被路由到的消息】" + str);
        //Object response1 = rabbitTemplate.convertSendAndReceive(RabbitMQConfig.EXCHANGE, "topic.message", str, correlationId);
        //log.info("【发送了一条不能正确被路由的消息】,exchange:[{}],routingKey:[{}],message:[{}]", RabbitMQConfig.EXCHANGE, RabbitMQConfig.NO_ROUTING_KEY, pay);
        //log.info("sendAndReceive 结束发送消息，消费者响应 : " + response1 + " 消息处理完成");

    }


}
