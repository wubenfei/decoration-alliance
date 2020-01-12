package com.ours.userapp.service.serviceimpl;

import com.ours.entity.User;
import com.ours.entity.UserDec;
import com.ours.userapp.mapper.UserDecMapper;
import com.ours.userapp.mapper.UserMapper;
import com.ours.userapp.service.UserAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserAppServiceImpl implements UserAppService {

    @Autowired
    UserMapper userMapper;

    public int insert(User user) {
        int i = userMapper.insert(user);
        return i;
    }

    @Override
    public User query(String phone) {
        return userMapper.query(phone);
    }

    @Override
    public int saveUrl(String url ,int i) {
        return userMapper.saveUrl(url,i);
    }

    @Override
    public int updataPwd(String phone, String password) {
        int i = userMapper.updataPwd(password, phone);
        return i;
    }

}
