package day009;

import java.text.DecimalFormat;
import java.text.MessageFormat;

public class Ex09_Format {

	public static void main(String[] args) {
		DecimalFormat format = new DecimalFormat("###,###");
		int num = 123456789;
		System.out.println(format.format(num));
		
		String message = "{0} : {1}";
		String name = "홍길동";
		int score = 100;
		//format 메소드 : 가변 매개변수, 매개변수의 다형성, 박싱, 래퍼클래스(자동)
		String result = MessageFormat.format(message,  name, score);
		
		System.out.println(result);
		
		

	}

}
