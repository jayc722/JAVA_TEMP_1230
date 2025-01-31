package selfstudy.day020;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;


		/* 쇼핑몰 구현
		 * -제품 관리
		 * 	-관리자가 관리
		 * 	-관리자는 admin/admin 고정
		 * 	-제품 추가, 수정, 삭제, 제품 입고
		 * 		-제품 추가
		 * 			-제품 코드(6자리. ABC001), 분류, 제품명, 옵션, 가격을 등록
		 * 			-ABC001, 문구, 볼펜, 빨강, 1000
		 * 			-DEF001, 의류, 셔츠, XL, 30000 
		 * 			-XYZ001, 식품, 우유 1L, 딸기, 2000
		 * 			-XYZ002, 식품, 딸기우유, 1L, 2000 
		 * 			-XYZ003, 식품, 딸기우유, 2L, 3000
		 * 			-분류는 문구 의류 식품 가전 기타로 고정
		 * 			-각 분류마다 분류코드가 지정
		 * 				-문구 : ABC, 의류 : DEF, 식품 : XYZ, 가전 : ELC, 기타 : ETC
		 * 			-제품 코드는 분류 코드에 등록된 순서 3자리를 만들어서 총 6자리로 고정
		 * -제품 입고
		 * 	-제품 코드, 수량을 입력해서 제품을 입고(제품이 있어야 구매 가능)
		 * -제품 구매
		 * 	-등록된 제품을 선택해서 구매
		 * 	-로그인한 사용자가 제품을 구매할 수 있음
		 * 	-로그인 하지 않으면 제품 조회 및 구매x
		 * 	-수량이 있는 제품만 구매 가능(남은 수량보다 큰 수 입력 시 구매x)
		 * 	-제품 코드와 수량을 선택해서 구매
		 * 	-결제 과정은 없음(생략)
		 * -제품 조회
		 * 	-분류를 이용하여 주회
		 * 		-문구 의류 식품 가전 기타 전체
		 * 	-제품 코드, 제품명, 옵션, 수량, 가격 조회
		 * -회원가입
		 * 	-아이디, 비번, 비번확인은 입력해서 회원가입
		 * -로그인
		 * 	-아이디, 비번을 입력하여 회원이면 제품 조회로, 아니면 메인으로 돌아감
		 * 	-관리자이면 관리자 메뉴로 이동
		 */
		
		/* 메인 메뉴
		 * 1. 로그인
		 * 2. 회원 가입
		 * 3. 종료
		 * 
		 * 
		 * 관리자 메뉴(로그인 시 관리자인 경우)
		 * 1. 제품 등록 
		 * 2. 제품 수정
		 * 3. 제품 삭제
		 * 4. 제품 입고
		 * 5. 로그아웃
		 * 
		 * 
		 * 사용자 메뉴(로그인 시 사용자인 경우)
		 * 1. 제품 조회
		 * 2. 로그 아웃
		 * 
		 * 제품 조회 메뉴
		 * 1. 문구 조회
		 * 2. 의류 조회
		 * 3. 식품 조회
		 * 4. 가전 조회
		 * 5. 기타 조회
		 * 6. 전체 조회
		 * 7. 이전으로
		 * 
		 * 제품 상세 
		 * 제품 정보를 출력
		 * 1. 제품 구매
		 * 2. 이전으로
		 * 
		 */
public class Ex01_Client {
	
	
	static Scanner scan = new Scanner(System.in);
	static List<Product> list = new ArrayList<Product>();
	static List<Id> idList = new ArrayList<Id>();
 	static final String admin = "admin";
	
