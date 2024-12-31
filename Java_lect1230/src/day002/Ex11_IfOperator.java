package day002;
import java.util.Scanner;

public class Ex11_IfOperator {

	public static void main(String[] args) {
		/* 두 정수와 산술 연산자를 입력받는 코드
		 * 예시) 두 정수와 산술 연산자를 입력하세요 ( 1 + 2 ) : 3 * 4
		 * 3 * 4
		 */
		
		int num1 = 0, num2 = 0;
		char oper = 0;
		Scanner scan = new Scanner(System.in);
		
		System.out.print(" 두 정수와 산술 연산자를 입력하세요. 스페이스로 구분합니다. (예시 : 1 + 2) : ");
		num1 = scan.nextInt();
		oper = scan.next().charAt(0);
		num2 = scan.nextInt();
		
		System.out.println(num1 + " " + oper + " " + num2 );
		
		int answer = 0;
		double answer2 = 0;
		
		if (oper == '+') {
			answer = num1 + num2;
			System.out.println("결과는 : " + answer);
			System.out.println(" " + num1 + " " + oper + " " + num2 + " = " + (num1 + num2));
		} else if (oper == '-') {
			answer = num1 - num2;
			System.out.println("결과는 : " + answer);
			System.out.println(" " + num1 + " " + oper + " " + num2 + " = " + (num1 - num2));
		} else if (oper == '*') {
			answer = num1 * num2;
			System.out.println("결과는 : " + answer);
			System.out.println(" " + num1 + " " + oper + " " + num2 + " = " + (num1 * num2));
		} else if (oper == '/') {
			answer2 =num1 / (double)num2;
			System.out.println("결과는 : " + answer2);
			System.out.println(" " + num1 + " " + oper + " " + num2 + " = " + ((double)num1 / num2));
		} else if (oper == '%') {
		answer = num1 % num2;
		System.out.println("결과는 : " + answer);
		System.out.println(" " + num1 + " " + oper + " " + num2 + " = " + (num1 % num2));
		}  else  				{
			System.out.println(oper + "는 잘못된 산술 연산자입니다");
		}

	}

}
