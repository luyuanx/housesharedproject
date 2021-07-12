package com.it.service;

import com.github.pagehelper.PageInfo;
import com.it.entity.Houses;

import java.util.List;

public interface HousesService {
    PageInfo<Houses> queryAllHouses(Integer page,Integer limit,Houses houses);

    Integer addHousesSubmit(Houses houses);

    Houses queryHousesById(Integer id);

    int updateHousesSubmit(Houses houses);

    int deleteHousesSubmit(List<String> ids);

    int updateHouse(Houses houses);





}
