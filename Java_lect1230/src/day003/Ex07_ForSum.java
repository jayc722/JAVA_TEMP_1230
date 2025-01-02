package day003;

public class Ex07_ForSum {

	public static void main(String[] args) {
		/* 1 부터 10까지의 합을 구하는 코드
		 * 
		 */
		
		int sum = 0;
		int num = 10;
		for(int i = 1; i <= num; i++) sum += i;
		
		System.out.println("1부터 " + num + " 까지의 합은 " + sum + " 입니다.");
	
		
		//1부터 10까지의 짝수의 합
		sum=0;
		for(int i = 1; i <= num; i++) if(i%2==0) sum += i;
		
		System.out.println("1부터 " + num + " 까지의 짝수의 합은 " + sum + " 입니다.");
		
		sum=0;
		for(int i = 2; i <= num; i+=2) sum += i;
		
		System.out.println("1부터 " + num + " 까지의 짝수의 합은 " + sum + " 입니다.");
		
		sum=0;
		for(int i = 1; i <= num/2; i++) sum += 2*i;
		
		System.out.println("1부터 " + num + " 까지의 짝수의 합은 " + sum + " 입니다.");

		
		
	}

}
