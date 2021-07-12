package com.it.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.it.entity.Houses;
import com.it.entity.Rentinfo;
import com.it.mapper.HousesMapper;
import com.it.mapper.RentinfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("Rentinfo")
public class RentinfoServiceImpl extends ServiceImpl<RentinfoMapper, Rentinfo> implements RentinfoService {

    @Autowired
    private RentinfoMapper rentinfoMapper;

    @Autowired
    private HousesService housesService;

    @Autowired
    private HousesMapper housesMapper;

    @Override
    public int addRentinfo(Rentinfo rentinfo) {
        int insert = baseMapper.insert(rentinfo);
        return insert;
    }

    @Override
    public PageInfo<Rentinfo> queryAllRentinfo(Integer page,Integer limit,Rentinfo rentinfo) {
        List<Rentinfo> rentinfos = rentinfoMapper.queryAllRentinfo(rentinfo);
        PageHelper.startPage(page, limit);
        PageInfo<Rentinfo> rentinfoPageInfo = new PageInfo<>(rentinfos);
        return rentinfoPageInfo;
    }

    @Override
    public int deleteRentinfoById(String id) {
        int i = baseMapper.deleteById(id);
        return i;
    }

    @Override
    public int stopRentById(String id) {

        Rentinfo rentinfo = new Rentinfo();
        rentinfo.setId(Integer.parseInt(id));
        List<Rentinfo> rentinfos = rentinfoMapper.queryAllRentinfo(rentinfo);
        Rentinfo rent = rentinfos.get(0);

        Integer housesId = rent.getHousesId();
        Houses houses = new Houses();
        houses.setId(housesId);
        List<Houses> housesList = housesMapper.queryAllHouse(houses);
        Houses hou = housesList.get(0);

        hou.setStatus(0);
        int i = housesService.updateHouse(hou);

        rent.setStatus(0);
        int i1 = rentinfoMapper.updateRentinfo(rent);
        return i+i1;

    }

    @Override
    public int updateRentinfo(Rentinfo rentinfo) {
        int i = rentinfoMapper.updateRentinfo(rentinfo);
        return i;
    }

    @Override
    public Rentinfo queryRentinfoById(String id) {
        Rentinfo rentinfo = baseMapper.selectById(id);
        return rentinfo;
    }
}
