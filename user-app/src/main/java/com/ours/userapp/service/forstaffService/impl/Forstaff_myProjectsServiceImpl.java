package com.ours.userapp.service.forstaffService.impl;

import com.ours.userapp.mapper.DesignerMapper;
import com.ours.userapp.service.forstaffService.Forstaff_myProjectsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
@Service
public class Forstaff_myProjectsServiceImpl implements Forstaff_myProjectsService {
    @Autowired
    private DesignerMapper designerMapper;
    @Override
    public List<Map<String, Object>> getStepList(Integer des_id) {
        return designerMapper.getStepList(des_id);
    }

    @Override
    public Map<String, Object> getStep(Integer contractid) {
        return designerMapper.getStep(contractid);
    }
}
