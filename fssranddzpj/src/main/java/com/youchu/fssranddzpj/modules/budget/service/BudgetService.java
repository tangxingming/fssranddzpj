package com.youchu.fssranddzpj.modules.budget.service;

import com.youchu.fssranddzpj.modules.budget.entity.BudgetEntity;

public interface BudgetService {
    void stringSave2MQ(String data);
    void jsonSave2MQ(BudgetEntity budgetEntity);
    void xmlSave2MQ(BudgetEntity budgetEntity);
}
