package homework.ex2.v2;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class StudentProgram implements ConsoleProgram{
	
	private Scanner scan = new Scanner(System.in);
	
	private StudentManager studentManager = new StudentManager();	//기본생성자
	
	private SubjectManager subjectManager = new SubjectManager();
	
	public void run() {
		int menu = 0;
		final int EXIT = 13;
		
		//불러오기
		String studentFileName = "src/homework/ex2/v2/student.txt";
		String subjectFileName = "src/homework/ex2/v2/subject.txt";
		
		load(studentFileName,new ArrayList<Object>(studentManager.getList()));
		load(subjectFileName,new ArrayList<Object>(subjectManager.getList()));
		
		
		do {
			printMenu("학생 등록","학생 수정","학생 삭제","과목 등록","과목 수정", "과목 삭제", 
					"성적 등록", "성적 등록", "성적 수정", "성적 삭제","학생 조회","과목 조회","성적 조회","종료");
		try {
			menu = scan.nextInt();
			
			removeBuffer();
			
			runMenu(menu);
			
			
			
		}
		//잘못된 타입의 메뉴를 입력한 경우
		catch(InputMismatchException e) {
			System.out.println("올바른 입력이 아닙니다.");
			removeBuffer();
		}
		
		}while( menu != EXIT);
	}
	

	public static void printMenu(String ... menus ) {
		printBar('-', 15);
		//메뉴가 없는 경우
		if(menus.length == 0) {
			System.out.println("메뉴 없음");
			return;
		}
		//메뉴들을 숫자를 붙여서 출력
		for(int i = 0; i < menus.length; i++) {
			String menu = menus[i];
			if(i<9)System.out.println(i+1 + ".  " + menu);
			if(i>8)System.out.println(i+1 + ". " + menu);
		}
		printBar('-', 15);
		System.out.print("메뉴 선택 : ");
	}
	public static void printBar(char bar, int count) {
		for(int i = 1; i <= count; i++) {
			System.out.print(bar);
		}
		System.out.println();
	}
	

	
	private void removeBuffer() {
		scan.nextLine();
	}
	
	@Override
	public void runMenu(int menu) {
		switch(menu) {
		case 1 :
			System.out.println("프로그램 추가");
			break;
		case 2 :
			System.out.println("프로그램 수정");
			break;
		case 3 :
			System.out.println("프로그램 검색");
			break;
		case 4 : 
			System.out.println("종료");
			break;
		}
		return;
	}


	@Override
	public void printMenu() {
		// TODO Auto-generated method stub

	}




	@Override
	public void load(String fileName, List<Object> list) {
		// TODO Auto-generated method stub

	}


	@Override
	public void save(String fileName, List<Object> list) {
		// TODO Auto-generated method stub

	}
	private static void updateStudent() {
		//학년 반 번호 입력
		//입력한 학생 정보를 객체 생성
		
		//학생 매니저에게 학생 객체를 주면서 있는지 확인 요청하여 있으면 알림 후 종료
		//아니면 수정할 학년 반 번호 이름을 입력
		//입력받은 정로볼 객체 생성
		//학생 매니저에게 기존 학생 객체와 새 학생 객체를 주면서 수정하고 수정여부 요청
		//결과에 따라 알림
		


	}
	private static void insertStudent() {


		// 학년 반 번호 입력
		//주의 : 학생 객체 생성시 성적 리스트 생성
		// null 들어가면 
		//입력받은 학년반번호이름을 이용하여 객체 생성->리스트에 있는 기능 활용 위해
		//생성한 객체가 리스트에 있는지 확인하여 있으면 종료(Student클래스의 equals를 오버라이딩)
		//없으면 리스트에 추가 후 안내 문구


	}
	private static void deleteStudent() {
		//학년 반 번호 입력

		//입력받은 정보로 객체 생성

		//학생 매니저에게 학생 객체를 주면서 삭제하고 삭제여부 요청
		//삭제 성공하면 성공알림문구
		
		//실패하면 실패 알림문구 출력
		
		
		
	}
	private static void insertSubject() {
		//학년 학기 과목명 입력
		
		//과목 객체 생성
		
		//과목 매니저에게 과목을 주면서 등록 요청 후 결과에 따라 알림
	}
	
	private static void updateSubject() {
		//학년 학기 과목명 입력
		
		//입력한 정보로 객체 생성
		
		//새 과목 정보를 입력(학년 학기 과목)
		
		//과목 매니저에게 기존 과목객체와 새 과목 객체를 주면서 수정 요청 후 결과에 따라 알림
		
		//
		
	}
	private static void deleteSubject() {
		//학년 학기 과목명 입력
		
		//입력한 정보로 객체 생성
		
		//리스트에서 생성한 객체를 제거해서 성공하면 성공 알림
		
		//실패하면 실패 알림
		
	}
		
	private static void deleteScore() {
		//학년 반 번호 입력
		
		//입력한 정보로 객체 생성(Student 클래스)
		
		//학생 매니저에게 확인해서 없으면 알림 후 종료
		
		// 학년 학기 과목 입력
		
		//입력한 정보로 객체 생성(Subjsect)
		
		//과목 매니저에게 확인 후 아니면 알림 후 종료
		
		//학생 매니저에게 과목 정보를 주면서 성적 삭제하라고 요청 하 성공하면 알림//실패하면 알림
		
	}
	
	private static void updateScore() {
		//학년 반 번호 입력
		
		//입력한 정보로 객체 생성(Student 클래스)
		
		//학생 매니저에게 확인해서 없으면 알림 후 종료	
		
		// 학년 학기 과목 입력
		
		//입력한 정보로 객체 생성(Subjsect)
		
		//과목 매니저에게 확인 후 아니면 알림 후 종료
		
		//새 과목 정보를 입력(학년 학기 과목)을 입력
		
		//과목 매니저에게 새 과목을 확인 후 아니면 알림 후 종료
		
		//성적을 입력
		
		// 새 과목 정보와 성적을 이용하여 성적 객체 생성
		
		// 학생 매니저에게 기존 과목 객체와 새 성적 객체를 주면서 수정하라고 요청한 후 성공하면 알림//실패하면 알림
		
		
	}
	
	private static void insertScore() {
		//학년 반 번호 입력
		
		//입력한 정보로 객체 생성(Student 클래스)
		
		//학생 매니저에게 학생이 있는지 확인해서 없으면 알림 후 종료	=> indexOf(contains로는 찾은애 활용 어려움) =>
		
		// 학년 학기 과목 입력
		
		//입력한 정보로 객체 생성(Subjsect)
		
		//과목 매니저에게 있는 과목인지 확인 후 아니면 알림 후 종료
		
		//성적 입력해서 과목 정보와 성적을 이용하여 객체 생성(Score)
		
		//학생 매니저에게 학생 객체와 성적 객체를 주면서 성적 등록 요청 후 결과에 따라 알림

	}

	private static void searchScore() {
		//학년 반 번호 입력
		
		//입력한 정보 이용해 객체 생성
		
		//학생 매니저에 학생이 없으면 알림 후 종료
		
		//학년 학기 과목명을 입력
		
		//과목 정보로 객체 생성
		
		//학생 매니저에게 학생정보와 과목정보를 주면서 성적을 출력하라고 요청
		
	}
	private static void searchSubject() {
		//과목 매니저에게 등록된 과목 출력 요청
	}
	private static void searchStudent() {
		//학년 반 번호 입력
		//입력한 정보 이용해 객체 생성
		//학생 매니저에게 학생 정보를 주면서 정보 출력//없으면 없다고 출력
	}





}
