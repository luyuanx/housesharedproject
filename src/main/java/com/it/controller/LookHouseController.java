package com.it.controller;

import com.github.pagehelper.PageInfo;
import com.it.entity.*;
import com.it.service.LookHouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;

@Controller
public class LookHouseController {

    @Autowired
    private LookHouseService lookHouseService;

    @ResponseBody
    @RequestMapping("/queryLookHouseAll")
    public R queryLookHouseAll(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer limit,String numbers, String custname, LookHouse lookHouse){
        if (numbers!=null&&!numbers.equals("")){
            lookHouse.setHouses(new Houses(numbers));
        }
        if (custname!=null&&!custname.equals("")){
          lookHouse.setCustomer(new Customer(custname));
        }

        PageInfo<LookHouse> pageInfo = lookHouseService.queryLookHouseAll(page, limit, lookHouse);
        return R.ok("成功", pageInfo.getTotal(), pageInfo.getList());

    }

    @RequestMapping("/queryLookHouseIndex")
    public String queryLookHouseIndex(){
        return "lookhouse/lookhouseIndex";
    }

    @ResponseBody
    @RequestMapping("/deleteLookHouse")
    public R deleteLookHouse(String ids){
        int count=0;
        List<String> strings = Arrays.asList(ids.split(","));
        for (String string : strings) {
            int i = lookHouseService.deleteLookHouse(string);
            if (i>0) count++;
            else count=0;
        }
        if (count>0) return R.ok();
        else return R.fail("删除失败");
    }

    @ResponseBody
    @RequestMapping("/refuseRentingHouse")
    public R refuseRentingHouse(String id){
        LookHouse lookHouse = new LookHouse();
        lookHouse.setId(Integer.parseInt(id));
        lookHouse.setStutas(1);
        int i = lookHouseService.refuseRentingHouse(lookHouse);
        if(i>0) return R.ok();
        else return R.fail("拒绝租赁失败");
    }

    @RequestMapping("/agreeRentingHouse")
    public String agreeRentingHouse(String id, Model model){
        LookHouse lookHouse = lookHouseService.agreeRentingHouse(Integer.parseInt(id));
        Customer customer = lookHouse.getCustomer();
        Houses houses = lookHouse.getHouses();
        Owner owners = lookHouse.getOwners();
        model.addAttribute("lookHouse", lookHouse);
        model.addAttribute("customer", customer);
        model.addAttribute("houses", houses);
        model.addAttribute("owners", owners);

        return "lookhouse/agree";
    }

    public R agreeRentingHouseSubmit(LookHouse lookHouse){
        int i = lookHouseService.agreeRentingHouseSubmit(lookHouse);
        if(i>0) return R.ok();
        else return R.fail("操作失败");

    }


}
