package com.running.service;

import com.running.bean.*;
import com.running.dao.*;
import com.running.method.ExcelUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;


/**
 * 处理后台页面请求
 */
@Service
public class StuService {

    @Autowired
    StudentBeanMapper studentBeanMapper;
    @Autowired
    StatisticBeanMapper statisticBeanMapper;
    @Autowired
    ClassesBeanMapper classesBeanMapper;
    @Autowired
    CollegeBeanMapper collegeBeanMapper;
    @Autowired
    GradeBeanMapper gradeBeanMapper;
    @Autowired
    ResultBeanMapper resultBeanMapper;
    @Autowired
    WeekBeanMapper weekBeanMapper;

    /**
     * 通过clid查询班级的学生信息
     *
     * @param clid
     * @return
     */
    public List<StudentBean> StuByClid(Integer clid) {
        return studentBeanMapper.selectByClid(clid);
    }

    /**
     * 通过模糊查询的关键字进行查询
     * clid进行维持
     *

     * @return
     */
    public List<StudentBean> searchsname(Integer clid,String sname) {
        if (sname.equals("0")){
            StudentBeanExample example = new StudentBeanExample();
            StudentBeanExample.Criteria criteria = example.createCriteria();
            criteria.andSdeleteEqualTo(1);
            List<StudentBean> studentBeanList =  studentBeanMapper.selectByExample(example);
            return studentBeanList;
        }else {
            StudentBeanExample example = new StudentBeanExample();
            StudentBeanExample.Criteria criteria = example.createCriteria();
            criteria.andClidEqualTo(clid);
            criteria.andSdeleteEqualTo(1);
            criteria.andSnameLike("%" + sname + "%");
            List<StudentBean> studentBeanList = studentBeanMapper.selectByExample(example);
            return studentBeanList;
        }
    }

    /**
     * 新增学生
     *
     * @param studentBean
     */
    public void addStu(StudentBean studentBean) {
        studentBeanMapper.insertSelective(studentBean);
    }

    /**
     * 修改学生信息
     * 兼删除学生信息 sdelete=0
     *
     * @param studentBean
     */
    public void updateStu(StudentBean studentBean) {
        studentBeanMapper.updateByPrimaryKeySelective(studentBean);
    }


    /**
     * record
     * 显示学生跑步记录
     */
    public StudentBean StudentRecord(Integer sid) {
        return studentBeanMapper.selectByPrimaryKey(sid);
    }

    public List<StatisticBean> RunRecord(Integer sid) {
        StatisticBeanExample example = new StatisticBeanExample();
        StatisticBeanExample.Criteria criteria = example.createCriteria();
        criteria.andSidEqualTo(sid);
        return statisticBeanMapper.selectByExample(example);

    }

