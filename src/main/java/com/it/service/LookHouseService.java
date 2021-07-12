package com.it.service;

import com.github.pagehelper.PageInfo;
import com.it.entity.LookHouse;

public interface LookHouseService  {
    PageInfo<LookHouse> queryLookHouseAll(Integer page,Integer limit,LookHouse lookHouse);

    int deleteLookHouse(String id);

    int refuseRentingHouse(LookHouse lookHouse);

    LookHouse agreeRentingHouse(Integer id);

    int agreeRentingHouseSubmit(LookHouse lookHouse);
}
