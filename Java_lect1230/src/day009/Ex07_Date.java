package day009;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Ex07_Date {

	public static void main(String[] args) throws ParseException {

		
		
		Date date = new Date();
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		System.out.println(date);

		String str = format.format(date);
		
		System.out.println(str);
		
		str = "2024-01-01 14:30:00";
		
		//date = format.parse(str);			//예외 발생
		
		date = format.parse(str);
		
		System.out.println(date);
		
		
		
		
	}

}
