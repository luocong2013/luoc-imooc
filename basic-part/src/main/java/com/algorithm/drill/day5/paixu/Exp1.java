package com.algorithm.drill.day5.paixu;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Exp1 {

    public static void main(String[] args) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd a HH:mm:ss SSS Z");
        Calendar calendar = Calendar.getInstance();
        System.out.println(df.format(calendar.getTime()));
    }

}
