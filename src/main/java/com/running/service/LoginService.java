package com.running.service;

import com.running.bean.AdminBean;
import com.running.bean.AdminBeanExample;
import com.running.bean.Msg;
import com.running.dao.AdminBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public boolean addAdmin(AdminBean adminBean) {
       return adminBeanMapper.insertSelective(adminBean)==1;
    }

    /**
     * 更新管理员信息
     *
     * @param adminBean
     */
    public void updateAdmin(AdminBean adminBean) {
        adminBeanMapper.updateByPrimaryKeySelective(adminBean);
    }


    /**
     * 显示管理员信息
     *
     * @return
     */
    public List<AdminBean> admins() {
        return adminBeanMapper.selectByExample(null);
    }

    /**
     * 单个删除
     *
     * @param aid
     */
    public void deleteAdmin(Integer aid) {
        adminBeanMapper.deleteByPrimaryKey(aid);
    }

    /**
     * 批量删除
     *
     * @param del_aids
     */
    public void deleteBatch(List<Integer> del_aids) {
        AdminBeanExample example = new AdminBeanExample();
        AdminBeanExample.Criteria criteria = example.createCriteria();
        //delete from xxx where emp_id in(1,2,3)
        criteria.andAidIn(del_aids);
        adminBeanMapper.deleteByExample(example);
    }

    /**
     * 检查用户名是否存在
     * true：代表当前姓名存在   fasle：不存在
     *
     * @param username
     * @return
     */
    public boolean checkUser(String username) {
        AdminBeanExample example = new AdminBeanExample();
        AdminBeanExample.Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo(username);
        long count = adminBeanMapper.countByExample(example);
        return count == 1;
    }


    public List<AdminBean> searchaname(String aname) {
        if (aname.equals("0")){
            return adminBeanMapper.selectByExample(null);
        }else {
            return adminBeanMapper.searchaname(aname);
        }
    }

    public Msg updatePassword(Integer aid, String oldpassword, String newpassword) {
        AdminBean adminBean = adminBeanMapper.selectByPrimaryKey(aid);
        if (oldpassword.equals(adminBean.getPassword())){
            adminBean.setPassword(newpassword);
            adminBeanMapper.updateByPrimaryKeySelective(adminBean);
            return Msg.success();
        }else {
            return Msg.fail().add("err","密码错误");
        }
    }
}
