package com.it.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.it.entity.Repair;
import com.it.mapper.RepairMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("RepairService")
public class RepairServiceImpl extends ServiceImpl<RepairMapper,Repair> implements RepairService {

    @Autowired
    private RepairMapper repairMapper;


    @Override
    public PageInfo<Repair> queryAllRepair(Integer page, Integer limit, Repair repair) {
        List<Repair> repairs = repairMapper.queryAllRepair(repair);
        PageHelper.startPage(page, limit);
        PageInfo<Repair> pageInfo = new PageInfo<>(repairs);
        return pageInfo;
    }

    @Override
    public int deleteRepair(String id) {
         return  baseMapper.deleteById(id);
    }

    @Override
    public int updateStatus(Repair repair) {
        return  baseMapper.updateById(repair);

    }


}
