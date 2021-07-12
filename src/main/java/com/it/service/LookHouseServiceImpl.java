package com.it.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.it.entity.LookHouse;
import com.it.mapper.LookHouseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("LookHouseService")
public class LookHouseServiceImpl extends ServiceImpl<LookHouseMapper,LookHouse> implements LookHouseService {

    @Autowired
    private LookHouseMapper lookHouseMapper;

    @Override
    public PageInfo<LookHouse> queryLookHouseAll(Integer page,Integer limit,LookHouse lookHouse) {
        List<LookHouse> housesList = lookHouseMapper.queryLookHouseAll(lookHouse);
        PageHelper.startPage(page, limit);
        PageInfo<LookHouse> pageInfo = new PageInfo(housesList);
        return pageInfo;
    }

    @Override
    public int deleteLookHouse(String id) {
        int i = baseMapper.deleteById(id);
        return i;
    }

    @Override
    public int refuseRentingHouse(LookHouse lookHouse) {
        int i = baseMapper.updateById(lookHouse);
        return i;
    }

    @Override
    public LookHouse agreeRentingHouse(Integer id) {
        LookHouse lookHouse = lookHouseMapper.agreeRentingHouse(id);
        return lookHouse;
    }

    @Override
    public int agreeRentingHouseSubmit(LookHouse lookHouse) {
        int i = baseMapper.updateById(lookHouse);
        return i;
    }


}
