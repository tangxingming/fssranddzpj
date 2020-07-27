package com.youchu.fssranddzpj.modules.reimbursement.entity;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Data;

import java.io.Serializable;

/**
 * 报销信息实体类
 */
@Data
@JacksonXmlRootElement(localName = "MESSAGE")
public class ReimbursementEntity implements Serializable {
    /**
     * 报销申请ID
     */
    @JacksonXmlProperty(localName = "REIMBURSE_APPLYID")
    private String applyReimId;
    /**
     * 申请票据号码
     */
    @JacksonXmlProperty(localName = "REIMBURSE_EINVOICENUM")
    private String einvoiceNumber;
    /**
     * 报销申请人
     */
    @JacksonXmlProperty(localName = "REIMBURSE_APPLICANT")
    private String applicant;
    /**
     * 审批人
     */
    @JacksonXmlProperty(localName = "REIMBURSE_APPROVER")
    private String approver;
    /**
     * 金额
     */
    @JacksonXmlProperty(localName = "REIMBURSE_AMOUNT")
    private String amount;
    /**
     * 备注
     */
    @JacksonXmlProperty(localName = "REIMBURSE_REMARK")
    private String remark;
    /**
     * 缴款码
     */
    @JacksonXmlProperty(localName = "REIMBURSE_BILLNUM")
    private String billNum;
    /**
     * 申请日期
     */
    @JacksonXmlProperty(localName = "REIMBURSE_APPLYDATE")
    private String applyDate;
    /**
     * 报销状态
     */
    @JacksonXmlProperty(localName = "REIMBURSE_APPLYSTATUS")
    private String applyStatus;
}
