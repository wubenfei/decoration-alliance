package com.ours.userappservice.mapper;

import com.ours.entity.Step;

import java.util.List;
import java.util.Map;

public interface StepMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Step record);

    int insertSelective(Step record);

    Step selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Step record);

    int updateByPrimaryKey(Step record);

    Map<String, Object> selectByContractId(Integer contractId);
}