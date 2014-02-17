package com.cmp.testschedular;

import java.util.*;
import java.util.Timer;

public class MainApplication {
//Live Url To start timer:http://checkmypasswords.com/RememberYourPassword/Login.do?method=restart	
//method=restart
   public void start() {
    Timer timer = new Timer();
    System.out.println("I am starting re bho.........");
    Calendar date = new GregorianCalendar();//Calendar.getInstance();
   // date.set(
      //Calendar.DAY_OF_WEEK,
      //Calendar.SUNDAY
   // 		Calendar.AM,Calendar.PM
   // );
    /*System.out.println(Calendar.AM);
    System.out.println(Calendar.PM);
    date.set(Calendar.HOUR, 0);
    date.set(Calendar.MINUTE, 0);
    date.set(Calendar.SECOND, 0);
    date.set(Calendar.MILLISECOND, 0);*/
    date.set(Calendar.HOUR_OF_DAY, 0);
    date.set(Calendar.MINUTE, 0);
    date.set(Calendar.SECOND, 0);
    date.set(Calendar.MILLISECOND, 0);

    // next day
    //date.add(Calendar.DAY_OF_MONTH, 1);
    // Schedule to run every Sunday in midnight
    timer.schedule(
      new ReportGenerator(),date.getTime(),1000* 60* 60 * 24      
    );
  }
}