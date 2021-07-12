package com.it.service;

import com.github.pagehelper.PageInfo;
import com.it.entity.Rentals;

public interface RentalsService {
    PageInfo<Rentals> queryAllRentals(Integer limit,Integer page,Rentals rentals);

    int updateStatus(Rentals rentals);

    int deleteRentals(String id);
}
