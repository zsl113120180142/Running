package com.running.controller.mobile;

import com.running.bean.Msg;
import com.running.bean.StudentBean;
import com.running.service.mobile.MoblieLoginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: MobileLogin
 * @Description: 移动端登录
 * @Author: zsl
 * @Date: 2020/8/25 16:45
 * @Version: v1.0
 */
@Api(tags ="移动端登录")
@RequestMapping("/mobile")
@RestController
public class MobileLoginController {
    @Autowired
    MoblieLoginService moblieLoginService;

    @ApiOperation("移动端登录")
    @PostMapping("/mobileLogin")
    public Msg moblieLogin(@RequestBody StudentBean studentBean/*,HttpServletRequest req*/){
        Msg msg = moblieLoginService.moblieLogin(studentBean);
        return msg;
    }

    /**
     * 退出时调用，用于消除全局变量中的登录的用户名称
     * @param req
     * @return
     */
  /*  @ApiOperation("移动端退出时调用")
    @GetMapping("/mobilequit")
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
     * 登录成功触发，在全局变量中做登记，防止异地登录
     * @param username
     * @return
     */
    /*
    @ApiOperation("移动端登录成功触发")
    @GetMapping("/mobilewriteToSession")
    public String testSession(@RequestParam("snum") String username) {
        System.out.println(username);
        LoginMap.getMessHttpSession(username).setAttribute("writed", "my word...");
        return (String)LoginMap.getMessHttpSession(username).getAttribute("writed");
    }*/

}
