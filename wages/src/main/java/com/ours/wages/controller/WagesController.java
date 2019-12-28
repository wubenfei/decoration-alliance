package com.ours.wages.controller;


import com.ours.entity.Adjustment;
import com.ours.entity.Wages;
import com.ours.wages.service.WagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

// 解决跨域问题
@CrossOrigin
@Controller
public class WagesController {

    @Autowired
    private WagesService wagesService;

    @ResponseBody
    @RequestMapping("getAll")
    public List<Wages> getAll(){
        System.out.println("进入wages的getAll请求");
        List<Wages> list = wagesService.getAll();
        System.out.println("拿到的数据为："+list);
        return list;
    }

    @ResponseBody
    @RequestMapping("updateWages")
    public int updateWages(String jobNumber,String name,Integer wages,Integer royalty,String status,String granted,Integer id){
        System.out.println("进入wages的updateWages请求");
        System.out.println(jobNumber);
        System.out.println(name);
        System.out.println(wages);
        System.out.println(royalty);
        System.out.println(status);
        System.out.println(granted);
        System.out.println("id="+id);
        int i = wagesService.update(jobNumber, name, wages, royalty, status, granted, id);
        System.out.println("受影响行数："+i);
        return i;
    }


    @ResponseBody
    @RequestMapping("getAdjustment")
    public List<Adjustment> getAdjustment(){
        System.out.println("进入getAdjustment请求");
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String today = sdf.format(date);
        int day = date.getDate();
        String[] strs = today.split("-");
        strs[2]=1+"";
        String newString =strs[0]+"-"+strs[1]+"-"+strs[2];
        System.out.println(newString);
        List<Adjustment> list = wagesService.getAdjustment(newString);
        System.out.println("结果为："+list);
        return list;
    }

}
