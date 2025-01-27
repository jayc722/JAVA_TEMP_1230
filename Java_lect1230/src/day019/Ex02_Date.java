package day019;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

public class Ex02_Date {

	public static void main(String[] args) {
		/*
		 * 주어진 문자열이 날짜 형태인지 확인하는 코드 작성
		 * 
		 * 단, 날짜는 yyyy-MM-dd 형태일때만 날짜로 판별
		 */

		String str1 = "2025-01-27";			//o
		
		
		String str2 = "25-01-27";			//x
		
		String str3 = "2025-01-32";			
		
		/*
		String str1 = str11;
		int index1 = str1.indexOf("-");
		if(index1 != 4)return;
		String tmp1 = str1.substring(0,index1);
		str1 = str1.substring(index1+1);
		System.out.println(tmp1);
		System.out.println(str1);
		int index2 = str1.indexOf("-");
		if(index2 != 2)return;
		String tmp2 = str1.substring(index2+1);
		System.out.println(tmp2);
		int index3 = tmp2.length();
		if(index3 != 2)return;

		System.out.println(str11 + "은 날짜 형식입니다.");
		*/
		
		//1.날짜 객체 만드는 방법
		System.out.println(isDate2(str1));
		System.out.println(isDate2(str2));
		System.out.println(isDate2(str3));
		
		System.out.println("-------------------");
		
		System.out.println(isDate3(str1));
		System.out.println(isDate3(str2));
		System.out.println(isDate3(str3));
		
	}
	//Date 객체를 활용해서 사용
	public static boolean isDate1(String str) {
		try{
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			Date date = format.parse(str);
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public static boolean isDate2(String str) {
		try {
			String [] list = str.split("-");
			if(list.length==0)return false;
			if(list[0].length() != 4) return false;
			
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			Date date = format.parse(str);
			return true;

			
			
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
		
		
	}
	
	//정규표현식 활용
	public static boolean isDate3(String str) {
		String regex = "^\\d{4}-\\d{2}-\\d{2}$";
		
		return Pattern.matches(regex, str);
	}
	
	//문자열 추출
	public static boolean isDate4(String str) {
		String [] list = str.split("-");
		if(list.length != 3) return false; 
		
		try {
			if(list[0].length() != 4 || list[1].length() != 2 || list[2].length() != 2)return false;
			int year = Integer.parseInt(list[0]);
			int month = Integer.parseInt(list[1]);
			int day = Integer.parseInt(list[2]);
			return true;
			
		}catch (Exception e) {			//year month day가 integer로 바뀌면 true 안 바뀌면(숫자 이외 포함) false
		return false;
		}

		
		
	}

}
