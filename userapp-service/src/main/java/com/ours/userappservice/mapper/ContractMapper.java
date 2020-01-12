package com.ours.userappservice.mapper;

import com.ours.entity.Contract;

import java.util.List;

public interface ContractMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Contract record);

    int insertSelective(Contract record);

    Contract selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Contract record);

    int updateByPrimaryKey(Contract record);

    List<Contract> getContractList(Integer userId);

    Contract selectByContractNumber(String contractNumber);
}