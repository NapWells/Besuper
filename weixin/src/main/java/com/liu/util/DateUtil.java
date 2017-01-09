package com.liu.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by anybody on 2017/1/4.
 */
public class DateUtil {
    public static String formatDate(Date date){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        return dateFormat.format(date);
    }
}
