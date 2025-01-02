package day003;

import java.util.Scanner;

public class Ex06_ForGCD {

	public static void main(String[] args) {
		// 두 정수 num1과 num2를 입력받아 최대 공약수를 구하는 코드를 작성하세요

	Scanner scan = new Scanner(System.in);
		
	int gcd=1;
		
	System.out.print("두 정수를 입력하세요 : ");
	int num1 = scan.nextInt(), num2 = scan.nextInt();
		
	for(int i=1; i<=num1||i<=num2; i++) if(num1%i==0) if(num2%i==0) gcd = i;		//중첩if문으로 &&연산자와 같은 효과
	System.out.println(num1 + " 과 " + num2 + " 의 최대 공약수는 : " + gcd );
	
	}

}
