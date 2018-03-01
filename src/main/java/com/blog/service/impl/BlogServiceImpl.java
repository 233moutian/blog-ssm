package com.blog.service.impl;

import com.blog.dao.BlogMapper;
import com.blog.model.POJO.Blog;
import com.blog.service.BlogService;
import com.blog.util.BaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by 233moutian on 2018/3/1.
 * @Explain: 博文业务实现
 */
@Service
public class BlogServiceImpl extends BaseServiceImpl<Blog> implements BlogService {
    @Autowired
    private BlogMapper blogMapper ;

    @Override
    protected BaseMapper<Blog> getBaseMapper() {
        return this.blogMapper;
    }

}
