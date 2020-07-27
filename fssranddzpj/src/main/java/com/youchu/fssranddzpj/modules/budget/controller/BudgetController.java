package com.youchu.fssranddzpj.modules.budget.controller;

import com.alibaba.fastjson.JSONObject;
import com.youchu.fssranddzpj.common.utils.R;
import com.youchu.fssranddzpj.modules.budget.entity.BudgetEntity;
import com.youchu.fssranddzpj.modules.budget.service.BudgetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/budget")
public class BudgetController {

    @Autowired
    private BudgetService budgetService;

    @PostMapping("/save")
    public R saveData(@RequestParam(value = "data",required = true) String data) {
        budgetService.stringSave2MQ(data);
        return R.ok(data);
    }

    @PostMapping(value = "/saveJson",consumes = "application/json")
    public R saveJsonData(@RequestBody BudgetEntity budgetEntity) {
        budgetService.jsonSave2MQ(budgetEntity);
        return R.ok();
    }

    @PostMapping(value = "/saveXml",consumes = "application/xml")
    public R saveXmlData(@RequestBody BudgetEntity budgetEntity) {
        budgetService.xmlSave2MQ(budgetEntity);
        return R.ok();
    }
}
