package com.ours.userapp.controller;

import com.ours.userapp.service.forstaffService.Forstaff_uploadImgsService;
import com.ours.userapp.utils.FtpUtil;
import com.ours.userapp.utils.IDUtils;
import lombok.AllArgsConstructor;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

@RestController
public class Forstaff_uploadImgs {
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
    private Forstaff_uploadImgsService guis;

    //规定图片文件格式
    private List<String> sList = Arrays.asList(".BMP", ".JPG", ".PNG", ".TIF", ".GIF", ".PCX",
            ".TGA", ".EXIF", ".FPX", ".SVG", ".PSD", ".CDR", ".PCD", ".DXF", ".UFO", ".EPS", ".AI",
            ".RAW", ".JPEG", ".wmf", ".WEBP", ".bmp", ".jpg", ".png", ".tif", ".gif", ".pcx",
            ".tga", ".exif", ".fpx", ".svg", ".psd", ".cdr", ".pcd", ".dxf", ".ufo", ".eps", ".ai",
            ".raw", ".wmf", ".webp", ".jpeg");

    @PostMapping("/uploadImg")
    private Map<String, Object> uploadImg(MultipartFile upload) throws IOException {
        System.out.println("接收上传");
        Map<String, Object> map = new HashMap<>();
        //获取原始文件名uploadName
        String uploadName = upload.getOriginalFilename();
        System.out.println("getOriginalFilename:" + uploadName);

        //使用IDUtils工具类生成新的文件名，新文件名 = newName + 文件后缀
        String newName = IDUtils.genImageName();
        //生成一串数字名字,不使用原名
        String endName = uploadName.substring(uploadName.lastIndexOf("."));
        System.out.println("endName:" + endName);
        if (!sList.contains(endName)) {
            map.put("error", "创建失败,请上传图片格式");
            return map;
        }
        newName = newName + uploadName.substring(uploadName.lastIndexOf("."));
        System.out.println("新名字:" + newName);
        //3生成文件在服务器端存储的子目录
        String filePath = new DateTime().toString("/yyyy/MM/dd");
        String img_url = baseUrl + "jiandu" + filePath + "/" + newName;
        System.out.println("路径:" + img_url);
        //保存路径,插入数据库

        //4获取上传的io流
        InputStream input = upload.getInputStream();
        //5调用FtpUtil工具类进行上传
        boolean result = FtpUtil.uploadFile(host, port, userName, passWord, basePath, filePath, newName, input);
        input.close();
        if (result) {
            map.put("img_url", img_url);
            return map;
        } else {
            map.put("warning", "监督文件/聊天图片上传失败");
            return map;
        }
    }

    @PostMapping("/saveImg")
    public Integer saveImg(Integer userid,String links) {
        //按合同id插入监督图片
        Date date = new Date();
        return guis.saveImg(userid,links);
    }
}
