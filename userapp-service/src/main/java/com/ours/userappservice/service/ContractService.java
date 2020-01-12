package com.ours.userappservice.service;

import com.ours.entity.Contract;

import java.util.List;

public interface ContractService {

    int deleteByPrimaryKey(Integer id);

    int insert(Contract record);

    int insertSelective(Contract record);

    Contract selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Contract record);

    int updateByPrimaryKey(Contract record);

    List<Contract> getContractList(Integer userId);

    Contract selectByContractNumber(String contractNumber);

}
