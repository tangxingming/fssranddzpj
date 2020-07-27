package com.youchu.fssranddzpj.modules.balance.service;

import com.youchu.fssranddzpj.modules.balance.entity.BalanceEntity;

public interface BalanceService {
    void stringSave2MQ(String data);
    void jsonSave2MQ(BalanceEntity balanceEntity);
    void xmlSave2MQ(BalanceEntity balanceEntity);
}
