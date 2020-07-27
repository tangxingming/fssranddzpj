package com.youchu.fssranddzpj.entity;


import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDateTime;

public class PayNoteRegister implements Serializable {
    private static final long serialVersionUID = 1L;
    private int billId; //缴款书ID
    private String billNum; //缴款书号
    private String eTicketNum; //电子缴款书号
    private String payer; //缴款人名称
    private Date fillDate; //制单日期
    private int bankId; //银行账户
    private int isWaitAffirm; //是否待查收入转 1是0否
    private BigDecimal originFund; //金额
    private LocalDateTime payBankDt; //收款时间
    private String bankAffirm; //交易流水号
    private String bankStation; //交款银行网点
    private int payWayId; //缴款方式

    public PayNoteRegister() {
    }

    public PayNoteRegister(int billId, String billNum, String eTicketNum, String payer, Date fillDate, int bankId, int isWaitAffirm, BigDecimal originFund, LocalDateTime payBankDt, String bankAffirm, String bankStation, int payWayId) {
        this.billId = billId;
        this.billNum = billNum;
        this.eTicketNum = eTicketNum;
        this.payer = payer;
        this.fillDate = fillDate;
        this.bankId = bankId;
        this.isWaitAffirm = isWaitAffirm;
        this.originFund = originFund;
        this.payBankDt = payBankDt;
        this.bankAffirm = bankAffirm;
        this.bankStation = bankStation;
        this.payWayId = payWayId;
    }

    public int getBillId() {
        return billId;
    }

    public void setBillId(int billId) {
        this.billId = billId;
    }

    public String getBillNum() {
        return billNum;
    }

    public void setBillNum(String billNum) {
        this.billNum = billNum;
    }

    public String geteTicketNum() {
        return eTicketNum;
    }

    public void seteTicketNum(String eTicketNum) {
        this.eTicketNum = eTicketNum;
    }

    public String getPayer() {
        return payer;
    }

    public void setPayer(String payer) {
        this.payer = payer;
    }

    public Date getFillDate() {
        return fillDate;
    }

    public void setFillDate(Date fillDate) {
        this.fillDate = fillDate;
    }

    public int getBankId() {
        return bankId;
    }

    public void setBankId(int bankId) {
        this.bankId = bankId;
    }

    public int getIsWaitAffirm() {
        return isWaitAffirm;
    }

    public void setIsWaitAffirm(int isWaitAffirm) {
        this.isWaitAffirm = isWaitAffirm;
    }

    public BigDecimal getOriginFund() {
        return originFund;
    }

    public void setOriginFund(BigDecimal originFund) {
        this.originFund = originFund;
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
        return "PayNoteRegister{" +
                "billId=" + billId +
                ", billNum='" + billNum + '\'' +
                ", eTicketNum='" + eTicketNum + '\'' +
                ", payer='" + payer + '\'' +
                ", fillDate=" + fillDate +
                ", bankId=" + bankId +
                ", isWaitAffirm=" + isWaitAffirm +
                ", originFund=" + originFund +
                ", payBankDt=" + payBankDt +
                ", bankAffirm='" + bankAffirm + '\'' +
                ", bankStation='" + bankStation + '\'' +
                ", payWayId=" + payWayId +
                '}';
    }
}
