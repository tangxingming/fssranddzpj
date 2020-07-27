package com.youchu.fssranddzpj.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDateTime;

public class ManualPayInfoRegister implements Serializable {
    private static final long serialVersionUID = 1L;
    private int keyWord;          //字轨
    private String billNum;          //缴款书号
    private String eTicketNum;       //电子缴款书号
    private int cantonId;            //行政区划
    private int unitId;              //单位
    private int hallId;              //缴费大厅
    private Date fillDate;           //制单日期
    private String payer;            //缴款人
    private String payerAccount;        //缴款人账号
    private String payerBank;        //缴款人开户行
    private int bankId;              //收款银行
    private String payee;            //收款人名称
    private String payeeAccount;        //收款人账号
    private String payeeBank;        //收款人开户行
    private String memo;             //备注
    private String vertifyCode;      //校验码
    private BigDecimal originFund;   //票面总金额
    private int isScale;             //是否分成
    private int isHand;              //是否手工票
    private LocalDateTime payBankDt; //收款时间
    private String bankAffirm;       //交易流水号
    private String bankStation;      //交款银行网点
    private int isWaitAffirm;        //是否待查收入转 1是0否
    private String writeName;        //填单人
    private Date writeDate;          //填单日期
    private int payWayId;            //缴款方式

    public ManualPayInfoRegister() {
    }

    public ManualPayInfoRegister(int keyWord, String billNum, String eTicketNum, int cantonId, int unitId, int hallId, Date fillDate, String payer, String payerAccount, String payerBank, int bankId, String payee, String payeeAccount, String payeeBank, String memo, String vertifyCode, BigDecimal originFund, int isScale, int isHand, LocalDateTime payBankDt, String bankAffirm, String bankStation, int isWaitAffirm, String writeName, Date writeDate, int payWayId) {
        this.keyWord = keyWord;
        this.billNum = billNum;
        this.eTicketNum = eTicketNum;
        this.cantonId = cantonId;
        this.unitId = unitId;
        this.hallId = hallId;
        this.fillDate = fillDate;
        this.payer = payer;
        this.payerAccount = payerAccount;
        this.payerBank = payerBank;
        this.bankId = bankId;
        this.payee = payee;
        this.payeeAccount = payeeAccount;
        this.payeeBank = payeeBank;
        this.memo = memo;
        this.vertifyCode = vertifyCode;
        this.originFund = originFund;
        this.isScale = isScale;
        this.isHand = isHand;
        this.payBankDt = payBankDt;
        this.bankAffirm = bankAffirm;
        this.bankStation = bankStation;
        this.isWaitAffirm = isWaitAffirm;
        this.writeName = writeName;
        this.writeDate = writeDate;
        this.payWayId = payWayId;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(int keyWord) {
        this.keyWord = keyWord;
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

    public int getHallId() {
        return hallId;
    }

    public void setHallId(int hallId) {
        this.hallId = hallId;
    }

    public Date getFillDate() {
        return fillDate;
    }

    public void setFillDate(Date fillDate) {
        this.fillDate = fillDate;
    }

    public String getPayer() {
        return payer;
    }

    public void setPayer(String payer) {
        this.payer = payer;
    }

    public String getPayerAccount() {
        return payerAccount;
    }

    public void setPayerAccount(String payerAccount) {
        this.payerAccount = payerAccount;
    }

    public String getPayerBank() {
        return payerBank;
    }

    public void setPayerBank(String payerBank) {
        this.payerBank = payerBank;
    }

    public int getBankId() {
        return bankId;
    }

    public void setBankId(int bankId) {
        this.bankId = bankId;
    }

    public String getPayee() {
        return payee;
    }

    public void setPayee(String payee) {
        this.payee = payee;
    }

    public String getPayeeAccount() {
        return payeeAccount;
    }

    public void setPayeeAccount(String payeeAccount) {
        this.payeeAccount = payeeAccount;
    }

    public String getPayeeBank() {
        return payeeBank;
    }

    public void setPayeeBank(String payeeBank) {
        this.payeeBank = payeeBank;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getVertifyCode() {
        return vertifyCode;
    }

    public void setVertifyCode(String vertifyCode) {
        this.vertifyCode = vertifyCode;
    }

    public BigDecimal getOriginFund() {
        return originFund;
    }

    public void setOriginFund(BigDecimal originFund) {
        this.originFund = originFund;
    }

    public int getIsScale() {
        return isScale;
    }

    public void setIsScale(int isScale) {
        this.isScale = isScale;
    }

    public int getIsHand() {
        return isHand;
    }

    public void setIsHand(int isHand) {
        this.isHand = isHand;
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

    public int getIsWaitAffirm() {
        return isWaitAffirm;
    }

    public void setIsWaitAffirm(int isWaitAffirm) {
        this.isWaitAffirm = isWaitAffirm;
    }

    public String getWriteName() {
        return writeName;
    }

    public void setWriteName(String writeName) {
        this.writeName = writeName;
    }

    public Date getWriteDate() {
        return writeDate;
    }

    public void setWriteDate(Date writeDate) {
        this.writeDate = writeDate;
    }

    public int getPayWayId() {
        return payWayId;
    }

    public void setPayWayId(int payWayId) {
        this.payWayId = payWayId;
    }

    @Override
    public String toString() {
        return "ManualPayInfoRegister{" +
                "keyWord='" + keyWord + '\'' +
                ", billNum='" + billNum + '\'' +
                ", eTicketNum='" + eTicketNum + '\'' +
                ", cantonId=" + cantonId +
                ", unitId=" + unitId +
                ", hallId=" + hallId +
                ", fillDate=" + fillDate +
                ", payer='" + payer + '\'' +
                ", payerAccount=" + payerAccount +
                ", payerBank='" + payerBank + '\'' +
                ", bankId=" + bankId +
                ", payee='" + payee + '\'' +
                ", payeeAccount=" + payeeAccount +
                ", payeeBank='" + payeeBank + '\'' +
                ", memo='" + memo + '\'' +
                ", vertifyCode='" + vertifyCode + '\'' +
                ", originFund=" + originFund +
                ", isScale=" + isScale +
                ", isHand=" + isHand +
                ", payBankDt=" + payBankDt +
                ", bankAffirm='" + bankAffirm + '\'' +
                ", bankStation='" + bankStation + '\'' +
                ", isWaitAffirm=" + isWaitAffirm +
                ", writeName='" + writeName + '\'' +
                ", writeDate=" + writeDate +
                ", payWayId=" + payWayId +
                '}';
    }
}
