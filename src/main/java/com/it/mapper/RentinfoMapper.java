package com.it.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.it.entity.Rentinfo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RentinfoMapper extends BaseMapper<Rentinfo> {

    List<Rentinfo> queryAllRentinfo(Rentinfo rentinfo);

    int updateRentinfo(Rentinfo rentinfo);
}
