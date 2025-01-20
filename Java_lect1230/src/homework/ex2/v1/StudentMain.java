package homework.ex2.v1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;



///////////////////////////////숙제////////////////////////////////////////
public class StudentMain {
	static Scanner scan = new Scanner(System.in);
	//등록된 과목을 관리할 과목 리스트
		static ArrayList<Subject> subjectList = new ArrayList<Subject>();
		//등록된 학생을 관리할 학생 리스트
		static ArrayList<Student> studentList = new ArrayList<Student>();
	public List<SubjectScore> list;
	
	public static void main(String[] args) {
	
		/* 학생 성적 관리 프로그램 작성
		 * 1. 학생 등록
		 * -학년 반 번호 이름을 입력받아 등록
		 * -이미 등록된 학생 정보(학년 반 번호가 같은 경우)라면 등록x
		 * 
		 * 2. 학생 수정
		 * -학년 반 번호를 입력받아 학생이 있ㅇ는지 찾고 있으면 수정
		 * -수정 정보는 학년, 반, 번호, 이름
		 * -to 이미 등록된 학생 정보로 수정하려 하면 수정x
		 * 
		 * 3. 학생 삭제
		 * -학년 반 번호를 입력받아 학생이 있는지 찾고 있으면 삭제
		 * 4. 과목 등록
		 * -학년 학기 과목명을 입력받아 없으면 등록 ( 1 1 1국어 -> 1 1 1 국어 중복 x 1 1 2 국어는 가능)
		 * 5. 과목 수정
		 * -학년 학기 과목을 입력받아 있으면 학년 학기 과목을 입력받아 수정
		 * -수정하려는 과목이 이미 등록된 과목이라면 수정하지 않음
		 * 6. 과목 삭제
		 * -학년 학기 과목을 입력받아 있으면 삭제
		 * 7. 성적 등록
		 * -학년 반 번호를 입력받아 학생을 찾고 있으면 과목 출력
		 * -과목 선택
		 * -성적을 입력해서 학생 성적 등록 
		 * 8. 성적 수정
		 * -학년 반 번호 입력 학생 찾고 있으면 학년 학기 과목 입력 있으면 수정
		 * 9. 성적 삭제
		 * -학년 반 번호 입력 학생 찾고 있으면 학년 학기 과목 입력 있으면 삭제
		 * 10. 학생 조회
		 * -학년, 반 입력하면 학생들을 조회
		 * 11. 괴목 조회
		 * -등록된 과목 전체 조회
		 * 12. 성적 조회
		 * -학년 반 번호 입력하면 학생 있으면 학생 성적 전체 조회
		 * 
		 * 
		 * 클래스를 2개
		 * 
		 * 
		 */
		
		//학생 찾는거 메소드 오버로딩?
		//find 1학년1반1번 > 학생 찾기 1학년1반1번 수학 학생 > 과목? > 성적?
		//student grd clssNum chrNum stdName 
		
		int menu = 0;
		final int EXIT = 13;
		
		String stdFileName = "src/homework/ex2/v1/student.txt";
		String subjectFileName = "src/homework/ex2/v1/subject.txt";
		//불러오기
		studentList = (ArrayList<Student>) load(stdFileName); //형변환 해주기 -> 메소드 다형성으로 재사용 해주기위해 
																//-> student랑 subject 따로 load로 만들면 매개변수가 같아서 subject
		if (studentList == null)studentList = new ArrayList<Student>();
		
		subjectList = (ArrayList<Subject>) load(subjectFileName); 
		if (subjectList == null)subjectList = new ArrayList<Subject>();
		do {
			printMenu("학생 등록","학생 수정","학생 삭제","과목 등록","과목 수정", "과목 삭제", 
					"성적 등록", "성적 수정", "성적 삭제","학생 조회","과목 조회","성적 조회","종료");
		
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
		
		//저장하기
		save(stdFileName, studentList);
		save(subjectFileName, subjectList);
		
	}
	private static void save(String fileName, Object obj) {
		try(FileOutputStream fos = new FileOutputStream(fileName);
				ObjectOutputStream oos = new ObjectOutputStream(fos)){
			
			oos.writeObject(obj);
			
		} catch (Exception e) {	//귀찮으니 그냥 다 exception
			System.out.println("-------------------");
			System.out.println("저장하기 실패.");
			System.out.println("-------------------");
			e.printStackTrace();
		} 
		
		
	}
	private static Object load(String fileName) { //매개변수 다형성 이용해서 재사용 하기 위해 object클래스로 리턴

		try(FileInputStream fis = new FileInputStream(fileName);
				ObjectInputStream ois = new ObjectInputStream(fis)){
		
			
			return ois.readObject();	//try문 코드가 return으로
			
		} catch (Exception e) {
			System.out.println("-------------------");
			System.out.println("불러오기 실패");
			System.out.println("-------------------");
			e.printStackTrace();
		}
		
		return null;
	}
	//학년 반 번호 입력하면 객체 반환
	public static Student inputBaseStudent() {
		System.out.print("학년 입력 : ");
		int stdGrade = scan.nextInt();
		
		System.out.print("학급 입력 : ");
		int stdClass = scan.nextInt();
		
		System.out.print("번호 입력 : ");
		int stdNum = scan.nextInt();
		removeBuffer();



		return new Student(stdGrade, stdClass, stdNum, "");

	}
	public static Student inputStudent() {
		Student tmp = inputBaseStudent();

		System.out.println("이름 : ");
		String name = scan.nextLine();

		tmp.setStdName(name);
		return tmp;
	}

	private static void updateStudent() {
		//학년 반 번호 입력
		Student std = inputBaseStudent();
		//입력한 학생 정보를 객체 생성

		//생성한 객체가 리스트에 있으면 번지를 가져옴
		int index = studentList.indexOf(std);
		//번지가 음수이면 안내문구 출력 후 종료	->못찾은 경우
		if(index < 0) {
			System.out.println("일치하는 학생이 없습니다.");
			return;
		}
		System.out.println("----------------");
		System.out.println("수정할 학생 정보 입력");
		System.out.println("----------------");
		//아니면 수정할 학년 반 번호 이름을 입력
		//입력받은 정로볼 객체 생성
		Student newStd = inputStudent();
		
		std = studentList.remove(index);
		if(studentList.contains(newStd)) {
			System.out.println("이미 등록된 학생입니다.");
			studentList.add(index, std);
			return;
		}
		studentList.add(index, std);
		
		System.out.println();
		//번지에 있는 객체를 위에서 생성한 객체로 변경
		studentList.get(index).update(newStd);
		System.out.println("학생 수정했습니다.");


	}
	private static void insertStudent() {

		Student std = inputStudent();
		
		if(studentList.contains(std)) {
			System.out.println("이미 등록된 학생입니다.");
			return;
		}
		// 학년 반 번호 입력
		//주의 : 학생 객체 생성시 성적 리스트 생성
		// null 들어가면 
		//입력받은 학년반번호이름을 이용하여 객체 생성->리스트에 있는 기능 활용 위해
		//생성한 객체가 리스트에 있는지 확인하여 있으면 종료(Student클래스의 equals를 오버라이딩)
		//없으면 리스트에 추가 후 안내 문구
		studentList.add(std);
		System.out.println("학생을 등록했습니다.");
		System.out.println(studentList);
		

	}
	private static void deleteStudent() {
		//학년 반 번호 입력
		Student std = inputBaseStudent();
		//입력받은 정보로 객체 생성

		//생성한 객체를 이용하여 리스트에서 삭제 eqauls 오버라이딩해서 contains 이용
		//->인서트에서 오버라이딩된거 이용?
		if(studentList.remove(std)) {
			System.out.println("학생 삭제했습니다.");
			return;
		}
		//실패하면 실패 알림문구 출력
		System.out.println("일치하는 학생이 없습니다.");


	}
	private static void insertSubject() {
		//학년 학기 과목명 입력
		Subject subject = inputSubject();
		
		//이미 등록된 과목이면 알림 후 종료 => subject 클래스 equals 오버라이딩해서 비교
		if (subjectList.contains(subject)) {
			System.out.println("이미 등록된 과목입니다.");
			return;
		}
		
		
		//과목 추가 후 알림
		subjectList.add(subject);
		System.out.println("과목을 등록했습니다.");
		System.out.println(subjectList);
		
	}

	private static void updateSubject() {
		//학년 학기 과목명 입력
		/* 1 1 국어
		 * 1 2 국어
		 * 2 1 영어
		 * 2 2 영어
		 * 1 3 국어		->1 1 국어로 수정하려 할때 어떻게 판별할건지/contains로 하면 1 3 국어로 수정하려 하면 중복취급됨
		 * 
		 */
		//입력한 정보로 객체 생성
		Subject subject = inputSubject();
		
		//등록된 과목이 아니면 알림 후 종료(contains랑 indexof 중에 indexof 사용하면 번지를 밑에서 재사용 가능)
		int index = subjectList.indexOf(subject);
		if(index < 0) {
			System.out.println("일치하는 과목이 없습니다.");
			return;
		}
		System.out.println("----------------");
		System.out.println("수정할 과목 정보 입력");
		System.out.println("----------------");
		//새 과목 정보를 입력(학년 학기 과목)
		Subject newSubject = inputSubject();
		
		Subject oldSubject = subjectList.remove(index);
		
		
		//등록된 과목이면 알림 후 종료
		if(subjectList.contains(newSubject)) {
			subjectList.add(index, oldSubject);
			System.out.println("이미 등록된 과목입니다.");
			return;
		}
		//리스트에서 index 번지에 있는 값을 제거 후 제거된 객체를 저장 -> 실패하면 다시 넣어주기 위해
		//tmp에 잠시 저장 -> 1 3 국어 	-> 수정할 내용 입력(1. 1 1 국어/2. 1 3 국어/3. 1 3 수학) ->나머지 리스트와 비교 
		//->리스트에 새 과목 정보와 일치하는 과목이 있으면 제거된 객체 다시 저장->아니면 수정 ->제거된 객체 다시 추가
		
		//아니면 수정	//tmp를 추가
		subjectList.add(index, newSubject);
		System.out.println("과목을 수정했습니다.");
	}
	private static void deleteSubject() {
		//학년 학기 과목명 입력
		Subject subject = inputSubject();
		
		
		//입력한 정보로 객체 생성
		
		//리스트에서 생성한 객체를 제거해서 성공하면 성공 알림
		if(subjectList.remove(subject)) {
			System.out.println("과목을 삭제했습니다.");
			return;
		}
		//실패하면 실패 알림
		System.out.println("일치하는 과목이 없습니다.");
		
		
	}
		
	private static void deleteScore() {
		//학년 반 번호 입력
		//입력한 정보로 객체 생성(Student 클래스)
		//리스트에 있는지 확인해서 없으면 알림 후 종료	=> indexOf(contains로는 찾은애 활용 어려움) =>
		// 학년 학기 과목 입력
		//입력한 정보로 객체 생성(Subjsect)
		System.out.println("------------------------");
		System.out.println("학생 정보를 입력");
		System.out.println("------------------------");
		Student std = inputBaseStudent();
		//입력한 정보로 객체 생성(Student 클래스)
		//리스트에 있는지 확인해서 없으면 알림 후 종료	=> indexOf(contains로는 찾은애 활용 어려움) =>
		int index = studentList.indexOf(std);
		if(index < 0){
			System.out.println("일치하는 학생이 없습니다.");
			return;
		}
		
		// 학년 학기 과목 입력
		//입력한 정보로 객체 생성(Subjsect)
		System.out.println("------------------------");
		System.out.println("성적 정보를 입력");
		System.out.println("------------------------");
		Subject subject = inputSubject();
		//과목리스트에 등록된 과목인지 확인 후 아니면 알림 후 종료
		if(!subjectList.contains(subject)){
			System.out.println("일치하는 과목이 없습니다.");
			return;
		}
		if(studentList.get(index).deleteScore(subject)) {
			System.out.println("성적을 삭제했습니다.");
			return;
		}
		System.out.println("일치하는 성적이 없습니다.");
		//(과목 리스트에 등록된 과목인지 확인 후 아니면 알림 후 종료) 안해도 되는데 하는게 좋음...
		//학생에게 과목 정보를 주면서 성적 삭제하라고 요청 하 성공하면 알림//실패하면 알림
		
	}
	
	private static void updateScore() {
		//학년 반 번호 입력
				//입력한 정보로 객체 생성(Student 클래스)
				//리스트에 있는지 확인해서 없으면 알림 후 종료	=> indexOf(contains로는 찾은애 활용 어려움) =>
				// 학년 학기 과목 입력
				//입력한 정보로 객체 생성(Subjsect)
		//과목 리스트에 등록된 과목인지 확인 후 아니면 알림 후 종료
		//학년 반 번호 입력			//insert에서 뽑아옴
		System.out.println("------------------------");
		System.out.println("학생 정보를 입력");
		System.out.println("------------------------");
		Student std = inputBaseStudent();
		//입력한 정보로 객체 생성(Student 클래스)
		//리스트에 있는지 확인해서 없으면 알림 후 종료	=> indexOf(contains로는 찾은애 활용 어려움) =>
		int index = studentList.indexOf(std);
		if(index < 0){
			System.out.println("일치하는 학생이 없습니다.");
			return;
		}
		
		// 학년 학기 과목 입력
		//입력한 정보로 객체 생성(Subjsect)
		System.out.println("------------------------");
		System.out.println("성적 정보를 입력");
		System.out.println("------------------------");
		Subject subject = inputSubject();
		//과목리스트에 등록된 과목인지 확인 후 아니면 알림 후 종료
		if(!subjectList.contains(subject)){
			System.out.println("일치하는 과목이 없습니다.");
			return;
		}
		
		//새 과목 정보를 입력(학년 학기 과목)을 입력
		System.out.println("------------------------");
		System.out.println("수정할 성적 정보를 입력");
		System.out.println("------------------------");
		Subject newSubject = inputSubject();
		if(!subjectList.contains(newSubject)){
			System.out.println("이미 등록된 과목입니다.");
			return;
		}
		
		// 과목 리스트에 등록된 과목인지 확인 후 아니면 알림 후 종료
		//성적을 입력
		System.out.print("성적 : ");
		int score = scan.nextInt();
		// 새 과목 정보와 성적을 이용하여 성적 객체 생성
		SubjectScore subjectScore = new SubjectScore(newSubject, score);
		// 학생에게 기존 과목 정보와 성적 정보를 주면서 수정하라고 요청한 후 성공하면 알림//실패하면 알림
		if(studentList.get(index).updateScore(subject, subjectScore)) {
			System.out.println("성적을 수정했습니다.");
			return;
		}
		//실패하면 알림
		System.out.println("이미 등록된 성적입니다.");
	}
	
	private static void insertScore() {
		//학년 반 번호 입력
		System.out.println("------------------------");
		System.out.println("학생 정보를 입력");
		System.out.println("------------------------");
		Student std = inputBaseStudent();
		//입력한 정보로 객체 생성(Student 클래스)
		//리스트에 있는지 확인해서 없으면 알림 후 종료	=> indexOf(contains로는 찾은애 활용 어려움) =>
		int index = studentList.indexOf(std);
		if(index < 0){
			System.out.println("일치하는 학생이 없습니다.");
			return;
		}
		
		// 학년 학기 과목 입력
		//입력한 정보로 객체 생성(Subjsect)
		System.out.println("------------------------");
		System.out.println("성적 정보를 입력");
		System.out.println("------------------------");
		Subject subject = inputSubject();
		//과목리스트에 등록된 과목인지 확인 후 아니면 알림 후 종료
		if(!subjectList.contains(subject)){
			System.out.println("일치하는 과목이 없습니다.");
			return;
		}
			
		//성적 입력해서 과목 정보와 성적을 이용하여 객체 생성(Score)
		System.out.println("성적 : ");
		int score = scan.nextInt();
		
		SubjectScore subjectScore = new SubjectScore(subject, score);
		//학생을 선택 => list.getIndex 활용해서 indexOf에서 가져온애 활용 tmp.update() (list.get(xx).update()보다 조금 보기 편해서)
		if(studentList.get(index).insertScore(subjectScore)){
			System.out.println("성적을 추가했습니다.");
			return;
		}
		System.out.println("이미 등록된 성적입니다.");
		
		
		{
			//학생 성적에 새 성적이 있는지 확인해서 없으면 추가 후 알림
			//있으면 추가 안하고 알림		=>확인하는 코드를 학생(클래스)한테 시킴
			//학생에게 새 성적을 주고 추가하라고 시키고 추가 여부를 이용하여 추가 했으면 성공 알림 실패했으면 실패 알림
			//코드 길어지니까....
		}

	}

	private static void searchScore() {
		//학년 반 번호 입력
		System.out.println("---------------");
		System.out.println("조회하려는 학생 정보 입력");
		System.out.println("---------------");
		//입력한 정보 이용해 객체 생성
		Student std = inputBaseStudent();
		//리스트에 학생이 없으면 알림 후 종료	=>indexOf
		int index = studentList.indexOf(std);
		if(index < 0) {
			System.out.println("일치하는 학생이 없습니다.");
			return;
		}
		
		//학년 학기 과목명을 입력
		System.out.println("---------------");
		System.out.println("조회화려는 과목 정보 입력");
		System.out.println("---------------");
		
		
		//과목 정보로 객체 생성
		Subject subject = inputSubject();
		
		
		//리스트에서 학생을 선택
		Student selectStd = studentList.get(index);
		
		//선택한 학생에게 과목정보를 주면서 성적을 출력하라고 요청
		selectStd.printScore(subject);
		
	}
	private static void searchSubject() {
		//등록된 과목 전체 출력
		if(subjectList.size() == 0) {
			System.out.println("등록된 과목이 없습니다.");
			return;
		}
		for(Subject subject : subjectList)System.out.println(subject);
		
		
		
	}
	private static void searchStudent() {
		//학년 반 번호 입력
		//입력한 정보 이용해 객체 생성
		Student std = inputBaseStudent();
		//리스트에서 일치하는 학생 있으면 정보 출력//없으면 없다고 출력
		int index = studentList.indexOf(std);
		if(index >= 0) {
			studentList.get(index).print();
			return;
		}
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
	public static void runMenu(int menu) {
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

	
	private static void removeBuffer() {
		scan.nextLine();
	}
	
	//학년 학기 과목명 입력하여 과목 객체 생성 메소드
	public static Subject inputSubject() {
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
