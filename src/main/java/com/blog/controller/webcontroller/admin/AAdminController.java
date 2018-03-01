package com.blog.controller.webcontroller.admin;

import com.blog.been.AjaxResult;
import com.blog.been.PageBean;
import com.blog.controller.webcontroller.BaseAdminController;
import com.blog.model.Admin;
import com.blog.service.AdminService;
import com.blog.util.Encrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * Created by 黄柏樟 on 2016/3/8.
 * 修改人 sky on 2016/4/5.
 * @Explain: 管理员控制器
 */
@Controller
@RequestMapping(value = "admin/admin")
public class AAdminController extends BaseAdminController<Admin,Long> {

    @Autowired
    private AdminService adminService;

    @RequestMapping("list")
    public String list(){
        return TEMPLATE_PATH+"list";
    }
    /**
     * 登录页
     */
    @RequestMapping("/loginUI")
    public String login() {
        return TEMPLATE_PATH+"loginUI";
    }

    /**
     * 登陆
     * @param admin
     * @param session
     * @param redirectAttributes
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(Admin admin,HttpSession session,RedirectAttributes redirectAttributes){
        try {
            Admin loginAdmin=this.adminService.login(admin);
            if (loginAdmin!=null){
                session.setAttribute("loginAdmin",loginAdmin);
                return "redirect:/admin/admin/list";
            }else {
                redirectAttributes.addFlashAttribute("result", new AjaxResult(false, "用户名或者密码错误"));
                return REDIRECT_URL+"loginUI";
            }
        }catch (Exception e){
            e.printStackTrace();
            redirectAttributes.addFlashAttribute("result", new AjaxResult(false, "发生错误"));
            return REDIRECT_URL+"loginUI";
        }
    }

    /**
     * 用户登出
     * 
     * @param session
     * @return
     */
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpSession session) {
        session.removeAttribute("loginAdmin");
        return REDIRECT_URL+"/loginUI";
    }

    /**
     * 查看个人资料
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(value = "/show/{id}")
    public String show(@PathVariable Long id , Model model) {
        Admin admin  = adminService.selectByPrimaryKey(id);
        model.addAttribute("admin" , admin);
        return TEMPLATE_PATH + "show";
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
        return adminService.dataTable(searchText, sEcho, pageBean);
    }

    /**
     * 异步删除
     * @param id
     * @return
     */
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    @ResponseBody
    public AjaxResult delete(@PathVariable Long id) {
        try {
            adminService.deleteByPrimaryKey(id);
            return successResult;
        }catch(Exception e){
            e.printStackTrace();
        }
        return errorResult;
    }

    /**
     * 个人信息
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(value = "/saveUI/{id}")
    public String saveUI(@PathVariable Long id , Model model) {
        model.addAttribute(this.adminService.selectByPrimaryKey(id));
        return TEMPLATE_PATH + "saveUI";
    }

    /**
     * 更改个人信息
     * @param admin
     * @param redirectAttributes
     * @return
     */
    @RequestMapping( value="/update",method = RequestMethod.POST)
    public String update(Admin admin,RedirectAttributes redirectAttributes ){
        try {
            admin.setPassword(Encrypt.e(admin.getPassword()));
            adminService.updateByPrimaryKey(admin);
            redirectAttributes.addFlashAttribute("msg",RESULT_OK);
            return REDIRECT_URL+"list";
        }catch(Exception e){
            e.printStackTrace();
        }
        redirectAttributes.addFlashAttribute("msg", RESULT_ERROR);
        return REDIRECT_URL+"list";
    }

    /**
     * 添加
     * @param admin
     * @param redirectAttributes
     * @return
     */
    @RequestMapping( value="/add",method = RequestMethod.POST)
    public String add(Admin admin,RedirectAttributes redirectAttributes ){
        try {
            admin.setPassword(Encrypt.e(admin.getPassword()));    //md5加密
            adminService.insert(admin);
            redirectAttributes.addAttribute("msg",RESULT_OK);
            return REDIRECT_URL+"list";
        }catch(Exception e){
            e.printStackTrace();
        }
        redirectAttributes.addFlashAttribute("msg", RESULT_ERROR);
        return REDIRECT_URL+"list";
    }

    /**
     * 新增或更改页
     * @return
     */
    @RequestMapping(value = "/saveUI", method = RequestMethod.GET)
    public String editUI() {
        return TEMPLATE_PATH + "saveUI";
    }

}
