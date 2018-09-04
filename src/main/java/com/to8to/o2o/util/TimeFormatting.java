package com.to8to.o2o.util;

import java.util.Date;

public class TimeFormatting {

    /**
     * 获取时间戳 10位
     */
    public static int setSecondTimestamp(Date date){
        if (null == date) {
            return 0;
        }
        String timestamp = String.valueOf(date.getTime());
        int length = timestamp.length();
        if (length > 3) {
            return Integer.valueOf(timestamp.substring(0,length-3));
        } else {
            return 0;
        }
    }
}
