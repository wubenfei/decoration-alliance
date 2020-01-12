package com.ours.userappservice.controller;

import com.ours.entity.Designer;
import com.ours.userappservice.controller.from.DesignerImgFrom;
import com.ours.userappservice.mapper.DesignerMapper;
import com.ours.userappservice.service.DesignerEffectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class DesignerController {
    @Autowired
    private DesignerEffectService dfs;
    @Autowired
    private DesignerMapper designerMapper;

    /**
     * 首页展示设计师成果
     *
     * @return
     */
    @RequestMapping("getDesignerEffect")
    @CrossOrigin
    public List<Map<String, Object>> getDesigner() {
        List<List<Map<String, Object>>> lists = getLists();
        System.out.println(lists);
        //新建一个list<Map<String,Object>>
        List<Map<String, Object>> effectList = new ArrayList<>();

        if (!lists.isEmpty()) {
            for (List<Map<String, Object>> m1 : lists) {
                System.out.println("m1中的数据为：" + m1);
                if (m1.size() >= 1) {
                    //取长度
                    int length = m1.size();
                    for (int i = 0; i < length; i++) {
                        //取随机单
                        int rand = (int) (Math.random() * 4) + 1;
                        System.out.println("随机数为：" + rand);
                        Map<String, Object> map = m1.get(i);
                        //get("...img"+(1-4)随机数)
                        //get("des_id")
                        String imgUrl = (String) map.get("designer_img" + rand);
                        while (imgUrl == null) {
                            int randIndex = (int) (Math.random() * 4) + 1;
                            imgUrl = (String) map.get("designer_img" + randIndex);
                        }
                        Integer designerId = (Integer) map.get("designer_id");
                        System.out.println("随机得到的图片地址为：" + imgUrl);
                        System.out.println("设计师id" + designerId);

                        //得到设计师的名字
                        Designer designer = designerMapper.selectByPrimaryKey(designerId);
                        String designerName = designer.getDesignerName();
                        //新建map
                        HashMap<String, Object> hashMap = new HashMap();
                        hashMap.put("url", imgUrl);
                        hashMap.put("designerKey", map.get("id"));
                        hashMap.put("designerId", designerId);
                        hashMap.put("designerName", designerName);
                        //{ ,}
                        //存入list
                        effectList.add(hashMap);
                    }
                } else {
                    return null;
                }
            }
        }
        return effectList;
    }
    //点击效果展示下面的图片或者相关信息
    @RequestMapping("getDesignerImgsByUserId")
    @CrossOrigin
    public List<DesignerImgFrom> getDesignerImgsByUserId(Integer userId) {
        System.out.println("getDesignerImgsByUserId请求进来了");
        System.out.println("userId的值为：" + userId);
        List<DesignerImgFrom> imgFromList = new ArrayList<>();
        //获取所有的设计师成果信息
        List<List<Map<String, Object>>> lists = getLists();
        //新建一个list<Map<String,Object>>
        List<Map<String, Object>> effectList = new ArrayList<>();
        if (!lists.isEmpty()) {
            for (List<Map<String, Object>> m1 : lists) {
                if (m1.size() >= 1) {
                    int length = m1.size();
                    for (int i = 0; i < length; i++) {
                        if (m1.get(i).get("designer_id") == userId) {
                            effectList.add(m1.get(i));
                            break;
                        }
                    }
                }
            }
        }
        getDesignerImg(effectList, imgFromList);
        DesignerImgFrom designerImgFrom = new DesignerImgFrom();
        return imgFromList;
    }

    //点击效果展示根据用户点击的下标显示对象的效果图片
    @RequestMapping("getDesignerImgs")
    @CrossOrigin
    public List<DesignerImgFrom> getDesignerImgs(Integer designerKey) {
        System.out.println("getDesignerImgs请求进来了");
        System.out.println("designerKey的值为：" + designerKey);
        List<List<Map<String, Object>>> lists = getLists();
        //新建一个list<Map<String,Object>>
        List<Map<String, Object>> effectList = new ArrayList<>();
        if (!lists.isEmpty()) {
            for (List<Map<String, Object>> m1 : lists) {
                if (m1.size() >= 1) {
                    int length = m1.size();
                    for (int i = 0; i < length; i++) {
                        if (m1.get(i).get("id") == designerKey) {
                            effectList.add(m1.get(i));
                            break;
                        }
                    }
                }
            }
        }
        HashMap<String, Object> ImgHashMap = new HashMap<>();
        List<DesignerImgFrom> designerImgFromList = new ArrayList<>();
        getDesignerImg(effectList, designerImgFromList);
        System.out.println("需要展示的图片：" + designerImgFromList);
        return designerImgFromList;
    }

    //将要展示的效果图片转换为所需要的格式
    private void getDesignerImg(List<Map<String, Object>> effectList, List<DesignerImgFrom> designerImgFromList) {
        for (int i = 0; i < effectList.size(); i++) {
            Map<String, Object> designerMap = effectList.get(i);
            Set<Map.Entry<String, Object>> entries = designerMap.entrySet();
            Iterator<Map.Entry<String, Object>> iterator = entries.iterator();
            int index = -1;
            while (iterator.hasNext()) {
                Map.Entry<String, Object> next = iterator.next();
                String key = next.getKey();
                if (key.contains("designer_img")) {
                    index++;
                    String value = (String) next.getValue();
                    DesignerImgFrom designerImgFrom = new DesignerImgFrom(index, value);
                    designerImgFromList.add(designerImgFrom);
                }
            }
        }
    }

    //获取所有的设计师成果数据的方法
    private List<List<Map<String, Object>>> getLists() {
        List<List<Map<String, Object>>> lists = new ArrayList<>();
        List<Integer> values = new ArrayList<>();
        List<Map<String, Object>> maps = dfs.getDesignerEffects();
        if (!maps.isEmpty()) {
            for (Map<String, Object> m : maps) {
                Set<Map.Entry<String, Object>> set = m.entrySet();
                Iterator<Map.Entry<String, Object>> iterator = set.iterator();
                String removeKey = null;
                while (iterator.hasNext()) {
                    Map.Entry<String, Object> next = iterator.next();
                    String key = next.getKey();
                    if (key.contains("designer_img")) {
                        String img = (String) next.getValue();
                        if (img == null || img.trim().length() == 0) {
                            removeKey = key;
                        }
                    }
                    if (key.equals("designer_id")) {
                        Integer value = (Integer) next.getValue();
                        System.out.println("des-value:" + value);
                        if (values.isEmpty()) {
                            values.add(value);
                            ArrayList<Map<String, Object>> listMaps1 = new ArrayList<>();
                            listMaps1.add(m);
                            lists.add(listMaps1);
                        } else {
                            if (values.contains(value)) {
                                int index = -1;
                                for (int i = 0; i < values.size(); i++) {
                                    if (values.get(i).equals(value)) {
                                        index = i;
                                        System.out.println("index:" + index);
                                        break;
                                    }
                                }
                                (lists.get(index)).add(m);
                            } else {
                                values.add(value);
                                ArrayList<Map<String, Object>> listMaps3 = new ArrayList<>();
                                listMaps3.add(m);
                                lists.add(listMaps3);
                            }
                        }
                    }
                }
                m.remove(removeKey);
            }
        }
        return lists;
    }
}
