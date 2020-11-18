package com.running.controller;

import com.running.service.AutomationService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

/**
 * @ClassName: MyTimerTask
 * @Description: TODO
 * @Author: zsl
 * @Date: 2020/8/26 22:17
 * @Version: v1.0
 */
@Api(tags ="自动化接口，无需调用，自动启动")
@Controller
public class MyTimerTask {
    @Autowired
    AutomationService automationService;
    /**
     * 按顺序依次为
     * 秒（0~59）
     * 钟（0~59）
     * 时（0~23）
     * 天（1~31(但要注意一些特别的月份)）
     * 月（1~12）
     * 周（1~7 1=SUN 或 SUN，MON，TUE，WED，THU，FRI，SAT）
     * 年（1970－2099）年(可选)
     * 其中每个元素可以是一个具体值（1）,也可以是一个连续区间(1-5),也可以是一个间隔时间(1-4/2)(/表示每隔2),也可以是一个列表(1,3,5),或通配符。
     * 由于"月份中的日期"和"星期中的日期"这两个元素互斥的,必须要对其中一个设置?.
     * “?”字符：表示不确定的值
     * “,”字符：指定数个值
     * “-”字符：指定一个值的范围
     * “/”字符：指定一个值的增加幅度。n/m表示从n开始，每次增加m
     * “L”字符：用在日表示一个月中的最后一天，用在周表示该月最后一个星期X
     * “W”字符：指定离给定日期最近的工作日(周一到周五)
     * “#”字符：表示该月第几个周X。6#3表示该月第3个周五字段 允许值 允许的特殊字符
     * 秒 0-59 , - * /
     * 分 0-59 , - * /
     * 小时 0-23 , - * /
     * 日期 1-31 , - * ? / L W C
     * 月份 1-12 或者 JAN-DEC , - * /
     * 星期 1-7 或者 SUN-SAT , - * ? / L C #
     * 年（可选） 留空, 1970-2099 , - * /
     *
     */
//　　 每隔30秒执行一次：*/30 * * * * ?
//    每隔30分钟执行一次：0 */30 * * * ?
//    每天23点执行一次：0 0 23 * * ?
//    每月1号凌晨1点执行一次：0 0 1 1 * ?
//    每月最后一天1点执行一次：0 0 1 L * ?
//    每周星期天凌晨1点实行一次：0 0 1 ? * L
//    每小时在26分、29分、33分执行一次：0 26,29,33 * * * ?
//    每天的0点、13点、18点、21点都执行一次：0 0 0,13,18,21 * * ?

    /**
     * 每周星期一凌晨12点实行一次
     * 0 0 0 ? * 1
     */
    //                 秒分时 日 月 周
    @Scheduled(cron = "0 0 0 ? * MON")
    //@Scheduled(cron = "*/10 * * * * ?")
    public void AutomationIncreaseWeek()
    {
        //开始生成新的一周
        Boolean a=  automationService.AutomationIncreaseWeek();
        //System.out.println(a);
        //每周跑步记录清零
        Boolean b=automationService.AutomationIncreaseStatistic();
        //System.out.println(b);
        //更新新一周学生总跑步次数
        Boolean c=automationService.AutomationUpdateSnt();
        //System.out.println(c);
        //更新新一周学生跑步成绩
        Boolean d=automationService.AutomationUpdatesrun();
        //System.out.println(d);
        //System.out.println("---------------------下一周-------------------------");
    }

}
