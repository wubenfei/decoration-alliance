package com.ours.userservice.controller;

import com.ours.entity.*;
import com.ours.userservice.controller.from.DepartmentFrom;
import com.ours.userservice.controller.from.RoleFrom;
import com.ours.userservice.controller.from.StaffFrom;
import com.ours.userservice.mapper.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    private StaffMapper staffMapper;
    @Resource
    private PermissionMapper permissionMapper;
    @Resource
    private DepartmentMapper departmentMapper;
    @Resource
    private DesignerMapper designerMapper;
    @Resource
    private StaffRoleMapper staffRoleMapper;
    @Resource
    private StaffDepMapper staffDepMapper;

    /**
     * 登录请求
     *
     * @param username 用户名
     * @param password 密码
     * @param session  session
     * @return
     */
    @RequestMapping("login")
    @CrossOrigin
    public Staff userLogin(String username, String password, HttpSession session) {
        System.out.println(username);
        System.out.println(password);
        //根据员工输入的电话号码及密码获得该员工信息
        Staff staff = staffMapper.selectPhoneAndPassword(username, password);
        System.out.println(staff);
        if (staff != null) {
            //将员工对象添加进session中  staff
            session.setAttribute("staff", staff);
            //获取员工id
//            Integer id = staff.getId();
            String jobNumber = staff.getJobNumber();
            //根据员工id查询出该员工的所有权限信息
            List<Permission> permissionList = permissionMapper.selectStaffAllPermission(jobNumber);
            //将登陆成功的员工权限添加进session中保存
            session.setAttribute("permission", permissionList);
            System.out.println(permissionList);
        }
        return staff;
    }

    /**
     * 获取员工信息
     *
     * @return
     */
    @RequestMapping("getAllStaff")
    @CrossOrigin
    public List<Object> getAllStaff() {
        System.out.println("getAllStaff请求进来了");
        //请求进来首先查出所有的员工信息
        List<Staff> staffList = staffMapper.selectAllStaff();
        System.out.println("所有的员工信息集合：" + staffList);
        //查出所有的设计师信息
        List<Designer> designersList = designerMapper.selectAllDesigner();
        System.out.println("所有的设计师信息集合：" + designersList);
        //创建一个集合用于存储所有员工需要展示信息
        List<Object> staffAndDesignerList = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        //遍历员工对象集合，根据员工工号查到所有员工的部门信息
        for (int i = 0; i < staffList.size(); i++) {
            //获取员工id
            Staff staff = staffList.get(i);
            Date joinDate = staff.getJoinDate();
            Date dismissionDate = staff.getDismissionDate();
            String joinFormat = sdf.format(joinDate);
            String jobNumber = staff.getJobNumber();
            //根据员工工号查到所有员工的部门信息
            Department department = departmentMapper.selectStaffDepartmentByDepId(jobNumber);
            System.out.println("员工" + staff.getStaffName() + "属于" + department.getDepName());
            //创建一个展示员工对象,并赋值
            if (dismissionDate != null) {
                String dismissionFormat = sdf.format(dismissionDate);
                StaffFrom staffFrom = new StaffFrom("staff", staff.getJobNumber(), staff.getStaffName(), department.getDepName(), staff.getPhone(), staff.getRoleName(), joinFormat, staff.getStatus(), dismissionFormat);
                staffAndDesignerList.add(staffFrom);
            } else {
                StaffFrom staffFrom = new StaffFrom("staff", staff.getJobNumber(), staff.getStaffName(), department.getDepName(), staff.getPhone(), staff.getRoleName(), joinFormat, staff.getStatus(), null);
                staffAndDesignerList.add(staffFrom);
            }
        }
        //遍历设计师集合，根据设计师id找到每个设计师对应的部门,并将设计师要展示的信息赋值添加到集合中
        for (int i = 0; i < designersList.size(); i++) {
            Designer designer = designersList.get(i);
            String designerJob = designer.getDesignerJob();
            Date joinData = designer.getJoinData();
            Date dismissionDate = designer.getDismissionDate();
            String joinFormat = sdf.format(joinData);
            Department department = departmentMapper.selectStaffDepartmentByDepId(designerJob);
            System.out.println("设计师：" + designer.getDesignerName() + "属于：" + department.getDepName());
            if (dismissionDate != null) {
                String dismissionFormat = sdf.format(dismissionDate);
                StaffFrom staffFrom = new StaffFrom("designer", designer.getDesignerJob(), designer.getDesignerName(), department.getDepName(), designer.getDesignerPhone(), designer.getRoleName(), joinFormat, designer.getDesignerStatus(), dismissionFormat);
                staffAndDesignerList.add(staffFrom);
            } else {
                StaffFrom staffFrom = new StaffFrom("designer", designer.getDesignerJob(), designer.getDesignerName(), department.getDepName(), designer.getDesignerPhone(), designer.getRoleName(), joinFormat, designer.getDesignerStatus(), null);
                staffAndDesignerList.add(staffFrom);
            }
        }
        System.out.println("所有的员工信息以及设计师信息:" + staffAndDesignerList);
        return staffAndDesignerList;
    }

    /**
     * 获取所有员工的部门信息
     *
     * @param kind
     * @return
     */
    @RequestMapping("getDepartmentName")
    @CrossOrigin
    public List<Object> getDepartmentName(String kind) {
        System.out.println("当前传过来的员工类型为：" + kind);
        System.out.println("getRoleName请求进来了");
        List<Department> depName = departmentMapper.getDepName();
        List<Object> departmentList = new ArrayList<>();
        for (int i = 0; i < depName.size(); i++) {
            Department department = depName.get(i);
            //判断员工不是设计师
            if (kind.equals("staff")) {
                if (department.getDepId().equals("ZSLM-SJ")) {
                    DepartmentFrom departmentFrom = new DepartmentFrom(department.getDepId(), department.getDepName(), true);
                    departmentList.add(departmentFrom);
                } else {
                    DepartmentFrom departmentFrom = new DepartmentFrom(department.getDepId(), department.getDepName(), false);
                    departmentList.add(departmentFrom);
                }
            } else {
                if (department.getDepId().equals("ZSLM-SJ")) {
                    DepartmentFrom departmentFrom = new DepartmentFrom(department.getDepId(), department.getDepName(), false);
                    departmentList.add(departmentFrom);
                } else {
                    DepartmentFrom departmentFrom = new DepartmentFrom(department.getDepId(), department.getDepName(), true);
                    departmentList.add(departmentFrom);
                }
            }
        }
        System.out.println(departmentList);
        return departmentList;
    }

    /**
     * 获取所有员工的员工职级
     *
     * @param kind
     * @return
     */
    @RequestMapping("getRoleName")
    @CrossOrigin
    public List<Object> getRoleName(String kind) {
        System.out.println("getRoleName请求中传过来的kind值为" + kind);
        //获取所有的员工职级
        List<StaffRole> roleName = staffRoleMapper.getRoleName();
        System.out.println(roleName);
        //创建一个空集合，用于存员工职级信息
        List<Object> roleNameList = new ArrayList<>();
        for (int i = 0; i < roleName.size(); i++) {
            StaffRole staffRole = roleName.get(i);
            RoleFrom roleFrom = new RoleFrom(staffRole.getStaffRoleName(), staffRole.getStaffRoleValue(), false);
            roleNameList.add(roleFrom);
        }
        return roleNameList;
    }

    /**
     * 修改员工信息
     *
     * @param departName 员工部门
     * @param roleName   员工职级
     * @param value1     离职时间
     * @param statu      员工状态
     */
    @RequestMapping("updateStaff")
    @CrossOrigin
    public StaffFrom updateStaff(String kind, String jobNumber, String departName, String roleName, String value1, String statu) {
        System.out.println("updateStaff请求进来了");
        System.out.println("要修改的员工为：" + kind);
        System.out.println("要修改的职级为：" + roleName);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println("离职时间为：" + value1);
        Date parse = null;
        String format = null;
        System.out.println("判断离职日期是否为空串" + !"".equals(value1.trim()));
        //判断是修改的是设计师还是其他员工
        if (kind.equals("staff")) {
            //员工离职时候将员工离职时间添加进数据库，并修改状态为离职
            if (!"".equals(value1.trim())) {
                try {
                    parse = sdf.parse(value1);
                    System.out.println("修改员工的离职时间为：" + parse);
                    //员工离职，修改员工状态，将员工状态改为已经离职
                    staffMapper.updateByStatusAndDismissionDate(statu, parse, jobNumber);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("修改员工职级为：" + roleName);
                System.out.println("修改员工所在的部门为：" + departName);
                staffDepMapper.updateStaffDep(departName, jobNumber);
                staffMapper.updateRoleName(roleName, jobNumber);
                System.out.println("修改成功");
            }
            //根据员工的工号查到修改后的员工的部门
            Staff staff = staffMapper.selectJobNumber(jobNumber);
            Date joinDate = staff.getJoinDate();
            Date dismissionDate = staff.getDismissionDate();
            return getStaffFrom(jobNumber, sdf, staff, joinDate, dismissionDate);
        } else {
            //员工离职时候将员工离职时间添加进数据库，并修改状态为离职
            if (!"".equals(value1.trim())) {
                try {
                    parse = sdf.parse(value1);
                    System.out.println("修改员工的离职时间为：" + parse);
                    //修改设计师的状态和离职时间
                    designerMapper.updateDesignerStatus(statu, parse, jobNumber);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("修改员工职级为：" + roleName);
                //设计设计师的职级
                designerMapper.updateRoleName(roleName, jobNumber);
                System.out.println("修改员工所在的部门为：" + departName);
                staffDepMapper.updateStaffDep(departName, jobNumber);
                System.out.println("设计师信息修改成功");
            }
            Designer designer = designerMapper.selectJobNumber(jobNumber);
            Date joinData = designer.getJoinData();
            Date dismissionDate = designer.getDismissionDate();
            return getStaffFrom(jobNumber, sdf, designer, joinData, dismissionDate);
        }
    }


    private StaffFrom getStaffFrom(String jobNumber, SimpleDateFormat sdf, Staff staff, Date joinDate, Date dismissionDate) {
        Department department = departmentMapper.selectStaffDepartmentByDepId(jobNumber);
        String joinFormat = sdf.format(joinDate);
        //创建一个展示员工对象,并赋值
        if (dismissionDate != null) {
            String dismissionFormat = sdf.format(dismissionDate);
            System.out.println("修改后的员工职级为：" + staff.getRoleName());
            StaffFrom staffFrom = new StaffFrom("staff", staff.getJobNumber(), staff.getStaffName(), department.getDepName(), staff.getPhone(), staff.getRoleName(), joinFormat, staff.getStatus(), dismissionFormat);
            return staffFrom;
        } else {
            StaffFrom staffFrom = new StaffFrom("staff", staff.getJobNumber(), staff.getStaffName(), department.getDepName(), staff.getPhone(), staff.getRoleName(), joinFormat, staff.getStatus(), null);
            return staffFrom;
        }
    }
    private StaffFrom getStaffFrom(String jobNumber, SimpleDateFormat sdf, Designer designer, Date joinDate, Date dismissionDate) {
        Department department = departmentMapper.selectStaffDepartmentByDepId(jobNumber);
        String joinFormat = sdf.format(joinDate);
        //创建一个展示员工对象,并赋值
        if (dismissionDate != null) {
            String dismissionFormat = sdf.format(dismissionDate);
            System.out.println("修改后的员工职级为：" + designer.getRoleName());
            StaffFrom staffFrom = new StaffFrom("designer", designer.getDesignerJob(), designer.getDesignerName(), department.getDepName(), designer.getDesignerPhone(), designer.getRoleName(), joinFormat, designer.getDesignerStatus(), dismissionFormat);
            return staffFrom;
        } else {
            StaffFrom staffFrom = new StaffFrom("designer", designer.getDesignerJob(), designer.getDesignerName(), department.getDepName(), designer.getDesignerPhone(), designer.getRoleName(), joinFormat, designer.getDesignerStatus(), null);
            return staffFrom;
        }
    }
}
