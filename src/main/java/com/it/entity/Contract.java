package com.it.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;
import java.util.Date;

public class Contract implements Serializable {


    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Integer customerId;

    private Integer housesId;
    private Date qzrq; //起租日期

    private Date kfrq; //看房日期

    private Date tzrq; //结束日期

    private Double money;

    private String paymoney;

    private Date createTime;

    private String djr;

    private Date updateTime;

    private String xgr;

    private Integer rentId;
    private Integer payrent; //交租日

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Integer getHousesId() {
        return housesId;
    }

    public void setHousesId(Integer housesId) {
        this.housesId = housesId;
    }

    public Date getQzrq() {
        return qzrq;
    }

    public void setQzrq(Date qzrq) {
        this.qzrq = qzrq;
    }

    public Date getKfrq() {
        return kfrq;
    }

    public void setKfrq(Date kfrq) {
        this.kfrq = kfrq;
    }

    public Date getTzrq() {
        return tzrq;
    }

    public void setTzrq(Date tzrq) {
        this.tzrq = tzrq;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public String getPaymoney() {
        return paymoney;
    }

    public void setPaymoney(String paymoney) {
        this.paymoney = paymoney;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getDjr() {
        return djr;
    }

    public void setDjr(String djr) {
        this.djr = djr;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getXgr() {
        return xgr;
    }

    public void setXgr(String xgr) {
        this.xgr = xgr;
    }

    public Integer getRentId() {
        return rentId;
    }

    public void setRentId(Integer rentId) {
        this.rentId = rentId;
    }

    public Integer getPayrent() {
        return payrent;
    }

    public void setPayrent(Integer payrent) {
        this.payrent = payrent;
    }

    @Override
    public String toString() {
        return "Contract{" +
                "id=" + id +
                ", customerId=" + customerId +
                ", housesId=" + housesId +
                ", qzrq=" + qzrq +
                ", kfrq=" + kfrq +
                ", tzrq=" + tzrq +
                ", money=" + money +
                ", paymoney='" + paymoney + '\'' +
                ", createTime=" + createTime +
                ", djr='" + djr + '\'' +
                ", updateTime=" + updateTime +
                ", xgr='" + xgr + '\'' +
                ", rentId=" + rentId +
                ", payrent=" + payrent +
                '}';
    }
}
