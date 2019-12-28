package com.ours.userservice.service.impl;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.ours.entity.Designer;
import com.ours.userservice.mapper.DesignerMapper;
import com.ours.userservice.service.DesignerService;

import java.util.Date;
import java.util.List;

@Service
public class DesignerServiceImpl implements DesignerService {

    @Resource
    private DesignerMapper designerMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return designerMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Designer record) {
        return designerMapper.insert(record);
    }

    @Override
    public int insertSelective(Designer record) {
        return designerMapper.insertSelective(record);
    }

    @Override
    public Designer selectByPrimaryKey(Integer id) {
        return designerMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Designer record) {
        return designerMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Designer record) {
        return designerMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<Designer> selectAllDesigner() {
        return designerMapper.selectAllDesigner();
    }

    @Override
    public int updateDesignerStatus(String status, Date dismissionDate, String jobNumber) {
        return designerMapper.updateDesignerStatus(status, dismissionDate, jobNumber);
    }

    @Override
    public int updateRoleName(String roleName, String jobNumber) {
        return designerMapper.updateRoleName(roleName, jobNumber);
    }

    @Override
    public Designer selectJobNumber(String jobNumber) {
        return designerMapper.selectJobNumber(jobNumber);
    }

}
