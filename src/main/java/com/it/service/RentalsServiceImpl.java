package com.it.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.it.entity.Rentals;
import com.it.mapper.RentalsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("RentalsService")
public class RentalsServiceImpl extends ServiceImpl<RentalsMapper, Rentals> implements RentalsService {

    @Autowired
    private RentalsMapper rentalsMapper;

    @Override
    public PageInfo<Rentals> queryAllRentals(Integer limit,Integer page,Rentals rentals) {
        List<Rentals> rentals1 = rentalsMapper.queryAllRentals(rentals);
        PageHelper.startPage(limit,page);
        PageInfo<Rentals> pageInfo = new PageInfo<>(rentals1);
        return pageInfo;
    }

    @Override
    public int updateStatus(Rentals rentals) {
        return baseMapper.updateById(rentals);
    }

    @Override
    public int deleteRentals(String id) {
       return  baseMapper.deleteById(id);
    }
}
