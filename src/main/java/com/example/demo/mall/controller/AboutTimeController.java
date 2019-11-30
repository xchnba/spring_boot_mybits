package com.example.demo.mall.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.SQLOutput;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.zip.DataFormatException;

@Controller
@RequestMapping("/time")
public class AboutTimeController {
    @RequestMapping("/convertime")
    @ResponseBody
    public String converTime()   {
        DateTimeFormatter df =  DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter dft =  DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String date = "2019-11-30";
        String dateTime = "2019-11-30 17:35:35";
        //只能转换成localDate格式
        LocalDate ld = LocalDate.parse(date,df);
        //转成LocalDateTime格式会报错
//        java.time.DateTimeException: Unable to obtain LocalTime from TemporalAccessor: {},ISO resolved to 2019-11-30 of type java.time.format.Parsed
//        LocalDateTime ldt = LocalDateTime.parse(date,df);
        LocalDateTime ldt = LocalDateTime.parse(dateTime,dft); //这样才可以，一定要格式相同比 Date格式严格多了
        //localDate转成时间戳
        long timestamp = ld.atStartOfDay(ZoneOffset.ofHours(8)).toInstant().toEpochMilli();
        //时间戳转成localDateTime
        LocalDateTime localDateTime = Instant.ofEpochMilli(timestamp).atZone(ZoneOffset.ofHours(8)).toLocalDateTime();
        //获取秒数 localDateTime转换时间戳
        Long second = localDateTime.toEpochSecond(ZoneOffset.of("+8"));
        //获取毫秒数 localDateTime转换时间戳
        Long milliSecond = localDateTime.toInstant(ZoneOffset.of("+8")).toEpochMilli();

        //localDateTime 转换成String 当然也是要到时分秒的
        String dateTimes = localDateTime.format(dft);
        System.out.println("dateTimes==="+dateTimes);

        //时间戳转换成localDate
        LocalDate         localDate = Instant.ofEpochMilli(timestamp).atZone(ZoneOffset.ofHours(8)).toLocalDate();
        //将时间戳转换成Date
        Date dates = new Date(timestamp);
        System.out.println("dates===="+dates);
        //将Date转成时间戳   时间戳除以1000可以得到秒
        Long  dateconvertimestamp = dates.getTime();
        if(timestamp == dateconvertimestamp){
            System.out.println("转换时间是一样的");
        }
        //Date格式用这个格式转成String 或者 String转成 Date
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat sdfd = new SimpleDateFormat("yyyy-MM-dd");
        String nowDate = sdfd.format(dates);
        System.out.println("nowDate=="+nowDate);
        String nowDateTime = simpleDateFormat.format(dates);
        System.out.println("nowDateTime=="+nowDateTime);

        try {
            //又将String转换回Date
            Date dt = sdfd.parse(nowDate);
            System.out.println("dt===="+dt);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return dates.toString();
    }

    //LocalDate和LocalDateTime的一些新特性
    @RequestMapping("/localDate")
    @ResponseBody
    public String LocalDateAndTime(){
        //获取当前日期
        LocalDate.now();
        //根据参数设置日期，参数分别为年，月，日
        LocalDate localDate = LocalDate.of(2019,1,7);
        System.out.println(localDate);  //运行结果为：2019-01-07
        //获取当前日期是所在月的第几天
        localDate.getDayOfMonth();
        //获取当前日期是星期几（星期的英文全称）
        localDate.getDayOfWeek();
        //获取当前日期是所在年的第几天
        localDate.getDayOfYear();
        //获取当前日期所在月份（月份的英文全称）
        localDate.getMonth();
        //获取当前日期所在月份的数值
        localDate.getMonthValue();
        //获取当前日期所在月份有多少天
        localDate.lengthOfMonth();
        //获取当前日期所在年有多少天
        localDate.lengthOfYear();
        //获取当前日期所在年是否是闰年
        localDate.isLeapYear();
        //with开头的方法，我的理解是将参数替换localDate中的对应属性，重新计算得到新的日期。
//        LocalDate localDate = LocalDate.of(2019,1,7);
        System.out.println(localDate.withDayOfMonth(2));//2019-01-02，
        System.out.println(localDate.withDayOfYear(40)); //2019-02-09，
        System.out.println(localDate.withMonth(2));//2019-02-07，
        System.out.println(localDate.withYear(2020));//2020-01-07

        System.out.println(localDate.minusDays(1)); //将当前日期减一天
        System.out.println(localDate.minusMonths(1));//将当前日期减一月
        System.out.println(localDate.minusWeeks(1));//将当前日期减一周
        System.out.println(localDate.minusYears(1));//将当前日期减一年
        System.out.println(localDate.plusDays(1)); //将当前日期加一天
        System.out.println(localDate.plusMonths(1));//将当前日期加一月
        System.out.println(localDate.plusWeeks(1));//将当前日期加一周
        System.out.println(localDate.plusYears(1));//将当前日期加一年


        LocalTime localTime = LocalTime.of(12,35,59);
        System.out.println(localTime.minusHours(1)); //将当前时间减一小时
        System.out.println(localTime.minusMinutes(1)); //将当前时间减一分钟
        System.out.println(localTime.minusSeconds(10));//将当前时间减十秒
        System.out.println(localTime.plusHours(1));//将当前时间加一小时
        System.out.println(localTime.plusMinutes(1)); //将当前时间加一分钟
        System.out.println(localTime.plusSeconds(10));//将当前时间加十秒

        System.out.println(localTime.getHour()); //获取当前时间的小时数
        System.out.println(localTime.getMinute()); //获取当前时间的分钟数
        System.out.println(localTime.getSecond()); //获取当前时间的秒数


        return "aaa";
    }



}
