package com.ours.userapp.service.forstaffService.impl;

import com.ours.userapp.mapper.UserMapper;
import com.ours.userapp.service.forstaffService.Forstaff_uploadImgsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Forstaff_uploadImgsServiceImpl implements Forstaff_uploadImgsService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public Integer saveImg(Integer userid,String links) {
        return userMapper.saveUrl(links,userid);
    }
}
