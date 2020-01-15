package com.ours.userservice.service;

import com.ours.entity.Designer;

import java.util.Date;
import java.util.List;

public interface DesignerService{


    int deleteByPrimaryKey(Integer id);

    int insert(Designer record);

    int insertSelective(Designer record);

    Designer selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Designer record);

    int updateByPrimaryKey(Designer record);

    List<Designer> selectAllDesigner();

    int updateDesignerStatus(String status, Date dismissionDate, String jobNumber);

    int updateRoleName(String roleName, String jobNumber);

    Designer selectJobNumber(String jobNumber);

    Designer selectByJobNumberAndPassword(String jobNumber, String password);
}
