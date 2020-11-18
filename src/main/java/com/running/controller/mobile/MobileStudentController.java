package com.running.controller.mobile;

import com.running.bean.Msg;
import com.running.bean.StudentBean;
import com.running.service.mobile.MoblieStudentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName: MobileStudentController
 * @Description: TODO
 * @Author: zsl
 * @Date: 2020/8/26 14:19
 * @Version: v1.0
 */
@Api(tags ="移动端学生页面")
@RestController
@RequestMapping("/mobile")
public class MobileStudentController {
    @Autowired
    MoblieStudentService moblieStudentService;

    /**
     * 显示全部学生
     * @param sid
     * @return
     */
    @ApiOperation("显示学生全部信息")
    @GetMapping("selectStudent")
    public Msg selectStudent(@RequestParam("sid") Integer sid) {
        Msg msg = moblieStudentService.selectStudent(sid);
        return msg;
    }

    /**
     * 修改学生信息
     * @param studentBean
     * @return
     */
    @ApiOperation("修改学生信息")
    @PutMapping("/updataStudent")
    public Msg updataStudent(@RequestBody StudentBean studentBean){
        Msg msg = moblieStudentService.updataStudent(studentBean);
        return msg;
    }

}
