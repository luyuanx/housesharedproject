package com.it.service;

import com.github.pagehelper.PageInfo;
import com.it.entity.Repair;

public interface RepairService{
    PageInfo<Repair> queryAllRepair(Integer page,Integer limit,Repair repair);

    int deleteRepair(String id);

    int updateStatus(Repair repair);
}
