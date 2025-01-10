package day009;

import java.text.MessageFormat;
import java.util.Scanner;

public class Ex12_TryCatch2 {

	public static void main(String[] args) {
		/* 두 정수와 산술 연산자를 입력받아 산술 연산 결과를 출력하는 메소드
		 * 단 예외 처리를 적용
		 * 0으로 나눌수 없습니다.
		 * 
		 * 
		 * 
		 * 
		 */
		
		try (Scanner scan = new Scanner(System.in)) {
			System.out.print("정수 입력 :");
			int num1 = scan.nextInt();
			
			System.out.print("연산자 입력 : ");
			char opr = scan.next().charAt(0);
			
			System.out.print("정수 입력 : ");
			int num2 = scan.nextInt();
			try {
			double res = calculate(num1, opr, num2);
			
			System.out.print("결과 : " + res);
			}catch(ArithmeticException e) {
				System.out.println("0으로 나눌 수 없습니다.");
			}catch(RuntimeException e) {
				System.out.println(MessageFormat.format("결과 : {0}", e.getMessage()));
			}catch(Exception e) {
				System.out.println(MessageFormat.format("결과 : {0}", e.getMessage()));
			}
			
			System.out.println();
			try {
			switch (opr) {
			case '+' :
				System.out.println(num1 + " + " + num2 + " = " + (num1 + num2));
				break;
				
			case '-' :
				System.out.println(num1 + " - " + num2 + " = " + (num1 - num2));
				break; 
				
			case '*' :
			case 'x' :
				System.out.println(num1 + " * " + num2 + " = " + (num1 * num2));
				break; 
				
			case '/' :
				System.out.println(num1 + " / " + num2 + " = " + ((double)num1 / num2));

				break; 
				
			case '%' :
				System.out.println(num1 + " % " + num2 + " = " + (num1 % num2));
				
				break;
			default :
				System.out.println("올바른 값을 입력하세요.");
				break;
			}
			
			}catch(ArithmeticException e) {
				System.out.println("0으로 나눌 수 없습니다.");
			}catch(Exception e) {
				System.out.println("알 수 없는 예외 발생");
			}
		}
		
		
		
		
		
		
		
	}

	private static double calculate(int num1, char opr, int num2) throws Exception {
		
			switch (opr) {
			case '+' :
			return (num1 + num2);
			case '-' :
				return (num1 - num2);
			case '*' :
			case 'x' :
				return (num1 * num2);
			case '/' :
				return ((double)num1 / num2);
			case '%' :
				return (num1 % num2);
			default :
				throw new Exception("산술 연산자가 아닙니다.");			//임의 에로 만들어 주고 싶을 때
		
	}

}
}
