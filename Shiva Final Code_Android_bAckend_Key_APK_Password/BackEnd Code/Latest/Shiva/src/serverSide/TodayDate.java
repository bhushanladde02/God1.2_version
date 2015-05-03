package serverSide;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TodayDate {

	public static String todaydate()
	{
		 Date date = new Date();
		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
	     return sdf.format(date);
	}
}
