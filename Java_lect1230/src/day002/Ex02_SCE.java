package day002;

public class Ex02_SCE {

	public static void main(String[] args) {

		//단락회로평가 예제(SCE)
		//short-circuit evaluation
		int num1 = -10, num2 = 20;
		// sce에 의해 num1이 양수이면 num2가 안 바뀌고 num1이 음수이면 num2 가 10으로 바뀜 >> 대입 연산자를 논리연산자와 안 쓰면 문제는 없음
		boolean result = num1 < 0 && (num2 = 10) < 0;
		
		System.out.println("결과 값 : "  + result);
		System.out.println("num1 : "  + num1 + ", num2 : " + num2);

	}

}
