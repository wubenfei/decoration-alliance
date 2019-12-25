package com.ours.friendlyCompany.controller;

import com.ours.friendlyCompany.dao.FriendlycompanyMapper;
import com.ours.friendlyCompany.entity.DecorationCompany;
import com.ours.friendlyCompany.service.FriendlycompanyService;
import com.ours.friendlyCompany.utils.FtpUtil;
import com.ours.friendlyCompany.utils.IDUtils;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

@RestController
@CrossOrigin
public class FriendlyCompanyController {
    @Value("${FTP.ADDRESS}")
    private String host;
    // 端口
    @Value("${FTP.PORT}")
    private int port;
    // ftp用户名
    @Value("${FTP.USERNAME}")
    private String userName;
    // ftp用户密码
    @Value("${FTP.PASSWORD}")
    private String passWord;
    // 文件在服务器端保存的主目录
    @Value("${FTP.BASEPATH}")
    private String basePath;
    // 访问图片时的基础url
    @Value("${IMAGE.BASE.URL}")
    private String baseUrl;
    @Autowired
    private FriendlycompanyService fcm;
    //规定文件格式
    private List<String> sList = Arrays.asList("doc", "docx", "pdf");

    //@Cacheable(cacheNames="getFriendlyCompanyKind")
    @GetMapping("/getFriendlyCompanyKind")
    public List<Map<String, Object>> getFriendlyCompanyKind(HttpServletResponse response) {

        //头
        //头
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Allow-Methods", "*");
        response.setHeader("Access-Control-Allow-Headers", "Content-Type,Access-Token");
        response.setHeader("Access-Control-Expose-Headers", "*");
        return fcm.queryAllValue();
    }

    //创建新的装修团队
    @RequestMapping("/creatDecorationCompanyAndUpload")
    public String creatDecorationCompany(String friendly_company_kind,
                                         String company_name,
                                         String company_address,
                                         String company_phone,
                                         String company_rephone,
                                         String company_idcard,
                                         String company_idname,
                                         Date intime,
                                         MultipartFile upload,
                                         String uploadName
    ) throws IOException {

        System.out.println("文件名字:" + uploadName);
        if (friendly_company_kind.equals("装修团队")) {
            //插入数据
            DecorationCompany decorationCompany = new DecorationCompany();
            decorationCompany.setCompanyName(company_name);
            decorationCompany.setCompanyAddress(company_address);
            decorationCompany.setCompanyPhone(company_phone);
            decorationCompany.setCompanyRephone(company_rephone);
            decorationCompany.setCompanyIdcard(company_idcard);
            decorationCompany.setCompanyIdname(company_idname);
            decorationCompany.setCompanyIntime(intime);

            //1获取原始文件名uploadName
            //2使用IDUtils工具类生成新的文件名，新文件名 = newName + 文件后缀
            String newName = IDUtils.genImageName();
            //生成一串数字名字,不使用原名
            String endName = uploadName.substring(uploadName.lastIndexOf("."));
            if (!sList.contains(endName)) {
                return "创建失败,请上传doc/docx/pdf格式的资质文档";
            }
            newName = newName + uploadName.substring(uploadName.lastIndexOf("."));
            System.out.println("新名字:" + newName);
            //3生成文件在服务器端存储的子目录
            String filePath = new DateTime().toString("/yyyy/MM/dd");
            String company_url = baseUrl + "zizhi" + filePath + "/" + newName;
            System.out.println("路径:" + company_url);
            decorationCompany.setCompanyUrl(company_url);
            //插入数据库
            int i = fcm.insertAcompany(decorationCompany);
            //4获取上传的io流
            InputStream input = upload.getInputStream();
            //5调用FtpUtil工具类进行上传
            boolean result = FtpUtil.uploadFile(host, port, userName, passWord, basePath, filePath, newName, input);
            if (result) {
                return "success";
            } else {
                return "资质文件上传失败";
            }
        } else {
            return "请选择入驻团队类型!";
        }
    }

    //资质文档上传
    // @RequestMapping("/upload")
    public String upload() {
        return "1";
    }
}
