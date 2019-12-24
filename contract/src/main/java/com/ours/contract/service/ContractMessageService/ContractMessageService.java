package com.ours.contract.service.ContractMessageService;

import com.ours.contract.entity.DecorationCompany;
import com.ours.contract.entity.Designer;
import com.ours.contract.entity.Staff;
import com.ours.contract.entity.User;

import java.util.List;
import java.util.Map;

public interface ContractMessageService {
    List<Map<String, Object>> queryContractMessage(int from, int pageSize);

    User getUsername(int user_id);

    Designer getDesignername(int designer_id);

    DecorationCompany getDecorationCompany(int decoration_company_id);

    Staff getStaff(int staff_id);

    Integer queryContractMessageAll();

    int updateStatusById(int id, String status);

    List<Map<String, Object>> queryContractTimeById(String num);

    List<Map<String, Object>> queryAll(int from, int pageSize);

    int queryAllCount();

    List<Map<String, Object>> queryBySql(String toString);

    int queryBySql1(String toString);
}
