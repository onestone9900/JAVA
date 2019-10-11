package date;

import java.util.Calendar;

public class CalendarExample {

	public String getWeek(int week) {
		
		String resultWeek="";
		
		switch(week) {
			case Calendar.MONDAY :
				resultWeek = "월요일";
				break;
			case Calendar.TUESDAY :
				resultWeek = "화요일";
				break;
			case Calendar.WEDNESDAY :
				resultWeek = "수요일";
				break;
			case Calendar.THURSDAY :
				resultWeek = "목요일";
				break;
			case Calendar.FRIDAY:
				resultWeek = "금요일";
				break;
			case Calendar.SATURDAY:
				resultWeek = "토요일";
				break;
			case Calendar.SUNDAY :
				resultWeek = "일요일";
				break;
		}
		return resultWeek;
	}
	
	public String getAmPm(int ampm) {
		return ampm==Calendar.AM ? "AM" : "PM";
	}
	
	public static void main(String[] args) {
		CalendarExample ce = new CalendarExample();
		
		Calendar now = Calendar.getInstance();
		
		//년
		int year = now.get(Calendar.YEAR);
		System.out.println(year+"년");
		//월
		int month = now.get(Calendar.MONTH) + 1;
		System.out.println(month+"월");
		//일
		int day = now.get(Calendar.DAY_OF_MONTH);
		System.out.println(day+"일");
		//주
		System.out.println(ce.getWeek(now.get(Calendar.DAY_OF_WEEK)));
		//ampm
		System.out.println(ce.getAmPm(now.get(Calendar.AM_PM)) );
		//시간
		int hour = now.get(Calendar.HOUR);
		System.out.println(hour + ":");
		//분
		int minute = now.get(Calendar.MINUTE);
		System.out.println(minute + ":");
		//초
		int second = now.get(Calendar.SECOND);
		System.out.println(second + ":");
		
		
		
	}
}

