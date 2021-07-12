package com.it.controller;

import com.it.entity.*;
import com.it.service.ContractService;
import com.it.service.HousesService;
import com.it.service.LookHouseService;
import com.it.service.RentinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

@Controller
public class ContractController {
    @Autowired
    private ContractService contractService;

    @Autowired
    private RentinfoService rentinfoService;

    @Autowired
    private HousesService housesService;

    @Autowired
    private LookHouseService lookHouseService;



    @ResponseBody
    @RequestMapping("addContract")
    public R addContract(@RequestBody Contract contract){

        //test

        //添加新增记录租赁
        Rentinfo rentinfo=new Rentinfo();
        rentinfo.setCreateTime(new Date());
        rentinfo.setCustomerId(contract.getCustomerId());
        rentinfo.setContractId(contract.getId());
        rentinfo.setHousesId(contract.getHousesId());
        rentinfo.setContractId(contract.getId());
        rentinfo.setAddress(new Houses().getAddress());
        rentinfoService.addRentinfo(rentinfo);

        //房子状态改成已经租赁状态
        Houses houses=new Houses();
        //根据房子id查询房子记录
        Houses hou=housesService.queryHousesById(contract.getHousesId());
        houses.setStatus(1);
        houses.setId(contract.getHousesId());
        houses.setPrice(hou.getPrice());
        houses.setArea(hou.getArea());
        housesService.updateHousesSubmit(houses);

        //更改看房状态
        LookHouse lookhouse=new LookHouse();
        lookhouse.setId(contract.getRentId());
        lookhouse.setStutas(1);//g更改为已看房
        lookHouseService.agreeRentingHouseSubmit(lookhouse);

        //合同信息
        contract.setRentId(rentinfo.getId());
        contractService.addContract(contract);

        return R.ok();
    }



}
