package com.ours.friendlyCompany.controller;

import com.ours.friendlyCompany.entity.Datalist1;
import com.ours.friendlyCompany.entity.Staff;
import com.ours.friendlyCompany.service.AddStaff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
public class InsertStaffController {
    @Autowired
    private AddStaff as;

    /**
     * 获取所有部门及工号
     *
     * @return
     */
    @GetMapping("getDepartments")
    public Datalist1 getDepartments() {
        //查询所有部门
        List<Map<String, Object>> list = as.getAllDepartments();
        Datalist1 datalist = new Datalist1();
        datalist.setForlist(list);
        //查询工号
        String designer_name = as.queryMaxDesigner_name();
        datalist.setPageTotal(Integer.valueOf(designer_name) + 1);
        //查询所有职级
        List<Map<String, Object>> list1 = as.queryAllLevel();
        datalist.setForlist1(list1);
        return datalist;
    }

    @RequestMapping("creatStaff")
    public String creatStaff(
            String tel,
            String department,
            String staff_num,
            String staff_name,
            String phone,
            String addr,
            String id_card,
            Date join_date,
            String role_name
    ) {
        if (department.equals("设计部")) {
            return "sheji";
        } else {
            Staff staff = new Staff();
            //按身份证判断员工是否已经存在
            //按身份证判断员工是否已经存在
            Staff s = as.queryByIdcard(id_card);
            if (s != null) {
                return "已有该身份证的员工,新建员工失败!";
            }
            staff.setTel(tel);
            staff.setPhone(phone);
            staff.setIdCard(id_card);
            staff.setStaffName(staff_name);
            staff.setAddr(addr);
            staff.setJoinDate(join_date);
            staff.setRoleName(role_name);
            staff.setJobNumber(staff_num);
            int i = as.insertStaff(staff);
            if (i == 1) {
                return i + "";
            } else {
                return "新建员工失败!";
            }
        }
    }

}


