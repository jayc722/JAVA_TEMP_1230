package day008;

import java.util.Scanner;

public class Ex01_AccountBook {
	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		// 가계부
		
		/* 가계부에 필요한 클래스 선언
		 * 메뉴
		 * 1. 가계부 등록
		 * 2. 가계부 수정
		 * 3. 가계부 삭제
		 * 4. 가계부 조회
		 * 5. 종료
		 * 메뉴 선택 : 1
		 * ---------------
		 * 수입 / 지출 : 수입
		 * 분류 : 월급
		 * 내용 : 1월 월급
		 * 금액 : 10000000
		 * 일시 : 2025-01-08
		 * ----------------
		 * 가계부 등록이 완료됐습니다.
		 * ---------------- 
		 * 메뉴
		 * 1. 가계부 등록
		 * 2. 가계부 수정
		 * 3. 가계부 삭제
		 * 4. 가계부 조회
		 * 5. 종료
		 * 메뉴 선택 : 2
		 * ---------------
		 * 1. 수입/월급/1월 월급/10000000/2025-01-08
		 * 수정할 내역을 선택하세요. : 1
		 * 금액 : 20000000
		 * ---------------
		 * 수정이 완료됐습니다.
		 * ---------------
		 * 메뉴 선택 : 3
		 * ---------------
		 * 1. 수입/월급/1월 월급/10000000/2025-01-08
		 * 삭제할 내역을 선택하세요. : 1
		 * ---------------
		 * 삭제가 완료됐습니다.
		 * ---------------
		 * 
		 * 
		 */


		char menu;
		int count = 0;
		Item [] list = new Item[10];
		list[count++] = new Item("수입", "월급", "1월 월급", 10000000, "2025-01-08");
		do {
			menu = 0;
			//System.out.println("메뉴");
			//printMenu("가계부 등록", "가계부 수정", "가계부 삭제", "가계부 조회", "종료");
			printMenu();
			menu = scan.next().charAt(0);
			count = runmenu(menu, list, count);
			list = expand(list, count);

		}while(menu != '5');





	}

	private static Item[] expand(Item[] list, int count) {
		if(list == null) return new Item[10];
		if(count < list.length) return list;
		Item tmp[] = new Item[list.length+5];
		System.arraycopy(list, 0, tmp, 0, list.length);
		return tmp;
	}

	private static int runmenu(int menu, Item[] list, int count) {
		switch(menu) {
		case '1' :
			printBar('-',15);
			System.out.println("1. 가계부 등록");
			printBar('-',15);
			count = addAB(list, count);
			break;
		case '2' :
			printBar('-',15);
			System.out.println("2. 가계부 수정");
			printBar('-',15);
			modAB(list, count);
			break;
		case '3' :
			printBar('-',15);
			System.out.println("3. 가계부 삭제");
			printBar('-',15);
			count=delAB(list,count);
			break;
		case '4' :
			printBar('-',15);
			System.out.println("4. 가계부 조회");
			printBar('-',15);
			avgAB(list, count);
			break;
		case '5' :
			printBar('-',15);
			System.out.println("종료합니다.");
			printBar('-',15);
			break;
		default :
			System.out.println("잘못된 입력입니다.");
			break;
		}
		return count;

	}
	
	
	private static void avgAB(Item[] list, int count) {
		if (viewAB(list, count)) return;
		int sum = 0;
		for(int i = 0; i < count; i++) {
			if(list[i].getIncome().equals("수입")) sum += list[i].getMoney();
			else sum -= list[i].getMoney();
		}
		System.out.println("합계 : " + sum);
		
		
	}

	private static int delAB(Item[] list, int count) {
		
		if (viewAB(list, count)) return count;
		int input = -1;
		do {
			System.out.print("삭제할 번호 입력(0입력시 되돌아가기) : ");
			input = scan.nextInt()-1;
			if(input>=0&&input<count) {
				System.out.print("삭제할 내역 : ");
				list[input].print();
				count--;
				break;
			}else if(input == -1)return count; 
			else System.out.println("해당하는 번호 선택");
		}while(true);

		for(int i = input; i < count; i++) {
			list[input] = list[input + 1];
		}

		return count;
	}

	private static void modAB(Item[] list, int count) {
		if (viewAB(list, count)) return;
		int input = -1;
		do {
			System.out.print("수정할 번호 입력(0입력 시 되돌아가기) : ");
			input = scan.nextInt()-1;
			if(input>=0&&input<count) {
				list[input].print();
				break;
			}else if(input == -1)return;
			else System.out.println("해당하는 번호 선택");
		}while(true);
		if(input<0||input>count)return;					
		String income = list[input].getIncome();					//게터나 세터중에 하나는 써야될거같음...
		String type = list[input].getType();
		String content = list[input].getContent();
		int money = list[input].getMoney();
		String date = list[input].getDate();
		System.out.println("수입/지출 : " + income + " / 분류 : " + type + " / 내용 : " + content + " / 금액 : " + money + " / 일시 : " + date);
		//게터 쓰면 이거 표시하기 좋은듯
		do {
		System.out.println("수정할 내역 선택 수입/지출(1) 분류(2) 내용(3) 금액(4) 일시(5) 돌아가기(그 외)");
		char mod = scan.next().charAt(0);
		switch(mod) {
		case '1' :
			System.out.print("수입/지출 : ");
			income = scan.next();					//list[input].setIncome(scan.next());로 코드 줄일수있을거같긴한데
													//income부터 date 변수 안써도 됨...
			break;
		case '2' :
			System.out.print("분류 : ");
			type = scan.next();

			break;
		case '3' : 
			System.out.print("내용 : ");
			scan.nextLine();//엔터 처리
			content = scan.nextLine();

			break;
		case '4' :
			System.out.print("금액 : ");
			money = scan.nextInt();

			break;
		case '5' :
			System.out.print("일시 : ");
			date = scan.next();
			break;
		default :
			System.out.println("메뉴 화면으로 돌아갑니다.");
			return;

		}
		list[input] = new Item(income, type, content, money, date);
		System.out.println("수정 되었습니다.");
		list[input].print();
		}while(true);
	}

	private static int addAB(Item[] list, int count) {
		//내역 정보 입력
		String income;
		do {
		System.out.print("수입/지출 : ");
		income = scan.next();
		}while(!(income.equals("수입")|income.equals("지출")));
		System.out.print("분류 : ");
		String type = scan.next();
		System.out.print("내용 : ");
		scan.nextLine();//엔터 처리
		String content = scan.nextLine();
		System.out.print("금액 : ");
		int money = scan.nextInt();
		System.out.print("일시 : ");
		String date = scan.next();

		//내역 리스트에 추가
		list[count] = new Item(income, type, content, money, date);

		list[count].print();
		return ++count;
	}

	private static boolean viewAB(Item[] list, int count) {
		if(count == 0 || list == null) {
			System.out.println("등록한 내역이 없습니다.");
		return true;	
		}
		for(int i = 0; i < count; i++) list[i].print(i); 
		return false;
	}
