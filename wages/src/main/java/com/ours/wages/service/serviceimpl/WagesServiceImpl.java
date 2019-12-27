package com.ours.wages.service.serviceimpl;

import com.ours.entity.Wages;
import com.ours.wages.mapper.WagesMapper;
import com.ours.wages.service.WagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WagesServiceImpl implements WagesService {

    @Autowired
    private WagesMapper wagesMapper;

    @Override
    public List<Wages> getAll() {
        List<Wages> list = wagesMapper.getAll();
        return list;
    }
}
