package com.youchu.fssranddzpj.modules.balance.service.Impl;

import com.alibaba.fastjson.JSONObject;
import com.youchu.fssranddzpj.config.Sender;
import com.youchu.fssranddzpj.modules.balance.entity.BalanceEntity;
import com.youchu.fssranddzpj.modules.balance.service.BalanceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("balanceService")
public class BalanceServiceImpl implements BalanceService {
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private Sender sender;
    @Override
    public void stringSave2MQ(String data) {
    logger.info(data);
    sender.sendQueue(data);
    }

    @Override
    public void jsonSave2MQ(BalanceEntity balanceEntity) {
        String data = JSONObject.toJSONString(balanceEntity);
        logger.info(data);
        sender.sendQueue(data);
    }

    @Override
    public void xmlSave2MQ(BalanceEntity balanceEntity) {
        String data = JSONObject.toJSONString(balanceEntity);
        logger.info(data);
        sender.sendQueue(data);
    }
}
