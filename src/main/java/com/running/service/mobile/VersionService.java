package com.running.service.mobile;

import com.running.bean.Msg;
import com.running.bean.VersionBean;
import com.running.bean.VersionBeanExample;
import com.running.dao.VersionBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName: VersionService
 * @Description: TODO
 * @Author: zsl
 * @Date: 2020/9/24 10:53
 * @Version: v1.0
 */
@Service
public class VersionService {

    @Autowired
    VersionBeanMapper versionBeanMapper;

    public Msg selectMobileVersion() {
        VersionBeanExample example = new VersionBeanExample();
        example.setOrderByClause("vid DESC");
        List<VersionBean> versionList = versionBeanMapper.selectByExample(example);
        if (versionList != null){
            VersionBean versionBean = versionList.get(0);
            return Msg.success().add("version",versionBean);
        }else {
            return Msg.fail();
        }
    }

    public Msg updateMobileVersion(VersionBean versionBean) {
        if (versionBean != null){
            versionBeanMapper.updateByPrimaryKeySelective(versionBean);
            return Msg.success();
        }else {
            return Msg.fail();
        }
    }
}
