package com.it.controller;

import com.github.pagehelper.PageInfo;
import com.it.entity.R;
import com.it.entity.Repair;
import com.it.service.RepairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;

@Controller
public class RepairController {

    @Autowired
    private RepairService repairService;

    @RequestMapping("/repairIndex")
    public String repairIndex(){
        return "repair/repairIndex";
    }

    @ResponseBody
    @RequestMapping("/queryAllRepair")
    public R queryAllRepair(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "15") Integer limit, Repair repair){
        PageInfo<Repair> pageInfo = repairService.queryAllRepair(page, limit, repair);
        if (pageInfo.getTotal()>0){
            return R.ok("请求成功", pageInfo.getTotal(), pageInfo.getList());
        }
        else {
            return R.fail("请求失败");
        }
    }

    @ResponseBody
    @RequestMapping("/deleteRepair")
    public R deleteRepair(String ids){
        int count =0;
        List<String> strings = Arrays.asList(ids.split(","));
        for (String string : strings) {
            int i = repairService.deleteRepair(string);
            if (i>0) count++;
            else count=0;
        }
        if (count>0) return R.ok("删除成功");
        else return R.fail("删除失败");
    }

    @ResponseBody
    @RequestMapping("/updateRepairStatus")
    public R updateStatus(String id){
        Repair repair = new Repair();
        repair.setId(Integer.parseInt(id));
        repair.setStatus(1);
        int i = repairService.updateStatus(repair);
        if (i>0) return R.ok("状态更新成功");
        else return R.fail("状态更新失败");
    }
    @RequestMapping("/addRepair")
    public String addRepair(){
        return "repair/repairAdd";
    }

}
