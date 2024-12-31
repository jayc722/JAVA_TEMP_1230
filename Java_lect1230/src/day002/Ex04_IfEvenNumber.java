package day002;

public class Ex04_IfEvenNumber {

	public static void main(String[] args) {
		/* if 문을 이용한 홀짝 판별 예제
		  */

		int num = 4;
		
		// num 가 짝수라면 짝수라고 출력
		
		if (num % 2 == 0) {
			System.out.println(num + " 는 짝수입니다");
		}
		
		// num 가 홀수면 홀수라고 출력
		
		if (num % 2 != 0) {
			System.out.println(num + " 는 홀수입니다");
		}
		
		
		
		
		
	}

}
