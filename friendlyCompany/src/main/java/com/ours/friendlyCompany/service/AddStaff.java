package com.ours.friendlyCompany.service;

import com.ours.friendlyCompany.entity.Designer;
import com.ours.friendlyCompany.entity.Staff;
import com.ours.friendlyCompany.entity.StaffDep;

import java.util.List;
import java.util.Map;

public interface AddStaff {
    List<Map<String, Object>> getAllDepartments();

    String queryMaxDesigner_name();

    List<Map<String, Object>> queryAllLevel();

    int insertStaff(Staff staff);

    Staff queryByIdcard(String id_card);

    int insertStaffDep(StaffDep staffDep);

    Designer queryDesignerByIdcard(String id_card);

    int insertDesigner(Designer designer);
}
