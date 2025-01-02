package selfstudy;

import java.util.Scanner;

public class SS_1231_PrimeNumber {

	public static void main(String[] args) {
		
		
int num = 0;
		
		int notPrime=0, count = 0;
		
		Scanner scan = new Scanner(System.in);
		
		for(int i=0;i==0;) {
			System.out.print("약수를 구할 수를 입력하세요. : ");
			num = scan.nextInt();
			i++;
			if(num<=0) {
				System.out.println("양의 정수만 입력해 주세요");
			i=0;
			}
		}
		
		
		for(int i = 1; i <= num; i++) {
			
			notPrime = num % i;
			
			if(notPrime == 0) {
				
				System.out.println(num + " 은 " + i + " 을 약수로 가집니다" );
				count++;
			}
		}
		
		if(count==2) {
			System.out.println(num + " : 1과 자기 자신만을 약수로 가지는 소수입니다.");
		}else {
			System.out.println(num + "의 약수는 1과 자기 자신을 포함하여 " + count + " 개입니다.");
		}
		
		
		
		
		
		
		
		
		
	}

}
