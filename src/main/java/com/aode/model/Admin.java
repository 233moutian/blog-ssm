package com.aode.model;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by 黄柏樟 on 2016/3/8.
 * @Explain: 管理员类
 */
@Table(name = "blog_admin")
public class Admin {
    @Id
    private Long a_id ;
    private String account;
    private String password ;
    private String name ;
    private String email;
    private String phoneNumber;



    public Admin(Long a_id, String account, String password, String name, String email, String phoneNumber) {
        this.a_id = a_id;
        this.account = account;
        this.password = password;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public Admin(){
        super();
    }

    public Long getA_id() {
        return a_id;
    }

    public void setA_id(Long a_id) {
        this.a_id = a_id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "a_id=" + a_id +
                ", account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", eamil='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
