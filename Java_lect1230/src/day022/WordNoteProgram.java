package day022;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

//단어장 이어서

public class WordNoteProgram implements ConsoleProgram {
	
	private Scanner scan = new Scanner(System.in); 
	private String id;	
	private List<Word> words;
	private Map<String, List<Word>> myWords;

	
	
	@Override
	public void run() {

		//int menu;
		//final int EXIT = 5;

		String wordsFileName = "src/day022/words.txt";
		String myWordsFileName = "src/day022/myWords.txt";
		
		
		
		//불러오기
		words = (List<Word>) load(wordsFileName);
		myWords = (Map<String, List<Word>>) load(myWordsFileName);
		
		//불러오기 실패 처리
		if(words == null) {
			words = new ArrayList<Word>();
			//words.add(new Word("apple", "명", "사과"));
			//words.add(new Word("banana", "명", "바나나"));
			
		}
		if(myWords == null) {
			myWords = new HashMap<String, List<Word>>();
		//	List<String> list = new ArrayList<String>();
		//	list.add("test");
		//	myWords.put("abc", list);
		}
		
		
		//아이디 입력

		System.out.print("아이디 : ");
		id = scan.next();

		
		
		if("admin".equals(id)) {
			WordNoteAdminProgram adminProgram = new WordNoteAdminProgram(scan, words);
			adminProgram.run();
		}else {
			WordNoteUserProgram userProgram = new WordNoteUserProgram(scan, words, myWords, id);
			userProgram.run();
		}
			
		
		//저장하기

		save(wordsFileName, words);
		save(myWordsFileName, myWords);
		
		
		
		/*
		int EXIT = "admin".equals(id) ? 4 : 3;	//관리자 메뉴는 종료가 4번 사용자메뉴는 3번


		do {
			printMenu();

			menu = scan.nextInt();
			scan.nextLine();

			runMenu(menu);

		}while(menu != EXIT);

		 */

	}


	@Override
	public void printMenu() {
		if("admin".equals(id)) {
			System.out.println("----------------");
			System.out.println("1. 단어 등록");
			System.out.println("2. 단어 수정");
			System.out.println("3. 단어 삭제");
			System.out.println("4. 종료");
			System.out.println("----------------");
			System.out.print("메뉴 선택");

		}else {
			System.out.println("----------------");
			System.out.println("1. 단어 검색");
			System.out.println("2. 내 단어 보기");
			System.out.println("3. 종료");
			System.out.println("----------------");
			System.out.print("메뉴 선택");


		}
	}
/*
	public void runMenu(int menu) {

	}
*/








}
