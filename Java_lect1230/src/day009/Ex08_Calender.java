package day009;

import java.util.Calendar;

public class Ex08_Calender {

	public static void main(String[] args) {

		Calendar c = Calendar.getInstance();
		
		System.out.println(c.get(Calendar.YEAR) + "년");
		System.out.println(c.get(Calendar.MONTH) + 1 + "월");
		System.out.println(c.get(Calendar.DAY_OF_MONTH) + "일");
		System.out.println(c.get(Calendar.HOUR_OF_DAY) + "시");
		int date = c.get(Calendar.DAY_OF_WEEK);
		System.out.println(date);
		
		switch(date) {
		case 1 : System.out.println("일");break;
		case 2 : System.out.println("월");break;
		case 3 : System.out.println("화");break;
		case 4 : System.out.println("수");break;
		case 5 : System.out.println("목");break;
		case 6 : System.out.println("금");break;
		case 7 : System.out.println("토");break;
		}
		
		
		
	}

}
