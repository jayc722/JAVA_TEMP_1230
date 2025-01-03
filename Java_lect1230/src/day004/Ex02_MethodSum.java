package day004;

public class Ex02_MethodSum {

	public static void main(String[] args) {
		
		int num1 = 1, num2 = 2;
		int sum = sum(15, 20);
		System.out.println(sum(1,2) + " + " + sum + " = " + (sum + sum(num1,num2)));
		
		
		
	}
	
	
	/* 두 정수가 주어지면 두 정수의 합을 알려주는 메소드
	 * 매개변수 : 두 정수 int num1, int num2
	 * 리턴타입 : 두 정수의 합(정수,int)
	 * 메소드명 : sum
	 * 접근제어자 클래스 리턴타입 클래스명 ( 매개변수 ) { }
	 * 
	 */

	public static int sum(int num1, int num2) {
		int result;
		result = num1 + num2;		
		return result;
	}
	
	
	
}
