package com.it.controller;

import com.github.pagehelper.PageInfo;
import com.it.entity.Houses;
import com.it.entity.Owner;
import com.it.entity.R;
import com.it.service.HousesService;
import com.it.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Controller
public class HousesController {



    @Autowired
    private OwnerService ownerService;

    @Autowired
    private HousesService housesService;

    @RequestMapping("/queryHousesIndex")
    public String queryHousesIndex(){
        return "/houses/housesIndex";
    }

    @ResponseBody
    @RequestMapping("/queryAllHouses")
    public R queryAllHouses(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "15") Integer limit,  Houses houses, String custname){

        Owner owner = new Owner();
        if (custname!=null && custname!=""){

            owner.setCustname(custname);
            houses.setOwner(owner);
        }

        PageInfo<Houses> pageInfo = housesService.queryAllHouses(page,limit,houses);
        return R.ok("成功",pageInfo.getTotal(), pageInfo.getList());
    }

    @RequestMapping("/housesAdd")
    public String housesAdd(){
        return "houses/add";
    }
    

    /**
     * 上传图片
     * @param
     * @return
     */
    @RequestMapping("fileUpload")
    @ResponseBody
    public R fileUpload(@RequestParam("file") MultipartFile file){
        if(file.isEmpty()){
            return R.fail("上传失败") ;
        }
        String fileName = file.getOriginalFilename();
//        int size = (int) file.getSize();
//        System.out.println(fileName + "-->" + size);

        String path = "D:\\images" ;
        File dest = new File(path + "/" + fileName);
        if(!dest.getParentFile().exists()){ //判断文件父目录是否存在
            dest.getParentFile().mkdir();
        }
        try {
            file.transferTo(dest); //保存文件
            return R.ok(fileName);
        } catch (IllegalStateException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return R.fail("上传失败");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return R.fail("上传失败");
        }
    }

    @ResponseBody
    @RequestMapping("/addHousesSubmit")
    public R addHousesSubmit(@RequestBody Houses houses){
        Integer integer = housesService.addHousesSubmit(houses);
        if (integer>0){
            return R.ok();
        }else {
            return R.fail("添加失败");
        }
    }

    @ResponseBody
    @RequestMapping("/findOwnerAll")
    public List<Owner> findOwnerAll(){
        PageInfo<Owner> pageInfo = ownerService.queryOwnerAll(1, 1, null);
        return pageInfo.getList();
    }

    @RequestMapping("/updateHouses")
    public String updateHouses(Integer id, Model model){
        Houses houses = housesService.queryHousesById(id);
        Owner owner = ownerService.queryOwnerById(houses.getOwnerId());
        model.addAttribute("houses", houses);
        model.addAttribute("owner", owner);
        PageInfo<Owner> pageInfo = ownerService.queryOwnerAll(1, 1, null);
        model.addAttribute("ownerlist", pageInfo.getList());


        return "houses/update";
    }

    @ResponseBody
    @RequestMapping("/updateHousesSubmit")
    public R updateHousesSubmit(@RequestBody Houses houses){
        int i = housesService.updateHousesSubmit(houses);
        if(i>0) return R.ok();
        else return R.fail("更新失败");
    }

    @ResponseBody
    @RequestMapping("/deleteHousesSubmit")
    public R deleteCustomerSubmit(String ids){
        List<String> strings = Arrays.asList(ids.split(","));
        int i = housesService.deleteHousesSubmit(strings);
        if (i>0) return R.ok();
        else return R.fail("删除失败");

    }

}
