package com.blog.controller.webcontroller.page;

import com.blog.controller.webcontroller.BaseAdminController;
import com.blog.model.POJO.Comment;
import com.blog.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by 233moutian on 2018/3/1
 * @Explain: 前端评论界面控制器
 */
@Controller
@RequestMapping(value = "page/comment")
public class PCommentController extends BaseAdminController<Comment,Long> {

    @Autowired
    private AdminService adminService;

    @RequestMapping("list")
    public String list(){
        return TEMPLATE_PATH+"list";
    }

}
