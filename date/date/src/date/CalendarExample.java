package date;

import java.util.Calendar;

public class CalendarExample {

	public String getWeek(int week) {
		
		String resultWeek="";
		
		switch(week) {
			case Calendar.MONDAY :
				resultWeek = "������";
				break;
			case Calendar.TUESDAY :
				resultWeek = "ȭ����";
				break;
			case Calendar.WEDNESDAY :
				resultWeek = "������";
				break;
			case Calendar.THURSDAY :
				resultWeek = "�����";
				break;
			case Calendar.FRIDAY:
				resultWeek = "�ݿ���";
				break;
			case Calendar.SATURDAY:
				resultWeek = "�����";
				break;
			case Calendar.SUNDAY :
				resultWeek = "�Ͽ���";
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
		
		//��
		int year = now.get(Calendar.YEAR);
		System.out.println(year+"��");
		//��
		int month = now.get(Calendar.MONTH) + 1;
		System.out.println(month+"��");
		//��
		int day = now.get(Calendar.DAY_OF_MONTH);
		System.out.println(day+"��");
		//��
		System.out.println(ce.getWeek(now.get(Calendar.DAY_OF_WEEK)));
		//ampm
		System.out.println(ce.getAmPm(now.get(Calendar.AM_PM)) );
		//�ð�
		int hour = now.get(Calendar.HOUR);
		System.out.println(hour + ":");
		//��
		int minute = now.get(Calendar.MINUTE);
		System.out.println(minute + ":");
		//��
		int second = now.get(Calendar.SECOND);
		System.out.println(second + ":");
		
		
		
	}
}

