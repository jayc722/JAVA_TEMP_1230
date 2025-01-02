package day003;

import java.util.Scanner;

public class Ex05_ForPrimeNumber {

	public static void main(String[] args) {
		// 정수를 입력받아 입력받은 정수가 소수인지 아닌지 판별하는 예제
		
	Scanner scan = new Scanner(System.in);
	int isPrime = 0;	

	System.out.print("정수를 입력하세요 : ");
	int num = scan.nextInt();
		
	for (int i = 2; i < num; i++) if (num % i == 0) isPrime++;
		
	if (isPrime==0) System.out.println(num + " 은 소수입니다.");
	else System.out.println(num + " 의 약수는 " + (isPrime + 2) + " 개입니다.");

	}

}
