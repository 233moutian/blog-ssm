package com.aode.util;

/**
 * Created by 周欣文 on 2017/1/12.
 *
 * @Explain: java实现发送邮件
 */

import javax.mail.*;
import javax.mail.internet.*;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

public class MailUtil {
    private String  isSSL = "true";
    private String  port = "465";
    private String  auth = "true";
    private String to = ""; // 收件人
    private String from = "13192692203@163.com"; // 发件人
    private String host = "smtp.163.com"; // smtp主机 使用SSL，端口号465或587
    private String username = "13192692203@163.com"; // 用户名
    private String password = "qq123456"; // 密码
    private String subject = "Verification code"; // 邮件主题
    private String content = ""; // 邮件正文
    private String cord ; // 验证码

    public MailUtil() {
    }

    public MailUtil(String toWhere) {   // 其他写死  变量只有一个收件人邮箱
        this.to = toWhere;
    }

    public MailUtil(String isSSL, String port, String to, String from, String host, String username, String password, String subject, String content, String cord) {
        this.isSSL = isSSL;
        this.port = port;
        this.to = to;
        this.from = from;
        this.host = host;
        this.username = username;
        this.password = password;
        this.subject = subject;
        this.content = content;
        this.cord = cord;
    }

    public void createCord(){
        String pross = "";
        for (int i = 0; i < 6 ; i++){
            pross += new Random().nextInt(10);;
        }
        this.cord = pross;
        this.content = "Your verification code is : " + cord + ".It will lose efficacy 10 minute later.";
    }

    /**
     * 把主题转换为中文
     *
     * @param strText
     * @return
     */
    public String transferChinese(String strText) {

        try {
//            strText = MimeUtility.encodeText(new String(strText.getBytes(),"GB2312"), "GB2312", "B");
            strText = MimeUtility.encodeText(strText, "GB2312", "B");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return strText;
    }


    /**
     * 发送邮件
     *
     * @return 成功返回true，失败返回false
     */
    public boolean sendMail() {
        // 构造mail session
        Properties props = System.getProperties();
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.auth", auth);
        props.put("mail.smtp.ssl.enable", isSSL);
        props.put("mail.smtp.port", port);
        props.setProperty("mail.smtp.timeout", "60000");
        props.setProperty("mail.smtp.connectiontimeout", "60000");
        Session session = Session.getDefaultInstance(props,
                new Authenticator() {
                    public PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });
        try {
            // 构造MimeMessage并设定基本的值，创建消息对象
            MimeMessage msg = new MimeMessage(session);
            // 设置消息内容
            msg.setFrom(new InternetAddress(from));
            // 把邮件地址映射到Internet地址上
            InternetAddress[] address = {new InternetAddress(to)};
            /**
             * setRecipient（Message.RecipientType type, Address
             * address），用于设置邮件的接收者。<br>
             * 有两个参数，第一个参数是接收者的类型，第二个参数是接收者。<br>
             * 接收者类型可以是Message.RecipientType .TO，Message
             * .RecipientType.CC和Message.RecipientType.BCC，TO表示主要接收人，CC表示抄送人
             * ，BCC表示秘密抄送人。接收者与发送者一样，通常使用InternetAddress的对象。
             */
            msg.setRecipients(Message.RecipientType.TO, address);
            // 设置邮件的标题
            subject = transferChinese(subject);
            msg.setSubject(subject, "UTF-8");
            // 构造Multipart
            Multipart mp = new MimeMultipart();

            // 向Multipart添加正文
            MimeBodyPart mbpContent = new MimeBodyPart();
            // 设置邮件内容(纯文本格式)
            // mbpContent.setText(content);
            // 设置邮件内容(HTML格式)
            mbpContent.setContent(content, "text/html;charset=utf-8");
            System.out.println(content);
            // 向MimeMessage添加（Multipart代表正文）
            mp.addBodyPart(mbpContent);
            // 向Multipart添加MimeMessage
            msg.setContent(mp);
            // 设置邮件发送的时间。
            msg.setSentDate(new Date());
            // 发送邮件
            Transport.send(msg);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public String getCord(){
        createCord();   // 先初始化数据
        if (checkMailAdress(this.to) && sendMail()){
            return this.cord;
        }
        return null;
    }

    public boolean checkMailAdress(String email){
//        check a  mail adress is valid.
//        http://api.verify-email.org/api.php?usr=your_username&pwd=your_password&check=email@tocheck.com
        if (!email.matches("[\\w\\.\\-]+@([\\w\\-]+\\.)+[\\w\\-]+")) {
            return false;
        }
        return true;
    }

}