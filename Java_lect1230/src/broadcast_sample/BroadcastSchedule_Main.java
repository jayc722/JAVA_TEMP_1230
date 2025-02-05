package broadcast_sample;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import selfstudy.day021.Ex02.User;



public class BroadcastSchedule_Main {
	
	private User userTmp = new User("tmp",false);
	
	private static Scanner scan = new Scanner(System.in);
	private static final String EXIT = "EXIT";
	
	//private static List<Word> wordList = new ArrayList<Word>();
	private static List<User> userList = new ArrayList<User>();
	private static List<Company> comList = new ArrayList<Company>();
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		
		//방송 편성표
		
		//조회, 수정 가능

		
		if(userList.isEmpty() || userList.size()==0) {
			userList.add(new User("admin", true));
			userList.add(new User("smpl", false));
		}
		
		if(comList.isEmpty() || comList.size()==0) {
			Company kbs = new Company("KBS");
			kbs.getList().add(new TimeTable(1,0,"1","1"));
			comList.add(kbs);
			
			Company sbs = new Company("SBS");
			sbs.getList().add(new TimeTable(1,30,"2","2"));
			comList.add(sbs);
			
			Company mbc = new Company("MBC");
			mbc.getList().add(new TimeTable(2,0,"3","3"));
			comList.add(mbc);
		}
		
		
		
		String menu = "";
		do {
			printMenu("로그인", "로그인 없이 편성표 조회", "회원가입", "세이브 후 종료");
			menu = scan.next();
			scan.nextLine();
			if(menu.equals(EXIT))break;
			runMenu(menu);
			
		}while(menu != "4");
		System.out.println("종료합니다.");

		
		
		
		
		

	}
	private static void printMenu(String ...menus) {
		System.out.println("-----------------");

		for(int i = 0; i < menus.length; i++) {
			System.out.println((i + 1) + ". " + menus[i]);
		}

		System.out.println("-----------------");
		System.out.print("메뉴 입력 : ");
	}
	
	
	
	private static void runMenu(String menu) {

		switch (menu) {
		case "1" :
			login();
			return;

		case "2" : 
			table();
			return;
			
		case "3" : 
			signUp();
			return;
		case "4" :
			return;

		default :
			System.out.println("잘못된 입력입니다.");
		}
	}
	
	
	
	
	private static void signUp() {
		// TODO Auto-generated method stub
		
	}
	private static void table() {
		String menu = "";
		do {
		printMenu("전페 편성표", "방송사별 조회", "이전 메뉴");
		menu = scan.nextLine();
		if(menu.equals(EXIT))break;
		runTableMenu(menu);
		
	}while(menu != "3");
	}
	
	
	
	private static void runTableMenu(String menu) {
		switch (menu) {
		case "1" :
			dateTable(false);
			return;

		case "2" : 
			companyTable(false);
			return;
			
		case "3" : 
			return;

		default :
			System.out.println("잘못된 입력입니다.");
		}
		
	}
	
	
	
	private static void companyTable(boolean b) {
		// TODO Auto-generated method stub
		
	}
	private static void dateTable(boolean b) {

		
		
		
		
	}
	
	
	private static void login() {
		System.out.print("아이디 입력 : ");
		String id = scan.nextLine();
		
		User tmpUser = new User(id);
		
		int index = userList.indexOf(tmpUser);
		
		if(index<0) {
			userList.add(tmpUser);
			index = userList.indexOf(tmpUser);
		}
		
			runMenu(userList.get(index),userList.get(index).isAth());
	
	}
	private static void runMenu(User user, boolean ath) {
		// TODO Auto-generated method stub
		
	}
}
