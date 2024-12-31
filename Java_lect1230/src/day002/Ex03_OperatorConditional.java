package day002;

public class Ex03_OperatorConditional {

	public static void main(String[] args) {
		
		/*  num가 홀수이면 false 라고 출력하고 num 가 짝수이면 true라고 출력하는 예제 (어제 한 것) 
		 	num가 홀수이면 홀수라고 출력하고 num 가 짝수이면 짝수라고 출력하는 예제	 */
		//조건연산자
		
		int num = 3;
		boolean isEven = num % 2 == 0;
		System.out.println(num + " 는 짝수? " + isEven);
		
		String result = (num % 2 == 0) ? "짝수" : "홀수";				// 조건선택연산자 (조건식) ? (참일 때 결과값) : (거짓일 때 결과값)
		
		System.out.println(num + " 는 " + result);
		
	}

}
