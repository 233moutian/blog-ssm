package com.aode.controller.webcontroller.admin;

import com.aode.been.AjaxResult;
import com.aode.been.PageBean;
import com.aode.model.User;
import com.aode.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Date;
import java.util.Map;
import java.util.UUID;

/**
 * Created by 黄柏樟 on 2016/6/28.
 * @Explain: 学生报名管理控制器
 */
@Controller
@RequestMapping("admin/user")
public class UserController extends BaseAdminController<User, String>{
    @Autowired
    private UserService userService ;

    @RequestMapping(value = "add" ,method = RequestMethod.POST)
    public String add(User user , RedirectAttributes redirectAttributes){
        user.setu_id((UUID.randomUUID().toString()));
        user.setDate(new Date());
        this.userService.insert(user) ;
        redirectAttributes.addFlashAttribute("result", successResult);
        return REDIRECT_URL+"list";
    }

    /**
     * 异步删除
     * @param u_id
     * @return
     */
    @RequestMapping(value = "/delete/{u_id}", method = RequestMethod.POST)
    @ResponseBody
    public AjaxResult delete(@PathVariable String u_id) {
        try {
            this.userService.deleteByPrimaryKey(u_id);
            return successResult;
        }catch(Exception e){
            e.printStackTrace();
        }
        return errorResult;
    }
    @RequestMapping("list")
    public String list(){
        return TEMPLATE_PATH+"list";
    }
    /**
     * 异步获取dataTable
     * @param searchText
     * @param sEcho
     * @param pageBean
     * @return
     */
    @RequestMapping("dataTable")
    @ResponseBody
    public Map dataTable(String searchText, int sEcho, PageBean pageBean) {
        return userService.dataTable(searchText, sEcho, pageBean);
    }

    @RequestMapping(value = "update" ,method = RequestMethod.POST)
    public String update(User user , RedirectAttributes redirectAttributes){
        this.userService.updateInfo(user) ;
        redirectAttributes.addFlashAttribute("result", successResult);
        return REDIRECT_URL+"list";
    }

    /**
     * 新增页
     * @return
     */
    @RequestMapping(value = "/saveUI", method = RequestMethod.GET)
    public String saveUI() {
        return TEMPLATE_PATH + "saveUI";
    }

    @RequestMapping("saveUI/{u_id}")
    public String saveUI(@PathVariable String u_id, Model model){
        model.addAttribute(this.userService.selectByPrimaryKey(u_id));
        return TEMPLATE_PATH + "saveUI";
    }

}
