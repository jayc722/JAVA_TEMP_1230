package day011;

public class Ex01_Lambda {

	public static void main(String[] args) {

		//인터페이스의 객체를 생성하기 위해 구현 클래스 선언 후 구현 클래스의 객체를 생성 	(1)
		MyMath mm = new MyMathClass();

		System.out.println(mm.max(1, 2));

		//인터페이스의 객체를 생성하기 위해 익명 클래스 선언 후 객체를 생성				(2)

		MyMath mm2 = new MyMath() {
			@Override
			public int max(int num1, int num2) {
				return num1 > num2 ? num1 : num2;	// 두 정수중에 큰 값을 리턴
			}

		};
		System.out.println(mm2.max(1, 2));

		//람다식 : 인터페이스의 객체를 생성하기 위해 인명클래스 선언 후 객체 생성			(3)
		//함수형 인터페이스(추상메소드가 하나뿐) 인 경우에만 가능
		MyMath mm3 = (num1, num2)->{
			return num1 > num2 ? num1 : num2;
		};
		System.out.println(mm3.max(1, 2));
		//실행문 하나일 경우	
		MyMath mm4 = (num1, num2)-> num1 > num2 ? num1 : num2;
		//매개변수 하나면 ^이 소괄호도 지워도됨
		System.out.println(mm4.max(1, 2));
		
		Abs abs = (num) ->{
			return num < 0 ? -num : num;
		};		//간소화가 가능 Abs abs = num -> num < 0 ? -num : num;
		System.out.println(abs.abs(-10));
	}
}

//인터페이스																(1)
interface MyMath{
	int max(int num1, int num2);		//두 정수중에 큰 num을 반환하는 인터페이스
}

interface Abs{
	int abs(int num);
}


//기존 -> 구현 클래스(람다식x)												(1)
class MyMathClass implements MyMath{

	@Override
	public int max(int num1, int num2) {
		return num1 > num2 ? num1 : num2;	// 두 정수중에 큰 값을 리턴
	}



}