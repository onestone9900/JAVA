package date;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateExample {
	
	public static void main(String[] args) {
		Date time = new Date();
		System.out.println(time);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyy�� MM�� dd�� hh�� mm�� ss��");
		System.out.println(sdf.format(time));
	}
}
