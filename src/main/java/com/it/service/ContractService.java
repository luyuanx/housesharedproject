package com.it.service;

import com.it.entity.Contract;

public interface ContractService  {
    int addContract(Contract contract);

    Contract queryContractById(Integer id);
}
