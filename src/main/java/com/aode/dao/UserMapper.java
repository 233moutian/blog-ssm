package com.aode.dao;

import com.aode.model.User;
import com.aode.util.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
@Repository
public interface UserMapper extends BaseMapper<User> {
    /**
     *
     * @param getPageBean 封装了排序字段。排序方式，查询值，分页值，分页页数
     * @return 查询后的集
     */
    public List<User> selectAllUser(Map<String,Object> getPageBean);

    /**
     *
     * @param getPageBean 封装了排序字段。排序方式，查询值，分页值，分页页数
     * @return 集的条数
     */
    public int countAll(Map<String,Object> getPageBean);

    void updateInfo(User user);
}