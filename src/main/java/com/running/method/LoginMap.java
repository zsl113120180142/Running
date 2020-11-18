//package com.running.method;
//
//import javax.servlet.http.HttpSession;
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * @ClassName: LoginMap
// * @Description: 用于防止异地登录的全局map文件，用sessionid作为标识码，vue每次访问时，sessionid的值回不同，这会导致消除接口的调用失败
// * @Author: zsl
// * @Date: 2020/8/29 1:31
// * @Version: v1.0
// */
//public class LoginMap {
//    private static Map<String, HttpSession> map=new HashMap<>();
//
//    public static Map<String, HttpSession> getMap() {
//        return map;
//    }
//
//    public static HttpSession getMessHttpSession(String username) {
//        return map.get(username);
//    }
//
//    public static void setMess(String username,HttpSession httpSession) {
//        map.put(username, httpSession);
//    }
//
//    public static boolean remove(String username) {
//        HttpSession judge = map.get(username);
//        if(judge!=null) {
//            return map.remove(username, judge);
//        }
//        return true;
//    }
//
//    public static boolean isExist(String username) {
//        if(map.get(username)!=null) {
//            return true;
//        }
//        return false;
//    }
//
//}
