package homework.ex2.v2;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;


public class StudentProgram implements ConsoleProgram{
	
	Scanner scan = new Scanner(System.in);
	
	private StudentManager studentManager = new StudentManager();	//기본생성자
	
	private SubjectManager subjectManager = new SubjectManager();
	
	public void run() {
		int menu = 0;
		final int EXIT = 13;
		
		//불러오기
		String studentFileName = "src/homework/ex2/v2/student.txt";
		String subjectFileName = "src/homework/ex2/v2/subject.txt";
		
		List<Student>students = new ArrayList<Student>();
		List<Subject>subjects = new ArrayList<Subject>();
		
		
		do {
			printMenu("학생 등록","학생 수정","학생 삭제","과목 등록","과목 수정", "과목 삭제", 
					"성적 등록", "성적 수정", "성적 삭제","학생 조회","과목 조회","성적 조회","종료");
		try {
			menu = scan.nextInt();
			
			removeBuffer();
			
			runMenu(menu);
			
			save(studentFileName,studentManager.getList());
			save(subjectFileName,subjectManager.getList());
			
		}
		//잘못된 타입의 메뉴를 입력한 경우
		catch(InputMismatchException e) {
			System.out.println("올바른 입력이 아닙니다.");
			removeBuffer();
		}
		
		}while( menu != EXIT);
	}
	
	//메소드들 static 제거 ->
	

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
	

	
	private void removeBuffer() {
		scan.nextLine();
	}
	
