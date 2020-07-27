package com.youchu.fssranddzpj.modules.reimbursement.controller;

import com.youchu.fssranddzpj.common.utils.R;
import com.youchu.fssranddzpj.modules.reimbursement.entity.ReimbursementEntity;
import com.youchu.fssranddzpj.modules.reimbursement.service.ReimbursementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reimbursement")
public class ReimbursementController {
    @Autowired
    private ReimbursementService reimbursementService;
    @PostMapping("/save")
    public R saveData(@RequestParam(value = "data", required = true) String data) {
        reimbursementService.stringSave2MQ(data);
        return R.ok(data);
    }
    @PostMapping(value = "/saveJson",consumes = "application/json")
    public R saveJsonData(@RequestBody ReimbursementEntity reimbursementEntity){
        reimbursementService.jsonSave2MQ(reimbursementEntity);
        return R.ok();
    }
    @PostMapping(value = "/saveXml",consumes = "application/xml")
    public R saveXmlData(@RequestBody ReimbursementEntity reimbursementEntity){
        reimbursementService.xmlSave2MQ(reimbursementEntity);
        return R.ok();
    }
}
