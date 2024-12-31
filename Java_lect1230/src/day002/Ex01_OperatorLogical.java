package day002;

public class Ex01_OperatorLogical {

	public static void main(String[] args) {
	
		
		//성적을 저장하기 위한 정수 변수를 선언하고, 80으로 초기화 하세요.
		
		int score = 80;
		boolean isB = score >= 80 && score < 90;
		System.out.println(score + " 는 B 입니까? " + isB);

		
		//나이가 19세 이상이면 성인임을 판별하는 예제
				
		int age = 25;
		boolean isAdult = age >= 19;
		System.out.println(age + " 살은 성인입니까? " + isAdult);

		
		//나이가 19세이상이 아니면 청소년으로 판별하는 예제(!연산자)
		System.out.println(age + " 살은 미성년자입니까? " + !isAdult);
	

		//정수가 0이상인지 판별하는 예제(||연산자)
		int num = 10;
		boolean isPositive = num > 0 || num == 0;	// num >= 0;
		System.out.println(num + " 는 0 이상인가? " + isPositive);
		
		
		
	
	}

}
