package day009;

import java.util.regex.Pattern;

public class Ex03_Regex {

	public static void main(String[] args) {
		// 주어진 문자열 숫자로만 되어있는지 확인
		
		String str = "0012313a";
						
		String regex = "^\\d+$";
		
		if(Pattern.matches(regex, str)) {
			System.out.println(str + "은 숫자로만 이뤄졌습니다");
			
		}else {
			System.out.println(str + "에 숫자 이외의 문자 있음");
		}
		
		

	}

}
