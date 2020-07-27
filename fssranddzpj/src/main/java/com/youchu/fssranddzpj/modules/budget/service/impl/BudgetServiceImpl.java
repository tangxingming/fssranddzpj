package com.youchu.fssranddzpj.modules.budget.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.youchu.fssranddzpj.config.RabbitMQConfig;
import com.youchu.fssranddzpj.modules.budget.entity.BudgetEntity;
import com.youchu.fssranddzpj.modules.budget.service.BudgetService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("budgetService")
public class BudgetServiceImpl implements BudgetService {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Override
    public void stringSave2MQ(String data) {
        logger.info(data);
        rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE, "topic.user.001", data);
    }

    @Override
    public void jsonSave2MQ(BudgetEntity budgetEntity) {
        String data = JSONObject.toJSONString(budgetEntity);
        logger.info(data);
        rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE, "topic.user.002", data);
    }

    @Override
    public void xmlSave2MQ(BudgetEntity budgetEntity) {
        String data = JSONObject.toJSONString(budgetEntity);
        logger.info(data);
        rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE, "topic.user.002", data);
    }


}
