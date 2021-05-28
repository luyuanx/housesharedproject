package com.it.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.it.entity.Customer;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CustomerMapper extends BaseMapper<Customer> {

    List<Customer> queryCustomer(Customer customer);




}
