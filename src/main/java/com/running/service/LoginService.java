package com.running.service;

import com.running.bean.AdminBean;
import com.running.bean.AdminBeanExample;
import com.running.dao.AdminBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * 处理登录的事件
 */
@Service
public class LoginService {

    @Autowired
    AdminBeanMapper adminBeanMapper;


    /**
     * 验证用户名，密码
     *
     * @param username
     * @return
     */
    public AdminBean DoLogin(String username) {
        return adminBeanMapper.selectByUsername(username);
    }

    /**
     * 找回密码操作
     *
     * @param username
     * @param phone
     * @return
     */
    public String GetPassword(String username, String phone) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("username", username);
        map.put("phone", phone);
        String password = adminBeanMapper.selectPassword(map);
        return password;
    }

    /**
     * 增加管理员信息
     *
     * @param adminBean
     */
    public void addAdmin(AdminBean adminBean) {
        adminBeanMapper.insertSelective(adminBean);
    }

    /**
     * 更新管理员信息
     *
     * @param adminBean
     */
    public void updataAdmin(AdminBean adminBean) {
        adminBeanMapper.updateByPrimaryKeySelective(adminBean);
    }



    /**
     *显示管理员信息
     * @return
     */
    public List<AdminBean> admins() {
        return adminBeanMapper.selectByExample(null);
    }

    /**
     * 单个删除
     * @param aid
     */
    public void deleteAdmin(Integer aid) {
        adminBeanMapper.deleteByPrimaryKey(aid);
    }

    /**
     * 批量删除
     * @param del_aids
     */
    public void deleteBatch(List<Integer> del_aids) {
        AdminBeanExample example = new AdminBeanExample();
        AdminBeanExample.Criteria criteria = example.createCriteria();
        //delete from xxx where emp_id in(1,2,3)
        criteria.andAidIn(del_aids);
        adminBeanMapper.deleteByExample(example);

    }
}
