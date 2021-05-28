package com.it.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.it.entity.Customer;
import com.it.mapper.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service("Customer")
public class CustomerServiceImpl extends ServiceImpl<CustomerMapper,Customer> implements CustomerService {

    @Autowired
    private CustomerMapper customerMapper;

    @Override
    public PageInfo<Customer> queryCustomer(int page,int limit, Customer customer) {

        PageHelper.startPage(page, limit);
        List<Customer> customerMappers = customerMapper.queryCustomer(customer);
        PageInfo<Customer> pageInfo = new PageInfo<>(customerMappers);
        return pageInfo;
    }

    @Override
    public int addCustomer(Customer customer) {
        int insert = baseMapper.insert(customer);
        return insert;
    }

    @Override
    public int deleteCustomer(List<String> ids) {
        int count = 0;
        for (String id  : ids) {
            int i = baseMapper.deleteById(id);
            if (i>0) count++;
        }
        return count;
    }

    @Override
    public int updateCustomer(Customer customer) {
        customer.setUpdateTime(new Date());
        int i = baseMapper.updateById(customer);
        return i;
    }

    @Override
    public Customer customerUpdate(Integer id) {
        Customer customer = new Customer();
        customer.setId(id);
        List<Customer> customers = baseMapper.queryCustomer(customer);
        return customers.get(0);
    }

}
