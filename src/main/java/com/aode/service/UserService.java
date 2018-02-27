package com.aode.service;

import com.aode.been.PageBean;
import com.aode.model.User;

import java.util.Map;

/**
 * Created by 黄柏樟 on 2016/6/28.
 * @Explain: 学生报名业务接口
 */
public interface UserService extends BaseService<User> {
    Map dataTable(String searchText, int sEcho, PageBean pageBean);

    void updateInfo(User user);
}
