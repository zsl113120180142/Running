package com.running.service.mobile;

import com.running.bean.Msg;
import com.running.bean.StudentBean;
import com.running.bean.StudentBeanExample;
import com.running.dao.StudentBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName: MoblieLoginService
 * @Description: TODO
 * @Author: zsl
 * @Date: 2020/8/25 17:00
 * @Version: v1.0
 */
@Service
public class MoblieLoginService {

    @Autowired
    StudentBeanMapper studentBeanMapper;

    public Msg moblieLogin(StudentBean studentBean/*, HttpServletRequest req*/) {
        //提取属性
        String username = studentBean.getSnum();
        String password = studentBean.getSpassword();
        //登录判断
        /*ModelAndView mav = new ModelAndView();
        mav.setViewName("login");
        if (LoginMap.isExist(username)) {
            System.out.println(username + "已登陆...");
            mav.setViewName("logined");
            mav.addObject("username", username);
        }else {*/
            StudentBeanExample example = new StudentBeanExample();
            StudentBeanExample.Criteria criteria = example.createCriteria();
            criteria.andSnumEqualTo(username);
            criteria.andSdeleteEqualTo(1);
            List<StudentBean> studentBeans = studentBeanMapper.selectByExample(example);
            if (studentBeans.size() == 0) {
                //mav.setViewName("register");
                return Msg.fail().add("err", "账号错误,请重新登录");
            } else if (studentBeans.get(0).getSpassword().equals(password)) {
               /* req.getSession().setAttribute("logined", username);
                LoginMap.setMess(username, req.getSession());
                System.out.println(LoginMap.getMessHttpSession(username).getAttribute("logined"));
                mav.setViewName("success");
                mav.addObject("username", username);*/
                return Msg.success().add("err", "登录成功").add("sid", studentBeans.get(0).getSid());
            } else {
               // mav.setViewName("register");
                return Msg.fail().add("err", "密码错误，请重新登录");
            }
        }
       /* return Msg.fail().add("err", "该账号已在其他地方登录");
    }*/



}
