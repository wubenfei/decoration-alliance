package com.ours.friendlyCompany.service.impl;

import com.ours.friendlyCompany.dao.DepartmentMapper;
import com.ours.friendlyCompany.dao.StaffMapper;
import com.ours.friendlyCompany.entity.Staff;
import com.ours.friendlyCompany.service.AddStaff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class AddStaffImpl implements AddStaff {
    @Autowired
    private DepartmentMapper departmentMapper;
    @Autowired
    private StaffMapper staffMapper;

    @Override
    public List<Map<String, Object>> getAllDepartments() {
        return departmentMapper.getAllDepartments();
    }

    @Override
    public String queryMaxDesigner_name() {
        return staffMapper.queryMaxDesigner_name();
    }

    @Override
    public List<Map<String, Object>> queryAllLevel() {
        return departmentMapper.queryAllLevel();
    }

    @Override
    public int insertStaff(Staff staff) {
        return staffMapper.insertSelective(staff);
    }

    @Override
    public Staff queryByIdcard(String id_card) {
        return staffMapper.queryByIdcard(id_card);
    }

}
