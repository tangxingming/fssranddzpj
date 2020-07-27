package com.youchu.fssranddzpj.modules.budget.entity;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Data;

import java.io.Serializable;

/**
 *  预算实体类
 */
@Data
@JacksonXmlRootElement(localName ="MESSAGE")
public class BudgetEntity implements Serializable {

    /**
     * 预算单位
     */
    @JacksonXmlProperty(localName = "BUDGET_NAME")
    private String name;

    /**
     * 预算科目
     */
    @JacksonXmlProperty(localName = "BUDGET_SUBJECT")
    private String subject;

    /**
     * 金额
     */
    @JacksonXmlProperty(localName = "BUDGET_MONEY")
    private String money;

    /**
     * 创建时间
     */
    @JacksonXmlProperty(localName = "BUDGET_CREATE_TIME")
    private String createTime;
}
