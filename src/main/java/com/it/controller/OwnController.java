package com.it.controller;

import com.github.pagehelper.PageInfo;
import com.it.entity.Owner;
import com.it.entity.R;
import com.it.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Controller
public class OwnController {

    @Autowired
    private OwnerService ownerService;

    @RequestMapping("/ownerIndex")
    public String ownerIndex(){
        return "owner/ownerIndex";
    }


    @RequestMapping("queryAllOwner")
    @ResponseBody
    public R queryAllOwner(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "15") int limit,  Owner owner){
        PageInfo<Owner> pageInfo = ownerService.queryOwnerAll(page, limit, owner);

        return R.ok("chenggong",pageInfo.getTotal(),pageInfo.getList());
    }

    @RequestMapping("/owneradd")
    public String ownerAdd(){
        return "owner/add";
    }

    @ResponseBody
    @RequestMapping("/addOwnerSubmit")
    public R addOwnerSubmit(@RequestBody Owner owner){
        owner.setCreateTime(new Date());
        int add = ownerService.add(owner);
        if (add>0) return R.ok();
        else return R.fail("添加失败");
    }

    @ResponseBody
    @RequestMapping("/deleteOwnerSubmit")
    public R deleteOwnerSubmit(String ids){
        //将前端传来的字符串转换为list
        List<String> strings = Arrays.asList(ids.split(","));
        int delete = ownerService.delete(strings);

        if (delete>0) return R.ok();
        else return R.fail("删除失败");

    }


    @RequestMapping("/updateOwner")
    public String updateOwner(Model model, Integer id){
        Owner owner = ownerService.queryOwnerById(id);
        model.addAttribute("Owner", owner);
        return "/owner/update";
    }

    @ResponseBody
    @RequestMapping("/updateOwnerSubmit")
    public R updateOwnerSubmit(@RequestBody Owner owner){
        owner.setCreateTime(new Date());
        int i = ownerService.updateData(owner);
        if(i>0) return R.ok();
        else return R.fail("更新失败");
    }



}
