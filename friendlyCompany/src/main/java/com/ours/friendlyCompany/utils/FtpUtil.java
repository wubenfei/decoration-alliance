package com.ours.friendlyCompany.utils;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;

import java.io.*;

/**
 * ftp上传下载工具类
 *
 * @author zhu
 */
public class FtpUtil {

    /**
     * Description: 向FTP服务器上传文件
     *
     * @param host     FTP服务器ip
     * @param port     FTP服务器端口
     * @param username FTP登录账号
     * @param password FTP登录密码
     * @param basePath FTP服务器基础目录,/home/ftpuser/images
     * @param filePath FTP服务器文件存放路径。例如分日期存放：/2018/05/28。文件的路径为basePath+filePath
     * @param filename 上传到FTP服务器上的文件名
     * @param input    输入流
     * @return 成功返回true，否则返回false
     */
    public static boolean uploadFile(String host, int port, String username, String password, String basePath,
                                     String filePath, String filename, InputStream input) {
        boolean result = false;
        FTPClient ftp = new FTPClient();
        try {
            int reply;
            ftp.connect(host, port);// 连接FTP服务器
            // 如果采用默认端口，可以使用ftp.connect(host)的方式直接连接FTP服务器
            ftp.login(username, password);// 登录
            System.out.println("ftp" + username + "登录成功");
            reply = ftp.getReplyCode();
            if (!FTPReply.isPositiveCompletion(reply)) {
                ftp.disconnect();
                return result;
            }
            //切换到上传目录
            if (!ftp.changeWorkingDirectory(basePath + filePath)) {
                System.out.println("目录:" + filePath);
                System.out.println("基础目录:" + basePath);
                //如果目录不存在创建目录
                String[] dirs = filePath.split("/");
                String tempPath = basePath;
                for (String dir : dirs) {
                    if (null == dir || "".equals(dir)) continue;
                    tempPath += "/" + dir;
                    System.out.println("tempPath:" + tempPath);

                    if (!ftp.changeWorkingDirectory(tempPath)) {
                        if (!ftp.makeDirectory(tempPath)) {
                            System.out.println("!ftp.makeDirectory(tempPath)");
                            return result;
                        } else {
                            ftp.changeWorkingDirectory(tempPath);
                        }
                    }
                }
            }
            //设置为被动模式
            ftp.enterLocalPassiveMode();
            //设置上传文件的类型为二进制类型
            ftp.setFileType(FTP.BINARY_FILE_TYPE);
            //上传文件
            if (!ftp.storeFile(filename, input)) {
                System.out.println("上传:" + filename + "失败" + input);
                return result;
            }
            input.close();
            ftp.logout();
            System.out.println("上传成功,ftp退出登录");
            result = true;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (ftp.isConnected()) {
                try {
                    ftp.disconnect();
                } catch (IOException ioe) {
                }
            }
        }
        return result;
    }

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
    public static boolean downloadFile(String host, int port, String username, String password, String remotePath,
                                       String fileName, String localPath) {
        boolean result = false;
        FTPClient ftp = new FTPClient();
        try {
            int reply;
            ftp.connect(host, port);
            // 如果采用默认端口，可以使用ftp.connect(host)的方式直接连接FTP服务器
            ftp.login(username, password);// 登录
            reply = ftp.getReplyCode();
            if (!FTPReply.isPositiveCompletion(reply)) {
                ftp.disconnect();
                return result;
            }
            ftp.changeWorkingDirectory(remotePath);// 转移到FTP服务器目录
            FTPFile[] fs = ftp.listFiles();
            for (FTPFile ff : fs) {
                if (ff.getName().equals(fileName)) {
                    File localFile = new File(localPath + "/" + ff.getName());

                    OutputStream is = new FileOutputStream(localFile);
                    ftp.retrieveFile(ff.getName(), is);
                    is.close();
                }
            }

            ftp.logout();
            result = true;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (ftp.isConnected()) {
                try {
                    ftp.disconnect();
                } catch (IOException ioe) {
                }
            }
        }
        return result;
    }
	
	/*public static void main(String[] args) {
		try {  
	        FileInputStream in=new FileInputStream(new File("E:\\download\\image\\pic.jpg"));  
	        boolean flag = uploadFile("192.168.50.129", 21, "ftpuser", "ftpuser", "/home/ftpuser/images","/2018/05/28", "uppic.jpg", in);  
	        System.out.println(flag);  
	    } catch (FileNotFoundException e) {  
	        e.printStackTrace();  
	    }  
	}*/
}
