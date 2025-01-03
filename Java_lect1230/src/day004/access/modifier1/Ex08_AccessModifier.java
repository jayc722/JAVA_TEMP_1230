package day004.access.modifier1;

import day004.access.modifier2.B;

public class Ex08_AccessModifier {

	public static void main(String[] args) {

		
		//A 클래스는 이 예제와 같은 패키지
		//B 클래스는 이 예제와 다른 패키지
		A a1 = new A();		//같은 패키지는 따로 import 안해도 자동으로 인식
		B b1 = new B();		//다른 패키지라 ctrl+shift+o로 import
		
		
		//public 인 필드들은 다른 패키지의 클래스 에서도 사용 가능
		a1.name = "홍길동";
		b1.name = "임꺽정"; 
		
		// default 인 필드들은 같은 패키지에 있는 클래스에서 사용 가능
		a1.address = "서울시";
		// b1.address = "서울시";			다른 패키지 -> 사용x
		
		// protected는 상속 배우고
		
		//private 는 해당 클래스가 아니면 사용할 수 없음
		//a1.num = "000101-1234567";
		//b1.num = "001101-2345678";
		
		//범위가 좁을 수록 사용이 제한적
		
		//getter 와 setter 로 private 가져올수 있음
		b1.setNum("00101-2345678");
		System.out.println(b1.getNum());
		
		
	}

}
