package com.blog.service;

import com.blog.been.PageBean;
import com.blog.model.Admin;

import java.util.Map;

/**
 * Created by 黄柏樟 on 2016/3/8.
 * @Explain: 商家业务接口
 */
public interface AdminService extends BaseService<Admin> {
    /**
     * @param admin 登陆用户
     * @return
     */
    public Admin login(Admin admin) ;

    /**
     * @param searchText 模糊查询内容
     * @param sEcho
     * @param pageBean 分页实体
     * @return
     */
    Map dataTable(String searchText, int sEcho, PageBean pageBean);
}
