package day001;

public class Ex08_VariableCasting {

	public static void main(String[] args) {
		
		
		// 자동 자료형 변환
		double num1 = 1;		// int 1이 double 로 자동 형변환
		
		int num2 = 'A';			// A 정수값. char A가 int 로 자동 형변환
		
		long num3 = 1234;		// int 1234 가 long 으로 자동 형변환
		
		System.out.println(num1);
		System.out.println(num2);
		System.out.println(num3);
		
		
		//강제 자료형 변환 : 데이터 손실 발생(반드시)		데이터 값 손실 발생하기 때문에 에러
		int num4 = (int)3.14;		//		소수점 버림
		int num5 = (int)123L;		// 		앞자리 버림
		
		System.out.println(num4);
		System.out.println(num5);
		
		//강제 자료형 변환 : 원하는 결과값을 위해서(임의)
		double result = (double)1 / 2;		//정수 나누기 정수는 0이 나오기 때문에 둘중 하나를 실수로 만들어놓을 필요가
		
		System.out.println(result);

	}

}
