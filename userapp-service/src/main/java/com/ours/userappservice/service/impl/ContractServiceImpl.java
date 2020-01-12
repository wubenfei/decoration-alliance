package com.ours.userappservice.service.impl;

import com.ours.entity.Contract;
import com.ours.userappservice.mapper.ContractMapper;
import com.ours.userappservice.service.ContractService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ContractServiceImpl implements ContractService {

    @Resource
    private ContractMapper contractMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return contractMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Contract record) {
        return contractMapper.insert(record);
    }

    @Override
    public int insertSelective(Contract record) {
        return contractMapper.insertSelective(record);
    }

    @Override
    public Contract selectByPrimaryKey(Integer id) {
        return contractMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Contract record) {
        return contractMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Contract record) {
        return contractMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<Contract> getContractList(Integer userId) {
        return contractMapper.getContractList(userId);
    }

    @Override
    public Contract selectByContractNumber(String contractNumber) {
        return contractMapper.selectByContractNumber(contractNumber);
    }

}
