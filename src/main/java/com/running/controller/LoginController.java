package com.running.controller;

import com.running.bean.AdminBean;
import com.running.bean.Msg;
import com.running.dao.AdminBeanMapper;
import com.running.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 后台
 * 处理用户发来的登录请求
 */
@Controller
public class LoginController {

    @Autowired
    LoginService loginService;


    /**
     * 显示管理员信息
     * 数据丢失一般与bean方法中的get和set方法有关
     */
    @ResponseBody
    @RequestMapping("/Admins")
    public Msg Admins(){
        List<AdminBean> adminBeans = loginService.admins();
        return Msg.success().add("admins",adminBeans);
    }

    /**
     * 删除管理员
     */
    @ResponseBody
    @RequestMapping(value="/deleteAdmin/{aid}",method=RequestMethod.DELETE)
    public Msg deleteAdmin(@PathVariable("aid") Integer aid){
        loginService.deleteAdmin(aid);
        return Msg.success();
    }
    /**
     * 修改管理员
     */
    @ResponseBody
    @RequestMapping(value="/updataAdmin/{aid}",method=RequestMethod.PUT)
    public Msg UpdataAdmin(AdminBean adminBean){
        System.out.println(adminBean);
        loginService.updataAdmin(adminBean);
        return Msg.success();
    }


    /**
     * 新增管理员
     */
    @RequestMapping(value="/addAdmin",method= RequestMethod.POST)
    @ResponseBody
    public Msg AddAdmin(AdminBean adminBean){
        loginService.addAdmin(adminBean);
        return Msg.success();
    }
    /**
     * 找回密码
     */
    @ResponseBody
    @RequestMapping("/GetPassword")
    public Msg GetPassword(
            @RequestParam(value = "username") String username,
            @RequestParam(value = "phone") String phone) {

        String password = loginService.GetPassword(username, phone);

        if (password != null && password != "") {
            return Msg.success().add("password", password);
        } else {
            return Msg.fail().add("password", password);
        }

    }

    /**
     * 登录：验证用户名和密码是否正确
     * 并在返回时返回taken
     */
    @ResponseBody
    @RequestMapping("/DoLogin")
    public Msg DoLogin(
            @RequestParam(value = "username") String username,
            @RequestParam(value = "password") String password) {

        String login = loginService.DoLogin(username);

        if (login.equals(password)) {
            return Msg.doLogin();
        } else {
            return Msg.fail().add("error", "账号密码错误");
        }
    }
}
