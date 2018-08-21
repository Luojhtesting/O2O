package com.to8to.o2o.testScripts;

import javax.xml.crypto.Data;
import java.util.Date;

public class Time {

    public static void main(String[] args) {
        Date date = new Date();
        System.out.println(getSecondTimestamp(date));
    }

    public static int getSecondTimestamp(Date date){
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
