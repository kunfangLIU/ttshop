/*
import com.lkf.common.util.FtpUtil;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

*/
/**
 * User: Administrator
 * Date: 2017/10/30
 * Time: 19:49
 * Version:V1.0
 *//*

public class FtpUploadTest {
    @Test
    public void testFtpUpload() throws IOException {
        //创建FTPClient客户端
        FTPClient ftpClient = new FTPClient();
        //创建FTP连接
        ftpClient.connect("10.31.166.46",21);
        //登录
        ftpClient.login("ftpuser","lkfwjx");
        //读取本地文件
        FileInputStream fileInputStream = new FileInputStream(new File("E:\\ns.jpg"));
        //配置上传参数
        ftpClient.changeWorkingDirectory("/home/ftpuser/www/images");
        //表示以二进制方式上传
        ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
        //上传文件
        ftpClient.storeFile("hello.jpg",fileInputStream);
        //关闭连接
        fileInputStream.close();
        ftpClient.logout();

    }
    @Test
    public void testFtpUtil() throws FileNotFoundException {
        FileInputStream fileInputStream = new FileInputStream(new File("E:\\10.jpg"));
        FtpUtil.uploadFile("10.31.166.46",21,"ftpuser","lkfwjx","/home/ftpuser/www/images","/2017/10/30","hello2.jpg",fileInputStream);
    }
}
*/
