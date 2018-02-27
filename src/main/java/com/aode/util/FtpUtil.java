package com.aode.util;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * ftp 工具类
 * Created by 林智 on 2017/1/8.
 */

public class FtpUtil {
    //    tring host, int port, String username, String password
    // 连接ftp服务器的需要的信息
    private final static String HOST = "127.0.0.1"; //ftp服务器ip地址    119.23.15.24 是无法访问FTP的
    private final static int PORT = 21;                   //ftp端口
    private final static String USERNAME = "ftpuser";     //ftp用户名
    private final static String PASSWORD = "jm7259ftp";     //ftp密码

    // 动态图片的格式
    public final static String[] PICTURE_FORMAT = {".jpg", ".png"};

    // 服务器上的路径，该路径为所有文件的主路径，且必须在服务器上存在，否则上传失败
    private final static String BASE_PATH = "/home/ftpuser/jm";

    // 服务器上用户头像的路径
    public final static String HEAD_PORTRAIT_PATH = "headPortrait/";

    //服务器上酒店图片的路径
    public final static String HOTEL_PATH = "hotelPicture/";
/*
    public static void uploadHeadProtrait(MultipartFile headPortarit, User user, FTPClient ftp) {
        if (!headPortarit.isEmpty() && checkFileExt(getFileExt(headPortarit.getOriginalFilename()), PICTURE_FORMAT)) {
            String picture = null;
            String dataPath = new SimpleDateFormat("yyyy/MM/").format(new Date());
            try {
                picture = dataPath + uploadFile(ftp, BASE_PATH, HEAD_PORTRAIT_PATH + dataPath, headPortarit.getOriginalFilename(),
                        headPortarit.getInputStream());
                user.setUser_picture(picture);
            } catch (IOException e) {
                System.out.println("---------> HeadPortarit upload error");
                e.printStackTrace();
            }
        }
    }*/

    public static String uploadHotelPicture(MultipartFile multipartFile,FTPClient ftpClient){
        String picture_src = null;
        System.out.println(multipartFile.isEmpty()+"---------------------------> 1");
        System.out.println(checkFileExt(getFileExt(multipartFile.getOriginalFilename()),PICTURE_FORMAT)+"---------------------------------------> 2");
        if (!multipartFile.isEmpty() && checkFileExt(getFileExt(multipartFile.getOriginalFilename()),PICTURE_FORMAT)){
            System.out.println("进来了吗？---------------------------！");
            try {
                String dataPath = new SimpleDateFormat("yyyy/MM/").format(new Date());
                picture_src = dataPath + uploadFile(ftpClient,BASE_PATH,HOTEL_PATH + dataPath, multipartFile.getOriginalFilename(),multipartFile.getInputStream());
            }catch (IOException io){
                System.out.println("----- upload ftp picture error ----");
                io.printStackTrace();
            }
        }
        return  picture_src;
    }

