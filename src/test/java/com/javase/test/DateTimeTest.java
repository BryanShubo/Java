/*
package com.javase.test;

import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.joda.time.DateTime;


public class DateTimeTest {

    public static void main(String[] args) {
        Date defaultEffDate = new DateTime(1900,1,1,23,59,59).withTime(23, 59, 59, 999).toDate();

        Date testDate = new DateTime(1900,1,1,23,59,59).withTime(23, 59, 59, 999).toDate();

        Date test2Date = new DateTime(1800,1,1,23,59,59).withTime(23, 59, 59, 999).toDate();

        Date defaultTermDate = new DateTime(9999, 12, 31, 23, 59, 59).withTime(23, 59, 59, 999).toDate();

        System.out.println(defaultEffDate + " : " + defaultTermDate);

        System.out.println(defaultEffDate.before(defaultTermDate));

        System.out.println(defaultEffDate.after(defaultTermDate));

        System.out.println(defaultEffDate.before(testDate));

        System.out.println(defaultEffDate.after(testDate));

        System.out.println(defaultEffDate.compareTo(testDate));
        System.out.println(defaultEffDate.compareTo(defaultTermDate));

        System.out.println(defaultEffDate.compareTo(test2Date));

        String str = "xProduct";
        String str1 = "Xpp";
        System.out.println(StringUtils.startsWith(str, "x"));
        System.out.println(StringUtils.startsWith(str1, "x"));


    }
}
*/
