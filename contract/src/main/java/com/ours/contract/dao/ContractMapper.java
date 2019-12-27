package com.ours.contract.dao;

import com.ours.contract.entity.Contract;

import java.util.List;
import java.util.Map;

public interface ContractMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Contract record);

    int insertSelective(Contract record);

    Contract selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Contract record);

    int updateByPrimaryKey(Contract record);
    List<Map<String, Object>> queryContractMessage(int from, int pageSize);

    Integer queryContractMessageAll();

    int updateStatusById(int id, String status);

    List<Map<String, Object>> queryContractTimeById(String num);

    List<Map<String, Object>> queryAll(int from, int pageSize);

    int queryAllCount();

    List<Map<String, Object>> queryBySql(String _parameter);

    int queryBySql1(String toString);
}