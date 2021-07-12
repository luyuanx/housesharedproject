package com.it.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.util.Date;

public class LookHouse {
    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Integer housesId;

    private Integer customerId;

    private Date lookDate;

    private String remarks;
    private Date date;

    private String djr;
    private Date updateTime;

    private String xgr;

    private Integer stutas;

    private Customer customer;

    private Houses houses;

    private Owner owners;



    public static long getSerialVersionUID() {
        return serialVersionUID;
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

    public Date getLookDate() {
        return lookDate;
    }

    public void setLookDate(Date lookDate) {
        this.lookDate = lookDate;
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

    public Integer getStutas() {
        return stutas;
    }

    public void setStutas(Integer stutas) {
        this.stutas = stutas;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Houses getHouses() {
        return houses;
    }

    public void setHouses(Houses houses) {
        this.houses = houses;
    }

    public Owner getOwners() {
        return owners;
    }

    public void setOwners(Owner owners) {
        this.owners = owners;
    }

    @Override
    public String toString() {
        return "LookHouse{" +
                "id=" + id +
                ", housesId=" + housesId +
                ", customerId=" + customerId +
                ", lookDate=" + lookDate +
                ", remarks='" + remarks + '\'' +
                ", date=" + date +
                ", djr='" + djr + '\'' +
                ", updateTime=" + updateTime +
                ", xgr='" + xgr + '\'' +
                ", stutas=" + stutas +
                ", customer=" + customer +
                ", houses=" + houses +
                ", owners=" + owners +
                '}';
    }
}
