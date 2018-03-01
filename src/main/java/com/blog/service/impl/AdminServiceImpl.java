package com.blog.service.impl;

import com.blog.been.PageBean;
import com.blog.dao.AdminMapper;
import com.blog.model.Admin;
import com.blog.service.AdminService;
import com.blog.util.BaseMapper;
import com.blog.util.Encrypt;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 黄柏樟 on 2016/3/8.
 * @Explain: 商家业务实现类
 */
@Service
public class AdminServiceImpl extends BaseServiceImpl<Admin> implements AdminService {

    @Autowired
    private AdminMapper adminMapper ;

    @Override
    protected BaseMapper<Admin> getBaseMapper() {
        return adminMapper;
    }

    @Override
    public Admin login(Admin admin) {
        admin.setPassword(Encrypt.e(admin.getPassword()));
        return this.adminMapper.login(admin);
    }

    @Override
    public Map dataTable(String searchText, int sEcho, PageBean pageBean) {
        Map<String, Object> parameterMap = new HashMap<String, Object>();
        if (searchText != null && !searchText.trim().isEmpty()) {
            searchText = "%"+searchText+"%";
            parameterMap.put("searchText",searchText);
        } if(pageBean.getSort()!=null&& !pageBean.getSort().trim().isEmpty()){
            parameterMap.put("sort",pageBean.getSort());
            parameterMap.put("order",pageBean.getOrder());
        }
        parameterMap.put("pageOffset", pageBean.getPageOffset());
        parameterMap.put("size", pageBean.getSize());
        List<Admin> list  = adminMapper.selectAllAdmin(parameterMap);
        int cout=adminMapper.countAll(parameterMap);
        pageBean.init(cout,list);
        Map<String,Object> map=new HashedMap();
        map.put("sEcho", sEcho+1);//不知道是什么,每次加一就好
        map.put("iTotalRecords", list.size());//当前总数据条数
        map.put("iTotalDisplayRecords",cout);//查询结果的总条数
        map.put("aaData", list);
        return map;
    }
}
