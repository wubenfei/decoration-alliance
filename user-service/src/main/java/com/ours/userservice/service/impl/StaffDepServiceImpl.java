package com.ours.userservice.service.impl;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.ours.entity.StaffDep;
import com.ours.userservice.mapper.StaffDepMapper;
import com.ours.userservice.service.StaffDepService;

@Service
public class StaffDepServiceImpl implements StaffDepService {

    @Resource
    private StaffDepMapper staffDepMapper;

    @Override
    public int insert(StaffDep record) {
        return staffDepMapper.insert(record);
    }

    @Override
    public int insertSelective(StaffDep record) {
        return staffDepMapper.insertSelective(record);
    }

    @Override
    public int updateStaffDep(String depId, String jobNumber) {
        return staffDepMapper.updateStaffDep(depId, jobNumber);
    }

}
