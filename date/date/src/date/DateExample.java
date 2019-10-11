package date;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateExample {
	
	public static void main(String[] args) {
		Date time = new Date();
		System.out.println(time);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyy년 MM월 dd일 hh시 mm분 ss초");
		System.out.println(sdf.format(time));
	}
}
