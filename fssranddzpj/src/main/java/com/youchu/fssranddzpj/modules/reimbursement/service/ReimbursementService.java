package com.youchu.fssranddzpj.modules.reimbursement.service;

import com.youchu.fssranddzpj.modules.reimbursement.entity.ReimbursementEntity;

public interface ReimbursementService {
    void stringSave2MQ(String data);
    void jsonSave2MQ(ReimbursementEntity reimbursementEntity);
    void xmlSave2MQ(ReimbursementEntity reimbursementEntity);
}
