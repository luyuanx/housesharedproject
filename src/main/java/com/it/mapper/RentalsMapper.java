package com.it.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.it.entity.Rentals;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface RentalsMapper extends BaseMapper<Rentals> {
    List<Rentals> queryAllRentals(Rentals rentals);
}
