package com.youchu.fssranddzpj.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class RefundPayInfoRegister implements Serializable {
    private static final long serialVersionUID = 1L;
    private String backBillNum;       //票据编码
    private int keyWord;              //字轨
    private int cantonId;             //区划
    private int unitId;               //单位
    private int itemId;               //项目
    private String drawMan;           //收款人
    private String drawBank;          //收款人开户行
    private String drawAccount;       //收款人账户
    private int bankId;               //银行账户
    private BigDecimal fund;          //金额
    private LocalDateTime dealDate;   //办理日期
    private String bankStation;       //办理网点
    private String bankAffirm;        //交易流水号

    public RefundPayInfoRegister() {
    }

    public RefundPayInfoRegister(String backBillNum, int keyWord, int cantonId, int unitId, int itemId, String drawMan, String drawBank, String drawAccount, int bankId, BigDecimal fund, LocalDateTime dealDate, String bankStation, String bankAffirm) {
        this.backBillNum = backBillNum;
        this.keyWord = keyWord;
        this.cantonId = cantonId;
        this.unitId = unitId;
        this.itemId = itemId;
        this.drawMan = drawMan;
        this.drawBank = drawBank;
        this.drawAccount = drawAccount;
        this.bankId = bankId;
        this.fund = fund;
        this.dealDate = dealDate;
        this.bankStation = bankStation;
        this.bankAffirm = bankAffirm;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getBackBillNum() {
        return backBillNum;
    }

    public void setBackBillNum(String backBillNum) {
        this.backBillNum = backBillNum;
    }

    public int getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(int keyWord) {
        this.keyWord = keyWord;
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

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getDrawMan() {
        return drawMan;
    }

    public void setDrawMan(String drawMan) {
        this.drawMan = drawMan;
    }

    public String getDrawBank() {
        return drawBank;
    }

    public void setDrawBank(String drawBank) {
        this.drawBank = drawBank;
    }

    public String getDrawAccount() {
        return drawAccount;
    }

    public void setDrawAccount(String drawAccount) {
        this.drawAccount = drawAccount;
    }

    public int getBankId() {
        return bankId;
    }

    public void setBankId(int bankId) {
        this.bankId = bankId;
    }

    public BigDecimal getFund() {
        return fund;
    }

    public void setFund(BigDecimal fund) {
        this.fund = fund;
    }

    public LocalDateTime getDealDate() {
        return dealDate;
    }

    public void setDealDate(LocalDateTime dealDate) {
        this.dealDate = dealDate;
    }

    public String getBankStation() {
        return bankStation;
    }

    public void setBankStation(String bankStation) {
        this.bankStation = bankStation;
    }

    public String getBankAffirm() {
        return bankAffirm;
    }

    public void setBankAffirm(String bankAffirm) {
        this.bankAffirm = bankAffirm;
    }

    @Override
    public String toString() {
        return "RefundPayInfoRegister{" +
                "backBillNum='" + backBillNum + '\'' +
                ", keyWord=" + keyWord +
                ", cantonId=" + cantonId +
                ", unitId=" + unitId +
                ", itemId=" + itemId +
                ", drawMan='" + drawMan + '\'' +
                ", drawBank='" + drawBank + '\'' +
                ", drawAccount='" + drawAccount + '\'' +
                ", bankId=" + bankId +
                ", fund=" + fund +
                ", dealDate=" + dealDate +
                ", bankStation='" + bankStation + '\'' +
                ", bankAffirm='" + bankAffirm + '\'' +
                '}';
    }
}
