package com.youchu.fssranddzpj.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TrafficCtrlPayInfoRegister implements Serializable {
    private static final long serialVersionUID = 1L;
    private String billNum;             //处罚决定书号
    private String occurName;           //当事人
    private BigDecimal funds;           //金额
    private BigDecimal lateFee;         //滞纳金
    private int bankId;                 //银行
    private int isNoHere;               //是否异地
    private int isSpecialBill;          //是否开票
    private String specialBillNum;      //票据号
    private LocalDateTime payBankDt;    //收款时间
    private String bankAffirm;          //交易流水号
    private String bankStation;         //收款网点
    private int payWayId;               //缴款方式

    public TrafficCtrlPayInfoRegister() {
    }

    public TrafficCtrlPayInfoRegister(String billNum, String occurName, BigDecimal funds, BigDecimal lateFee, int bankId, int isNoHere, int isSpecialBill, String specialBillNum, LocalDateTime payBankDt, String bankAffirm, String bankStation, int payWayId) {
        this.billNum = billNum;
        this.occurName = occurName;
        this.funds = funds;
        this.lateFee = lateFee;
        this.bankId = bankId;
        this.isNoHere = isNoHere;
        this.isSpecialBill = isSpecialBill;
        this.specialBillNum = specialBillNum;
        this.payBankDt = payBankDt;
        this.bankAffirm = bankAffirm;
        this.bankStation = bankStation;
        this.payWayId = payWayId;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getBillNum() {
        return billNum;
    }

    public void setBillNum(String billNum) {
        this.billNum = billNum;
    }

    public String getOccurName() {
        return occurName;
    }

    public void setOccurName(String occurName) {
        this.occurName = occurName;
    }

    public BigDecimal getFunds() {
        return funds;
    }

    public void setFunds(BigDecimal funds) {
        this.funds = funds;
    }

    public BigDecimal getLateFee() {
        return lateFee;
    }

    public void setLateFee(BigDecimal lateFee) {
        this.lateFee = lateFee;
    }

    public int getBankId() {
        return bankId;
    }

    public void setBankId(int bankId) {
        this.bankId = bankId;
    }

    public int getIsNoHere() {
        return isNoHere;
    }

    public void setIsNoHere(int isNoHere) {
        this.isNoHere = isNoHere;
    }

    public int getIsSpecialBill() {
        return isSpecialBill;
    }

    public void setIsSpecialBill(int isSpecialBill) {
        this.isSpecialBill = isSpecialBill;
    }

    public String getSpecialBillNum() {
        return specialBillNum;
    }

    public void setSpecialBillNum(String specialBillNum) {
        this.specialBillNum = specialBillNum;
    }

    public LocalDateTime getPayBankDt() {
        return payBankDt;
    }

    public void setPayBankDt(LocalDateTime payBankDt) {
        this.payBankDt = payBankDt;
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

    public int getPayWayId() {
        return payWayId;
    }

    public void setPayWayId(int payWayId) {
        this.payWayId = payWayId;
    }

    @Override
    public String toString() {
        return "TrafficCtrlPayInfoRegister{" +
                "billNum='" + billNum + '\'' +
                ", occurName='" + occurName + '\'' +
                ", funds=" + funds +
                ", lateFee=" + lateFee +
                ", bankId=" + bankId +
                ", isNoHere=" + isNoHere +
                ", isSpecialBill=" + isSpecialBill +
                ", specialBillNum='" + specialBillNum + '\'' +
                ", payBankDt=" + payBankDt +
                ", bankAffirm='" + bankAffirm + '\'' +
                ", bankStation='" + bankStation + '\'' +
                ", payWayId=" + payWayId +
                '}';
    }
}
