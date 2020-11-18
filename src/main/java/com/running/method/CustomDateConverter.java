package com.running.method;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * @ClassName: CustomDateConverter
 * @Description: 时间转化器
 * @Author: zsl
 * @Date: 2020/8/26 1:58
 * @Version: v1.0
 */
public class CustomDateConverter implements Converter<String, Date>  {
    @Override
    public Date convert(String source) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            return simpleDateFormat.parse(source);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
