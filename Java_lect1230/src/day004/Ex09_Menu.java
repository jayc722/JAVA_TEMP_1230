package day004;

import java.util.Scanner;

public class Ex09_Menu {

	public static void main(String[] args) {
		/* 다음과 같이 실행되는 코드 작성하세요
		 * 메뉴
		 * 1. 프로그램 실행
		 * 2. 종료
		 * 메뉴 선택 : 1
		 */
		Scanner scan = new Scanner(System.in);
		char input = 0;
		char junk1;

		A: do {
			System.out.print("메뉴\n1. 프로그램 실행\n2. 종료\n메뉴 선택 : ");
			input = scan.next().charAt(0);
			switch(input) {
			case '1' :
				do {
					System.out.print("문자를 입력하세요(종료하려면 q) : ");
					input = scan.next().charAt(0);
				}while(input != 'q');
				break;
			case '2' :
				System.out.println("프로그램을 종료합니다.");
				break A;
			default :
				System.out.println("1 또는 2번을 입력하여 진행.");
				continue;
			}
		}while(true);




	}

}
