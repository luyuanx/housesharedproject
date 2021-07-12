package com.it.service;

import com.github.pagehelper.PageInfo;
import com.it.entity.Customer;

import java.util.List;

public interface CustomerService {

    PageInfo<Customer> queryCustomer(int page,int limit, Customer customer);

    int addCustomer(Customer customer);

    int deleteCustomer(List<String> ids);

    int updateCustomer(Customer customer);

    Customer customerUpdate(Integer id);

    Customer queryCustomer(String id);



}
