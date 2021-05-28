package com.it.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.it.entity.Houses;
import org.springframework.stereotype.Component;

import java.util.List;

@Component()
public interface HousesMapper extends BaseMapper<Houses> {

    List<Houses> queryAllHouse(Houses houses);



}
