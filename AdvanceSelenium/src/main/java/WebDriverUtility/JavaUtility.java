package WebDriverUtility;
import java.sql.Date;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

public class JavaUtility {
  public int getRandomNumber() {
	  Random random = new Random();
	  int randomNumber = random.nextInt(5000);
	  return randomNumber;
  }
  
  public String getSystemDateYYYYMMDD() {
	  
	  Date dateObj = new Date(0);
	  SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	  String enddate = sdf.format(dateObj);
	return enddate;
	  
  }
  public String getRequireDateYYYYMMDD(int days) {
	 
	  SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");
	 
	  Calendar cal = sim.getCalendar();
	  cal.add(Calendar.DAY_OF_MONTH, 30);
	  String StartDate = sim.format(cal.getTime());
	  return StartDate;
  }


}
