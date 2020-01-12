package com.ours.userapp.service.forstaffService.impl;

import com.ours.userapp.mapper.DesignerMapper;
import com.ours.userapp.service.forstaffService.Forstaff_mySlaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
@Service
public class Forstaff_mySlaryServiceImpl implements Forstaff_mySlaryService {
    @Autowired
    private DesignerMapper designerMapper;
    @Override
    public Map<String, Object> getMySlary(String designerJob) {
        return designerMapper.getMySlary(designerJob);
    }
}
