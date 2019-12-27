package com.ours.contract.controller;

import com.ours.contract.utils.FtpUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DownloadController {
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
    //测试下载
    /**
     * Description: 从FTP服务器下载文件
     *
     * @param host       FTP服务器ip
     * @param port       FTP服务器端口
     * @param username   FTP登录账号
     * @param password   FTP登录密码
     * @param remotePath FTP服务器上的相对路径
     * @param fileName   要下载的文件名
     * @param localPath  下载后保存到本地的路径
     * @return
     */
   /* @GetMapping("/testdown")
    public boolean testdown(){
        return FtpUtil.downloadFile(host,port,userName,passWord,basePath,);
    }*/



}
