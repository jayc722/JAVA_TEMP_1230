package selfstudy;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;
import lombok.Data;

public class Ex03_Student {

	static public Scanner scan = new Scanner(System.in); 
	static List<StudentAtt> list = new ArrayList<StudentAtt>();
	public static void main(String[] args) {
		/*
		 * 학생들의 출석을 관리하는 프로그램
		 * 1. 학생 등록
		 * -이름만 입력해 등록
		 * 2. 출석 체크
		 * -날짜를 입력하면 등록된 학생들의 출석 여부를 체크(지각,조퇴x)
		 * 	-2025-01-27
		 * -출석이면 o 결석이면 x 로 관리
		 * 3. 출석 확인
		 * 4. 종료
		 * 
		 * 
		 */
		
		
		
		int menu = 0;
		do {
			
			
			printMenu();
			System.out.print("입력 : ");
			menu = scan.nextInt();
			scan.nextLine();
			
			runMenu(menu);
			
			
			
			
			


		}while(menu != 4);




	}
	private static void runMenu(int menu) {
		switch(menu) {
		case 1 :
			inputStd();
			break;
		case 2 :
			takeAtt();
			break;
		case 3 : 
			viewAtt();
			break;
		case 4 :
			break;
		default :
			System.out.println("잘못된 입력입니다.");
		}
	}




	private static void viewAtt() {
		String date = null;
		while(true) {
			System.out.print("날짜 입력 : ");
			date = scan.nextLine();
			if(isDate(date))break;
			System.out.println("yyyy-MM-dd 형식으로 입력해주세요.");
		}
		System.out.println(date + " : 출석");
		for(int i = 0; i < list.size(); i++) {
			
			System.out.print(i + ". " + list.get(i) + list.get(i).getDList().equals(date));
		}
		

		
	}

	public static boolean isDate(String str) {
		try{
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			Date date = format.parse(str);
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
 


	private static void takeAtt() {
		String date = null;
		while(true) {
			System.out.print("날짜 입력 : ");
			date = scan.nextLine();
			if(isDate(date))break;
			System.out.println("yyyy-MM-dd 형식으로 입력해주세요.");
		}
		System.out.println(date + " : 출석체크");
		for(int i = 0; i < list.size(); i++) {
			
			while(true) {
			System.out.print(i + ". " + list.get(i) + " : ");
			String input = scan.nextLine();
			
				if(input.equals("o")||input.equals("O")||input.equals("ㅇ")){
					list.get(i).getDList().add(new DateAtt(date, "O"));
					break;
				}else if(input.equals("x")||input.equals("X")||input.equals("ㄴ")){
					list.get(i).getDList().add(new DateAtt(date, "X"));
					break;
				}else System.out.println("출석여부 입력");
			}
		}

	}





	private static void inputStd() {
		System.out.print("학생 이름 입력 : ");
		String name = scan.nextLine();
		list.add(new StudentAtt(name));
		System.out.println(list);
		System.out.println("추가되었습니다.");
		
		
		
		
	}
	
	
	
	private static void printMenu() {
		System.out.println("---------------------");
		System.out.println("1. 학생 등록");
		System.out.println("2. 출석 체크");
		System.out.println("3. 출석 확인");
		System.out.println("4. 종료");
		System.out.println("---------------------");

	}

}

@Data
@AllArgsConstructor
class StudentAtt {
	String name;
	List<DateAtt> dList;
	
	public StudentAtt(String name) {
		super();
		this.name = name;
		this.dList = new ArrayList<DateAtt>();
	}
	
	
}
@Data
@AllArgsConstructor
class DateAtt{
	String date;
	String attend;
	
	
	@Override
	public String toString() {
		return date + " : " + attend;
	}
	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DateAtt other = (DateAtt) obj;
		return Objects.equals(date, other.date);
	}

	
	
	
}
