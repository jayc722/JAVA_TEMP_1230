package day013;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;
import lombok.Data;

public class Ex07_Schedule {
	static Scanner scan = new Scanner(System.in); 
	static List<Schedule> list = new ArrayList<Schedule>();
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
		int menu = 0;				//초기화 안하면 트라이캐치에서 걸렸을때 바로 while 가버려서 비교 불가..
		final int EXIT = 5;
		
		String fileName = "src/day013/schedule.txt";
		
		load(fileName,list);
		
		do {
			printMenu();
			
			try {
			menu = scan.nextInt();
			scan.nextLine();
			runMenu(menu);
			}
			catch(InputMismatchException e) {
				System.out.println("올바른 메뉴를 선택하세요.");
				scan.nextLine();							//전메뉴에서 잘못 입력한게 트라이캐치에 걸려 남은채로 넘어오는걸 방지
			}

		}while(menu != EXIT);


		save(fileName,list);






	}

	private static void load(String fileName, List<Schedule> list) {

		try(FileInputStream fis = new FileInputStream(fileName);
				ObjectInputStream ois = new ObjectInputStream(fis)){
		
			List<Schedule> tmp = (ArrayList<Schedule>)ois.readObject();	//list가 아니라 arraylist
			list.addAll(tmp);		//매개변수에 넘겨주기
			
		}catch (Exception e) {
			System.out.println("[불러오기 실패]");
			e.printStackTrace();
		
	}
	}

	private static void save(String fileName, List<Schedule> list) {

		try(FileOutputStream fos = new FileOutputStream(fileName);
				ObjectOutputStream oos = new ObjectOutputStream(fos)){
			
			oos.writeObject(list);
			
	
		} catch (Exception e) {
			System.out.println("[저장하기 실패]");
			e.printStackTrace();
		}
		
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

	private static void insSc() {
	
		
		//객체 생성			//클래스랑 변수선언때도 Ctrl+space 하면 제안 해줌
		try {
			Schedule schedule = inputSchedule();
			//리스트에 추가
			list.add(schedule);
			System.out.println("스케줄을 추가했습니다.");
		} catch (ParseException e) {
			System.out.println("날짜와 시간을 잘못 입력했습니다.");
		}		
		
		
	}
	
	private static Schedule inputSchedule() throws ParseException {
				// 날짜 
				System.out.print("날짜(yyyy-MM-dd) : ");
				String date = scan.nextLine();			// 엔터 입력 넘기기싫어서 그냥 nextline으로...문제생겨도 넘기기때문에...
				
				// 시간
				System.out.print("시간(HH:mm) : ");
				String time = scan.nextLine();
				
				// 할일
				System.out.print("할일 : ");
				String toDo = scan.nextLine();
				
				return new Schedule(date + " " + time, toDo);
	}

	private static void modSc() {
		// 날짜 입력
		System.out.print("날짜(yyyy-MM-dd) : ");
		String date = scan.nextLine();					//날짜 멤버변수는 date 입력받는건 string -> 코드 길어짐->메소드로
		
		
		List<Schedule> tmpList =
				list.stream()							//날짜에 맞는 애들 뽑아와 리스트에 저장
					.filter(s -> s.checkDate(date))
					.collect(Collectors.toList());
		
		//출력
		if(tmpList.size() == 0) {System.out.println("검색결과가 없습니다."); return;}
		for(int i = 0; i < tmpList.size(); i++)System.out.println(i + 1 + ". " + tmpList.get(i));
		
		//수정할 일정 선택
		System.out.println("수정할 일정 : ");
		int index = scan.nextInt() - 1;
		scan.nextLine();
		
		if(index < 0 || index >= tmpList.size()) {
			System.out.println("잘못된 일정을 선택했습니다.");
			return;
		}
		//수정할 정보 입력
		try {
			Schedule schedule = inputSchedule();
			
			//수정
			tmpList.get(index).update(schedule);		//set은 의미없음(tmp라서)
			System.out.println("스케줄을 수정했습니다.");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}


	private static void delSc() {
		// 날짜 입력
		System.out.print("날짜(yyyy-MM-dd) : ");
		String date = scan.nextLine();					//날짜 멤버변수는 date 입력받는건 string -> 코드 길어짐->메소드로
		
		
		List<Schedule> tmpList =
				list.stream()							//날짜에 맞는 애들 뽑아와 리스트에 저장
					.filter(s -> s.checkDate(date))
					.collect(Collectors.toList());
		
		//출력
		if(tmpList.size() == 0) {System.out.println("검색결과가 없습니다."); return;}
		for(int i = 0; i < tmpList.size(); i++)System.out.println(i + 1 + ". " + tmpList.get(i));
		
		//삭제할 일정 선택
		System.out.println("삭제할 일정 : ");
		int index = scan.nextInt() - 1;
		scan.nextLine();
		
		if(index < 0 || index >= tmpList.size()) {
			System.out.println("잘못된 일정을 선택했습니다.");
			return;
		}
		//삭제할 객체 가져옴
		
		Schedule tmp = tmpList.get(index);
		
		//리스트에서 삭제
		
		list.remove(tmp);
		
		System.out.println("스케줄을 삭제했습니다.");
		
		
		
	}

	private static void srcSc() {
		printSearchMenu();
		
		int menu = scan.nextInt();
		scan.nextLine();
		
		runSearchMenu(menu);
		
	}

	private static void runSearchMenu(int menu) {
		switch(menu) {
		case 1 :
			searchMonth();
			break;
		case 2 :
			searchDay();
			break;
		case 3 :
			System.out.println("프로그램 종료");
			break;
		default :
			System.out.println("잘못된 입력입니다.");
		}
		
	}

	private static void searchMonth() {
		// 날짜 
		scan.nextLine();
		System.out.print("날짜(yyyy-MM) : ");
		String date = scan.nextLine();			

		List<Schedule> tmpList = list.stream()
				.filter(s->s.getDateStr().substring(0, 7).equals(date))	//0에서 6번지(일)까지 조회
				.collect(Collectors.toList());

		if(tmpList.size() == 0) {
			System.out.println("검색 결과가 없습니다.");
			return;
		}

		tmpList.stream().forEach(s->System.out.println(s));
	}

	private static void searchDay() {
		// 날짜 
		scan.nextLine();
		System.out.print("날짜(yyyy-MM-dd) : ");
		String date = scan.nextLine();			
		List<Schedule> tmpList = list.stream()
								.filter(s->s.getDateStr().substring(0, 10).equals(date))	//0에서 9번지(일)까지 조회
								.collect(Collectors.toList());
		
		if(tmpList.size() == 0) {
			System.out.println("검색 결과가 없습니다.");
			return;
		}
		
		tmpList.stream().forEach(s->System.out.println(s));
	}

	private static void printSearchMenu() {
		System.out.println("-----------------------\n");
		System.out.println("메뉴 \n 1. 월 조회 \n 2. 일 조회 \n 3. 종료");
		System.out.println("-----------------------\n");
		System.out.print("번호 입력 : ");
		
	}

	private static void printMenu() {
		System.out.println("-----------------------\n");
		System.out.println("메뉴 \n 1. 스케줄 등록 \n 2. 스케줄 수정 \n 3. 스케줄 삭제 \n 4. 스케줄 조회 \n 5. 종료");
		System.out.println("-----------------------\n");
		System.out.print("번호 입력 : ");
		
	}

}
@Data
@AllArgsConstructor
class Schedule implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4512037263681472896L;
	
	private Date date;					//date 클래스
	private String toDo;
	// "2025-01-01 12:00"
	public void setDate(String dateTime) throws ParseException {			// 문자열로 입력받은 date를 Date 클래스 날짜 객체로 변환 해주기 위해
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:MM");
		
		this.date = format.parse(dateTime);				//입력방식이 틀리면 예외 발생가능 -> 예외처리
													//try catch로도 가능하지만 이번엔 throw
													//입력받은게 잘못됐으면 아예 추가하지 않고 넘어가게
	}
	
	public void update(Schedule schedule) {
		if(schedule == null) return;
		this.date = schedule.date;
		this.toDo = schedule.toDo;
		
	}

	public Schedule(String dateTime, String toDo) throws ParseException {	//시간 포함하니 datetime 으로
		this.toDo = toDo;
		setDate(dateTime);
		
	}
	
	public boolean checkDate(String date) {
		if(date == null || this.date == null)return false;
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String tmpDate = format.format(this.date);
		return tmpDate.equals(date);
		
				
		
	}
	public String getDateStr() {		//getDate는 @Data에 의해 만들어지기때문에 이름 따로
		
		if(date == null) return null; 		//안하면 널타입 에러
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		return format.format(date);
	}
	
	@Override
	public String toString() {
		return "[" + getDateStr() + "]" + toDo;
	}
	
	
}	

