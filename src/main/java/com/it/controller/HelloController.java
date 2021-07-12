package com.it.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Controller
public class HelloController {

    @ResponseBody
    @RequestMapping("/hello")
    public String timecheck(String username) {

        Date date = new Date();

        Date strtodate = null;
        if(belongCalendar(date,strtodate("2021-6-5 00:00:00"),strtodate("2021-6-5 05:00:00"))){
            return username+"早上好";
        }
        if(belongCalendar(date,strtodate("2021-6-5 06:00:00"),strtodate("2021-6-5 11:00:00"))){
            return username+"中午好";
        }
        if(belongCalendar(date,strtodate("2021-6-5 12:00:00"),strtodate("2021-6-5 17:00:00"))){
            return username+"下午好";
        }
        if(belongCalendar(date,strtodate("2021-6-5 18:00:00"),strtodate("2021-6-5 23:00:00"))){
            return username+"晚上好";
        }else {
            return null;
        }


    }

    public static Date strtodate(String str){
        Date date = null;

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        try {
            date =sdf.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }



    public static boolean belongCalendar(Date nowTime, Date beginTime, Date endTime) {
        Calendar date = Calendar.getInstance();
        date.setTime(nowTime);
        Calendar begin = Calendar.getInstance();
        begin.setTime(beginTime);
        Calendar end = Calendar.getInstance();
        end.setTime(endTime);
        if (date.after(begin) && date.before(end)) {
            return true;
        } else if (nowTime.compareTo(beginTime) == 0 || nowTime.compareTo(endTime) == 0) {
            return true;
        } else {
            return false;
        }
    }
}
