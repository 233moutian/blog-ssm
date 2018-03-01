package com.blog.service.impl;

import com.blog.dao.CommentMapper;
import com.blog.model.POJO.Comment;
import com.blog.service.CommentService;
import com.blog.util.BaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by 233moutian on 2018/3/1.
 * @Explain: 博文业务实现
 */
@Service
public class CommentServiceImpl extends BaseServiceImpl<Comment> implements CommentService {
    @Autowired
    private CommentMapper commentMapper ;

    @Override
    protected BaseMapper<Comment> getBaseMapper() {
        return this.commentMapper;
    }

}
