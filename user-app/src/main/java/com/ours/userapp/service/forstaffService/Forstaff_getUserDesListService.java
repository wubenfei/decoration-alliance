package com.ours.userapp.service.forstaffService;

import java.util.List;
import java.util.Map;

public interface Forstaff_getUserDesListService {
    List<Map<String, Object>> queryUserList(Integer des_id);

    int changNotIn(Integer id);

    int changIn(Integer id);

    List<Integer> getUsersId(Integer des_id);

    String getUsertitle();

    String getDesignertitle();

    Map<String, Object> queryLastChat(String s, String s1);

    List<Map<String, Object>> queryOneUser(String key, Integer des_id);

    List<Integer> getUsersIdByName(String key, Integer des_id);

    Integer queryNumNotstatus(String s, String s1);

    List<Integer> getDessId(Integer user_id);

    List<Map<String, Object>> queryDesList(Integer user_id);

    List<Integer> getUsersIdRe(Integer userId, String username);

    List<Map<String, Object>> queryUserListRe(Integer userId, String username);

    List<String> getAllUsername(Integer userId, String keyword);
}
