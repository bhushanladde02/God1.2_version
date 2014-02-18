package com.cmp.testschedular;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import mainpackage.AutoUpdate;

public class ReportGenerator extends TimerTask {

  public void run() {
    System.out.println("Generating report");
    //CleanerDatabase.deletecontent(); Call final method here
	AutoUpdate auto=new AutoUpdate();
	auto.mainMethod();
   }

}