	@Override
	public void runMenu(int menu) {
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


	@Override
	public void printMenu() {
		// TODO Auto-generated method stub

	}





	private void updateStudent() {		//manager한테 복잡한거 다 넘기고 알림문구만 출력
		System.out.println("----------------");
		System.out.println("학생 정보 입력");
		System.out.println("----------------");
		Student std = inputBaseStudent();

		Student selStd = studentManager.getStudent(std);		

		if(selStd == null) {

			System.out.println("일치하는 학생이 없습니다.");
			return;
		}

		System.out.println("----------------");
		System.out.println("수정할 학생 정보 입력");
		System.out.println("----------------");
		Student newStd = inputStudent();

		if(studentManager.updateStudent(selStd, newStd)) {
			System.out.println("학생을 수정했습니다");
			return;
		}
		System.out.println("이미 등록된 학생입니다.");


	}
	private void insertStudent() {


		//학생 정보를 입력받아 객체 생성
		Student std = inputStudent();

		//생성된 정보 -> 매니저 //등록 여부 받기
		if(!studentManager.insertStudent(std)) {		//매니저한테 요청 - > 결과만 받음
			System.out.println("이미 등록된 학생입니다.");
			return;
		}

		System.out.println("학생을 등록했습니다.");



	}
	private void deleteStudent() {
		
		
		Student std = inputBaseStudent();
		
		if(studentManager.deleteStudent(std)) {
			System.out.println("학생 삭제했습니다.");
			return;
		}
		
		System.out.println("일치하는 학생이 없습니다.");



	}
	private void insertSubject() {
		Subject subject = inputSubject();
		
		if(subjectManager.insertSubject(subject)) {
			System.out.println("과목을 추가했습니다.");
			return;
		}
		System.out.println("이미 등록된 과목입니다.");
	
	}
	
	private void updateSubject() {

		System.out.println("----------------");
		System.out.println("과목 정보 입력");
		System.out.println("----------------");
		
		Subject subject = inputSubject();

		if(!subjectManager.contains(subject)) {			//디본제공 메소드 없음
			System.out.println("일치하는 과목이 없습니다.");
			return;
		}
		
		System.out.println("----------------");
		System.out.println("수정할 학생 정보 입력");
		System.out.println("----------------");
		
		
		Subject newSubject = inputSubject();
		if(subjectManager.updateSubject(subject, newSubject)) {
			System.out.println("과목을 수정했습니다.");
			return;
		}
		System.out.println("이미 등록된 과목입니다.");
		
		
	}
	private void deleteSubject() {
		System.out.println("----------------");
		System.out.println("과목 정보 입력");
		System.out.println("----------------");
		
		Subject subject = inputSubject();
		if(subjectManager.deleteSubject(subject)) {
			System.out.println("과목을 삭제 했습니다.");
			return;	
			
		}
		System.out.println("일치하는 과목이 없습니다.");
	}
		
	private void deleteScore() {
		System.out.println("------------------------");
		System.out.println("학생 정보를 입력");
		System.out.println("------------------------");
		Student std = inputBaseStudent();


		if(studentManager.getStudent(std) == null){
			System.out.println("일치하는 학생이 없습니다.");
			return;
		}
		
		
		System.out.println("------------------------");
		System.out.println("성적 정보를 입력");
		System.out.println("------------------------");
		Subject subject = inputSubject();


		if(!subjectManager.contains(subject)){
			System.out.println("일치하는 과목이 없습니다.");
			return;
		}
		if(studentManager.deleteScore(std, subject)) {
			System.out.println("성적을 삭제했습니다.");
			return;
		}
		System.out.println("일치하는 성적이 없습니다.");
		
	}
	
	private void updateScore() {
		System.out.println("------------------------");
		System.out.println("학생 정보를 입력");
		System.out.println("------------------------");
		Student std = inputBaseStudent();
		
		if(studentManager.getStudent(std) == null){
			System.out.println("일치하는 학생이 없습니다.");
			return;
		}
		
		
		System.out.println("------------------------");
		System.out.println("성적 정보를 입력");
		System.out.println("------------------------");
		Subject subject = inputSubject();
		
		if(!subjectManager.contains(subject)){
			System.out.println("일치하는 과목이 없습니다.");
			return;
		}
		
		System.out.println("------------------------");
		System.out.println("수정할 성적 정보를 입력");
		System.out.println("------------------------");
		Subject newSubject = inputSubject();
		
		if(!subjectManager.contains(newSubject)){
			System.out.println("이미 등록된 과목입니다.");
			return;
		}
		
		
		System.out.print("성적 : ");
		int score = scan.nextInt();
		
		SubjectScore subjectScore = new SubjectScore(newSubject, score);
		
		if(studentManager.updateScore(std, subject, subjectScore)) {
			System.out.println("성적을 수정했습니다.");
			return;
		}
		
		System.out.println("이미 등록된 성적입니다.");
		
		
	}
	
	private void insertScore() {
		System.out.println("------------------------");
		System.out.println("학생 정보를 입력");
		System.out.println("------------------------");
		Student std = inputBaseStudent();
		
		if(studentManager.getStudent(std) == null){
			System.out.println("일치하는 학생이 없습니다.");
			return;
		}
	
		System.out.println("------------------------");
		System.out.println("성적 정보를 입력");
		System.out.println("------------------------");
		Subject subject = inputSubject();
		
		if(!subjectManager.contains(subject)){
			System.out.println("일치하는 과목이 없습니다.");
			return;
		}
			
		
		System.out.println("성적 : ");
		int score = scan.nextInt();
		
		SubjectScore subjectScore = new SubjectScore(subject, score);
		
		if(studentManager.insertScore(std, subjectScore)){
			System.out.println("성적을 추가했습니다.");
			return;
		}
		System.out.println("이미 등록된 성적입니다.");

	}

	private void searchScore() {
		System.out.println("---------------");
		System.out.println("조회하려는 학생 정보 입력");
		System.out.println("---------------");
		
		Student std = inputBaseStudent();

		if(studentManager.getStudent(std) == null){
			System.out.println("일치하는 학생이 없습니다.");
			return;
		}
		
		System.out.println("---------------");
		System.out.println("조회화려는 과목 정보 입력");
		System.out.println("---------------");
		
		
		Subject subject = inputSubject();
		
		
		studentManager.printScore(std, subject);

		
	}
	private void searchSubject() {
		subjectManager.print();
	}
	private void searchStudent() {
		Student std = inputBaseStudent();
		
		studentManager.printStudent(std);
	}

	//학년 반 번호 입력하면 객체 반환
	public Student inputBaseStudent() {
		System.out.print("학년 입력 : ");
		int stdGrade = scan.nextInt();
		
		System.out.print("학급 입력 : ");
		int stdClass = scan.nextInt();
		
		System.out.print("번호 입력 : ");
		int stdNum = scan.nextInt();
		removeBuffer();

		return new Student(stdGrade, stdClass, stdNum, "");

	}
	public Student inputStudent() {
		Student tmp = inputBaseStudent();

		System.out.println("이름 : ");
		String name = scan.nextLine();

		tmp.setStdName(name);
		return tmp;
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

	

}
