package day002;

public class Ex12_SwitchEvenNumber {

	public static void main(String[] args) {
		// Switch 문을 이용한 홀짝 판별 예제
		
		int num = 3;
		
		
		switch(num % 2) {
		case 0 :
			System.out.println(num + " 는 짝수");
			break;
		default :
			System.out.println(num + " 는 홀수");
		}

	}

}
