package day010;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

import lombok.AllArgsConstructor;
import lombok.Data;

public class Ex10_Dictionary {
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

		
		Scanner scan = new Scanner(System.in);
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
		for(int i = 1; i <= count; i++) {
			System.out.print(bar);
		}
		System.out.println();
	}
	
	private static void runMenu(int menu) {
		switch(menu) {
		case 1 :
			insertWord();
			break;
		case 2 :
			updateWord();
			break;
		case 3 :
			deleteWord();
			break;
		case 4 : 
			searchWord();
			break;
		case 5 :
			System.out.println("프로그램을 종료합니다.");
			break;
		default :
			System.out.println("올바른 메뉴를 선택하세요.");
		}
		return;
	}
	private static void searchWord() {
		//단어 입력
		System.out.println("단어 : ");
		String word = scan.nextLine();
		int count = 0;
		//단어장에 있는 단어가 검색 단어를 포함하고 있으면 출력
		for(Word tmp : list) {
			if(tmp.getWord().contains(word)) {
				System.out.println(tmp);
				count++;
			}
		}
		if (count == 0) System.out.println("일치하는 단어가 없습니다.");
	}
	private static void deleteWord() {
		//단어를 입력
		System.out.println("단어 : ");
		String word = scan.nextLine();
		//단어가 있으면 단어 삭제 후 알림문구 출력
		//없으면 알림문구 출력
		if(list.remove(new Word(word, "")))System.out.println("단어를 삭제했습니다.");
		else System.out.println("일치하는 단어가 없습니다.");
	}
	private static void updateWord() {
		// 단어와 새 뜻 입력
		System.out.println("단어 : ");
		String word = scan.nextLine();
		
		System.out.println("수정할 의미 : ");
		String meaning = scan.nextLine();
		//단어가 없으면 알림문구 후 종료
		//단어가 몇번인지 확인 후 -1번지이면 알림문구 후 종료
		Word wordObj = new Word(word, meaning);
		
		int index = list.indexOf(wordObj);
		if(index < 0) {
			System.out.println("일치하는 단어가 없습니다.");
			return;
		}
		//단어를 수정
		//번지에 있는 단어를 가져와서 단어를 수정
		list.set(index, wordObj);
		System.out.println("단어를 수정했습니다.");
	}
	private static void insertWord() {
		//단어와 뜻을 입력
		System.out.print("단어 : ");
		String word = scan.nextLine();
		
		System.out.print("의미 : ");
		String meaning = scan.nextLine();


		Word wordObj = new Word(word, meaning);
		//단어가 단어장에 있으면 알림문구 후 종료
		if(list.contains(wordObj)) {
			System.out.println("이미 등록된 단어입니다.");
			return;
		}

		//반복문 이용하여 판단
		/* for(Word tmp : list){
		 * 	if(tmp.getWord().equals(word)){
		 *		System.out.println("이미 등록된 단어입니다.");
		 * 		return;
		 * 		}
		 * 	}
		 */
		//단어 추가
		list.add(wordObj);
		System.out.println("단어를 등록했습니다.");
		
	}
	

}
@Data
@AllArgsConstructor
class Word{
	private String word, meaning;

	@Override //해시는 필요없음
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Word other = (Word) obj;
		return Objects.equals(word, other.word);
	}
	
	@Override
	public String toString() {
		return word + " : " + meaning;
	}
}


