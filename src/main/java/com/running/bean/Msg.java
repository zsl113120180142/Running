package com.running.bean;

import java.util.HashMap;
import java.util.Map;

/**
 * 通用的返回类
 */
public class Msg {
    //状态码   200-成功    404-失败
    private int code;
    //提示信息
    private String msg;
    //凭证token
    private String token;

    //用户要返回给浏览器的数据
    private Map<String, Object> extend = new HashMap<String, Object>();

    public static Msg doLogin(){
        Msg result = new Msg();
        result.setCode(200);
        result.setToken("true");
        result.setMsg("处理成功！");
        return result;
    }

    public static Msg success(){
        Msg result = new Msg();
        result.setCode(200);
        result.setMsg("处理成功！");
        return result;
    }

    public static Msg fail(){
        Msg result = new Msg();
        result.setCode(404);
        result.setMsg("处理失败！");
        return result;
    }


    //添加数据后缀字段
    public Msg add(String key,Object value){
        this.getExtend().put(key, value);
        return this;
    }



    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Map<String, Object> getExtend() {
        return extend;
    }

    public void setExtend(Map<String, Object> extend) {
        this.extend = extend;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