	public static void main(String[] args) {
		
		
		idList.add(new Id(admin, admin, true));
		
		int menu = 0;
		do {
			
			printMenu();
			menu = scan.nextInt();
			scan.nextLine();
			runMenu(menu);
			
			
			
		}while(menu != 3 );
		
		

	}
	private static void runMenu(int menu) {
		switch (menu) {
		case 1 :
			System.out.println("로그인");
			login();
			break;
			
		case 2 :
			System.out.println("회원가입");
			signUp();
			break;
			
		case 3 :
			break;
		default :
			System.out.println("올바른 메뉴 입력");
			break;

		}

	}
	private static void login() {
		Id tmpAccount = new Id("", "", false); 
		System.out.print("아이디 입력 : ");
		String tmpId = scan.nextLine();
		tmpAccount.setId(tmpId); 
		System.out.print("패스워드 입력 : ");
		String tmpPw = scan.nextLine();
		tmpAccount.setPassword(tmpPw);

		int result = idList.indexOf(tmpAccount);
		if (result<0) {
			System.out.println("없는 회원이거나 잘못된 패스워드 입력"); 
			return;
		}
		if (idList.get(result).getAthority() && idList.get(result).getPassword().equals(tmpPw)) {
			adminMenu();
			return;
		}
		if(result>0 && idList.get(result).getPassword().equals(tmpPw)) {
			userMenu(idList.get(result));
			return;
		}
		System.out.println("없는 회원이거나 잘못된 패스워드 입력"); 

	}
	private static void userMenu(Id id) {
		System.out.println("유저 메뉴");
		int usMenu = 0;
		do {
		printUserMenu();
		usMenu = scan.nextInt();
		scan.nextLine();
		runUserMenu(usMenu);
		
		}while(usMenu != 2);
		System.out.println("로그아웃");
	}
	private static void runUserMenu(int usMenu) {
		System.out.println("-------------------------");
		switch(usMenu) {
		case 1 :
			viewProductMenu();
			break;

		case 2 :

			System.out.println("[이전으로 돌아갑니다.]");
			break;

		default :
			System.out.println("[잘못된 메뉴입니다.]");
		}
		System.out.println("-------------------------");
		
	}
	private static void viewProductMenu() {
		System.out.println("제품 조회 메뉴");
		int menu = 0;
		do {
		printViewProductMenu();
		menu = scan.nextInt();
		scan.nextLine();
		runViewProductMenu(menu);
		
		}while(menu != 7);
		System.out.println("이전으로");
	
		
	}
	private static void runViewProductMenu(int menu) {
		switch (menu) {
		case 1,2,3,4,5 : 
			check(menu, true);
			break;

		case 6 :
			check(true);	// 메소드 오버로딩
			break;
			
		case 7 :
			System.out.println("[이전으로 돌아갑니다.]");
			break;
			
		default : 
			System.out.println("올바른 메뉴 선택");
			break;
		}
		
	}
	private static void check(boolean a) {
		for(Product pdt : list) {
			System.out.println(pdt.toString());
		}
		
		if(!a) return;
		
		int ckDtMenu = 0;
		
		do {
		printCheckDetailMenu();
		
		ckDtMenu = scan.nextInt();
		scan.nextLine();
		runCheckDetailMenu(ckDtMenu);
		
		}while(ckDtMenu != 2);
	}
	private static void check(int menu,boolean a) {
		for(Product pdt : list) {
			if(pdt.getCodeInput()==menu) {
			System.out.println(pdt.toString());
			}
		}
		
		if(!a) return;
		
		int ckDtMenu = 0;
		do {
		printCheckDetailMenu();
		ckDtMenu = scan.nextInt();
		scan.nextLine();
		runCheckDetailMenu(ckDtMenu);
		
		}while(ckDtMenu != 2);

	}
	
