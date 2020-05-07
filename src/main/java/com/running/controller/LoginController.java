package com.running.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.running.bean.AdminBean;
import com.running.bean.Msg;
import com.running.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

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
    public Msg Admins(@RequestParam(value = "pn", defaultValue = "1") Integer pn){
        // 这不是一个分页查询
        // 引入PageHelper分页插件
        // 在查询之前只需要调用，传入页码，以及每页的大小
        PageHelper.startPage(pn, 10);
        // startPage后面紧跟的这个查询就是一个分页查询
        List<AdminBean> adminBeans = loginService.admins();
        // 使用pageInfo包装查询后的结果，只需要将pageInfo交给页面就行了。
        // 封装了详细的分页信息,包括有我们查询出来的数据，传入连续显示的页数
        PageInfo page = new PageInfo(adminBeans,10);
        return Msg.success().add("admins",page);
    }

    /**
     * 删除管理员
     * 单个批量二合一
     * 批量删除：1-2-3
     * 单个删除：1
     */
    @ResponseBody
    @RequestMapping(value="/deleteAdmin/{aids}",method=RequestMethod.DELETE)
    public Msg deleteAdmin(@PathVariable("aids") String aids){
        //批量删除
        if(aids.contains("-")) {
            List<Integer> del_aids = new ArrayList<>();
            String[] str_aids = aids.split("-");
            //组装id的集合,遍历数组
            for (String string : str_aids) {
                del_aids.add(Integer.parseInt(string));
            }
            //批量删除的方法
            loginService.deleteBatch(del_aids);
        }
        else{
            Integer aid = Integer.parseInt(aids);
            loginService.deleteAdmin(aid);
        }

        return Msg.success();
    }
    /**
     * 修改管理员
     */
    @ResponseBody
    @RequestMapping(value="/updateAdmin/{aid}",method=RequestMethod.PUT)
    public Msg UpdateAdmin(AdminBean adminBean){
        loginService.updateAdmin(adminBean);
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

        //数据库用户名重复校验
        boolean b = loginService.checkUser(username);
        if(b){
            AdminBean login = loginService.DoLogin(username);
            String pass = login.getPassword();
            if (pass.equals(password)&&login.getWorks()==1) {
                return Msg.doLogin().add("login",login);
            } else {
                return Msg.fail().add("error", "密码错误");
            }
        }else {
            return Msg.fail().add("error", "账号错误");
        }

    }
}
