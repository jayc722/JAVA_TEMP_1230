package day006.score;

import java.util.Scanner;



public class StudentProgram {

	Scanner scan = new Scanner(System.in);
	
	public void run() {
		
		StudentManager sm = new StudentManager();
		char menu;
		// int count = 0;//studentmanager에 있음
		//반복
		do {
			//메뉴 출력
			printMenu();
			
			//메뉴 선택
			menu = scan.next().charAt(0);
			
			//기능 실행
			runMenu(menu, sm);

		}while(menu != '3');
	}
	
	private void runMenu(char menu,StudentManager sm) {
		System.out.println("-------------------------");
		switch(menu) {
		case '1':
			insertStudent(sm);
			break;
		case '2':
			sm.printStudent();
			break;
		case '3':
			System.out.println("프로그램을 종료합니다.");
			break;
		default:
			System.out.println("올바른 메뉴가 아닙니다.");
		}
		System.out.println("-------------------------");
	}
	private void insertStudent(StudentManager sm) {
		//학생 정보를 입력(이름과 성적)
		System.out.print("이름 : ");
		String name = scan.next();
		System.out.print("성적 : ");
		int score = scan.nextInt();
		//학생 정보를 이용해서 Student의 객체를 생성
		
		sm.insertStudent(name, score);
	}

	private static void printMenu() {
		System.out.println("-----------메뉴-----------");
		System.out.println("1. 학생 국어 성적 추가");
		System.out.println("2. 학생 국어 성적 전체 조회");
		System.out.println("3. 종료");
		System.out.println("-------------------------");
		System.out.print("메뉴 선택 : ");
	}
}
