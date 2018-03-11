package com.blog.controller.webcontroller.admin;

import com.alibaba.fastjson.JSONObject;
import com.blog.been.PageBean;
import com.blog.controller.webcontroller.BaseAdminController;
import com.blog.model.POJO.Blog;
import com.blog.service.BlogService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import org.apache.commons.collections.map.HashedMap;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
    public String list(@RequestParam(value = "pager.offset", required = false, defaultValue = "0") Integer offset,
                       @RequestParam(value = "limit", required = false, defaultValue = "10") Integer limit,
                       Model model){
        List<Blog> blogList = blogService
                .selectByRowBounds(new Blog(), new RowBounds(offset, limit));
        System.out.println(blogList.toString());
        model.addAttribute("blogList", blogList);
//        model.addAttribute("count",  new PageInfo(blogList).getTotal());  无法使用此方法，改用手动查询
        model.addAttribute("count",  blogService.selectCount(new Blog()));
        model.addAttribute("limit", limit);
        model.addAttribute("blogList", blogList);
        System.out.println(TEMPLATE_PATH+"list");
        return TEMPLATE_PATH+"list";
    }

    /*
    43行 注解内容value是获取这个名字的参数,并赋值给offset这个变量,且这个参数不是必须的,如果没有传过来,那么它的默认值为1
    44行 注解内容value是获取这个名字的参数,并赋值给limit这个变量,且这个参数不是必须的,如果没有传过来,那么它的默认值为10
    46-47行 分页查询:查询从第offset条开始,查limit条数据  即查出来的数据为offset < result <= offset+limit
    50行 count是总数据条数,需要将查询出来的list强转为Page<E>类型再调用getTotal()方法获得
    41行 limit每页数据条数
 */
    @RequestMapping(value = "/demoList", method = RequestMethod.GET)
    @ResponseBody
    public String demoList(@RequestParam(value = "pager.offset", required = false, defaultValue = "0") Integer offset,
                       @RequestParam(value = "limit", required = false, defaultValue = "10") Integer limit,
                       Model model) {
        List<Blog> blogList = blogService
                .selectByRowBounds(new Blog(), new RowBounds(offset, limit));
        model.addAttribute("blogList", blogList);
//        model.addAttribute("count",  new PageInfo(blogList).getTotal());  无法使用此方法，改用手动查询
        model.addAttribute("count",  blogService.selectCount(new Blog()));
        model.addAttribute("limit", limit);
//        return TEMPLATE_PATH+"list";   这个地方是个jsp地址
        return JSONObject.toJSON(model).toString();
    }

    /*
     * 异步获取dataTable分页数据  改编版
     * @param searchText
     * @param sEcho
     * @param pageBean
     * @return
     */
    @RequestMapping("dataTable")
    @ResponseBody
    public Map dataTable(PageBean pageBean) {
        System.out.println(pageBean.toString());
        Example example = new Example(Blog.class);
        if (pageBean.getSearchText() != null && !"".equals(pageBean.getSearchText())) {
            example.createCriteria().andLike("", pageBean.getSearchText());
            example.or().andLike("", pageBean.getSearchText());
            example.or().andLike("", pageBean.getSearchText());
            example.or().andLike("", pageBean.getSearchText());
            example.or().andLike("", pageBean.getSearchText());
            example.or().andLike("", pageBean.getSearchText());
        }
//        List<Blog> blogList = blogService.selectByExampleAndRowBounds(example,
//                new RowBounds(pageBean.getPageOffset(), pageBean.getSize()));
        List<Blog> blogList = blogService.selectAll();
        Map<String,Object> map = new HashedMap();
        map.put("iTotalRecords", blogList.size());//当前总数据条数
        map.put("iTotalDisplayRecords",blogService.selectCount(new Blog()));//查询结果的总条数
        map.put("aaData", blogList);
        return map;

    }


}
