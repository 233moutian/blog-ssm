package com.blog.dao;

import com.blog.model.Admin;
import com.blog.util.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by 黄柏樟 on 2016/3/8.
 * @Explain: 商家mapper接口
 */
@Repository
public interface AdminMapper extends BaseMapper<Admin> {
    /**
     * @param admin 登陆用户
     * @return 返回id，登陆账户，密码，姓名
     */
    public Admin login(Admin admin) ;

    /**
     *
     * @param getPageBean 封装了排序字段。排序方式，查询值，分页值，分页页数
     * @return 查询后的管理员集
     */
    public List<Admin> selectAllAdmin(Map<String,Object> getPageBean);

    /**
     *
     * @param getPageBean 封装了排序字段。排序方式，查询值，分页值，分页页数
     * @return 管理员集的条数
     */
    public int countAll(Map<String,Object> getPageBean);
}
