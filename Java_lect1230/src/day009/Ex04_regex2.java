package day009;

import java.util.regex.Pattern;

public class Ex04_regex2 {

	public static void main(String[] args) {
		// 주어진 아이디가 주어진 조건에 맞는지 확인
		//아이디는 숫자 또는 영문 또는 특수문자
		//아이디 최소 8자에서 최대 13자
		
		String id ="bac123111";
		
		String regex = "^(\\w|[!@#$]){8,13}$";			//\w 가 아니라 \\w 로 입력해야
														//[a-zA-Z0-9!@#$]{8,13}$
		
		if(Pattern.matches(regex,id))System.out.println(id + "는 사용이 가능");
		else System.out.println(id + "는 사용이 불가");
		

	}

}
