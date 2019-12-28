package com.ours.wages.service;


import com.ours.entity.Adjustment;
import com.ours.entity.Wages;

import java.util.List;

public interface WagesService {

    public List<Wages> getAll();

    public int update(String jobNumber,String name,Integer wages,Integer royalty,String status,String granted,Integer id);

    List<Adjustment> getAdjustment(String month);
}
