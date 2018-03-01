package com.blog.util;

/**
 * Created by 周欣文 on 2017/2/1.
 *
 * @Explain:
 */
import com.sun.mail.util.MailSSLSocketFactory;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.security.GeneralSecurityException;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

public class SendEmailUtils {
//    private static String account = "13192692203@163.com";//登录用户名
//    private static String pass = "qq123456";        //登录密码
//    private static String from = "13192692203@163.com";        //发件地址
    private static String account = "feijikava@163.com";//登录用户名
    private static String pass = "mqy870109";        //登录密码
    private static String from = "feijikava@163.com";        //发件地址
    private static String host = "smtp.163.com";        //服务器地址
    private static String port = "465";        //端口
    private static String protocol = "smtp"; //协议
    private String to = "";    //收件人
    private String cord ;    //验证码
    private String content = "";    //邮件内容

    //用户名密码验证，需要实现抽象类Authenticator的抽象方法PasswordAuthentication
    static class MyAuthenricator extends Authenticator{
        String u = null;
        String p = null;
        public MyAuthenricator(String u,String p){
            this.u=u;
            this.p=p;
        }
        @Override
        protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(u,p);
        }
    }

    public SendEmailUtils(String to) {
        this.to = to;
    }

    public boolean send(){
        Properties prop = new Properties();
        //协议
        prop.setProperty("mail.transport.protocol", protocol);
        //服务器
        prop.setProperty("mail.smtp.host", host);
        //端口
        prop.setProperty("mail.smtp.port", port);
        //使用smtp身份验证
        prop.setProperty("mail.smtp.auth", "true");
        //使用SSL，企业邮箱必需！
        //开启安全协议
        MailSSLSocketFactory sf = null;
        try {
            sf = new MailSSLSocketFactory();
            sf.setTrustAllHosts(true);
        } catch (GeneralSecurityException e1) {
            e1.printStackTrace();
            return false;
        }
        prop.put("mail.smtp.ssl.enable", "true");
        prop.put("mail.smtp.ssl.socketFactory", sf);
        Session session = Session.getDefaultInstance(prop, new MyAuthenricator(account, pass));
        session.setDebug(true);
        MimeMessage mimeMessage = new MimeMessage(session);
        try {
            mimeMessage.setFrom(new InternetAddress(from));
            mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            mimeMessage.setSubject("Verification code");
            mimeMessage.setSentDate(new Date());
            mimeMessage.setText(content);
            mimeMessage.saveChanges();
            Transport.send(mimeMessage);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public void createCord(){
        String pross = "";
        for (int i = 0; i < 6 ; i++){
            pross += new Random().nextInt(10);;
        }
        this.cord = pross;
        this.content = "Your verification code is : " + cord + ". It will be out of operation in 10 minutes.";
    }

    public boolean checkMailAdress(String email){
//        check a  mail adress is valid.
//        http://api.verify-email.org/api.php?usr=your_username&pwd=your_password&check=email@tocheck.com
        if (!email.matches("[\\w\\.\\-]+@([\\w\\-]+\\.)+[\\w\\-]+")) {
            return false;
        }
        return true;
    }

    public String getCord(){
        createCord();   // 先初始化数据
        if (checkMailAdress(this.to) && send()){
            return this.cord;
        }
        return null;
    }
}