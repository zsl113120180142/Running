package com.running.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.running.bean.AdminBean;
import com.running.bean.Msg;
import com.running.service.LoginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/**
 * 后台
 * 处理用户发来的登录请求
 */
@Api(tags ="后台登录页面，以及管理员操作")
@RequestMapping("/login")
@RestController
public class LoginController {

    @Autowired
    LoginService loginService;


    /**
     * admin模糊查询（通过姓名）
     */
    @ApiOperation("通过姓名对管理员进行模糊查询")
    @GetMapping("/searchAname")
    public Msg Adminsearch(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                           @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                           @RequestParam(value = "aname",defaultValue = "0") String aname) {

        PageHelper.startPage(pageNum, pageSize);
        List<AdminBean> adminBeans = loginService.searchaname(aname);
        PageInfo page = new PageInfo(adminBeans, 10);
        return Msg.success().add("searchadmin", page);
    }

    /**
     * 显示管理员信息
     * 数据丢失一般与bean方法中的get和set方法有关
     */
    @ApiOperation("显示管理员的全部信息")
    @GetMapping("/Admins")
    public Msg Admins(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                      @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
        // 这不是一个分页查询
        // 引入PageHelper分页插件
        // 在查询之前只需要调用，传入页码，以及每页的大小
        PageHelper.startPage(pageNum, pageSize);
        // startPage后面紧跟的这个查询就是一个分页查询
        List<AdminBean> adminBeans = loginService.admins();
        // 使用pageInfo包装查询后的结果，只需要将pageInfo交给页面就行了。
        // 封装了详细的分页信息,包括有我们查询出来的数据，传入连续显示的页数
        PageInfo page = new PageInfo(adminBeans, 10);
        return Msg.success().add("admins", page);
    }

    /**
     * 删除管理员
     * 单个批量二合一
     * 批量删除：1-2-3
     * 单个删除：1
     */
    @ApiOperation("删除管理员,单个批量二合一,批量删除：1-2-3")
    @DeleteMapping( "/deleteAdmin")
    public Msg deleteAdmin(@RequestParam("aids") String aids) {
        //批量删除
        if (aids.contains("-")) {
            List<Integer> del_aids = new ArrayList<>();
            String[] str_aids = aids.split("-");
            //组装id的集合,遍历数组
            for (String string : str_aids) {
                del_aids.add(Integer.parseInt(string));
            }
            //批量删除的方法
            loginService.deleteBatch(del_aids);
        } else {
            Integer aid = Integer.parseInt(aids);
            loginService.deleteAdmin(aid);
        }

        return Msg.success();
    }

    /**
     * 修改密码
     */
    @ApiOperation("修改密码")
    @PutMapping("/updatePassword")
    public Msg updatePassword(@RequestParam("aid") Integer aid,
                              @RequestParam("oldpassword") String oldpassword,
                              @RequestParam("newpassword") String newpassword) {
        Msg msg = loginService.updatePassword(aid,oldpassword,newpassword);
        return msg;
    }


    /**
     * 新增管理员
     */
    @ApiOperation("新增管理员")
    @PostMapping("/addAdmin")
    public Msg AddAdmin(@RequestBody AdminBean adminBean) {
        boolean num =loginService.addAdmin(adminBean);
        ModelAndView mav=new ModelAndView();
        if(num) {
            mav.setViewName("login");
        }else {
            mav.setViewName("register");
        }
        return Msg.success();
    }

    /**
     * 找回密码
     */
    @ApiOperation("找回密码")
    @GetMapping("/GetPassword")
    public Msg GetPassword(
            @RequestParam(value = "username") String username,
            @RequestParam(value = "phone") String phone) {

        String password = loginService.GetPassword(username, phone);

        if (password != null && password != "") {
            return Msg.success().add("password", password);
        } else {
            return Msg.fail().add("err","密码不存在");
        }

    }

    /**
     * 修改管理员
     */
    @ApiOperation("修改管理员")
    @PutMapping("/updateAdmin")
    public Msg UpdateAdmin(@RequestBody AdminBean adminBean) {
        loginService.updateAdmin(adminBean);
        return Msg.success();
    }


    /**
     * 登录：验证用户名和密码是否正确
     * 并在返回时返回taken
     */
    @ApiOperation("登录")
    @PostMapping("/DoLogin")
    public Msg DoLogin(
            @RequestParam(value = "username") String username,
            @RequestParam(value = "password") String password
            //HttpServletRequest req
            ) {
       /* ModelAndView mav = new ModelAndView();
        mav.setViewName("login");
        if (LoginMap.isExist(username)) {
            System.out.println(username + "已登陆...");
            mav.setViewName("logined");
            mav.addObject("username", username);
        } else {*/
            //数据库用户名重复校验
            boolean b = loginService.checkUser(username);
            if (b) {
                AdminBean login = loginService.DoLogin(username);
                String pass = login.getPassword();
                if (pass.equals(password) && login.getWorks() == true) {
                    /*
                    req.getSession().setAttribute("logined", username);
                    LoginMap.setMess(username, req.getSession());
                    System.out.println(LoginMap.getMessHttpSession(username).getAttribute("logined"));
                    mav.setViewName("success");
                    mav.addObject("username", username);*/
                    return Msg.doLogin().add("login", login);
                } else {
                    //mav.setViewName("register");
                    return Msg.fail().add("err", "密码错误");

                }
            } else {
               // mav.setViewName("register");
                return Msg.fail().add("err", "账号错误");
            }
        }
       /* return Msg.fail().add("err", "该账号已在其他地方登录");
    }*/






    /**
     * 退出时调用
     * @param req
     * @return
     */
    /*
    @ApiOperation("退出时调用")
    @GetMapping("/quit")
    public String quit(HttpServletRequest req) {

        if(req.getSession(false).getAttribute("logined")!=null) {
            String username = (String)req.getSession(false).getAttribute("logined");
            LoginMap.remove(username);
            req.getSession(false).invalidate();
            return "invaliate successful...";
        }else {
            return "this session not found...";
        }

    }*/

    /**
     * 登录成功触发
     * @param username
     * @return
     */
    /*
    @ApiOperation("登录成功触发")
    @GetMapping("/writeToSession")
    public String testSession(@RequestParam("username") String username) {
        System.out.println(username);
        LoginMap.getMessHttpSession(username).setAttribute("writed", "my word...");
        return (String)LoginMap.getMessHttpSession(username).getAttribute("writed");
    }*/


}
