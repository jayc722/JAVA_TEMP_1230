package day007;

import java.util.Scanner;


public class Ex05_StudentScore2 {
	
	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		/* 학생 성적 관리 프로그램 작성
		 * Student 클래스
		 * 
		 * 메뉴
		 * 1. 학생 성적 추가
		 * 2. 학생 성적 조회
		 * 3. 학생 성적 수정
		 * 4. 학생 성적 삭제
		 * 5. 프로그램 종료
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
			list = expand(list, count);

		}while(menu != '5');


	}
	private static Student[] expand(Student[] list, int count) {
		if(list == null) {
			return new Student[10];
		}
		if(count <= list.length) {
			return list;
		}
		//확장
		Student tmp[] = new Student[list.length + 5];
		//복사 
		System.arraycopy(list, 0, tmp, 0, list.length);
		
		return tmp;
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
			System.out.println("학생 성적 삭제");
			count = deleteScore(list, count);
			break;
		case '5' :
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



	private static int deleteScore(Student[] list, int count) {
					
					// 해당 student 찾기
		System.out.println("삭제할 학생의 정보를 입력하세요.");
		System.out.print("학년 : ");
		int grd = scan.nextInt();
		System.out.print("반 : ");
		int clssNum = scan.nextInt();
		System.out.print("번호 : ");
		int chrNum = scan.nextInt();
		System.out.print("과목 : ");
		String sbj = scan.next();

		// 해당 student.list가 있으면 해당 student index 기억
		int index = findStd(list, count, grd, clssNum, chrNum, sbj);

		if(index >= 0) {
			list[index].print();
			// 해당 index를 index+1로 덮어쓰기 -> count까지 반복
			
			//System.arraycopy(list, index+1, list, index, count-index);  //무슨 예외가 일어날지 모름
			
			/*if(index != count -1){
				Student [] tmp = new Student[list.length];
				System.arraycopy(list, 0, tmp, 0, count);
				System.arraycopy(list, index+1, tmp, index, count-index-1);
				list = tmp;
			}*/
			
			for(int i = index; i < count-1; i++){		//조건 처리 안해도됨
				list[i] = list[i + 1];
			}
			
			System.out.println("성적을 삭제했습니다.");
			count--;			// count--

		}else {
			System.out.println("없는 학생 정보 또는 과목입니다.");
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
		//int index = -1; 	//0번지부터 count-1 번지 까지 list에서 하나씩 꺼내 정보가 일치하면 index에 해당 번지 저장하고 break로 빠져나옴
		
		int index = findStd(list, count, grd, clssNum, chrNum, sbj);
		
		if(index >= 0) {
			list[index].print();
			System.out.println("수정할 학생의 성적을 입력하세요.");
			int score = scoreRange();
			list[index].setScore(score);
			System.out.println("성적을 수정했습니다.");
			list[index].print();
		}else {
			System.out.println("없는 학생 정보 또는 과목입니다.");
		}
		return;

	}
	/**주어진 정보가 배열의 몇번지에 있는지 알려주는 기능(없으면 -1)
	 * 
	 * @param list
	 * @param count
	 * @param grd
	 * @param clssNum
	 * @param chrNum
	 * @param sbj
	 * @return
	 */
	private static int findStd(Student[] list, int count, int grd, int clssNum, int chrNum, String sbj) {
		for(int i = 0; i < count; i++) {
			if(list[i].equal(grd, clssNum, chrNum, sbj)) {
				return i;
			}
		}
		return -1;

	}
	private static int findStd(Student[] list, int count, int grd, int clssNum, int chrNum) {
		for(int i = 0; i < count; i++) {
			if(list[i].equal(grd, clssNum, chrNum)) {
				return i;
			}
		}
		return -1;

	}// 과목 없이
	private static int insertScore(Student[] list, int count) {
		System.out.print("학년 : ");
		int grd = scan.nextInt();
		System.out.print("반 : ");
		int clssNum = scan.nextInt();
		System.out.print("번호 : ");
		int chrNum = scan.nextInt();
		String stdName;
		int index = findStd(list, count, grd, clssNum, chrNum);
		if(index >= 0) {
			stdName = list[index].getStdName();
			System.out.println("이름 : " + stdName);
		}else {
			System.out.print("이름 : ");
			stdName = scan.next();
		}
		System.out.print("과목 : ");
		String sbj = scan.next();


		// 학년 반 번호 + 과목 비교해 있는지 확인 -기존 메소드 활용

		index = findStd(list, count, grd, clssNum, chrNum, sbj);
		if(index>=0) {
			System.out.println("중복된 학생 혹은 과목입니다.");
			return count;
		}
		int score = scoreRange();

		Student stdTmp = new Student(grd, clssNum, chrNum, stdName, sbj, score);

		list[count] = stdTmp;
		list[count].print();
		return ++count;
	}



	private static int scoreRange() {
		int score = -1;
		do{
			System.out.print("성적 : ");
			score = scan.nextInt();
			if(!(score>=0&&score<=100))System.out.println("0부터 100까지의 범위로 입력해 주세요.");
		}while(!(score>=0&&score<=100));
		return score;
	}
	
	
	public static void printmenu() {
		System.out.println("================");
		System.out.println("메뉴");
		System.out.println("1. 학생 성적 추가");
		System.out.println("2. 학생 성적 조회");
		System.out.println("3. 학생 성적 수정");
		System.out.println("4. 학생 성적 삭제");
		System.out.println("5. 프로그램 종료");
		System.out.print("메뉴 선택 : ");				
														/*System.out.print("메뉴\r\n"
														+ "1. 학생 성적 추가\r\n"
														+ "2. 학생 성적 조회\r\n"
														+ "3. 학생 성적 수정\r\n"
														+ "4. 프로그램 종료\r\n"
														+ "메뉴 선택 : ");*/

	}




}
// student 클래스 4번이랑 겹치기 때문에 그냥 삭제해버리면 4번거 그대로 씀

