package generic_utility;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class JavaUtility {
	public static int generateRandomNum() {
		double randomNumber = Math.random()*10000;
		int random = (int) randomNumber;
		return random;
	}
	
	public static boolean compareName(String act, String org) {
		boolean status = act.equals(org);
		if (status) {
			System.out.println("Data created successfully!!!");
			return true;
		} else {
			System.out.println("Failed.....");
		}
		
		return false;
	}
	
	public static String generateDateTime() {		
		LocalDateTime now = LocalDateTime.now();
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("ddMMyyyy_HHmmss");
		
		String time = dtf.format(now);
		return time;
	}
}
