package com.liu.managerial_system.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author : liuhongbo
 * @description : TODO
 * @date : 2022/5/4 15:15
 */
public class TimeUtil {
    public static String getDateByDayOfWeek(String firstDayOfWeek, String dayOfWeek) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd");
        int nextDay = 0;
        Calendar calendar = Calendar.getInstance();
        try {
            Date date = simpleDateFormat.parse(firstDayOfWeek);
            calendar.setTime(date);
            switch (dayOfWeek) {
                case "1":
                    break;
                case "2":
                    nextDay = 1;
                    break;
                case "3":
                    nextDay = 2;
                    break;
                case "4":
                    nextDay = 3;
                    break;
                case "5":
                    nextDay = 4;
                    break;
                case "6":
                    nextDay = 5;
                    break;
            }
            calendar.add(Calendar.DAY_OF_WEEK, nextDay);
            return simpleDateFormat.format(calendar.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
