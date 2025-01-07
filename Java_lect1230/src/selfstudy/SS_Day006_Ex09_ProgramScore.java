package selfstudy;

import java.util.Scanner;

public class SS_Day006_Ex09_ProgramScore {
	
	
	
	static Scanner scan = new Scanner(System.in); 
	static int studentCount;
	public static void main(String[] args) {
		/* 학생의 국어 성적을 관리하는 프로그램
		 * 
		 * 메뉴
		 * 1. 학생 국어 성적 추가
		 * 2. 학생 성적 전체 조회
		 * 3. 종료
		 * 메뉴 선택 : 1
		 * 이름 : 홍길동
		 * 성적 : 100
		 * 메뉴 선택 : 2
		 * 홍길동 : 100
		 * 임꺽정 : 90
		 * 평균 : 95
		 * 
		 */
		char input = 0;
		studentCount = 0;
		
		Student [] std = new Student[5];
		
		do {
		//메뉴 출력
		printMenu();
		input = scan.next().charAt(0);
			
		runMenu(input, std);			//학생 정보를 이용해서 메뉴 실행 후 정보 받아옴 >> 꽉 찼을 경우 새 배열 만들기
		//1번
		
		//2번 
		
		//3번 종료
		std = expand(std);
		
		}while(input != '3');
	}
	
	private static Student[] expand(Student[] std) {
		if(std == null) return new Student[5];
			if(studentCount < std.length-1) {
				return std;
			}
			Student tmp[] = new Student[std.length + 5];
			System.arraycopy(std, 0, tmp, 0, std.length);
		return tmp;
	}

	public static void printMenu() {
		System.out.println("-----------------------");
		System.out.println("메뉴");
		System.out.println("1. 학생 국어 성적 추가");
		System.out.println("2. 학생 성적 전체 조회");
		System.out.println("3. 종료");
		System.out.print("메뉴 선택 : ");
	}
	
	public static void runMenu(char input, Student[] std) {
		System.out.println("-----------------------");
		switch(input) {
		case '1' :											
			// 학생 국어 성적 추가
			addKor(std);
			break;
		case '2' :							
			//학생 성적 전체 조회
			readKor(std);
			break;
		case '3' :			
			System.out.println("프로그램 종료");
			//종료
			break;

		default :
			System.out.println("메뉴 창에서 숫자로 선택해 주세요.");
			break;

		}
		System.out.println("-----------------------");
		return;
	}

	private static void readKor(Student[] std) {
		
		int sum = 0;

		for(int i = 0; i<studentCount; i++) {		
		
		std[i].print();
		sum += std[i].getScore();
		
	}
	
	double avg = sum / (double) studentCount;
	
	System.out.println("평균 : " + avg);
	
}

	private static void addKor(Student[] std) {
		
				//이름과 성적 입력
		System.out.print("이름 : ");
		scan.nextLine();				//nextLine으로 할 경우 앞에 남아있는 엔터 처리
		String name = scan.nextLine();
		System.out.println();
		System.out.print("성적 : ");
		int score = scan.nextInt();

		Student student = new Student(name, score);								// 학생 정보를 이용하여 Student 객체 생성, 배열에 추가
		
		std[studentCount] = student;
		studentCount++;		
		
		
	}
	

	public static int [] newStudentArray(int size) {
		
		int [] arr = new int [size];
		
		
		
		
		return arr;
	}
	
	

}



//학생 클래스

class Student{

	//필드
	private int score;
	private String name;
	
	//메소드
	public int getScore() {
		return score; 
	}
	
	
	public void print() {
		System.out.println("이름 : " + name);
		System.out.println("성적 : " + score);
		
	}
	
	
	// 생성자
	public Student(String name, int count) {
		this.name = name;
		this.score = count;
	}
	
	
}