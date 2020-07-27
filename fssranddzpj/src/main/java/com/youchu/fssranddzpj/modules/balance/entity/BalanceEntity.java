package com.youchu.fssranddzpj.modules.balance.entity;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Data;

import java.io.Serializable;
/**
 *  余额实体类
 */
@Data
@JacksonXmlRootElement(localName = "MESSAGE")
public class BalanceEntity implements Serializable {
    /**
     *  记账日期
     */
    @JacksonXmlProperty(localName = "BALANCE_DATE")
    private String BankDate;
    /**
     *  银行
     */
    @JacksonXmlProperty(localName = "BALANCE_BANK")
    private String Bank;
    /**
     *  银行账户
     */
    @JacksonXmlProperty(localName = "BALANCE_ID")
    private String BankId;
    /**
     *  账户余额
     */
    @JacksonXmlProperty(localName = "BALANCE_AMOUNT")
    private String TotalAmount;
}
