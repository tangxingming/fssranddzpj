package com.youchu.fssranddzpj.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class StuPayInfoRegister implements Serializable {
    private static final long serialVersionUID = 1L;
    private int studentId;           //学生id
    private int cantonId;            //行政区划
    private int unitId;              //单位
    private String studentNum;       //缴费号
    private String className;        //班级
    private String studentName;      //姓名
    private int bankId;              //银行
    private BigDecimal fund;         //金额
    private String payerAccount;     //付款账号
    private LocalDateTime payBankDt; //收款时间
    private String bankAffirm;       //交易流水号
    private String bankStation;      //办理网点

    public StuPayInfoRegister() {
    }

    public StuPayInfoRegister(int studentId, int cantonId, int unitId, String studentNum, String className, String studentName, int bankId, BigDecimal fund, String payerAccount, LocalDateTime payBankDt, String bankAffirm, String bankStation) {
        this.studentId = studentId;
        this.cantonId = cantonId;
        this.unitId = unitId;
        this.studentNum = studentNum;
        this.className = className;
        this.studentName = studentName;
        this.bankId = bankId;
        this.fund = fund;
        this.payerAccount = payerAccount;
        this.payBankDt = payBankDt;
        this.bankAffirm = bankAffirm;
        this.bankStation = bankStation;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
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

    public String getStudentNum() {
        return studentNum;
    }

    public void setStudentNum(String studentNum) {
        this.studentNum = studentNum;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
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

    public String getPayerAccount() {
        return payerAccount;
    }

    public void setPayerAccount(String payerAccount) {
        this.payerAccount = payerAccount;
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

    @Override
    public String toString() {
        return "StuPayInfoRegister{" +
                "studentId=" + studentId +
                ", cantonId=" + cantonId +
                ", unitId=" + unitId +
                ", studentNum='" + studentNum + '\'' +
                ", className='" + className + '\'' +
                ", studentName='" + studentName + '\'' +
                ", bankId=" + bankId +
                ", fund=" + fund +
                ", payerAccount='" + payerAccount + '\'' +
                ", payBankDt=" + payBankDt +
                ", bankAffirm='" + bankAffirm + '\'' +
                ", bankStation='" + bankStation + '\'' +
                '}';
    }
}
