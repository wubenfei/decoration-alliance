package com.ours.userappservice.service.impl;

import com.ours.entity.Step;

import com.ours.userappservice.mapper.StepMapper;
import com.ours.userappservice.service.StepService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class StepServiceImpl implements StepService {

    @Resource
    private StepMapper stepMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return stepMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Step record) {
        return stepMapper.insert(record);
    }

    @Override
    public int insertSelective(Step record) {
        return stepMapper.insertSelective(record);
    }

    @Override
    public Step selectByPrimaryKey(Integer id) {
        return stepMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Step record) {
        return stepMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Step record) {
        return stepMapper.updateByPrimaryKey(record);
    }

    @Override
    public Map<String, Object> selectByContractId(Integer contractId) {
        return stepMapper.selectByContractId(contractId);
    }


}
