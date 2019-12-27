package com.ours.wages.controller;

import com.ours.entity.Wages;
import com.ours.wages.service.WagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

// 解决跨域问题
@CrossOrigin
@Controller
public class WagesController {

    @Autowired
    private WagesService wagesService;

    @ResponseBody
    @RequestMapping("wages/getAll")
    public List<Wages> getAll(){
        System.out.println("进入wages的getAll请求");
        List<Wages> list = wagesService.getAll();
        return list;
    }



}