    public Msg ajaxUploadExcel(MultipartFile file){

        /*MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;

        MultipartFile file = multipartRequest.getFile("upfile");*/

        if (file.isEmpty()) {
            try {
                throw new Exception("文件不存在！");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        InputStream in = null;
        try {
            in = file.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }


        List<List<Object>> listob = null;
        try {
            listob = new ExcelUtils().getBankListByExcel(in,file.getOriginalFilename());
 //          System.out.println("listob触发了"+listob);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //该处可调用service相应方法进行数据保存到数据库中，现只对数据输出
        for (int i = 0; i < listob.size(); i++) {
            List<Object> lo = listob.get(i);
            StudentBean vo = new StudentBean();
            StudentBean j = null;

            //这里是主键验证，根据实际需要添加，可要可不要，加上之后，可以对现有数据进行批量修改和导入
            try {
                j = studentBeanMapper.selectByPrimaryKey(Integer.valueOf(String.valueOf(lo.get(0))));
            } catch (NumberFormatException e) {
                // TODO Auto-generated catch block
//               System.out.println("数据库中无该条数据，新增");
            }
            //vo.setUserId(Integer.valueOf(String.valueOf(lo.get(0))));  // 刚开始写了主键，由于主键是自增的，又去掉了，现在只有批量插入的功能，不能对现有数据进行修改了
            //表格的第一列   注意数据格式需要对应实体类属性

            /*
            vo.setInclass(Integer.valueOf(String.valueOf(lo.get(5))));//课内成绩
            vo.setSpe(Integer.valueOf(String.valueOf(lo.get(6))));//体测成绩
            vo.setSrun(Integer.valueOf(String.valueOf(lo.get(7))));//跑步成绩
            vo.setSresult(Integer.valueOf(String.valueOf(lo.get(8))));//总成绩
            */
            if (j == null) {
                ClassesBeanExample example = new ClassesBeanExample();
                ClassesBeanExample.Criteria criteria = example.createCriteria();
                criteria.andClnameEqualTo(String.valueOf(lo.get(3)));
                List<ClassesBean> classesBeans = classesBeanMapper.selectByExample(example);
                if (classesBeans.size()==0){
                    CollegeBeanExample collegeBeanExample = new CollegeBeanExample();
                    CollegeBeanExample.Criteria criteria1 = collegeBeanExample.createCriteria();
                    criteria1.andCnameEqualTo(String.valueOf(lo.get(1)));
                    List<CollegeBean> collegeBeans = collegeBeanMapper.selectByExample(collegeBeanExample);
                    if (collegeBeans.size()==0){
                        CollegeBean collegeBean = new CollegeBean();
                        collegeBean.setCname(String.valueOf(lo.get(1)));
                        collegeBeanMapper.insertSelective(collegeBean);
                    }
                    List<CollegeBean> collegeBeanList = collegeBeanMapper.selectByExample(collegeBeanExample);
                    Integer cid = collegeBeanList.get(0).getCid();
                    GradeBean gradeBean = new GradeBean();
                    gradeBean.setCid(cid);
                    gradeBean.setGname(Integer.valueOf(String.valueOf(lo.get(2))));
                    gradeBeanMapper.insertSelective(gradeBean);
                    GradeBeanExample gradeBeanExample = new GradeBeanExample();
                    gradeBeanExample.setOrderByClause("gid DESC");
                    List<GradeBean> gradeBeanList = gradeBeanMapper.selectByExample(gradeBeanExample);
                    Integer gid =gradeBeanList.get(0).getGid();
                    ClassesBean classesBean = new ClassesBean();
                    classesBean.setGid(gid);
                    classesBean.setClname(String.valueOf(lo.get(3)));
                    classesBeanMapper.insertSelective(classesBean);
                    List<ClassesBean> classesBeanList = classesBeanMapper.selectByExample(example);
                    Integer clid = classesBeanList.get(0).getClid();

                    vo.setSname(String.valueOf(lo.get(0)));//学生姓名

                    vo.setClid(clid);//班级id
                    vo.setSex(String.valueOf(lo.get(4)));//性别
                    vo.setSnum(String.valueOf(lo.get(5)));//学号
                    vo.setSpassword(String.valueOf(lo.get(6)));//密码
//                    System.out.println(vo);
                    studentBeanMapper.insertSelective(vo);
                    Automation(vo);
                }else {
                    List<ClassesBean> classesBeanList = classesBeanMapper.selectByExample(example);
                    Integer clid = classesBeanList.get(0).getClid();

                    vo.setSname(String.valueOf(lo.get(0)));//学生姓名

                    vo.setClid(clid);//班级id
                    vo.setSex(String.valueOf(lo.get(4)));//性别
                    vo.setSnum(String.valueOf(lo.get(5)));//学号
                    vo.setSpassword(String.valueOf(lo.get(6)));//密码
//                    System.out.println(vo);
                    studentBeanMapper.insertSelective(vo);
                    Automation(vo);
                }
            } else {
                ClassesBeanExample example = new ClassesBeanExample();
                ClassesBeanExample.Criteria criteria = example.createCriteria();
                criteria.andClnameEqualTo(String.valueOf(lo.get(2)));
                List<ClassesBean> classesBeans = classesBeanMapper.selectByExample(example);
                Integer clid = classesBeans.get(0).getClid();
                vo.setSid(Integer.valueOf(String.valueOf(lo.get(0))));
                vo.setSname(String.valueOf(lo.get(1)));//学生姓名
                vo.setClid(clid);//班级id
                vo.setSex(String.valueOf(lo.get(3)));//性别
                vo.setSnum(String.valueOf(lo.get(4)));//学号
                vo.setInclass(Integer.valueOf(String.valueOf(lo.get(5))));//课内成绩
                vo.setSpe(Integer.valueOf(String.valueOf(lo.get(6))));//体测成绩
                vo.setSrun(Integer.valueOf(String.valueOf(lo.get(7))));//跑步成绩
                vo.setSresult(Integer.valueOf(String.valueOf(lo.get(8))));//总成绩
                vo.setSnt(Integer.valueOf(String.valueOf(lo.get(10))));//跑步总次数
                studentBeanMapper.updateByPrimaryKey(vo);
            }

        }

        return Msg.success();
    }

    public void Automation(StudentBean studentBean){
        StudentBeanExample example = new StudentBeanExample();
        StudentBeanExample.Criteria criteria = example.createCriteria();
        criteria.andSnameEqualTo(studentBean.getSname());
        criteria.andSpasswordEqualTo(studentBean.getSpassword());
        List<StudentBean> studentBean1 = studentBeanMapper.selectByExample(example);
        WeekBeanExample weekBeanExample = new WeekBeanExample();
        weekBeanExample.setOrderByClause("wid DESC");
        List<WeekBean> weekBeanList = weekBeanMapper.selectByExample(weekBeanExample);

        ClassesBean classesBean = classesBeanMapper.selectByPrimaryKey(studentBean.getClid());
        GradeBean gradeBean = gradeBeanMapper.selectByPrimaryKey(classesBean.getGid());
        CollegeBean collegeBean = collegeBeanMapper.selectByPrimaryKey(gradeBean.getCid());
        StatisticBean statisticBean = new StatisticBean();
        statisticBean.setSid(studentBean1.get(0).getSid());
        statisticBean.setStnt(0);
        statisticBean.setWid(weekBeanList.get(0).getWid());
        statisticBean.setCid(collegeBean.getCid());
        statisticBean.setGid(gradeBean.getGid());
        statisticBean.setClid(classesBean.getClid());
        statisticBean.setSttime(new Date());
        statisticBeanMapper.insertSelective(statisticBean);


    }

    public List<StudentBean> queryExcelInfo(Integer clid) {
        StudentBeanExample example = new StudentBeanExample();
        StudentBeanExample.Criteria criteria = example.createCriteria();
        criteria.andSdeleteEqualTo(1);
        criteria.andClidEqualTo(clid);
        List<StudentBean> studentBeanList =  studentBeanMapper.selectByExample(example);
        return studentBeanList;
    }

    public ClassesBean findClname(Integer clid) {
        return classesBeanMapper.selectByPrimaryKey(clid);
    }
}
