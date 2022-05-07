package com.chenhao.mapper;

import com.chenhao.pojo.Contract;

import java.util.List;

public interface ContractMapper {
    List<Contract> findAll();
    Contract findById(Integer integer);
}
