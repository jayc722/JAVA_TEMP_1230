package day003;

import java.util.Scanner;

public class Ex17_DoWhileInput {

	public static void main(String[] args) {
		// 문자를 입력받아 문자가 q 일때 종료하는 코드

		
				Scanner scan = new Scanner(System.in);
				char ch;								//while이랑 다르게 먼저 시행하므로 초기화 안 해도 됨	
				
				do {
					System.out.print("q 를 입력해 종료 : ");
					ch = scan.next().charAt(0);
				} while(ch != 'q');
				System.out.println("프로그램 종료");
				
				

	}

}
