package day001;

public class Ex03_VariableNumber {

	public static void main(String[] args) {

		float num4 = 3.14f;
		System.out.printf("%.9f\n", num4);
		
		double num5 =3.14;
		System.out.printf("%.20f\n", num5);
		//소수점 20자리까지 확인
		
		//십진수 표현이 아닌 값을 정수에 저장하는 예제		
		int num6 = 0x10;	//16진수 10 => 16
		System.out.println(num6);
		int num7 = 010;		//8진수 10 => 8
		System.out.println(num7);
		int num8 = 0b10;	//2진수 10 => 2
		System.out.println(num8);
		int num9 = 'A';		//'A'에 해당하는 정수값(0041) 저장 => 65
		System.out.println(num9);
		double num10 =1e3; 	// 1*10^3 => 1000
		System.out.println(num10);
	}

}
