package com.it.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;
import java.util.Date;

public class Rentals implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Integer housesId;

    private Integer customerId;

    private Integer money;

    private Date ksrq;  //开始日期

    private Date jzrq;  //截至日期

    private String jfr;

    private String remarks;

    private Date date;

    private String djr;

    private Date updateTime;

    private String xgr;

    private Houses houses;

    private int status=0; //交租状态 0为未交租 1为交租

    private Customer customer;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Houses getHouses() {
        return houses;
    }

    public void setHouses(Houses houses) {
        this.houses = houses;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getHousesId() {
        return housesId;
    }

    public void setHousesId(Integer housesId) {
        this.housesId = housesId;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    public Date getKsrq() {
        return ksrq;
    }

    public void setKsrq(Date ksrq) {
        this.ksrq = ksrq;
    }

    public Date getJzrq() {
        return jzrq;
    }

    public void setJzrq(Date jzrq) {
        this.jzrq = jzrq;
    }

    public String getJfr() {
        return jfr;
    }

    public void setJfr(String jfr) {
        this.jfr = jfr;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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

    @Override
    public String toString() {
        return "Rentals{" +
                "id=" + id +
                ", housesId=" + housesId +
                ", customerId=" + customerId +
                ", money=" + money +
                ", ksrq=" + ksrq +
                ", jzrq=" + jzrq +
                ", jfr='" + jfr + '\'' +
                ", remarks='" + remarks + '\'' +
                ", date=" + date +
                ", djr='" + djr + '\'' +
                ", updateTime=" + updateTime +
                ", xgr='" + xgr + '\'' +
                ", houses=" + houses +
                ", status=" + status +
                ", customer=" + customer +
                '}';
    }
}
