package com.running.method;

import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Pattern;

/**
 * @ClassName: StringCheck
 * @Description: TODO
 * @Author: zsl
 * @Date: 2020/8/26 3:03
 * @Version: v1.0
 */
@Component
public class StringCheck {

    public enum FormatType{
        INTEGER, // "^(\\+|-)?[1-9]\\d*|0$"
        DECIMALS // "^((-|\\+)?(([1-9]\\d*)|0)(\\.\\d*)?)|0$"
    }

    //字符串长度检查
    public static boolean StringLengthInRange(String str, Integer minLength, Integer maxLength){
        byte bytes[] = str.getBytes();
        return (minLength <= bytes.length && bytes.length <= maxLength );
    }

    //整数字符串格式检查
    public static boolean StringIsInteger(String str){
        return Pattern.matches("^(\\+|-)?[1-9]\\d*|0$", str);
    }

    //小数字符串格式检查
    public static boolean StringIsDecimals(String str){
        return Pattern.matches("^((-|\\+)?(([1-9]\\d*)|0)(\\.\\d*)?)|0$", str);
    }

    //将字符串转换为Integer
    public static Integer transformStringToInteger(String string){
        Integer result = null;
        if(StringIsInteger(string)){
            result = Integer.parseInt(string);
        }
        return result;
    }

    //将字符串转换为Long
    public static Long transformStringToLong(String string){
        Long result = null;
        if(StringIsInteger(string)){
            result = Long.parseLong(string);
        }
        return result;
    }

    //将字符串转换为Double
    public static Double transformStringToDecimal(String string){
        Double result = null;
        if(StringIsDecimals(string)){
            result = Double.parseDouble(string);
        }
        return result;
    }

    //将字符串转换成时间（时分秒）
    public static Date transformStringToDate(String string) throws ParseException {
        Date result = null;
        SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss");
        result = df.parse(string);
        return result;
    }

    /**
     * @desc 字符串转时间戳,并比较大小
     * t1<t2 true
     * ti>t2 false
     * @example time="2019-04-19 00:00:00"
     **/
    public static String largerTime(String t1,String t2) {
        Date date1 ,date2;
        DateFormat formart = new SimpleDateFormat("hh:mm:ss");
        try
        {
            date1 = formart.parse(t1);
            date2 = formart.parse(t2);
            if(date1.compareTo(date2)<0)
            {
                return t2;
            }
            else
            {
                return t1;
            }
        }
        catch (ParseException e)
        {
            System.out.println("date init fail!bai");
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 将时间转化为日期
     * @param date
     * @return
     */
    public static String dateToWeek(Date date) {
        String[] weekDays = { "星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六" };
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        // 指示一个星期中的某天,0代表星期天。
        int w = cal.get(Calendar.DAY_OF_WEEK) - 1 < 0 ? 0 : cal.get(Calendar.DAY_OF_WEEK) - 1;
        return weekDays[w];
    }


}