	private static void runCheckDetailMenu(int ckDtMenu) {
		switch (ckDtMenu) {
		case 1 :
			if(purchase())System.out.println("구매 성공");
			break;

		case 2 :
			System.out.println("[이전으로 돌아갑니다.]");
			break;
			
		default : 
			System.out.println("올바른 메뉴 선택");
 			break;
		}
		
		
	}
	private static boolean purchase() {
		System.out.print("구매할 제품의 코드 번호 입력 : ");
		String code = scan.nextLine();
		
		Product tmpCode = new Product(code);
		int index = list.indexOf(tmpCode);
		
		if(index<0) {
			System.out.println("존재하지 않는 코드입니다.");
			return false;
		}
		
		System.out.println(list.get(index).toString());
		
		System.out.print("구매 수량 입력 : ");
		
		int num = scan.nextInt();
		
		if(num>list.get(index).getAmount()) {
			System.out.println("재고보다 많습니다.");
			return false;
		}
		
		if(num <=0) {
			System.out.println("정상적인 접근이 아닙니다.");
			return false;
		}
		
		System.out.println(list.get(index).getName() + " " + num + "개 구매합니다.");
		int priceNum = list.get(index).getPrice() * num;
		System.out.println(priceNum + " 원입니다.");
		
		
		list.get(index).setAmount(list.get(index).getAmount() - num);
		
		
		
		return true;
	}
	private static void printCheckDetailMenu() {
		System.out.println("-------------------------");
		System.out.println("1. 제품 구매");
		System.out.println("2. 이전으로");
		System.out.println("-------------------------");
		System.out.print("번호 입력 : ");
		
	}
	private static void printViewProductMenu() {
		System.out.println("-------------------------");
		System.out.println("1. 문구 조회");
		System.out.println("2. 의류 조회");
		System.out.println("3. 식품 조회");
		System.out.println("4. 가전 조회");
		System.out.println("5. 기타 조회");
		System.out.println("6. 전체 조회");
		System.out.println("7. 이전으로");
		System.out.println("-------------------------");
		System.out.print("번호 입력 : ");
		
		
	}
	private static void printUserMenu() {
		System.out.println("-------------------------");
		System.out.println("1. 제품 조회");
		System.out.println("2. 로그 아웃");
		System.out.println("-------------------------");
		System.out.print("번호 입력 : ");
		
		
	}
	private static void adminMenu() {
		System.out.println("어드민 메뉴");
		int adMenu = 0;
		do {
		printAdminMenu();
		adMenu = scan.nextInt();
		scan.nextLine();
		runAdminMenu(adMenu);
		
		}while(adMenu != 5);
		System.out.println("로그아웃");
	}
	private static void runAdminMenu(int adMenu) {
		switch (adMenu) {
		case 1 : 
			addProduct();
			break;
			
		case 2 : 
			updProduct();
			break;
			
		case 3 :
			delProduct();
			break;
			
		case 4 : 
			plusProduct();
			break;
			
		case 5 : break;
		default : 
			System.out.println("올바른 메뉴 선택");
			break;
		}
	}
	private static void plusProduct() {
		
		System.out.println("제품 입고 메뉴");
		
		printViewProductMenu();
		int menu = scan.nextInt();
		scan.nextLine();
		switch (menu) {
		case 1,2,3,4,5 : 
			check(menu, false);
			break;
		case 7 :
			return;
		case 6 :
		default :
			check(false);	// 메소드 오버로딩
			break;
		}
		System.out.println("입고할 제품의 코드 입력");
		String code = scan.nextLine();
		
		int index = list.indexOf(new Product(code));
		
		if(index<0) {
			System.out.println("올바른 코드가 아닙니다.");
			return;
		}
		
		System.out.println(list.get(index).toString());
		
		System.out.print("추가할 수량 입력 : ");
		
		int amount = scan.nextInt();
		scan.nextLine();
		
		list.get(index).setAmount(list.get(index).getAmount() + amount);
		
		System.out.println(list.get(index).toString());
		
		
		
	}
		
	
	private static void delProduct() {
		System.out.println("제품 삭제 메뉴");
		
		printViewProductMenu();
		int menu = scan.nextInt();
		scan.nextLine();
		switch (menu) {
		case 1,2,3,4,5 : 
			check(menu, false);
			break;
		case 7 :
			return;
		case 6 :
		default :
			check(false);	// 메소드 오버로딩
			break;
		}
		System.out.println("삭제할 제품의 코드 입력");
		String code = scan.nextLine();
		
		int index = list.indexOf(new Product(code));
		
		if(index<0) {
			System.out.println("올바른 코드가 아닙니다.");
			return;
		}
		
		System.out.println(list.get(index).toString());
		
		System.out.print("삭제하려면 '삭제' 입력 : ");
		
		if(!scan.nextLine().equals("삭제"))return;
		
		list.remove(index);
		
		System.out.println("삭제되었습니다.");
		
		
		
	}
	private static void updProduct() {
		System.out.println("제품 수정 메뉴");
		
		printViewProductMenu();
		int menu = scan.nextInt();
		scan.nextLine();
		switch (menu) {
		case 1,2,3,4,5 : 
			check(menu, false);
			break;
		case 7 :
			return;
		case 6 :
		default :
			check(false);	// 메소드 오버로딩
			break;
		}
		System.out.println("수정할 제품의 코드 입력");
		String code = scan.nextLine();
		
		int index = list.indexOf(new Product(code));
		
		if(index<0) {
			System.out.println("올바른 코드가 아닙니다.");
			return;
		}
		
		System.out.println(list.get(index).toString());
		
		
		printModMenu();
		int modMenu = scan.nextInt();
		scan.nextLine();
		
		if(modMenu == 1) {
		System.out.print("수정할 코드번호(세자리) : ");
		int codeNum = scan.nextInt();
		scan.nextLine();
		if(codeNum<0||codeNum>999) {
			System.out.println("잘못된 입력입니다");
			return;
		}
		Product tmpPdt = new Product(list.get(index).getSbj(), codeNum);
		if(list.contains(tmpPdt)) {
			System.out.println("이미 존재하는 코드입니다.");
			return;
		}
		list.get(index).setCode(tmpPdt.getCode());
		
		}
		if(modMenu == 2) {
			System.out.print("수정할 분류명 : ");
			String subject = scan.nextLine();
			if(!ProductNum.check(subject)) {
				System.out.println("잘못된 분류입니다.");
				return;
			}
			System.out.print("코드번호(세자리) : ");
			int codeNum = scan.nextInt();
			scan.nextLine();
			if(codeNum<0||codeNum>999) {
				System.out.println("잘못된 입력입니다");
				return;
			}
			Product tmpPdt = new Product(ProductNum.valueOf(subject), codeNum);
			if(list.contains(tmpPdt)) {
				System.out.println("이미 존재하는 코드입니다.");
				return;
			}
			list.get(index).setSbj(ProductNum.valueOf(subject));
			list.get(index).setCode(tmpPdt.getCode());
			
		}
		if(modMenu == 3) {
			System.out.print("수정할 제품명 : ");
			String name = scan.nextLine();
			
			list.get(index).setName(name);
		}
		if(modMenu == 4) {
			System.out.print("수정할 옵션 설명 : ");
			String option = scan.nextLine();
			
			list.get(index).setOpt(option);
		}
		if(modMenu == 5) {
			System.out.print("수정할 가격 : ");
			int price = scan.nextInt();
			
			list.get(index).setPrice(price);
		}
		System.out.println("이전으로 돌아갑니다.");
		return;
		
		
	}
	private static void printModMenu() {
		System.out.println("-------------------------");
		System.out.println("1. 코드 수정");
		System.out.println("2. 분류 수정");
		System.out.println("3. 재품명 수정");
		System.out.println("4. 옵션 수정");
		System.out.println("5. 가격 수정");
		System.out.println("6. 이전으로");
		System.out.println("-------------------------");
		System.out.print("번호 입력 : ");
		
	}
	private static void addProduct() {
		
		System.out.println("제품 추가");
		
		System.out.print("분류 : ");
		String subject = scan.nextLine();
		if(!ProductNum.check(subject)) {
			System.out.println("잘못된 분류입니다.");
			return;
		}
		System.out.print("코드번호(세자리) : ");
		int code = scan.nextInt();
		scan.nextLine();
		if(code<0||code>999) {
			System.out.println("잘못된 입력입니다");
			return;
		}
		Product tmpPdt = new Product(ProductNum.valueOf(subject), code);
		if(list.contains(tmpPdt)) {
			System.out.println("이미 존재하는 코드입니다.");
			return;
		}
		
		System.out.print("품명 : ");
		String name = scan.nextLine();
		tmpPdt.setName(name);
		System.out.print("옵션 : ");
		String option = scan.nextLine();
		tmpPdt.setOpt(option);
		System.out.print("가격 : ");
		int price = scan.nextInt();
		scan.nextLine();
		tmpPdt.setPrice(price);
		
		System.out.println(tmpPdt);
		
		list.add(tmpPdt);
		
		
		
	}
	private static void printAdminMenu() {
		System.out.println("-------------------------");
		System.out.println("1. 제품 등록");
		System.out.println("2. 제품 수정");
		System.out.println("3. 제품 삭제");
		System.out.println("4. 제품 입고");
		System.out.println("5. 로그 아웃");
		System.out.println("-------------------------");
		System.out.print("번호 입력 : ");
		
	}
	private static void signUp() {
		
		Id tmpAccount = new Id("", "", false); 
		while(true) {
		System.out.print("아이디 입력 : ");
		String tmpId = scan.nextLine();
		tmpAccount.setId(tmpId); 
		if(tmpId.length()<8 || idList.contains(tmpAccount)) {
			System.out.println("아이디가 8자리 미만이거나 중복되는 아이디가 있습니다.");
			continue;
		}
		break;
		}
		while(true) {
			System.out.print("패스워드 입력 : ");
			String tmpPw = scan.nextLine();
			if(tmpPw.length()<8) {
				System.out.println("패스워드는 8자리 이상으로 해 주세요.");
				continue;
			}
			tmpAccount.setPassword(tmpPw); 
			break;
		}
		idList.add(tmpAccount);
		System.out.println("회원가입 완료");
		return;
	}
	private static void printMenu() {
		System.out.println("-------------------------");
		System.out.println("1. 로그인");
		System.out.println("2. 회원가입");
		System.out.println("3. 종료");
		System.out.println("-------------------------");
		System.out.print("번호 입력 : ");
		
	}

	
	
	
	
}

