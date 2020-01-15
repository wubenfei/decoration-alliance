package com.ours.friendlyCompany.controller;

import com.ours.friendlyCompany.entity.DecorationCompany;
import com.ours.friendlyCompany.entity.Designer;
import com.ours.friendlyCompany.service.FriendlycompanyService;
import com.ours.friendlyCompany.utils.FtpUtil;
import com.ours.friendlyCompany.utils.IDUtils;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

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
    private List<String> sList = Arrays.asList(".doc", ".docx", ".pdf");

    /**
     * 得到所有的入驻类型:只有装修团队
     *
     * @param response
     * @return
     */
    @GetMapping("/getFriendlyCompanyKind")
    public List<Map<String, Object>> getFriendlyCompanyKind(HttpServletResponse response) {
        return fcm.queryAllValue();
    }

    /**
     * 创建新的装修团队
     * @param friendly_company_kind 装修团队
     * @param company_name 团队名
     * @param company_address 团队地址
     * @param company_phone 团队电话
     * @param company_rephone 团队备用电话
     * @param company_idcard 团队责任人身份证
     * @param company_idname 团队责任人姓名
     * @param intime 入驻时间
     * @param upload 上传的文件
     * @param uploadName 上传文件的名字:用于取后缀
     * @return 语句
     * @throws IOException 抛异常
     */
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
    /**
     * Auth: MrW
     * 根据手机号和密码查询装修公司
     */
    @RequestMapping("getDecorationCompany")
    public DecorationCompany getDC(String tel, String password){
        System.out.println("getDecorationCompany:"+tel+password);
        DecorationCompany decorationCompany = fcm.selectByTelAndPassword(tel,password);
        return decorationCompany;
    }
    @RequestMapping("getDesigner")
    public Designer getDesigner(String tel,String password){
        System.out.println("getDesigner:"+tel+password);
        Designer designer = fcm.selectDesignerByTelAndPassword(tel,password);
        return designer;
    }
}
