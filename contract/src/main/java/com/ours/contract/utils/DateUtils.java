package com.ours.contract.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
    public static String getYmdMhs(Date date) {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
    }
}
