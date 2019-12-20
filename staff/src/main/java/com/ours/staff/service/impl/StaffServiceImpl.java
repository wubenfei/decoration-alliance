package com.ours.staff.service.impl;

import com.ours.entity.Staff;
import com.ours.staff.mapper.StaffMapper;
import com.ours.staff.service.StaffService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class StaffServiceImpl implements StaffService{

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
    /**
     * @Auth:MrW
     * @param depId
     * @return
     */
    @Override
    public List<Staff> selectDepMembersByDepId(int depId) {
        List<Staff> taffs = staffMapper.selectDepMembersByDepId(depId);
        return taffs;
    }

}
