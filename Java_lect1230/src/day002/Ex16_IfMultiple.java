package day002;

public class Ex16_IfMultiple {

	public static void main(String[] args) {
		// 정수 num 가 2의 배수인지 3의 배수인지 6의 배수인지 2, 3, 6의 배수가 아닌지를 판별하는 코드
		
		int num = 80;
		
		
		// 순서에 상관없이 -> 조건식이 복잡
		if (num % 2 == 0 && num % 3 != 0) {
			System.out.println(num + "은 2의 배수");		
		}else if(num % 2 != 0 && num % 3 ==0) {
			System.out.println(num + "은 3의 배수");	
		}else if(num % 2 == 0 && num % 3 == 0) {
			System.out.println(num + "은 6의 배수");	
		}else {
			System.out.println(num + "은 2의 배수도 3의 배수도 6의 배수도 아니다");	
		}
		
		// 순서가 중요 -> 조건식이 간단
		if (num % 6 == 0) {
			System.out.println(num + "은 6의 배수");		
		}else if(num % 2 == 0) {
			System.out.println(num + "은 2의 배수");	
		}else if(num % 3 == 0) {
			System.out.println(num + "은 3의 배수");	
		}else {
			System.out.println(num + "은 2의 배수도 3의 배수도 6의 배수도 아니다");	
		}

		
		
		if ( num % 2 == 0 ) {
			if ( num % 3 == 0) {
				System.out.println(num + "은 6의 배수");	
			} else {
				System.out.println(num + "은 2의 배수");	
			} 
		}else if ( num % 3 == 0 ) {
				System.out.println(num + "은 3의 배수");	
		}else {
			System.out.println(num + "은 2의 배수도 3의 배수도 6의 배수도 아니다");	
		}
	
		
		int i = 0;
		if(num % 2 == 0) i++;
		
		if(num % 3 == 0) i += 2;
		
	
	
		switch (i) {
		case 1 :
			System.out.println(num + "은 2의 배수");	
			break;
		case 2 :
			System.out.println(num + "은 3의 배수");	
			break;
		case 3 :
			System.out.println(num + "은 6의 배수");	
			break;
		default :
			System.out.println(num + "은 2의 배수도 3의 배수도 6의 배수도 아니다");	
		}
		
		
		
		
	}

}
