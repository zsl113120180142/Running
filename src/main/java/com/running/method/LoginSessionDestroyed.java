//package com.running.method;
//
//import javax.servlet.http.HttpSession;
//import javax.servlet.http.HttpSessionEvent;
//import javax.servlet.http.HttpSessionListener;
//
///**
// * @ClassName: LoginSessionDestroyed
// * @Description: TODO
// * @Author: zsl
// * @Date: 2020/8/29 1:32
// * @Version: v1.0
// */
//public class LoginSessionDestroyed implements HttpSessionListener {
//    @Override
//    public void sessionCreated(HttpSessionEvent se) {
//    }
//
//    @Override
//    public void sessionDestroyed(HttpSessionEvent se) {
//        HttpSession session = se.getSession();
//        System.out.println("Destroyed:"+session.getId());
//        System.out.println("Destroyed:"+session.getAttribute("logined"));
//        System.out.println("Destroyed:"+LoginMap.getMap().size());
//        System.out.println("Destroyed:"+LoginMap.remove((String)session.getAttribute("logined")));
//        System.out.println("Destroyed-:"+LoginMap.getMap().size());
//        System.out.println("Destroyed-:"+session.getId());
//    }
//}
