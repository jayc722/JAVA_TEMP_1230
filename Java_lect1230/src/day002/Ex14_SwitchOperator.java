package day002;

import java.util.Scanner;

public class Ex14_SwitchOperator {

	public static void main(String[] args) {
		// switch 문을 이용해서 두 정수의 산술 연산코드

		
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("두 정수와 산술 연산자를 입력하세요. 스페이스로 구분합니다. (예시 : 1 + 2) : ");
		int num1 = scan.nextInt();
		char operator = scan.next().charAt(0);
		int num2 = scan.nextInt();
		
		
		
		switch(operator) {
		case '+' :
			System.out.println(num1 + " " + operator + " "  + num2 + " = " + (num1 + num2));
		break;
		case '-' :
			System.out.println(num1 + " " + operator + " "  + num2 + " = " + (num1 - num2));
		break;
		case '*' :
			System.out.println(num1 + " " + operator + " "  + num2 + " = " + (num1 * num2));
		break;
		case '/' :
			System.out.println(num1 + " " + operator + " "  + num2 + " = " + ((double)num1 / num2));
		break;
		case '%' :
			System.out.println(num1 + " " + operator + " "  + num2 + " = " + (num1 % num2));
		break;
		default :
			System.out.println(operator + " 는 유효하지 않은 연산자입니다.");
		}
		

		
		
		
		
		
		
		
	}

}
