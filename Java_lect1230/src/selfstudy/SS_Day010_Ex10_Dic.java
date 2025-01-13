package selfstudy;

import java.util.ArrayList;
import java.util.Scanner;

import lombok.AllArgsConstructor;
import lombok.Data;

public class SS_Day010_Ex10_Dic {
	static ArrayList<Word> list = new ArrayList<Word>();
	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		/* 다음 기능을 갖는 사전 프로그램
		 * 1. 단어 등록
		 * 2. 단어 수정
		 * 3. 단어 삭제
		 * 4. 단어 검색
		 * 5. 종료
		 * 메뉴 선택 : 1
		 * 단어 : apple
		 * 의미 : 사과
		 */

		
		int menu = 0;
		do {
			printMenu("단어 등록", "단어 수정", "단어 삭제", "단어 검색", "종료");
			menu = scan.nextInt();
			scan.nextLine();
			runMenu(menu);
			
			

			
			
		}while(menu != 5);
		
		
		
		
		
		
		






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
			System.out.println(i+1 + ". " + menu);
		}
		printBar('-', 15);
		System.out.print("메뉴 선택 : ");
	}
	
	public static void printBar(char bar, int count) {
		for(int i = 1; i<= count; i++) {
			System.out.print(bar);
		}
		System.out.println();
	}
	
	private static void runMenu(int menu) {
		switch(menu) {
		case 1 :
			insWord();
			break;
		case 2 :
			modWord();
			break;
		case 3 :
			delWord();
			break;
		case 4 : 
			srcWord();
			break;
		case 5 :
			System.out.println("프로그램 종료");
			break;
		default :
			System.out.println("올바른 메뉴 입력");
		}
		return;
	}
	private static void srcWord() {
		// TODO Auto-generated method stub
		
	}
	private static void delWord() {
		System.out.print("삭제할 단어 입력 : ");
		String word = scan.nextLine();
		if(list.contains(word)) {
			list.remove(word);
			System.out.println(word + " 삭제되었습니다.");
		}
		else System.out.println("없는 단어입니다.");
	}
	private static void modWord() {
		
	}
	private static void insWord() {
		
		
		System.out.print("단어 입력 : ");
		String word1 = scan.nextLine();
		
		System.out.print("의미 입력 : ");
		String word2 = scan.nextLine();
		
		list.add(new Word(word1,word2));
		
	}

}


@Data
@AllArgsConstructor
class Word{
	private String word, meaning;
	

		
	
	
}

