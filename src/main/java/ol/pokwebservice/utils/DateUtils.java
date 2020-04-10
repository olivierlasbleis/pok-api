package ol.pokwebservice.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtils {
	
	public static String generateDate() {
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");
	LocalDateTime now = LocalDateTime.now();
	return dtf.format(now); 
	}
	
	public static boolean compareDateUnder24Hours(String dateString) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm"); 
		LocalDateTime dateTime = LocalDateTime.parse(dateString, formatter).plusDays(1);
		LocalDateTime now = LocalDateTime.now();
		if (now.compareTo(dateTime) > 0) {
			return false;
		} else {
			return true;
		}
		
	}
}
