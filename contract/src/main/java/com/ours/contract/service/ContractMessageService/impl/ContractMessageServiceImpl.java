package com.ours.contract.service.ContractMessageService.impl;

import com.ours.contract.dao.*;
import com.ours.contract.entity.DecorationCompany;
import com.ours.contract.entity.Designer;
import com.ours.contract.entity.Staff;
import com.ours.contract.entity.User;
import com.ours.contract.service.ContractMessageService.ContractMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ContractMessageServiceImpl implements ContractMessageService {
    @Autowired
    private ContractMapper contractMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private DesignerMapper designerMapper;
    @Autowired
    private DecorationCompanyMapper decorationCompanyMapper;
    @Autowired
    private StaffMapper staffMapper;

    @Override
    public List<Map<String, Object>> queryContractMessage(int from, int pageSize) {
        return contractMapper.queryContractMessage(from, pageSize);
    }

    @Override
    public User getUsername(int user_id) {
        return userMapper.selectByPrimaryKey(user_id);
    }

    @Override
    public Designer getDesignername(int designer_id) {
        return designerMapper.selectByPrimaryKey(designer_id);
    }

    @Override
    public DecorationCompany getDecorationCompany(int id) {
        return decorationCompanyMapper.selectByPrimaryKey(id);
    }

    @Override
    public Staff getStaff(int staff_id) {
        return staffMapper.selectByPrimaryKey(staff_id);
    }

    @Override
    public Integer queryContractMessageAll() {
        return contractMapper.queryContractMessageAll();
    }

    @Override
    public int updateStatusById(int id, String status) {
        return contractMapper.updateStatusById(id, status);
    }

    @Override
    public List<Map<String, Object>> queryContractTimeById(String num) {
        return contractMapper.queryContractTimeById(num);
    }

    @Override
    public List<Map<String, Object>> queryAll(int from, int pageSize) {
        return contractMapper.queryAll(from, pageSize);
    }

    @Override
    public int queryAllCount() {
        return contractMapper.queryAllCount();
    }

    @Override
    public List<Map<String, Object>> queryBySql(String toString) {
        return contractMapper.queryBySql(toString);
    }

    @Override
    public int queryBySql1(String toString) {
        return contractMapper.queryBySql1(toString);
    }


}
