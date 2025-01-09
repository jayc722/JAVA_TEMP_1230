package day008;

public class Ex07_Final {

	public static void main(String[] args) {
		/* final : 변하지 x
		 * -변수 : 변수가 변하지 않음 => 상수
		 * 		Math.PI
		 * -메소드 =>오버라이딩 불가
		 * -클래스 => 상속 불가
		 * String
		 * 
		 */
		//상수는 재할당이 한 번만 가능한 변수
		final int max;
		max = 10;

	}

}
final class C1{}
class C2{
	public void test1() {}
	public final void test2() {} 
}

//class D1 extends C1{}				//에러 : final class 부모 될 수 x
									//final 이 붙지 않으면 상속 가능
class D2 extends C2{
	
	@Override
	public void test1() {}
	//@Override
	//public void test2() {}		//final 메소드 -> 오버라이드 x
	
	
	
}