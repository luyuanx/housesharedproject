package com.it.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.it.entity.LookHouse;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LookHouseMapper extends BaseMapper<LookHouse> {
    List<LookHouse> queryLookHouseAll(LookHouse lookHouse);


    LookHouse agreeRentingHouse(Integer id);
}
