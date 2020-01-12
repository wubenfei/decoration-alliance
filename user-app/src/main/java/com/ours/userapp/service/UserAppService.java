package com.ours.userapp.service;

import com.ours.entity.User;
import com.ours.entity.UserDec;

import java.util.List;

public interface UserAppService {

    public int insert(User user);

    public User query(String phone);

    public int saveUrl(String url, int i);

    public int updataPwd(String phone, String password);
}