    /**
     * Description: 向FTP服务器上传文件
     * @param ftp FTPClient 实例
     * @param basePath FTP服务器基础目录
     * @param filePath FTP服务器文件存放路径。例如分日期存放：/2015/01/01。文件的路径为basePath+filePath
     * @param fileName 上传到FTP服务器上的文件名
     * @param input 输入流
     * @return 成功返回true，否则返回false
     */
    public static String uploadFile(FTPClient ftp,String basePath, String filePath, String fileName, InputStream input) {
        String tempFilename = fileName;
        try {
            //切换到上传目录
            if (!ftp.changeWorkingDirectory(basePath + "/" + filePath)) {
                //如果目录不存在创建目录
                String[] dirs = filePath.split("/");
                String tempPath = basePath;
                for (String dir : dirs) {
                    if (null == dir || "".equals(dir)) continue;
                    tempPath += "/" + dir;
                    if (!ftp.changeWorkingDirectory(tempPath)) {
                        if (!ftp.makeDirectory(tempPath)) {
                            return null;
                        } else {
                            ftp.changeWorkingDirectory(tempPath);
                        }
                    }
                }
            }
            //设置上传文件的类型为二进制类型
            ftp.setFileType(FTP.BINARY_FILE_TYPE);
            //随机生成文件名，防重复
            fileName = UUID.randomUUID().toString() + fileName;
            //上传文件
            if (!ftp.storeFile(fileName, input)) {
                return null;
            }
            input.close();
//            result = true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileName.equals(tempFilename) ? null : fileName;
    }

    /**
     * Description: 从FTP服务器下载文件
     * @param remotePath FTP服务器上的相对路径
     * @param fileName 要下载的文件名
     * @param localPath 下载后保存到本地的路径
     * @return
     */
    public static boolean downloadFile(FTPClient ftp, String remotePath,
                                       String fileName, String localPath) {
        boolean result = false;
        try {
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
            result = true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }


    /**
     * Description:删除linux服务器上文件的方法
     * @param remotePath  FTP服务器上的相对路径
     * @param fileName 要删除的文件的文件名
     */
    public static boolean deleteFile(FTPClient ftp, String remotePath,
                                     String fileName){
        boolean result = false;
        if (!ftp.isConnected()) {
            return result;
        }
        try {
            // 参数的格式为  "/home/ftpuser/www/images/" + fileName
//            result = ftp.deleteFile(BASE_PATH + remotePath + "/" +fileName);
            result = ftp.deleteFile(new StringBuilder().append(BASE_PATH).append("/").append(remotePath).append(fileName).toString());
            System.out.println("========文件目录为：" + new StringBuilder().append(BASE_PATH).append("/").append(remotePath).append(fileName).toString());
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return result;
    }

    /**
     * 删除FTP上的文件
     * @param ftpDirAndFileName 路径开头不能加/，比如应该是test/filename1
     * @return
     */
    /*public boolean deleteFile(String ftpDirAndFileName) {
        if (!ftpClient.isConnected()) {
            return false;
        }
        try {
            return ftpClient.deleteFile(ftpDirAndFileName);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }*/

    /**
     * Description: 连接FTP服务器的方法
     */
    public static FTPClient open(){
        FTPClient ftp = new FTPClient();
        try {
            int reply;
            ftp.connect(HOST, PORT);// 连接FTP服务器
            // 如果采用默认端口，可以使用ftp.connect(host)的方式直接连接FTP服务器
            ftp.login(USERNAME, PASSWORD);// 登录
            reply = ftp.getReplyCode();
            if (!FTPReply.isPositiveCompletion(reply)) {
                ftp.disconnect();
                return null;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ftp;
    }

    /**
     * Description: 关闭资源
     * @param ftp FTPClient 实例
     */
    public static void close(FTPClient ftp) {
        if (ftp.isConnected()) {
            try {
                ftp.logout();
                ftp.disconnect();
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }
    }

    /**
     * 获取文件的后缀名
     *
     * @param fileName 原文件名
     * @return 后缀
     */
    public static String getFileExt(String fileName) {
        return fileName.substring(fileName.lastIndexOf("."));
    }

    /**
     * 验证文件的后缀名
     *
     * @param fileExt 文件后缀名
     * @param extArray 符合要求的后缀名数组
     * @return
     */
    public static boolean checkFileExt(String fileExt, String[] extArray) {
        for (int i = 0; i < extArray.length; i++) {
            if (extArray[i].equals(fileExt)) {
                return true;
            }
        }
        return false;
    }
/*
    public static void main(String[] args) {
        try {
            File file = new File("D:\\壁纸\\pixiy\\9f2f070828381f30814f09a5a8014c086e06f06c.jpg");
            FileInputStream is = new FileInputStream(file);
            FTPClient ftp = open();
            String datePath = new SimpleDateFormat("yyyy/MM/").format(new Date());
            User user = new User();
            String headPortarit = uploadFile(ftp, BASE_PATH, HEAD_PORTRAIT_PATH + datePath, "test.jpg", is);
            headPortarit = headPortarit + datePath;
            user.setUser_picture(headPortarit);
            if (null != user.getUser_picture()) {
                System.out.println("picture upload success!");
            } else {
                System.out.println("picture upload failure!");
            }
            close(ftp);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }*/
}
