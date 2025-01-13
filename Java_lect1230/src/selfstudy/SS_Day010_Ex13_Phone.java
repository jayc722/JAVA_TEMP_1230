package selfstudy;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

import lombok.AllArgsConstructor;
import lombok.Data;

public class SS_Day010_Ex13_Phone {
	static ArrayList<Phone> list = new ArrayList<Phone>();
	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		// 전화번호 관리 프로그램
		/* 1. 전화번호 추가
		 * 	이름과 전화번호를 입력받아 추가
		 * 	동명이인이 있을 수 있기때문에 중복돼도 추가
		 * 2. 전화번호 수정
		 * 	이름을 입력
		 * 	이름과 일치하는 목록 출력
		 * 	수정하려는 전화번호 선택
		 * 	새 전화번호 입력받아 수정
		 * 3. 전화번호 삭제
		 *  이름을 입력
		 *  이름과 일치하는 목록 출력
		 *  삭제하려는 전화번호 선택
		 *  선택한 전화번호 삭제
		 * 4. 전화번호 조회
		 *  이름을 입력
		 *  이름이 포함된 전화번호 출력
		 * 
		 */

		list.set(0, new Phone("홍길동", "000-0000-0000"));
		int menu = 0;
		do {
			printMenu("전화번호 추가", "전화번호 수정", "전화번호 삭제", "전화번호 조회", "종료");
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
			System.out.println("전화번호 추가");
			//insAd();
			break;
		case 2 :
			System.out.println("전화번호 수정");
			//modAd();
			break;
		case 3 :
			System.out.println("전화번호 삭제");
			//delAd();
			break;
		case 4 : 
			System.out.println("전화번호 조회");
			srcAd();
			break;

		}
		return;
	}

	private static void srcAd() {
		//단어 입력
		System.out.print("검색할 이름 : ");
		String search = scan.nextLine();
		int count = 0;
		//단어장에 있는 단어가 검색 단어를 포함하고 있으면 출력
		for(Phone tmp : list) {
			if(tmp.getName().contains(search)) {
				System.out.println(tmp);
				count++;
			}
		}
		if (count == 0) System.out.println("일치하는 번호가 없습니다.");
	}

}





@Data
@AllArgsConstructor
class Phone{
	private String name, phNum;

	@Override //해시는 필요없음
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Phone other = (Phone) obj;
		return Objects.equals(name, other.name);
	}
	
	@Override
	public String toString() {
		return name + " : " + phNum;
	}
}


