package com.webservice.app.Utils;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AppDateUtils
{
    public static Timestamp dateToTimeStamp(Date date)
    {
      //  java.util.Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2011-05-18 16:29:31");
        Timestamp timestamp = new java.sql.Timestamp(date.getTime());
        return timestamp;
    }
}
