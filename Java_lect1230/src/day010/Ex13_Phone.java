package day010;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.regex.Pattern;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

public class Ex13_Phone {

	static Scanner scan = new Scanner(System.in);
	static ArrayList<Phone>list = new ArrayList<Phone>();

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
		list.add(new Phone("홍길동", "000-0000-0000"));
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
			insAd();
			break;
		case 2 :
			System.out.println("전화번호 수정");
			modAd();
			break;
		case 3 :
			System.out.println("전화번호 삭제");
			delAd();
			break;
		case 4 : 
			System.out.println("전화번호 조회");
			srcAd();
			break;

		}
		return;
	}

	private static void delAd() {
		System.out.print("삭제할 이름 입력 : ");
		String name = scan.nextLine();
		List <Phone> matches = new ArrayList<>();
		/* 강사님
	      ArrayList<Phone> tmpList = searchPhoneNumberList(name);
	       if(!printPhoneNumberList(tmpList, true) return;
	      for(int i = 0; i < tmpList.size(); i++)System.out.println((i+1) + ". " + tmpList.get(i));
	      System.out.print("삭제할 번호 선택 : ");
	      int index = scan.nextInt() - 1;
	      Phone pn = tmpList.get(index);			//equals 오버라이딩 제외해서 tmpList 실제있는애를 가져옴
	      list.remove(pn)				//Objects.equals() 호출 ->같은 객체이면 Object.equals(오버라이딩 있으면 오버라이딩 우선)
	      								//equlas 오버라이딩 안해야 정상작동
	      System.out.println("삭제되었습니다.");

		 */
		for (Phone tmp : list) if(tmp.getName().equals(name))matches.add(tmp);
		if(matches.isEmpty()) {
			System.out.println("해당하는 항복이 없습니다.");
			return;
		}

		System.out.println("삭제할 항목");
		for(int i = 0; i < matches.size(); i++)System.out.println((i+1) + ". " + matches.get(i));

		System.out.print("선택 : ");
		int num = scan.nextInt();
		scan.nextLine();
		if(num<1||num>matches.size()) {
			System.out.println("해당하는 항복이 없습니다.");
			return;
		}
		list.remove(matches.get(num-1));
		System.out.println("삭제되었습니다.");

	}
	/*
	   private static ArrayList<Phone> searchPhoneNumberList(String name) {
	   ArrayList<Phone> tmpList = searchPhoneNumberList(name);
	   for(Phone pn : list) if(pn.getName().contains(name))tmpList.add(pn);
		return tmpList;
	}
	 */
	
	
	private static void modAd() {
		System.out.print("수정할 이름 입력 : ");
		String name = scan.nextLine();
		List <Phone> matches = new ArrayList<>();

		/* 강사님
	      ArrayList<Phone> tmpList = searchPhoneNumberList(name);
	      if(!printPhoneNumberList(tmpList, true) return;
	      for(int i = 0; i < tmpList.size(); i++)System.out.println((i+1) + ". " + tmpList.get(i));
	      System.out.print("수정할 번호 선택 : ");
	      int index = scan.nextInt() - 1;
	      Phone pn = tmpList.get(index);			//equals 오버라이딩 제외해서 tmpList 실제있는애를 가져옴

		  System.out.println("이름 : ");
	      String newName = scan.nextLine();
		  System.out.print("바꿀 전화번호 입력 : ");
	      String newNum = scan.nextLine();
	      pn.update(newName, newNum);
	      System.out.println("수정되었습니다.");

		 */


		for (Phone tmp : list) if(tmp.getName().equals(name))matches.add(tmp);
		if(matches.isEmpty()) {
			System.out.println("해당하는 항복이 없습니다.");
			return;
		}

		System.out.println("수정할 항목");
		for(int i = 0; i < matches.size(); i++)System.out.println((i+1) + ". " + matches.get(i));

		System.out.print("선택 : ");
		int num = scan.nextInt();
		scan.nextLine();
		if(num<1||num>matches.size()) {
			System.out.println("해당하는 항복이 없습니다.");
			return;
		}

		System.out.print("바꿀 전화번호 입력 : ");
		String newNum = scan.nextLine();
		matches.get(num - 1).setPhNum(newNum);
		System.out.println("수정되었습니다.");

	}




	private static void insAd() {
		System.out.print("이름 : ");
		String name = scan.nextLine();

		System.out.print("전화번호 : ");
		String phNum = scan.nextLine();
		//정규표현식 체크 : 000-0000-0000 ->regix101
		String regex = "^\\d{2,3}(-?\\d{4}){2}$";
		if(!Pattern.matches(regex, phNum)) {
			System.out.println("올바른 전화번호가 아닙니다.");
			return;
		}
		list.add(new Phone(name, phNum));
		System.out.println("전화번호 추가");

	}




	private static void srcAd() {
		System.out.println(list);
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
		/*
		ArrayList<Phone> pList = searchPhoneNumberList(search);
		printPhoneNumberList(pList, false);
		
		 
		 
		
		*/
		 
		
		
	}

	private static boolean printPhoneNumberList(ArrayList<Phone> pList, boolean isNumber) {
		if(pList == null || pList.size() == 0) {
			System.out.println("결과가 없습니다.");
			return false;
		}
		for(int i = 0; i < pList.size(); i++) {
			if(isNumber)System.out.println((i+1) + ". ");
			System.out.println(pList.get(i));
		}
		return true;
		//중복되는 코드 여러번 재사용 가능
		
	}
	
	
}





@Getter
@Setter					// -> equals 가 자동 오버로딩 되기 때문(중복 불필요)
@AllArgsConstructor		
class Phone{
	private String name, phNum;//순서 중요 ->이순서대로 생성자 만들어짐

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
	/*
	public void update(String newName, String PhNum) {
		this.name = newName;
		this.phNum = phNum;
	}
	 */

}


