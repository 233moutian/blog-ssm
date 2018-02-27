package dao;

import com.aode.dao.AdminMapper;
import com.aode.model.Admin;
import com.aode.test.TestSupport;
import com.aode.util.Encrypt;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by 黄柏樟 on 2016/6/7.
 * @Explain:
 */
public class adminTest extends TestSupport {
    @Autowired
    private AdminMapper adminMapper ;
    /*
        测试登陆
     */
    @Test
    public void testLogin(){
        Admin a = new Admin() ;
        a.setAccount("hhbbz");
        a.setPassword(Encrypt.e("123456"));
        Admin admin = this.adminMapper.login(a) ;
        System.out.println(admin.toString());
    }
    /*
        测试插入
     */
    @Test
    public void testInsert(){
        Admin a = new Admin() ;
        a.setAccount("hhbbzz") ;
        a.setPassword(Encrypt.e("123456"));
        this.adminMapper.insert(a) ;

    }
    /*
        测试搜索
     */
    @Test
    public void testSelect(){
        Admin a = new Admin() ;
        a.setName("hhbbz");
        a.setPassword(Encrypt.e("123456"));
        Admin c = this.adminMapper.selectOne(a) ;
        System.out.println(c.toString());
    }

    @Test
    public void testSelectALL(){
        List<Admin> adminList = this.adminMapper.selectAll();
        for (Admin admin : adminList){
            System.out.println(admin.toString());
        }
    }
}
