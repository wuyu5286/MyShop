package com.jumeng.shop.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * ============================================================
 * 描 述 :
 * 作 者 : 鸿浩
 * 时 间 : 2015/12/25.
 * ============================================================
 */
public class DateUtil {
    public static final String FORMAT_TYPE = "yyyy-MM-dd";

    public static String[] getDate(long time) {
        String[] strings = new String[3];
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(time);
        String format = new SimpleDateFormat(FORMAT_TYPE).format(cal.getTime());
        String[] date = format.split("-");
        strings[0] = date[0];
        strings[1] = getMonth(date[1]);
        strings[2] = date[2];
        return strings;
    }

    private static String getMonth(String month) {
        switch (month) {
            case "01":
                return "JAN";
            case "02":
                return "FEB";
            case "03":
                return "MAR";
            case "04":
                return "APR";
            case "05":
                return "MAY";
            case "06":
                return "JUN";
            case "07":
                return "JUL";
            case "08":
                return "AUG";
            case "09":
                return "SEP";
            case "10":
                return "OCT";
            case "11":
                return "NOV";
            case "12":
                return "DEC";
            default:
                return "";
        }
    }
}
