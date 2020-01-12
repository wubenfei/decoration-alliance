package com.ours.userapp.service.forstaffService;

import java.util.List;
import java.util.Map;

public interface Forstaff_chatListService {
    List<Map<String, Object>> getChatList(String s, String s1);

    String qureyUrl(Integer user_id);

    String qureyDesUrl(Integer des_id);

    Integer changeChatListStatus(String s, String s1);
}
