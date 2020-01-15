package com.ours.userservice.service.impl;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.ours.entity.Staff;
import com.ours.userservice.mapper.StaffMapper;
import com.ours.userservice.service.StaffService;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class StaffServiceImpl implements StaffService {

    @Resource
    private StaffMapper staffMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return staffMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Staff record) {
        return staffMapper.insert(record);
    }

    @Override
    public int insertSelective(Staff record) {
        return staffMapper.insertSelective(record);
    }

    @Override
    public Staff selectByPrimaryKey(Integer id) {
        return staffMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Staff record) {
        return staffMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Staff record) {
        return staffMapper.updateByPrimaryKey(record);
    }

    @Override
    public Map<String, Object> selectPhoneAndPassword(String username, String password) {
        return staffMapper.selectPhoneAndPassword(username, password);
    }

    @Override
    public List<Staff> selectAllStaff() {
        return staffMapper.selectAllStaff();
    }

    @Override
    public int updateByStatusAndDismissionDate(String status, Date dismissionDate, String jobNumber) {
        return staffMapper.updateByStatusAndDismissionDate(status, dismissionDate, jobNumber);
    }

    @Override
    public int updateRoleName(String roleName, String jobNumber) {
        return staffMapper.updateRoleName(roleName, jobNumber);
    }

    @Override
    public Staff selectJobNumber(String jobNumber) {
        return staffMapper.selectJobNumber(jobNumber);
    }

}
