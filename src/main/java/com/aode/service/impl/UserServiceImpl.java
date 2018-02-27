package com.aode.service.impl;

import com.aode.been.PageBean;
import com.aode.dao.UserMapper;
import com.aode.model.User;
import com.aode.service.UserService;
import com.aode.util.BaseMapper;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 黄柏樟 on 2016/6/28.
 * @Explain: 学生报名业务实现
 */
@Service
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {
    @Autowired
    private UserMapper userMapper ;
    @Override
    protected BaseMapper<User> getBaseMapper() {
        return this.userMapper;
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
        List<User> list  = userMapper.selectAllUser(parameterMap);
        int cout=userMapper.countAll(parameterMap);
        pageBean.init(cout,list);
        Map<String,Object> map=new HashedMap();
        map.put("sEcho", sEcho+1);//不知道是什么,每次加一就好
        map.put("iTotalRecords", list.size());//当前总数据条数
        map.put("iTotalDisplayRecords",cout);//查询结果的总条数
        map.put("aaData", list);
        return map;
    }

    @Override
    public void updateInfo(User user) {
        this.userMapper.updateInfo(user) ;
    }
}
