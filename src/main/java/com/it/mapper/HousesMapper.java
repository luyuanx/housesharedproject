package com.it.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.it.entity.Houses;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface HousesMapper extends BaseMapper<Houses> {

    List<Houses> queryAllHouse(Houses houses);

    int updateHouse(Houses houses);



}
