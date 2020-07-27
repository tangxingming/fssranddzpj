package com.youchu.fssranddzpj.config;


import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class RabbitMQConfig {
    //目标队列
    public static final String QUEUE = "topic_queue";
    //目标消息交换机
    public  static final String EXCHANGE = "topic_exchange";
    //ROUTING KEY
    public static final String ROUTING_KEY = "topic.user";
    //NO_ROUTING_KEY
    public static final String NO_ROUTING_KEY = "topic.message";

    //没有被正确路由的消息
    public static final String MESSAGE_BAK_QUEUE_NAME = "un_routing_queue";
    //没有被正确路由的消息  备份交换机
    public static final String MESSAGE_BAK_EXCHANGE_NAME = "un_routing_exchange";

    //死信队列
    public static final String DEAD_LETTERS_QUEUE_NAME = "dead_letters_queue";
    //死信交换机
    public static final String DEAD_LETTERS_EXCHANGE_NAME = "dead_letters_exchange";

    /**
     * 声明备份队列、备份交换机、绑定队列到备份交换机
     * 建议使用FanoutExchange广播式交换机
     */
    @Bean
    public Queue msgBakQueue() {
        return new Queue(MESSAGE_BAK_QUEUE_NAME);
    }

    @Bean
    public FanoutExchange msgBakExchange() {
        return new FanoutExchange(MESSAGE_BAK_EXCHANGE_NAME);
    }

    @Bean
    public Binding msgBakBinding() {
        return BindingBuilder.bind(msgBakQueue()).to(msgBakExchange());
    }
    /**
     * 声明死信队列、死信交换机、绑定队列到死信交换机
     * 建议使用FanoutExchange广播式交换机
     */
    @Bean
    public Queue deadLettersQueue() {
        return new Queue(DEAD_LETTERS_QUEUE_NAME);
    }

    @Bean
    public FanoutExchange deadLettersExchange() {
        return new FanoutExchange(DEAD_LETTERS_EXCHANGE_NAME);
    }

    @Bean
    public Binding deadLettersBinding() {
        return BindingBuilder.bind(deadLettersQueue()).to(deadLettersExchange());
    }
    /**
     * 声明普通队列，并指定相应的备份交换机、死信交换机
     */
    @Bean
    public Queue topicQueue() {
        Map<String,Object> arg = new HashMap<String,Object>();
        //指定死信发送的Exchange
        arg.put("x-dead-letter-exchange",DEAD_LETTERS_EXCHANGE_NAME);
        // 第一个参数是队列名字， 第二个参数是指是否持久化
        return new Queue(QUEUE, true, false, false, arg);
    }
    @Bean
    public TopicExchange topicExchange(){
        Map<String,Object> arg = new HashMap<String,Object>();
        //声明备份交换机
        arg.put("alternate-exchange", MESSAGE_BAK_EXCHANGE_NAME);
        return new TopicExchange(EXCHANGE,true, false, arg);
    }
    @Bean
    public Binding binding(){
        return BindingBuilder.bind(topicQueue()).to(topicExchange()).with("topic.user.#");
    }
}
