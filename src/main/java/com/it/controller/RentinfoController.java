package com.it.controller;


import com.github.pagehelper.PageInfo;
import com.it.entity.*;
import com.it.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;

@Controller
public class RentinfoController {

    @Autowired
    private RentinfoService rentinfoService;

    @Autowired
    private HousesService housesService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private ContractService contractService;

    @Autowired
    private OwnerService ownerService;

    @ResponseBody
    @RequestMapping("/queryAllRentinfo")
    public R queryAllRentinfo(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "15") Integer limit,String numbers,String identity){
        Rentinfo rentinfo = new Rentinfo();
        Houses houses = new Houses();
        houses.setNumbers(numbers);
        rentinfo.setHouses(houses);

        Customer customer = new Customer();
        customer.setIdentity(identity);
        rentinfo.setCustomer(customer);

        PageInfo<Rentinfo> rentinfoPageInfo = rentinfoService.queryAllRentinfo(page, limit, rentinfo);
        return  R.ok("操作成功",rentinfoPageInfo.getTotal(), rentinfoPageInfo.getList());
    }

    @RequestMapping("/queryRentinfoIndex")
    public String queryRentinfoIndex(){
        return "rentinfo/rentinfoIndex";
    }


    @ResponseBody
    @RequestMapping("/deleteRentinfoById")
    public R deleteRentinfoById(String ids){
        List<String> rentinfos = Arrays.asList(ids.split(","));
        int count=0;
        for (String rentinfo : rentinfos) {
            int i = rentinfoService.deleteRentinfoById(rentinfo);
            count++;
        }
       if(count>0) return R.ok();
       else return R.fail("删除失败");

    }

    @ResponseBody
    @RequestMapping("/stopRent")
    public R stopRentById(String id){
        int i = rentinfoService.stopRentById(id);

        if (i>0) return R.ok();
        else return R.fail("操作失败");
    }

    @RequestMapping("/pact")
    public String pact(Model model,String id){

        Rentinfo rent = new Rentinfo();
        rent.setId(Integer.parseInt(id));
        PageInfo<Rentinfo> rentinfoPageInfo = rentinfoService.queryAllRentinfo(1, 15, rent);
        Rentinfo rentinfo = rentinfoPageInfo.getList().get(0);

        Integer housesId = rentinfo.getHousesId();
        Houses hou = new Houses();
        hou.setId(housesId);
        PageInfo<Houses> pageInfo = housesService.queryAllHouses(1, 25, hou);
        Houses houses = pageInfo.getList().get(0);

        Integer contractId = rentinfo.getContractId();
        Contract contract = contractService.queryContractById(contractId);

        Integer customerId = rentinfo.getCustomerId();
        Customer cus = new Customer();
        cus.setId(customerId);
        PageInfo<Customer> pageInfo1 = customerService.queryCustomer(1, 15, cus);
        Customer customer = pageInfo1.getList().get(0);

        Integer ownerId = houses.getOwnerId();
        Owner own = new Owner();
        own.setId(ownerId);
        PageInfo<Owner> pageInfo2 = ownerService.queryOwnerAll(1, 1, own);
        Owner owner = pageInfo2.getList().get(0);




        model.addAttribute("houses", houses);
        model.addAttribute("customer",customer);
        model.addAttribute("contract", contract);
        model.addAttribute("owner", owner);
        model.addAttribute("rentinfo", rentinfo);

        return "rentinfo/pact";
    }



}
