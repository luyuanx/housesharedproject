package com.it.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.it.entity.Houses;
import com.it.mapper.HousesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("HousesService")
public class HousesServiceImpl extends ServiceImpl<HousesMapper,Houses> implements HousesService {

    @Autowired
    private HousesMapper housesMapper;

    @Override
    public PageInfo<Houses> queryAllHouses(Integer page,Integer limit,Houses houses) {
        List<Houses> housesList = housesMapper.queryAllHouse(houses);
        PageHelper.startPage(page, limit);
        PageInfo<Houses> pageInfo = new PageInfo<>(housesList);
        return pageInfo;
    }

    @Override
    public Integer addHousesSubmit(Houses houses) {
        int insert = baseMapper.insert(houses);
        return insert;
    }

    @Override
    public Houses queryHousesById(Integer id) {
      Houses houses = new Houses();
      houses.setId(id);
      List<Houses> housesList = housesMapper.queryAllHouse(houses);
      return  housesList.get(0);
    }

    @Override
    public int updateHousesSubmit(Houses houses) {
        int i = baseMapper.updateById(houses);
        return i;
    }

    @Override
    public int deleteHousesSubmit(List<String> ids) {
        int count = 0;
        for (String id  : ids) {
            int i = baseMapper.deleteById(id);
            if (i>0) count++;
        }
        return count;
    }

    @Override
    public int updateHouse(Houses houses) {
        return housesMapper.updateHouse(houses);
    }


}
