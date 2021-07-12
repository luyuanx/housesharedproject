package com.it.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.it.entity.Contract;
import com.it.mapper.ContractMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("ContractService")
public class ContractServiceImpl extends ServiceImpl<ContractMapper,Contract> implements  ContractService {

    @Autowired
    private  ContractMapper contractMapper;

    @Override
    public int addContract(Contract contract) {
        int insert = baseMapper.insert(contract);
        return insert;
    }

    @Override
    public Contract queryContractById(Integer id) {
        return baseMapper.selectById(id);
    }
}
