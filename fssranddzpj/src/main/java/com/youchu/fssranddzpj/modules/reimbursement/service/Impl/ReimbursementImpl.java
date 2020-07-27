package com.youchu.fssranddzpj.modules.reimbursement.service.Impl;

import com.alibaba.fastjson.JSONObject;
import com.youchu.fssranddzpj.config.Sender;
import com.youchu.fssranddzpj.modules.reimbursement.entity.ReimbursementEntity;
import com.youchu.fssranddzpj.modules.reimbursement.service.ReimbursementService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("reimbursementService")
public class ReimbursementImpl implements ReimbursementService {
    public Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private Sender sender;

    @Override
    public void stringSave2MQ(String data) {
        logger.info(data);
        sender.sendQueue(data);
    }

    @Override
    public void jsonSave2MQ(ReimbursementEntity reimbursementEntity) {
        String data = JSONObject.toJSONString(reimbursementEntity);
        logger.info(data);
        sender.sendQueue(data);
    }

    @Override
    public void xmlSave2MQ(ReimbursementEntity reimbursementEntity) {
        String data = JSONObject.toJSONString(reimbursementEntity);
        logger.info(data);
        sender.sendQueue(data);
    }
}
