package com.webservice.app.Utils;

import org.apache.commons.lang.time.DateUtils;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Class for converting dates into multiple formats.
 */
public class AppDateUtils
{
    public static Timestamp dateToTimeStamp(Date date)
    {
      //  java.util.Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2011-05-18 16:29:31");
        Timestamp timestamp = new java.sql.Timestamp(date.getTime());
        return timestamp;
    }

    public static Date strToDate(String dateString) throws ParseException
    {
        String[] patterns = new String[] {"dd/MM/yyyy"};
       return DateUtils.parseDate(dateString,patterns);
    }
}
