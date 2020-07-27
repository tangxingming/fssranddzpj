package com.youchu.fssranddzpj.modules.balance.controller;

import com.youchu.fssranddzpj.common.utils.R;
import com.youchu.fssranddzpj.modules.balance.entity.BalanceEntity;
import com.youchu.fssranddzpj.modules.balance.service.BalanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/balance")
public class BalanceController {
    @Autowired
    private BalanceService balanceService;
    @PostMapping("/save")
    public R saveData(@RequestParam(value = "data",required = true) String data) {
        balanceService.stringSave2MQ(data);
        return R.ok(data);
    }

    @PostMapping(value = "/saveJson",consumes = "application/json")
    public R saveJsonData(@RequestBody BalanceEntity  balanceEntity) {
        balanceService.jsonSave2MQ(balanceEntity);
        return R.ok();
    }

    @PostMapping(value = "/saveXml",consumes = "application/xml")
    public R saveXmlData(@RequestBody BalanceEntity  balanceEntity) {
        balanceService.xmlSave2MQ(balanceEntity);
        return R.ok();
    }
}