/*
	private static void printMenu(String ... menus) {				//임의 항목 수 메뉴 생성 함수
		printBar('-', 15);
		if(menus.length == 0) {
			System.out.println("nothing");
			return;
		}
		for(int i = 0; i < menus.length; i++) {
			String menu = menus[i];
			System.out.println(i + 1 + "." + menu);
		}
		printBar('-',15);

	}
*/
	private static void printMenu() {
		System.out.print(	"---------------- \r\n"
				+ "메뉴\r\n"
				+ "1. 가계부 등록\r\n"
				+ "2. 가계부 수정\r\n"
				+ "3. 가계부 삭제\r\n"
				+ "4. 가계부 조회\r\n"
				+ "5. 종료\r\n"
				+ "메뉴 선택 : "			);

	}
	public static void printBar(char bar, int count) {
		for(int i = 0; i < count; i++)System.out.print(bar);
		System.out.println();
	}
	/*												//만들고보니 viewAB
	public static void printItems(Item[] list, int count) {
		if(count == 0 || list == null) {
			System.out.println("nothing");
			return;
		}
		for(int i = 0; i < count; i++)list[i].print(i+1);
	}
	 */

	public static boolean checkIndex(int index, int count) {				// index 확인
		return (index >= 0 && index < count);				//if 어쩌구보다 훨씬 직관적
	}
/*
	public static void updateItemList(Item[] list, int count) {
		if(viewAB(list, count))return;

		System.out.println("수정");
		int index = scan.nextInt()-1;

		if(!checkIndex(index, count)) {
			System.out.println("wrong number");
			return;
		}
}
	*/	
/*
	private static void deleteItem(Item[] list, int count, int index) {				//list 의 index 번 항목 삭제
		
	}
*/
}

class Item {
	//필드
	private String income, type, content, date;				//수입지출 분류 내용
	private int money;				//금액 연도 월 일




	//메소드
	public void print() {
		//1. 수입/월급/1월 월급/10000000/2025-01-08
		System.out.println(income + "/" + type + "/" + content + "/" + money + "/" + date);
	}

	public void print(int num) {
		System.out.print(num + 1 + ". ");
		print();
	}

	//////게터세터//////////////////////////////////////////////////////////////////
	public String getIncome() {
		return income;
	}
	public void setIncome(String income) {
		this.income = income;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	//////////////////////////////////////////////////////////////////////////////////////////////
	//생성자

	public Item(String income, String type, String content, int money, String date) {
		super();
		this.income = income;
		this.type = type;
		this.content = content;
		this.date = date;
		this.money = money;
	}



	@Override
	public String toString() {
		return "income + \"/\" + type + \"/\" + content + \"/\" + money + \"/\" + date";
	}






}
