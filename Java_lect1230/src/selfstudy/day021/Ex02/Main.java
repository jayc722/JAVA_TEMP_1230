package selfstudy.day021.Ex02;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
	// 통신 활용x
	/* 단어장 프로그램
	 * -관리자기능
	 * 	-단어 등록
	 * 	-단어 수정
	 * 	-단어 삭제
	 * 
	 * -사용자기능
	 * 	-단어 검색
	 * 	-내 검색 단어 보기
	 * 
	 * -주의사항
	 * 	-중복된 단어 허용
	 * 	-단어는 단어, 품사, 뜻으로 구성
	 * 	-사용자는 아이디로만 구분. 중복된 아이디 없음
	 * 	-사용자는 회원가입을 따로 하지 x
	 *	-관리자는 admin 고정
	 *	-저장, 불러오기 필수
	 *
	 *시작전
	 *아이디 : admin 
	 *관리자메뉴 출력
	 *메뉴 선택 : 
	 *
	 *아이디 : abc 
	 *사용자메뉴 출력
	 *메뉴 선택
	 *
	 */
	
	private static List<Word> wordList = new ArrayList<Word>();
	private static List<User> userList = new ArrayList<User>();
	
	private static Scanner scan = new Scanner(System.in);
	private static final String EXIT = "EXIT";
	//static String fileName = "src/day013/schedule.txt";
	
	public static void main(String[] args) {

		
		
		//load();
		
		if(userList.isEmpty() || userList.size()==0) {
			userList.add(new User("admin", true));
			userList.add(new User("smpl", false));
			
		}
		
		
		int menu = 0;
		do {
			printMenu("로그인", "종료");
			menu = scan.nextInt();
			scan.nextLine();
			runMenu(menu);
			
		}while(menu != 2);
		
		//save();

		
		
	}
	/*

	private static void load() {

		try(FileInputStream fis = new FileInputStream(fileName);
				ObjectInputStream ois = new ObjectInputStream(fis)){
		
			List<Schedule> tmp = (ArrayList<Schedule>)ois.readObject();	//list가 아니라 arraylist
			list.addAll(tmp);		//매개변수에 넘겨주기
			
		}catch (Exception e) {
			System.out.println("[불러오기 실패]");
			e.printStackTrace();
		
	}
	}

	private static void save() {

		try(FileOutputStream fos = new FileOutputStream(fileName);
				ObjectOutputStream oos = new ObjectOutputStream(fos)){
			
			oos.writeObject(list);
			
	
		} catch (Exception e) {
			System.out.println("[저장하기 실패]");
			e.printStackTrace();
		}
		
	}
	
	
	*/
	
	private static void printMenu(String ...menus) {
		System.out.println("-----------------");

		for(int i = 0; i < menus.length; i++) {
			System.out.println((i + 1) + ". " + menus[i]);
		}

		System.out.println("-----------------");
		System.out.print("메뉴 입력 : ");
	}
	private static void runMenu(int menu) {

		switch (menu) {
		case 1 :
			login();
			return;

		case 2 : 

			return;

		default :
			System.out.println("잘못된 입력입니다.");
		}
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
		
		if(userList.get(index).isAth()) {
			adminMenu(userList.get(index));
		}
		else {
			userMenu(userList.get(index));
		}
		
		
	}
	
	
	private static void userMenu(User user) {
		System.out.println("유저 메뉴 실행");
		int menu = 0;
		do {
			printMenu("단어 검색", "내가 검색한 단어 보기");
			
			menu = scan.nextInt();
			scan.nextLine();
			
			runUserMenu(menu, user);
			
			
		}while(menu != 3);
		
	}
	
	private static void runUserMenu(int menu, User user) {
		switch(menu) {
		case 1 :
			userSearchWord(user);
			return;

		case 2 : 
			mySearchWords(user);
			return;

		default :
			System.out.println("잘못된 입력입니다.");


		}

		
	}
	private static void mySearchWords(User user) {
		
		user.myList();
		
	}
	private static void userSearchWord(User user) {

		while(true) {
		System.out.println("나가려면 EXIT 입력");
		System.out.print("검색할 단어 입력 : ");
		String input = scan.nextLine();
		if(input.equals(EXIT))return;
		List<Word> tmpList = searchWord(input);
		if(tmpList.size() == 0) {
			System.out.println("해당하는 단어가 없었습니다.");
			continue;
		}
		
		user.searchList.add(input);
		
		for(int i = 0; i < tmpList.size(); i++) {
			tmpList.get(i).printShort(i);
		}
		
		System.out.print("단어의 번호를 입력(돌아가려면 그 외를 입력) : ");
		int num = -1;
		num =scan.nextInt() - 1;
		scan.nextLine();
		if(num<0||num>=tmpList.size()) continue;
		
		tmpList.get(num).print();
		
		}
		
			
		
	}
	private static List<Word> searchWord(String input) {

		List<Word> tmp = new ArrayList<Word>();
		for(Word word : wordList) {
			if(input.equals(word.getWordName())) {
				tmp.add(word);
			}
		}
		
		return tmp;
	}
	
	
	private static void adminMenu(User user) {
		System.out.println("관리자 메뉴 실행");
		int menu = 0;
		do {
			printMenu("단어 등록", "단어 수정", "단어 삭제", "돌아가기");
			
			menu = scan.nextInt();
			scan.nextLine();
			
			runAdminMenu(menu);
			
			
		}while(menu != 4);
		
	}
	
	

	private static void runAdminMenu(int menu) {

		switch(menu) {
		case 1 :
			insWord();
			return;

		case 2 : 
			updWord();
			return;

		case 3 : 
			delWord();
			return;
		case 4 :
			System.out.println("로그아웃");
			return;
		default :
			System.out.println("잘못된 입력입니다.");
		}

	}
	private static void delWord() {
		Word tmpWord = null;
		
		System.out.print("삭제할 단어(showAll입력시 전체출력) : ");
		String wName = scan.nextLine();
	
		
		int count = 0;
		for(int i = 0; i < wordList.size(); i++) {
			if(wordList.get(i).getWordName().equals(wName)||wName.equals("showAll")) wordList.get(i).printShort(i);
			tmpWord = wordList.get(i);
			count++;
		}

		if(count == 0) {
			System.out.println("해당하는 단어가 없습니다.");
			return;
		} else if(count > 1) {
		System.out.print("삭제할 단어의 번호를 입력(음수는 돌아가기) : ");
		int num = scan.nextInt()-1;
		scan.nextLine();
		if(num<0)return;
		tmpWord = wordList.get(num);
		}
		tmpWord.print();
		
		System.out.println("삭제하시겠습니까?(o를 입력해 삭제)");
		String inputO = scan.nextLine();
		if(inputO.equals("o")||inputO.equals("O")||inputO.equals("ㅇ"))
		wordList.remove(wordList.indexOf(tmpWord));
		
		System.out.println("단어를 삭제했습니다.");
		
	}
	private static void updWord() {
		Word tmpWord = null;
		
		System.out.print("수정할 단어(showAll입력시 전체출력) : ");
		String wName = scan.nextLine();
	
		
		int count = 0;
			for(int i = 0; i < wordList.size(); i++) {
			if(wordList.get(i).getWordName().equals(wName)||wName.equals("showAll")) wordList.get(i).printShort(i);
			tmpWord = wordList.get(i);
			count++;
		}

		if(count == 0) {
			System.out.println("해당하는 단어가 없습니다.");
			return;
		} else if(count > 1) {
		System.out.print("수정할 단어의 번호를 입력(음수는 돌아가기) : ");
		int num = scan.nextInt()-1;
		scan.nextLine();
		if(num<0)return;
		tmpWord = wordList.get(num);
		}
		tmpWord.print();
		
		Word inputWord = inputWord();
		if(inputWord == null)return;
		
		wordList.add(wordList.indexOf(tmpWord), inputWord);
		
		System.out.println("단어를 수정했습니다.");
		
	}
	private static void insWord() {
		
		Word tmpWord = inputWord();

		if(tmpWord != null) {
		wordList.add(tmpWord);
		System.out.println("단어가 등록되었습니다.");
		System.out.println("index : " + (wordList.size()-1));
		return;
		}
		System.out.println("돌아갑니다.");
		
	}
	private static Word inputWord() {
		System.out.print("단어 : ");
		String wName = scan.nextLine();
		if(wName == null || wName.equals("")) return null;
		System.out.print("품사 : ");
		String wClass = scan.nextLine();
		if(wClass == null || wClass.equals("")) return null;
		System.out.print("의미 : ");
		String wMean = scan.nextLine();
		if(wMean == null || wMean.equals("")) return null;
		
		return new Word(wName, wClass, wMean);
	}





}
