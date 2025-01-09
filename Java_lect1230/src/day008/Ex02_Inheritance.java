package day008;

import lombok.Data;
import day008.ex02.*;    // * 는 all

public class Ex02_Inheritance {

	public static void main(String[] args) {
		
		/* kiacar 생성 시
		 * car 클래스 멤버변수 power speed 먼저 생성
		 * car 클래서 생성자로 초기화 됨
		 * kiacar 클래서에서 선언한 멤버변수 생성
		 * kiacar 클래스 생성자로 초기화
		 * 
		 * 
		 * 
		 */
		
		
		KiaCar kia = new KiaCar();
		//kia.power = true; 				// private라 불가
		kia.turnOn();
		System.out.println(kia.isPower());
		//kia.speed = 10;						// protected 는 자기 + 패키지 + 자식 ->같은 패키지라 되는것
												// 자식 클래스가 아닌 다른 패키지에서 사용 ㅍ불가
	}
}

class Hyundai extends Car{
	
	public void test() {
		speed = 0;
		//다른 패키지이지만 자식 클래스면 사용 가능
	}
	
	
}

