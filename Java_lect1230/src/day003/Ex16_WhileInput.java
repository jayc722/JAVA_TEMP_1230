package day003;

import java.util.Scanner;

public class Ex16_WhileInput {

	public static void main(String[] args) {
		// 문자를 입력받아 문자가 q 일때 종료하는 코드

		
		
		
		
		Scanner scan = new Scanner(System.in);
		char ch = 'a';								//q 가 아닌 문자로 초기화	
				
		
		
		while(ch != 'q') {
			System.out.print("q 를 입력해 종료 : ");
			ch = scan.next().charAt(0);
		}
		
		
		System.out.println("프로그램 종료");
		
		
		
	}

}
