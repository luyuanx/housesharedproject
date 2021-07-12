package com.it.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.it.entity.LookHouse;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface LookHouseMapper extends BaseMapper<LookHouse> {
    List<LookHouse> queryLookHouseAll(LookHouse lookHouse);


    LookHouse agreeRentingHouse(Integer id);
}
