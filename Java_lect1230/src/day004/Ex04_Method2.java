package day004;

public class Ex04_Method2 {

	public static void main(String[] args) {
		/* 100 이하의 소수를 출력
		 * 
		 */

		prime(100);
		
		System.out.println();
		
		
		for(int i = 1; i <= 100; i++) {
			System.out.print(isPrimeNumber(i)? i + " " : "" );
		}
		
		/* 10이 소수인지 아닌지 판별
		 * 
		 * 
		 */
		System.out.println();
		
		int num = 10;
		if(isPrimeNumber(num)) {
			System.out.println(num + "는 소수");
		}else {
			System.out.println(num + "는 소수가 아닙니다.");
		}

		System.out.println(isPrimeNumber(num) ? num + "는 소수" : num + "는 소수가 아닙니다.");
		
	}

	public static void primeNum(int num) {
	if(num<2)return ;
		for(int i = 2, count = 0; i < num ; i ++) {
			for(int j = 2; j<i; j++) if(i % j == 0) {count++; break;}
			if (count == 0) System.out.println(i + " ");
			
		}
			
			
		
		return ;
	}
	/**
	 * 
	 * @param num 정수
	 * @return 소수인지 아닌지
	 */
	public static boolean isPrimeNumber(int num) {
		
	/* 기능 : 정수가 소수인지 아닌지 판별하는 메소드
	 * 리턴타입 : boolean
	 * 매개변수 : int
	 * 메소드명 : isPrimeNumber
	 */
		if(num==1) return false;
		for(int i=2; i < num; i++) if(num%i==0) return false; //1과 자기자신 제외한 수 중 약수 찾으면 소수x
		return true;
	}

	public static void prime(int max) {
		
		if(max<2)System.out.println("2이상의 수를 입력해 주세요.");
		for(int i = 2; i <=max; i++) if(isPrimeNumber(i))System.out.print(i + " ");
			
		return;
		
	}
	
	
}
