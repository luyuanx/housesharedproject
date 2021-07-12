package com.it.controller;

import com.github.pagehelper.PageInfo;
import com.it.entity.R;
import com.it.entity.Rentals;
import com.it.service.RentalsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;

@Controller
public class RentalsController {

    @Autowired
    private RentalsService rentalsService;

    @RequestMapping("/queryRentalsIndex")
    public String queryRentalsIndex(){
        return "rentals/rentalsIndex";
    }

    @ResponseBody
    @RequestMapping("/queryAllRentals")
    public R queryAllRentals(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "15") Integer limit, Rentals rentals){
        PageInfo<Rentals> pageInfo = rentalsService.queryAllRentals(limit, page, rentals);
        return R.ok("请求成功", pageInfo.getTotal(), pageInfo.getList());
    }

    @ResponseBody
    @RequestMapping("/updateStatus")
    public R updateStatus(String id){
        Rentals rentals = new Rentals();
        rentals.setId(Integer.parseInt(id));
        rentals.setStatus(1);
        int i = rentalsService.updateStatus(rentals);
        if (i>0) return R.ok();
        else return R.fail("更改失败");
    }

    @ResponseBody
    @RequestMapping("/deleteRentals")
    public R deleteRentals(String ids){
        List<String> rentalsinfo = Arrays.asList(ids.split(","));
        int count=0;
        for (String rentals : rentalsinfo) {
            int i = rentalsService.deleteRentals(rentals);
            count++;
        }
        if(count>0) return R.ok();
        else return R.fail("删除失败");
    }

}
