package com.running.controller.mobile;

import com.running.bean.ClassesBean;
import com.running.bean.Msg;
import com.running.bean.StudentBean;
import com.running.service.StuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

/**
 * @ClassName: UpLoadController
 * @Description: TODO
 * @Author: zsl
 * @Date: 2020/8/26 15:19
 * @Version: v1.0
 */
@Api(tags ="文件上传")
@RestController
@RequestMapping("file")
public class UpLoadController {

    @Value("${local_path}")
    private String path;
    @Value("${picture_url}")
    private String pictureurl;
    @Autowired
    StuService stuService;


    @ApiOperation("图片上传")
    @PostMapping("/upload")
    public Msg upload(MultipartFile file, HttpServletRequest request) throws IOException{
        path.getBytes("utf-8");
        String fileName = file.getOriginalFilename();
        File dir = new File(path,fileName);
        if(dir.exists()){
            dir.delete();
        }
        dir.mkdirs();
        file.transferTo(dir);
        //用键值对的方式存储，防止他中文乱码
        return Msg.success().add("filePath", "http://"+pictureurl+"/Running/static/"+fileName)
                .add("fileName",fileName);
    }

    @ApiOperation("Excel文件上传，解析到数据库")
    @PostMapping("/importExc")
    public Msg importExc(@RequestParam(value="excelFile",required = false) MultipartFile excelFile){
        Msg msg = stuService.ajaxUploadExcel(excelFile);
        return msg;
    }

    @GetMapping("/excel")
    public void excel(@RequestParam(value = "clid") Integer clid,HttpServletResponse response)throws IOException{
        //确定编码的格式
        response.setCharacterEncoding("UTF-8");
        //获取导出的数据
        List<StudentBean> list = stuService.queryExcelInfo(clid);
        //创建excel文件
        HSSFWorkbook wb = new HSSFWorkbook();
        //创建sheet页
        HSSFSheet sheet = wb.createSheet("学生信息表");
        //创建标题行
        HSSFRow titleRow = sheet.createRow(0);
        titleRow.createCell(0).setCellValue("学生ID");
        titleRow.createCell(1).setCellValue("学生姓名");
        titleRow.createCell(2).setCellValue("班级");
        titleRow.createCell(3).setCellValue("性别");
        titleRow.createCell(4).setCellValue("学号");
        titleRow.createCell(5).setCellValue("课内成绩");
        titleRow.createCell(6).setCellValue("体测成绩");
        titleRow.createCell(7).setCellValue("跑步成绩");
        titleRow.createCell(8).setCellValue("总成绩");
        titleRow.createCell(9).setCellValue("学生密码");
        titleRow.createCell(10).setCellValue("跑步总次数");
        //遍历将数据放到excel列中
        for (StudentBean student : list) {
            ClassesBean classesBean = stuService.findClname(clid);
            HSSFRow dataRow = sheet.createRow(sheet.getLastRowNum()+1);
            dataRow.createCell(0).setCellValue(student.getSid());
            dataRow.createCell(1).setCellValue(student.getSname());
            dataRow.createCell(2).setCellValue(classesBean.getClname());
            dataRow.createCell(3).setCellValue(student.getSex());
            dataRow.createCell(4).setCellValue(student.getSnum());
            if (student.getInclass()!=null) {
                dataRow.createCell(5).setCellValue(student.getInclass());
                dataRow.createCell(6).setCellValue(student.getSpe());
                dataRow.createCell(7).setCellValue(student.getSrun());
                dataRow.createCell(8).setCellValue(student.getSresult());
                dataRow.createCell(9).setCellValue(student.getSpassword());
                dataRow.createCell(10).setCellValue(student.getSnt());
            }
        }
        ClassesBean classes = stuService.findClname(clid);
            /*   // 设置下载时客户端Excel的名称
            String filename =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + ".xls";
               response.setContentType("application/vnd.ms-excel");
               response.setHeader("Content-disposition", "attachment;filename=" + filename);  */

        // 设置下载时客户端Excel的名称   （上面注释的改进版本，上面的中文不支持）
        response.setContentType("application/octet-stream;charset=utf-8");
        response.setHeader("Content-Disposition", "attachment;filename="
                //该版本为2003-的版本
                + new String("学生名单".getBytes(),"iso-8859-1")
                + ".xls");


        OutputStream ouputStream = response.getOutputStream();
        wb.write(ouputStream);
        ouputStream.flush();
        ouputStream.close();

    }
}

