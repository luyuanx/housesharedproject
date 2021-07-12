package com.it.service;

import com.github.pagehelper.PageInfo;
import com.it.entity.Rentinfo;

public interface RentinfoService  {

    int addRentinfo(Rentinfo rentinfo);

    PageInfo<Rentinfo> queryAllRentinfo(Integer page,Integer limit,Rentinfo rentinfo);

    int deleteRentinfoById(String id);

    int stopRentById(String id);

    int updateRentinfo(Rentinfo rentinfo);

    Rentinfo queryRentinfoById(String id);



}
