package day003;

public class Ex19_NestingPrimeNumber {

	public static void main(String[] args) {
		// 100 이하의 소수 출력하는 코드


		
		
		for(int num = 2, count = 0; num <= 100; num++) {
			for(int i=2;i<num; i++) {
				if(num % i ==0)count++;
			}
			if(count==0)System.out.print(num + " ");
			count=0;
		}
		
		System.out.println();
		
		for(int num = 2; num <= 100; num++) {
			for(int i=2; i<num; i++) {
				if(num % i == 0)break;
				else {
					System.out.print(num + " ");
					break;
				}
				
		}
		}
		
		
		
		
	}

}
