package com.ours.userapp.mapper;

import com.ours.entity.Adjustment;
import com.ours.entity.Designer;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface DesignerMapper {
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

    List<Map<String, Object>> queryUserList(Integer des_id);

    int changNotIn(Integer id);

    int changIn(Integer id);

    List<Integer> getUsersId(Integer des_id);

    String getUsertitle();

    String getDesignertitle();

    Map<String, Object> queryLastChat(String s, String s1);

    List<Map<String, Object>> queryOneUser(String key, Integer des_id);

    List<Integer> getUsersIdByName(String key, Integer des_id);

    Designer selectByTel(String tel);

    Designer selectByTelAndPassword(String tel, String password);

    List<Map<String, Object>> getChatList(String s, String s1);

    String qureyUrl(Integer user_id);

    String qureyDesUrl(Integer des_id);

    Integer queryNumNotstatus(String s, String s1);

    Integer changeChatListStatus(String s, String s1);

    Map<String, Object> getMySlary(String designerJob);

    List<Map<String, Object>> getStepList(Integer des_id);

    Map<String, Object> getStep(Integer contractid);

    List<Integer> getDecDesList(Integer des_id);

    List<Map<String, Object>> queryDesList(Integer des_id);

    String getDecorationtitle();

    List<Map<String, Object>> getHome(int i);

    List<String> getAllUsername(Integer s,String keyword);

    List<Integer> getUsersIdRe(Integer des_id, String username);

    List<Map<String, Object>> queryUserListRe(Integer des_id, String username);

    List<Adjustment> getAdjustment(String newString, String jobnum);

    List<Integer> getDessID(Integer user_id);

}