package com.blog.controller.webcontroller.admin;

import com.alibaba.fastjson.JSONObject;
import com.blog.controller.webcontroller.BaseAdminController;
import com.blog.model.POJO.Blog;
import com.blog.service.BlogService;
import com.github.pagehelper.Page;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by 233moutian on 2018/3/1
 * @Explain: 后台博文控制器
 */
@Controller
@RequestMapping(value = "admin/blog")
public class ABlogController extends BaseAdminController<Blog,Long> {

    @Autowired
    private BlogService blogService;

    @RequestMapping("list")
    public String list(){
        return TEMPLATE_PATH+"list";
    }

    /*
    43行 注解内容value是获取这个名字的参数,并赋值给offset这个变量,且这个参数不是必须的,如果没有传过来,那么它的默认值为1
    44行 注解内容value是获取这个名字的参数,并赋值给limit这个变量,且这个参数不是必须的,如果没有传过来,那么它的默认值为10
    46-47行 分页查询:查询从第offset条开始,查limit条数据
    50行 count是总数据条数,需要将查询出来的list强转为Page<E>类型再调用getTotal()方法获得
    41行 limit每页数据条数
 */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public String list(@RequestParam(value = "pager.offset", required = false, defaultValue = "0") Integer offset,
                       @RequestParam(value = "limit", required = false, defaultValue = "10") Integer limit,
                       Model model) {
        List<Blog> blogList = blogService
                .selectByRowBounds(new Blog(), new RowBounds(offset, limit));
        System.out.println(blogList.size());
        model.addAttribute("contactInformationList", blogList);
        model.addAttribute("count", ((Page) blogList).getTotal());
        model.addAttribute("limit", limit);
//        return TEMPLATE_PATH+"list";   这个地方是个jsp地址
        return JSONObject.toJSON(model).toString();
    }
}
