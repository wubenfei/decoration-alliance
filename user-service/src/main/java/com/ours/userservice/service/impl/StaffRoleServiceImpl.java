package com.ours.userservice.service.impl;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.ours.userservice.mapper.StaffRoleMapper;
import com.ours.entity.StaffRole;
import com.ours.userservice.service.StaffRoleService;

import java.util.List;

@Service
public class StaffRoleServiceImpl implements StaffRoleService {

    @Resource
    private StaffRoleMapper staffRoleMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return staffRoleMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(StaffRole record) {
        return staffRoleMapper.insert(record);
    }

    @Override
    public int insertSelective(StaffRole record) {
        return staffRoleMapper.insertSelective(record);
    }

    @Override
    public StaffRole selectByPrimaryKey(Integer id) {
        return staffRoleMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(StaffRole record) {
        return staffRoleMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(StaffRole record) {
        return staffRoleMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<StaffRole> getRoleName() {
        return staffRoleMapper.getRoleName();
    }


}
