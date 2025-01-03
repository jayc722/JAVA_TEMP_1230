package day004;

import java.util.Random;

/**
 *  두 정수의 최대 공약수
 *  두 정수의 최소 공배수
 *  메소드 재사용
 */

public class Ex03_Method {

	public static void main(String[] args) {
	
		
		System.out.println(gcd(10,15,1));
		
		System.out.println(lcm(18,39));
		
		System.out.println(lcm2(18,39));
		
		System.out.println(random2(5,77));

		
		
	}

	
	public static int gcd(int num1, int num2, int num3) {
		/* 기능 : 두 정수의 최대공약수
		 * 매개변수 : 두 정수
		 * 리턴타입 : 최대공약수(정수)
		 * 메소드명 : gcd
		 * 	 * 
		 */
	int gcd=1;
	for(int i=1; i<=num1||i<=num2; i++) if(num1%i==0) if(num2%i==0) gcd = i;		
	System.out.println(num1 + " 과 " + num2 + " 의 최대 공약수는 : " + gcd );
	if (num3==1) return gcd;
	else return 0;
	
	}
	
	public static int lcm (int num1, int num2) {
		/* 기능 : 두 정수의 최소공배수를 알려주는 메소드
		 * 매개변수 :
		 * 리턴타입 :
		 * 메소드명 : lcm
		 * 
		 */
		for(int i = num1; i <= num1*num2; i += num1) if (i % num2 == 0) {System.out.println(num1 + " 과 " + num2 + " 의 최소 공배수는 : " + i ); return i;}
		return 0;					//if 속에 리턴이 있으면 이 부분이 따로 필요
	}
	
	public static int lcm2 (int num1, int num2) {
		return num1*num2/gcd(num1,num2,1);		
	}
	
	public static int random2 (int min, int max) {
		/* 최소값과 최댓값 사이 랜덤한 수 생성 메소드
		 * 
		 */
		System.out.print(min + " 와 " + max + " 사이 랜덤한 값 출력 : ");
		Random random = new Random();
		return random.nextInt(max - min + 1) + min;
		
	}
}
