package com.youchu.fssranddzpj.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Time;
import java.util.Date;
import java.util.Timer;

public class BatchDeduInfoRegister implements Serializable {
    private static final long serialVersionUID = 1L;
    private int cantonId;               //区划
    private int unitId;                 //单位
    private String bankAffirm;          //交易流水号
    private String bankStation;         //银行网点
    private Date accountDate;           //收款日期
    private Time accountTime;           //收款时间
    private String accountCode;         //收款账号
    private String accountName;         //收款账户
    private String payer;               //付款人
    private String payerAccountCode;    //付款账号
    private String payerAccountName;    //付款账户
    private int payerTypeId;            //缴费类型
    private BigDecimal fund;            //金额
    private String postScript;          //附言

    public BatchDeduInfoRegister() {
    }

    public BatchDeduInfoRegister(int cantonId, int unitId, String bankAffirm, String bankStation, Date accountDate, Time accountTime, String accountCode, String accountName, String payer, String payerAccountCode, String payerAccountName, int payerTypeId, BigDecimal fund, String postScript) {
        this.cantonId = cantonId;
        this.unitId = unitId;
        this.bankAffirm = bankAffirm;
        this.bankStation = bankStation;
        this.accountDate = accountDate;
        this.accountTime = accountTime;
        this.accountCode = accountCode;
        this.accountName = accountName;
        this.payer = payer;
        this.payerAccountCode = payerAccountCode;
        this.payerAccountName = payerAccountName;
        this.payerTypeId = payerTypeId;
        this.fund = fund;
        this.postScript = postScript;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getCantonId() {
        return cantonId;
    }

    public void setCantonId(int cantonId) {
        this.cantonId = cantonId;
    }

    public int getUnitId() {
        return unitId;
    }

    public void setUnitId(int unitId) {
        this.unitId = unitId;
    }

    public String getBankAffirm() {
        return bankAffirm;
    }

    public void setBankAffirm(String bankAffirm) {
        this.bankAffirm = bankAffirm;
    }

    public String getBankStation() {
        return bankStation;
    }

    public void setBankStation(String bankStation) {
        this.bankStation = bankStation;
    }

    public Date getAccountDate() {
        return accountDate;
    }

    public void setAccountDate(Date accountDate) {
        this.accountDate = accountDate;
    }

    public Time getAccountTime() {
        return accountTime;
    }

    public void setAccountTime(Time accountTime) {
        this.accountTime = accountTime;
    }

    public String getAccountCode() {
        return accountCode;
    }

    public void setAccountCode(String accountCode) {
        this.accountCode = accountCode;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getPayer() {
        return payer;
    }

    public void setPayer(String payer) {
        this.payer = payer;
    }

    public String getPayerAccountCode() {
        return payerAccountCode;
    }

    public void setPayerAccountCode(String payerAccountCode) {
        this.payerAccountCode = payerAccountCode;
    }

    public String getPayerAccountName() {
        return payerAccountName;
    }

    public void setPayerAccountName(String payerAccountName) {
        this.payerAccountName = payerAccountName;
    }

    public int getPayerTypeId() {
        return payerTypeId;
    }

    public void setPayerTypeId(int payerTypeId) {
        this.payerTypeId = payerTypeId;
    }

    public BigDecimal getFund() {
        return fund;
    }

    public void setFund(BigDecimal fund) {
        this.fund = fund;
    }

    public String getPostScript() {
        return postScript;
    }

    public void setPostScript(String postScript) {
        this.postScript = postScript;
    }

    @Override
    public String toString() {
        return "BatchDeduInfoRegister{" +
                "cantonId=" + cantonId +
                ", unitId=" + unitId +
                ", bankAffirm='" + bankAffirm + '\'' +
                ", bankStation='" + bankStation + '\'' +
                ", accountDate=" + accountDate +
                ", accountTime=" + accountTime +
                ", accountCode='" + accountCode + '\'' +
                ", accountName='" + accountName + '\'' +
                ", payer='" + payer + '\'' +
                ", payerAccountCode='" + payerAccountCode + '\'' +
                ", payerAccountName='" + payerAccountName + '\'' +
                ", payerTypeId=" + payerTypeId +
                ", fund=" + fund +
                ", postScript='" + postScript + '\'' +
                '}';
    }
}
