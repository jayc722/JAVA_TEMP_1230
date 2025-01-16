package selfstudy;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import lombok.AllArgsConstructor;
import lombok.Data;

public class SS_Day013_Ex07_Schedule {
	static Scanner scan = new Scanner(System.in); 
	static ArrayList<Schedule> list = new ArrayList<Schedule>();

	public static void main(String[] args) {
		/*
		 * 다음 기능을 수행하는 프로그램 작성
		 * 
		 * 1. 스케줄 등록 // -날짜, 시작시간, 할일을 입력하여 등록
		 * 2. 스케줄 수정 // 날짜를 입력, 해당 날짜에 등록된 스케줄 출력, 수정할 스케줄을 선택, 날짜*시작시간*할일을 입력하여 수정
		 * 3. 스케줄 삭제 // 날짜를 입력, 해당 날짜에 등록된 스케줄 출력, 삭제할 스케줄 선택하여 삭제
		 * 4. 스케줄 조회 // 월 조회(년과 월을 입력받아 스케줄 조회), 일 조회(년 월 일을 입력받아 스케줄 조회)
		 * 
		 */
		int menu = 0;
		do {
			printMenu();
			System.out.print("번호 입력 : ");
			
			menu = scan.nextInt();
			scan.nextLine();
			runMenu(menu);


		}while(menu != 5);



	}

	private static void runMenu(int menu) {
		switch(menu) {
		case 1 :
			insSc();
			break;
		case 2 :
			modSc();
			break;
		case 3 :
			delSc();
			break;
		case 4 :
			srcSc();
			break;
		case 5 :
			System.out.println("프로그램 종료");
			break;
		default :
			System.out.println("잘못된 입력입니다.");
		}

	}

	private static void delSc() {
		System.out.println("월 입력 : ");
		int month = scan.nextInt();
		System.out.println("월 입력 : ");
		int day = scan.nextInt();
		
		List<Schedule> tmp = list.stream().filter(s->s.getMonth() == month && s.getDay() == day).collect(Collectors.toList());		
		
		print(list, s->s.getMonth() == month && s.getDay() == day);
		
		System.out.print("삭제할 스케줄 번호 입력 : ");
		int count = scan.nextInt();
		Schedule tmp2 = tmp.get(count-1);
		list.remove(tmp2);
		
	}

	private static void srcSc() {
		System.out.println("월 입력 : ");
		int month = scan.nextInt();
		System.out.println("일 입력 : ");
		int day = scan.nextInt();
		
		print(list, s->s.getMonth() == month && s.getDay() == day);
		
	}

	private static void modSc() {
		System.out.println("월 입력 : ");
		int month = scan.nextInt();
		System.out.println("일 입력 : ");
		int day = scan.nextInt();
		
		print(list, s->s.getMonth() == month && s.getDay() == day);
	}
	
		private static void print(List<Schedule> list, Predicate<Schedule> p) {		//삭제기능에서 사용하기 위해 수정(전체범위 이외에)
			Stream<Schedule> stream = list.stream();
			stream.filter(p).forEach(s->System.out.println(s));	
			}
	

	private static void insSc() {
		System.out.println("스케줄 등록");
		System.out.print("월 : ");
		int month = scan.nextInt();
		System.out.print("일 : ");
		int day = scan.nextInt();
		scan.nextLine();
		System.out.print("시작시간 : ");
		String time = scan.nextLine();
		System.out.print("할 일 : ");
		String toDo = scan.nextLine();
		
		list.add(new Schedule(month, day, time, toDo));
		System.out.println(list);
		
	}

	private static void printMenu() {
		System.out.println("메뉴 \n 1. 스케줄 등록 \n 2. 스케줄 수정 \n 3. 스케줄 삭제 \n 4. 스케줄 조회");

	}

}

@Data
@AllArgsConstructor
class Schedule{
	int month, day;
	String time;
	String toDo;
	
	@Override
	public String toString() {
		return month + "월 " + day + "일 " + "시작 시간 : " + time + " 할 일 : " + toDo;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Schedule other = (Schedule) obj;
		return month == other.month;
	}

	
	
}