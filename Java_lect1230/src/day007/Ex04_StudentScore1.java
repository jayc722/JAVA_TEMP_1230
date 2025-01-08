package day007;

import java.util.Scanner;

public class Ex04_StudentScore1 {
	
	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		/* 학생 성적 관리 프로그램 작성
		 * Student 클래스
		 * 
		 * 메뉴
		 * 1. 학생 성적 추가
		 * 2. 학생 성적 조회
		 * 3. 학생 성적 수정
		 * 4. 프로그램 종료
		 * 메뉴 선택 : 1
		 * 학년 : 1
		 * 반 : 1
		 * 번호 : 1
		 * 이름 : 홍길동
		 * 과목 : 국어
		 * 성적 : 100
		 * 
		 */
		
		//메뉴 출력
		//메뉴 실행
		// 1 2 3 4 선택 > 4 입력까지
		//성적 추가 > 
		//성적 조회
		//성적 수정
		
		
		
		char menu;
		int count = 0;
		Student [] list = new Student[10];
		//0번지에 1학년1반1번 홍길동 국어 100 가지는 객체 생성 저장
		list[count++] = new Student(1, 1, 1, "홍길동", "국어", 100);
		
		do {
			menu = 0;
			printmenu();
			menu = scan.next().charAt(0);
			
			count = runmenu(menu,list, count);
			

		}while(menu != '4');


	}
	private static int runmenu(char menu, Student[] list, int count) {
		switch(menu) {
		case '1' :
			System.out.println("================");
			System.out.println("학생 성적 추가");
			count = insertScore(list, count);
			break;
		case '2' :
			System.out.println("================");
			System.out.println("학생 성적 조회");
			for(int i = 0; i < count; i++)list[i].print();
			break;
		case '3' :
			System.out.println("================");
			System.out.println("학생 성적 수정");
			modifyScore(list,count);
			break;
		case '4' :
			System.out.println("================");
			System.out.println("프로그램 종료");
			System.out.println("================");
			break;
		default :
			System.out.println("================");
			System.out.println("잘못된 입력입니다.");
			break;
			

		}
		return count;



	}



	private static void modifyScore(Student[] list, int count) {
		for(int i = 0; i < count; i++)list[i].print();
		System.out.println("수정할 학생의 정보를 입력하세요.");
		System.out.print("학년 : ");
		int grd = scan.nextInt();
		System.out.print("반 : ");
		int clssNum = scan.nextInt();
		System.out.print("번호 : ");
		int chrNum = scan.nextInt();
		System.out.print("과목 : ");
		String sbj = scan.next();
		int index = -1; 	//0번지부터 count-1 번지 까지 list에서 하나씩 꺼내 정보가 일치하면 index에 해당 번지 저장하고 break로 빠져나옴
		
		for(int i = 0; i < count; i++) {
			if(list[i].equal(grd, clssNum, chrNum, sbj)) {
				index = i;
				break;
			}
		}

		if(index >= 0) {
			list[index].print();
			System.out.println("수정할 학생의 성적을 입력하세요.");
			System.out.print("성적 : ");
			int score = scan.nextInt();
			list[index].setScore(score);
			System.out.println("성적을 수정했습니다.");
			list[index].print();
		}else {
			System.out.println("없는 학생 정보 또는 과목입니다.");
		}
		return;

	}
	private static int insertScore(Student[] list, int count) {
		System.out.print("학년 : ");
		int grd = scan.nextInt();
		System.out.print("반 : ");
		int clssNum = scan.nextInt();
		System.out.print("번호 : ");
		int chrNum = scan.nextInt();
		System.out.print("이름 : ");
		String stdName = scan.next();
		System.out.print("과목 : ");
		String sbj = scan.next();
		System.out.print("성적 : ");
		int score = scan.nextInt();

		Student stdTmp = new Student(grd, clssNum, chrNum, stdName, sbj, score);
		list[count] = stdTmp;
		list[count].print();
		
		return ++count;
		
	}
	
	
	
	public static void printmenu() {
		System.out.println("================");
		System.out.println("메뉴");
		System.out.println("1. 학생 성적 추가");
		System.out.println("2. 학생 성적 조회");
		System.out.println("3. 학생 성적 수정");
		System.out.println("4. 프로그램 종료");
		System.out.print("메뉴 선택 : ");				
												/*System.out.print("메뉴\r\n"
														+ "1. 학생 성적 추가\r\n"
														+ "2. 학생 성적 조회\r\n"
														+ "3. 학생 성적 수정\r\n"
														+ "4. 프로그램 종료\r\n"
														+ "메뉴 선택 : ");*/

	}




}

class Student{

	private int grd, clssNum, chrNum, score;
	private String stdName;
	private String sbj;


	public void print(){
		System.out.println(grd + " 학년 " + clssNum + " 반 " + chrNum + "번 " + stdName + " " + sbj + " : " + score);
	}
	
	/* 주어진 정보가 있는지 확인하는 메소드
	 * 매개변수 : 학년 반 번호 과목
	 * 리턴타입 : boolean
	 * 메소드명 : equal
	 */
	
	public boolean equal(int grd, int clssNum, int chrNum, String sbj) {
		if(this.grd != grd)return false;
		if(this.clssNum != clssNum)return false;
		if(this.chrNum != chrNum)return false;
		if(!this.sbj.equals(sbj))return false;			//&&로 연결해도 됨
		
		return true;
	}
	public boolean equal(int grd, int clssNum, int chrNum) {
		if(this.grd != grd)return false;
		if(this.clssNum != clssNum)return false;
		if(this.chrNum != chrNum)return false;
			//과목 없이?
		
		return true;
	}
	
	
	public void setScore(int score) {
		this.score = score;
	}
	
	



	public String getStdName() {
		return stdName;
	}

	public void setStdName(String stdName) {
		this.stdName = stdName;
	}

	
	
	public Student(int grd, int clssNum, int chrNum, String stdName, String sbj, int score) {
		super();
		this.grd = grd;
		this.clssNum = clssNum;
		this.chrNum = chrNum;
		this.stdName = stdName;
		this.sbj = sbj;
		this.score = score;
	}

	


}
