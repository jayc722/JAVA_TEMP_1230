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
		Scanner scan = new Scanner(System.in); //표준입력
/*		char input = 0;

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

*/		
		
		///////////////////////////////////////////////////////////////////////////////////////
/*
		char menu;
		do {
			System.out.println("----------------");
			System.out.print("메뉴\n1. 프로그램 실행\n2. 종료\n메뉴 선택 : ");
			menu = scan.next().charAt(0);
			switch(menu) {
			case '1' :
				char ch;
				do {
					System.out.println("----------------");
					System.out.print("문자를 입력하세요(종료하려면 q) : ");
					ch = scan.next().charAt(0);
				}while(ch != 'q');
				break;
			case '2' :
				System.out.println("프로그램을 종료합니다.");
				break;
			default :
				System.out.println("잘못된 메뉴입니다.");
			}
		}while(menu != 2);
 */
	}
		
		
	/**
	 * 메뉴를 콘솔에 출력하는 메소드
	 */
	
	
	/**
	 * 메뉴에 따라 기능 실행 메소드
	 * @param menu 선택한 메뉴
	 * @return 없음
	 */
	
	public static void runMenu(char menu) {
		Scanner scan = new Scanner(System.in);
		switch(menu) {
		case '1' :
			char ch;
			do {
				System.out.println("----------------");
				System.out.print("문자를 입력하세요(종료하려면 q) : ");
				ch = scan.next().charAt(0);
			}while(ch != 'q');
			break;
		case '2' :
			System.out.println("프로그램을 종료합니다.");
			break;
		default :
			System.out.println("잘못된 메뉴입니다.");
		}
	}
	/**
	 * 프로그램 실행하는 메소드
	 */
	
	public static void program(){
	Scanner scan = new Scanner(System.in);
	char ch;
	do {
		System.out.println("----------------");
		System.out.print("문자를 입력하세요(종료하려면 q) : ");
		ch = scan.next().charAt(0);
	}while(ch != 'q');
	}
}
