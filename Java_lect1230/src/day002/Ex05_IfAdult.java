package day002;

public class Ex05_IfAdult {

	public static void main(String[] args) {
		/* 나이를 저장하는 변수 age 를 선언 및 초기화 하고
		 * age 가 19세 이상이면 성인, 아니라면 미성년자라고 출력하는 코드를 작성
		 */
		
		int age = 15 ;
		
		if(age >= 19) {
			System.out.println(age + " 세는 성인 입니다.");
		}
		
		if(!(age >= 19)) {
			System.out.println(age + " 세는 미성년자 입니다.");
		}

	}

}
