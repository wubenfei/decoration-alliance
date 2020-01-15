package com.ours.friendlyCompany.controller;

import com.ours.friendlyCompany.entity.Datalist1;
import com.ours.friendlyCompany.entity.Designer;
import com.ours.friendlyCompany.entity.Staff;
import com.ours.friendlyCompany.entity.StaffDep;
import com.ours.friendlyCompany.service.AddStaff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
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
     * 获取所有部门及职级
     * 有redis缓存
     * @return
     */
    @Cacheable(cacheNames = "getDepartments")
    @GetMapping("getDepartments")
    public Datalist1 getDepartments() {
        //查询所有部门
        List<Map<String, Object>> list = as.getAllDepartments();
        Datalist1 datalist = new Datalist1();
        datalist.setForlist(list);
        //查询所有职级
        List<Map<String, Object>> list1 = as.queryAllLevel();
        datalist.setForlist1(list1);
        return datalist;
    }

    /**
     * 查询工号
     *
     * @return 最大工号+1
     */
    @GetMapping("getDesignerNum")
    public int getDesignerNum() {
        //查询工号
        return ((Integer.valueOf(as.queryMaxDesigner_name())) + 1);
    }

    @CacheEvict(cacheNames = "getDepartments")
    @RequestMapping("creatStaff")
    public String creatStaff(
            String tel,
            String departmentId,
            String staff_num,
            String staff_name,
            String phone,
            String addr,
            String id_card,
            Date join_date,
            String role_name
    ) {
        if (departmentId.equals("ZSLM-SJ")) {
            Designer designer = new Designer();
            //按身份证判断员工是否已经存在
            Designer d = as.queryDesignerByIdcard(id_card);
            if (d != null) {
                return "已有该身份证的员工,新建员工失败!";
            }
            int j = insertStaffDep(departmentId, staff_num);
            if (j != 1) {
                return "员工加入部门有误,创建失败!";
            }
            designer.setDesignerName(staff_name);
            designer.setAddr(addr);
            designer.setDesignerJob(staff_num);
            designer.setRoleName(role_name);
            designer.setDesignerPhone(phone);
            designer.setTel(tel);
            designer.setJoinData(join_date);
            designer.setIdCard(id_card);
            int i = as.insertDesigner(designer);
            if (i == 1) {
                return i + "";
            } else {
                return "新建员工失败!";
            }
        } else {
            Staff staff = new Staff();
            //按身份证判断员工是否已经存在
            Staff s = as.queryByIdcard(id_card);
            if (s != null) {
                return "已有该身份证的员工,新建员工失败!";
            }
            int j = insertStaffDep(departmentId, staff_num);
            if (j != 1) {
                return "员工加入部门有误,创建失败!";
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

    /**
     * 按工号,部门编号插入数据
     *
     * @param departmentId 部门编号
     * @param staff_num    工号
     * @return
     */
    private int insertStaffDep(String departmentId, String staff_num) {
        StaffDep staffDep = new StaffDep();
        staffDep.setDepId(departmentId);
        staffDep.setJobNumber(staff_num);
        return as.insertStaffDep(staffDep);
    }

}


