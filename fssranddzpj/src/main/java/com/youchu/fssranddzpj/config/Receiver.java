package com.youchu.fssranddzpj.config;


import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Random;

@Slf4j
@Component
public class Receiver {
    int x = 1;
    int y = 1;
    //目标队列监听
    @RabbitListener(queues = RabbitMQConfig.QUEUE)
    public void receiverDirectQueue(String msg, Channel channel, Message message) throws IOException {
        Boolean ack = true;
        Exception exception = null;
        try{
            if (new Random().nextInt(10) < 0){ //目前虚拟的判定条件
                throw new RuntimeException("dead letter exception");
            }
        }catch (Exception e){
            ack = false;
            exception = e;
        }
        if (!ack) {
            log.error("消息消费发生异常，error msg:{}", exception.getMessage(), exception);
            log.info("这是【Consumer】拒绝的第"+x+"条信息:[{}]，该消息将会被转发到死信交换器中", msg);
            x++;
            channel.basicNack(message.getMessageProperties().getDeliveryTag(), false, false);
        } else {
            String routingKey = message.getMessageProperties().getReceivedRoutingKey();
            log.info("processQueueBcEvent " + Thread.currentThread().getName() + " 接收到来自队列" + RabbitMQConfig.QUEUE + "的消息：" + msg);
            log.info("processQueueBcEvent message routing key: " + routingKey);
            log.info("这是【Consumer成功监听到的第"+y+"条消息】" + msg);
            y++;
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
        }
    }

    int i = 1;
    //死信队列监听
    @RabbitListener(queues = RabbitMQConfig.DEAD_LETTERS_QUEUE_NAME)
    public void receiverDirectQueue1(String msg, Channel channel, Message message) throws IOException {

        log.info("【这是监听到的第" + i + "条死信队列的消息】" + msg.toString());
        i++;
       channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
    }
    int z = 1;
    //备份队列监听
    @RabbitListener(queues = RabbitMQConfig.MESSAGE_BAK_QUEUE_NAME)
    public void receiverDirectQueue2(String msg, Channel channel, Message message) throws IOException {

        log.info("【这是监听到的第" + z + "条备份队列的消息】" + msg.toString());
        z++;
        channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
    }
}
