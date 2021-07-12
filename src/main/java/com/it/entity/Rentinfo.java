package com.it.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;
import java.util.Date;

public class Rentinfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Integer housesId;

    private Integer customerId;

    private Integer contractId;

    private String address;

    private String remarks;

    private Date createTime;

    private String djr;

    private Date updateTime;

    private String xgr;

    private Customer customer;
    private Houses houses;

    private Contract contract;
    private Integer status;

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

    public Integer getContractId() {
        return contractId;
    }

    public void setContractId(Integer contractId) {
        this.contractId = contractId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
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

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Rentinfo{" +
                "id=" + id +
                ", housesId=" + housesId +
                ", customerId=" + customerId +
                ", contractId=" + contractId +
                ", address='" + address + '\'' +
                ", remarks='" + remarks + '\'' +
                ", createTime=" + createTime +
                ", djr='" + djr + '\'' +
                ", updateTime=" + updateTime +
                ", xgr='" + xgr + '\'' +
                ", customer=" + customer +
                ", houses=" + houses +
                ", contract=" + contract +
                ", status=" + status +
                '}';
    }
}
