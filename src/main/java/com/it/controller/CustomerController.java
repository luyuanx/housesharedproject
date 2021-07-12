package com.it.controller;

import com.github.pagehelper.PageInfo;
import com.it.entity.Customer;
import com.it.entity.R;
import com.it.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Controller
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping("/customerIndex")
    public String customerIndex(){
        return "customer/customerIndex";
    }
    
    //test

    @ResponseBody
    @RequestMapping("/queryCustomer")
    public R queryCustomer(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "15") int limit, Customer customer){

        PageInfo<Customer> pageInfo = customerService.queryCustomer(page, limit, customer);

        return R.ok("成功",pageInfo.getTotal(),pageInfo.getList());
    }

    @RequestMapping("/customerAdd")
    public String customerAdd(){
        return "customer/add";
    }

    @ResponseBody
    @RequestMapping("/addCustomerSubmit")
    public R addCustomerSubmit(@RequestBody Customer customer){
        customer.setCreateTime(new Date());
        int i = customerService.addCustomer(customer);
        if(i>0) return R.ok();
        else return R.fail("添加失败");
    }

    @ResponseBody
    @RequestMapping("/deleteCustomerSubmit")
    public R deleteCustomerSubmit(String ids){
        List<String> strings = Arrays.asList(ids.split(","));
        int i = customerService.deleteCustomer(strings);
        if (i>0) return R.ok();
        else return R.fail("删除失败");

    }

    @RequestMapping("/customerUpdate")
    public String customerUpdate(Model model,Integer id){
        Customer customer = customerService.customerUpdate(id);
        model.addAttribute("customer", customer);
        return "customer/update";
    }

    @ResponseBody
    @RequestMapping("/updateCustomerSubmit")
    public R updateCustomerSubmit(@RequestBody Customer customer){
        int i = customerService.updateCustomer(customer);
        if (i>0) return R.ok();
        else return R.fail("更新失败");
    }




}
