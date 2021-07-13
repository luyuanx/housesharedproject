package com.it.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.it.entity.Rentals;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RentalsMapper extends BaseMapper<Rentals> {
    List<Rentals> queryAllRentals(Rentals rentals);
}
