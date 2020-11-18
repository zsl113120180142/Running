package com.running.controller.mobile;

import com.running.bean.Msg;
import com.running.bean.VersionBean;
import com.running.service.mobile.VersionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName: MoblieVersionController
 * @Description: TODO
 * @Author: zsl
 * @Date: 2020/9/24 10:51
 * @Version: v1.0
 */
@Api(tags ="移动端版本的事务请求")
@RestController
@RequestMapping("/mobile")
public class MoblieVersionController {

    @Autowired
    VersionService versionService;

    @ApiOperation("修改版本号的显示")
    @PutMapping("/updateMobileVersion")
    public Msg updateMobileVersion(@RequestBody VersionBean versionBean){
        Msg msg = versionService.updateMobileVersion(versionBean);
        return msg;
    }

    @ApiOperation("最新版本号的显示")
    @GetMapping("/selectMobileVersion")
    public Msg selectMobileVersion(){
        Msg msg = versionService.selectMobileVersion();
        return msg;
    }

}
