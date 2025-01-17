package student;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;


public class StudentProgram {
static Scanner scan = new Scanner(System.in);
static List<Student> stdList = new ArrayList<Student>();
static List<Subject> sbjList = new ArrayList<Subject>();



	public void run() {				//객체 생성해서 호출하기 때문에  static 안 붙임. static 붙였으면 StudentProgram.run으로 바로 호출 가능하지만 객체지향성 down
		int menu = 0;
		final int EXIT = 13;
		stdList.add(new Student(0,0,0,"홍길동"));
		sbjList.add(new Subject(0,0,"체육"));
		
		do {
			printMenu("학생 등록","학생 수정","학생 삭제","과목 등록","과목 수정", "과목 삭제", 
					"성적 등록", "성적 수정", "성적 삭제","학생 조회", "과목 조회", "성적 조회", "종료");
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
	
	private void removeBuffer() {
		scan.nextLine();
	}


	public void printMenu(String ... menus ) {
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
	public void printBar(char bar, int count) {
		for(int i = 1; i <= count; i++) {
			System.out.print(bar);
		}
		System.out.println();
	}

	private void runMenu(int menu) {
		switch(menu) {
		case 13 : 
			System.out.println("종료");
			break;
		case 1 :
			System.out.println("학생 등록");
			insertStudent();
			break;
		case 2 :
			System.out.println("학생 수정");
			updateStudent();
			break;
		case 3 :
			System.out.println("학생 삭제");
			deleteStudent();
			break;
		case 4 : 
			System.out.println("과목 등록");
			insertSubject();
			break;
		case 5 : 
			System.out.println("과목 수정");
			updateSubject();
			break;
		case 6 : 
			System.out.println("과목 삭제");
			deleteSubject();
			break;
		case 7 : 
			System.out.println("성적 등록");
			insertScore();
			break;
		case 8 : 
			System.out.println("성적 수정");
			updateScore();
			break;
		case 9 : 
			System.out.println("성적 삭제");
			deleteScore();
			break;
		case 10 : 
			System.out.println("학생 조회");
			searchStudent();
			break;
		case 11 : 
			System.out.println("과목 조회");
			searchSubject();
			break;
		case 12 : 
			System.out.println("성적 조회");
			searchScore();
			break;



		}
		return;
	}

	public Student inputNum() {
		System.out.print("학년 입력 : ");
		int stdGrade = scan.nextInt();
		
		System.out.print("반 입력 : ");
		int stdClass = scan.nextInt();
		
		System.out.print("번호 입력 : ");
		int stdNum = scan.nextInt();
		removeBuffer();
		
		return new Student(stdGrade, stdClass, stdNum);
		
	}
	
	private void updateStudent() {
		//학년 반 번호 입력
		
		Student tmp = inputNum();
		//입력한 학생 정보를 객체 생성
		int index = stdList.indexOf(tmp);
		if(index<0) {
			char menu1 = '0';
			do {
				System.out.print("없는 학생입니다. 등록할까요? (y, n) : ");
				menu1 = scan.next().charAt(0);
				scan.nextLine();
				switch(menu1) {
				case 'y', 'Y' : insertStudent(tmp);
				case 'n', 'N' : break;
				default : System.out.println("잘못된 입력입니다.");break;
				}

			}while(menu1 != 'n' && menu1 != 'N');
		}else if(index >= 0) {
			System.out.println(stdList.get(index));
			System.out.println("수정할 정보 입력");
			Student newTmp = inputNum();
			int newIndex = stdList.indexOf(newTmp);
			if(newIndex<0||tmp.equals(newTmp)) {
				System.out.print("이름 입력(n입력시 수정 x) : ");
				String stdName = scan.nextLine();
				if(stdName.equals("n")||stdName.equals("N")) newTmp.setStdName(stdList.get(index).getStdName());
				else newTmp.setStdName(stdName);
				stdList.set(index, newTmp);
				System.out.println("수정 완료");
				System.out.println(stdList.get(index));
			}else if(newIndex >=0) {
				System.out.println("이미 있는 학생입니다.");
				return;
			}else throw new RuntimeException("알 수 없는 오류");
		}else throw new RuntimeException("알 수 없는 오류");
		
		//생성한 객체가 리스트에 있으면 번지를 가져옴
		//번지가 음수이면 안내문구 출력 후 종료	->못찾은 경우
		//아니면 수정할 학년 반 번호 이름을 입력
		//입력받은 정로볼 객체 생성
		//번지에 있는 객체를 위에서 생성한 객체로 변경
		
		
		
	}
	private void insertStudent(Student tmp) {
		// 메소드 오버로딩		
		
		int index = stdList.indexOf(tmp);
		if(index>=0)System.out.println("이미 등록된 학생 : " + stdList.get(index));
		else {
		System.out.print("이름 입력 : ");
		String stdName = scan.nextLine();
		tmp.setStdName(stdName);
		
		//주의 : 학생 객체 생성시 성적 리스트 생성
		// null 들어가면 
			stdList.add(tmp);
			System.out.println("학생이 추가되었습니다.");
			System.out.println(tmp);
		}
		//입력받은 학년반번호이름을 이용하여 객체 생성->리스트에 있는 기능 활용 위해
		//생성한 객체가 리스트에 있는지 확인하여 있으면 종료(Student클래스의 equals를 오버라이딩)
		//없으면 리스트에 추가 후 안내 문구
		
		
	}
	private void insertStudent() {
		// 학년 반 번호 입력
		
		
		Student tmp = inputNum();
		
		int index = stdList.indexOf(tmp);
		if(index>=0)System.out.println("이미 등록된 학생 : " + stdList.get(index));
		else {
		System.out.print("이름 입력 : ");
		String stdName = scan.nextLine();
		tmp.setStdName(stdName);
		
		//주의 : 학생 객체 생성시 성적 리스트 생성
		// null 들어가면 
			stdList.add(tmp);
			System.out.println("학생이 추가되었습니다.");
			System.out.println(tmp);
		}
		//입력받은 학년반번호이름을 이용하여 객체 생성->리스트에 있는 기능 활용 위해
		//생성한 객체가 리스트에 있는지 확인하여 있으면 종료(Student클래스의 equals를 오버라이딩)
		//없으면 리스트에 추가 후 안내 문구
		
		
	}
	private void deleteStudent() {
		//학년 반 번호 입력
		Student tmp = inputNum();
		//입력받은 정보로 객체 생성
		int index = stdList.indexOf(tmp);
		if(index<0) {
			System.out.println("없는 학생입니다.");
			return;
		}
		//생성한 객체를 이용하여 리스트에서 삭제 eqauls 오버라이딩해서 contains 이용
		//->인서트에서 오버라이딩된거 이용?
		else if(index>=0) {
			System.out.println(stdList.get(index) + "를 삭제합니다.");
			int max = stdList.size();
			stdList.remove(index);
			if(stdList.size() >= max)throw new RuntimeException("삭제되지 않았습니다.");
		}
		//실패하면 실패 알림문구 출력
	}
	
	public Subject inputSubject() {
		System.out.print("과목 학년 입력 : ");
		int sbjGrade = scan.nextInt();

		System.out.print("과목 학기 입력 : ");
		int sbjSemester = scan.nextInt();
		removeBuffer();

		System.out.print("과목 이름 입력 : ");
		String sbjName = scan.nextLine();

		return new Subject(sbjGrade, sbjSemester, sbjName);
		
	}


private void insertSubject() {
	//학년 학기 과목명 입력
	Subject tmpSub = inputSubject();
	//이미 등록된 과목이면 알림 후 종료 => subject 클래스 equals 오버라이딩해서 비교
	int index = sbjList.indexOf(tmpSub);
	if(index<0) {
		sbjList.add(tmpSub);
		System.out.println(tmpSub + "등록되었습니다.");
		System.out.println();
	}else {
		System.out.println(tmpSub + "는 이미 있는 과목입니다.");
		System.out.println();
	}
	
	
	//과목 추가 후 알림
}

private void updateSubject() {
		//학년 학기 과목명 입력
		/* 1 1 국어
		 * 1 2 국어
		 * 2 1 영어
		 * 2 2 영어
		 * 1 3 국어		->1 1 국어로 수정하려 할때 어떻게 판별할건지/contains로 하면 1 3 국어로 수정하려 하면 중복취급됨
		 * 
		 */
	//입력한 정보로 객체 생성
	Subject tmpSub = inputSubject();
	//등록된 과목이 아니면 알림 후 종료(contains랑 indexof 중에 indexof 사용하면 번지를 밑에서 재사용 가능)
	int index = sbjList.indexOf(tmpSub);
	if(index<0) {
		sbjList.add(tmpSub);
		System.out.println(tmpSub + "는 없는 과목입니다.");
		return;
	}else {
		System.out.println(tmpSub + "를 수정합니다.");
		System.out.println("수정하려는 내용 입력");
		Subject tmpSub2 = inputSubject();
		
	}
	
	//새 과목 정보를 입력(학년 학기 과목)

	//등록된 과목이면 알림 후 종료
	//리스트에서 index 번지에 있는 값을 제거 후 제거된 객체를 저장 -> 실패하면 다시 넣어주기 위해
	//tmp에 잠시 저장 -> 1 3 국어 	-> 수정할 내용 입력(1. 1 1 국어/2. 1 3 국어/3. 1 3 수학) ->나머지 리스트와 비교 
	//->리스트에 새 과목 정보와 일치하는 과목이 있으면 제거된 객체 다시 저장->아니면 수정 ->제거된 객체 다시 추가

		//아니면 수정	//tmp를 추가
		
	}
	private void deleteSubject() {
		//학년 학기 과목명 입력
		
		//입력한 정보로 객체 생성
		
		//리스트에서 생성한 객체를 제거해서 성공하면 성공 알림
		
		//실패하면 실패 알림
		
	}
		
	private void deleteScore() {
		//학년 반 번호 입력
		//입력한 정보로 객체 생성(Student 클래스)
		//리스트에 있는지 확인해서 없으면 알림 후 종료	=> indexOf(contains로는 찾은애 활용 어려움) =>
		// 학년 학기 과목 입력
		//입력한 정보로 객체 생성(Subjsect)
		//(과목 리스트에 등록된 과목인지 확인 후 아니면 알림 후 종료) 안해도 되는데 하는게 좋음...
		//학생에게 과목 정보를 주면서 성적 삭제하라고 요청 하 성공하면 알림//실패하면 알림
		
	}
	
	private void updateScore() {
		//학년 반 번호 입력
				//입력한 정보로 객체 생성(Student 클래스)
				//리스트에 있는지 확인해서 없으면 알림 후 종료	=> indexOf(contains로는 찾은애 활용 어려움) =>
				// 학년 학기 과목 입력
				//입력한 정보로 객체 생성(Subjsect)
		//과목 리스트에 등록된 과목인지 확인 후 아니면 알림 후 종료
		//새 과목 정보를 입력(학년 학기 과목)을 입력
		// 과목 리스트에 등록된 과목인지 확인 후 아니면 알림 후 종료
		//성적을 입력
		// 새 과목 정보와 성적을 이용하여 성적 객체 생성
		// 학생에게 기존 과목 정보와 성적 정보를 주면서 수정하라고 요청한 후 성공하면 알림//실패하면 알림
		
		
	}
	
	private void insertScore() {
		//학년 반 번호 입력
		//입력한 정보로 객체 생성(Student 클래스)
		//리스트에 있는지 확인해서 없으면 알림 후 종료	=> indexOf(contains로는 찾은애 활용 어려움) =>
		// 학년 학기 과목 입력
		//입력한 정보로 객체 생성(Subjsect)
		//과목리스트에 등록된 과목인지 확인 후 아니면 알림 후 종료
		//성적 입력해서 과목 정보와 성적을 이용하여 객체 생성(Score)
		//학생을 선택 => list.getIndex 활용해서 indexOf에서 가져온애 활용 tmp.update() (list.get(xx).update()보다 조금 보기 편해서)

		{
			//학생 성적에 새 성적이 있는지 확인해서 없으면 추가 후 알림
			//있으면 추가 안하고 알림		=>확인하는 코드를 학생(클래스)한테 시킴
			//학생에게 새 성적을 주고 추가하라고 시키고 추가 여부를 이용하여 추가 했으면 성공 알림 실패했으면 실패 알림
			//코드 길어지니까....
		}

	}

	private void searchScore() {
		//학년 반 번호 입력
		//입력한 정보 이용해 객체 생성
		//리스트에 학생이 없으면 알림 후 종료	=>indexOf
		//학년 학기 과목명을 입력
		//과목 정보로 객체 생성
		//리스트에서 학생을 선택
		//선택한 학생에게 과목정보를 주면서 성적을 출력하라고 요청
		
	}
	private void searchSubject() {
		//등록된 과목 전체 출력
	}
	private void searchStudent() {
		//학년 반 번호 입력
		//입력한 정보 이용해 객체 생성
		//리스트에서 일치하는 학생 있으면 정보 출력//없으면 없다고 출력
	}



}
