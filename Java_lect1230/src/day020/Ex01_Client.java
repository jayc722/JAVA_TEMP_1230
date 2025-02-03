package day020;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ex01_Client {


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
		 * 
		 * 제품 상세 
		 * 제품 정보를 출력
		 * 1. 제품 구매
		 * 2. 이전으로
		 * 
		 */
		
	private static List<Product> list = new ArrayList<Product>();
	private static List<Member> members = new ArrayList<Member>();
	private static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		//List<Product1> list = new ArrayList<Product1>();
		//list.add(new StationeryProduct();)
		//list.add(new ClothingProduct();)
		//->다형성 활용해서 리스트 하나로 여러 분류 관리 가능

		
		//관리자 샘플데이터
		members.add(new Member("admin", "admin", "관리자"));
		
		int menu = 0;
		do {
			
			printMainMenu();
			menu = scan.nextInt();
			scan.nextLine();
			runMainMenu(menu);
			
			
			
		}while(menu != 3 );
		
		
	}

	private static void printMainMenu() {
		System.out.println("-------------------------");
		System.out.println("1. 로그인");
		System.out.println("2. 회원가입");
		System.out.println("3. 종료");
		System.out.println("-------------------------");
		System.out.print("번호 입력 : ");
		
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

	private static void printUserMenu() {
		System.out.println("-------------------------");
		System.out.println("1. 제품 조회");
		System.out.println("2. 로그 아웃");
		System.out.println("-------------------------");
		System.out.print("번호 입력 : ");
		
	}

	private static void runMainMenu(int menu) {
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
			System.out.println("잘못된 메뉴입니다.");
			break;
		
		}
		
	}

	private static void runAdmin() {
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

	private static void runUser(Member user) {
		System.out.println("유저 메뉴");
		int usMenu = 0;
		do {
		printUserMenu();
		usMenu = scan.nextInt();
		scan.nextLine();
		runUserMenu(usMenu, user);

		}while(usMenu != 2);
		System.out.println("로그아웃");

	}

	private static void runAdminMenu(int adMenu) {
		switch (adMenu) {
		case 1 : 
			insertProduct();
			break;
			
		case 2 : 
			updProduct();
			break;
			
		case 3 :
			delProduct();
			break;
			
		case 4 : 
			storeProduct();
			break;
			
		case 5 : 
			System.out.println("이전으로 돌아갑니다");
			break;
		default : 
			System.out.println("잘못된 메뉴입니다.");
			break;
		}

	}

	private static void storeProduct() {
		// 제품 코드 입력
		System.out.print("제품 코드 : ");
		String code = scan.next();
		scan.nextLine();



		//일치하는 제품이 없으면 알림 후 종료
		int index = list.indexOf(new Product(code, "", "", "", 0));
		if(index<0) {
			System.out.println("일치하는 제품이 없습니다.");
			return;
		}
		//제품 수량을 입력
		System.out.print("수량 : ");
		int amount = scan.nextInt();
		scan.nextLine();
		
		Product product = list.get(index);
		product.store(amount);
		
		//제품 수량을 변경 후 알림
		
	}

	private static void delProduct() {
		// 제품 코드 입력
		System.out.print("제품 코드 : ");
		String code = scan.next();
		scan.nextLine();

		if(list.remove(new Product(code, "", "", "", 0))) {
			System.out.println("[제품을 삭제했습니다.]");
		}else {
			System.out.println("[일치하는 제품이 없습니다.]");
		}

	}

	private static void updProduct() {
		// 제품 코드 입력
		System.out.print("제품 코드 : ");
		String code = scan.next();
		scan.nextLine();



		//일치하는 제품이 없으면 알림 후 종료
		int index = list.indexOf(new Product(code, "", "", "", 0));
		if(index<0) {
			System.out.println("일치하는 제품이 없습니다.");
			return;
		}

		// 수정할 정보를 입력(제품명, 옵션, 가격)
		System.out.print("제품명 : ");
		String name = scan.nextLine();

		System.out.print("옵션 : ");
		String option = scan.nextLine();
		
		System.out.print("가격 : ");
		int price = scan.nextInt();
		scan.nextLine();
		//수정 후 알림 출력
		Product product = list.get(index);
		product.update(name,option, price);
		
		System.out.println("[제품을 수정했습니다.]");
		
	}

	private static void insertProduct() {
		// 제품 정보 입력
		System.out.print("분류 : ");
		String category = scan.next();
		scan.nextLine();
		
		System.out.print("제품명 : ");
		String name = scan.nextLine();
		
		System.out.print("옵션 : ");
		String option = scan.nextLine();
		
		System.out.print("가격 : ");
		int price = scan.nextInt();
		scan.nextLine();
		
		
		// 제품 정보로 객체 생성
		
		String codePrefix = Product.getCodePrefix(category);
		int count = getLastNum(list, codePrefix);
		Product product = new Product(count, category, name, option, price);
		
		
		
		//제품 목록에 추가하고 알림
		list.add(product);
		System.out.println("[제품을 등록했습니다.]");
		System.out.println(list);
		
		
		
	}

	private static int getLastNum(List<Product> list2, String codePrefix) {
		if(list == null) return -1;
		
		int max = 0;
		
		for(Product product : list) {	//code는 ABC001 -> ABC prefix, 001 suffix
			String productCodePrefix = product.getCode().substring(0,3);	//3번지까지 추출
			String productCodesuffix = product.getCode().substring(3);		//3번지부터 추출
			
			if(productCodePrefix.equals(codePrefix)) {
				//문자 "001" => 1로 변환
				int num = Integer.parseInt(productCodesuffix);
				if(max < num) max =num; 
			}
		}
		return max;
	}

	private static void runUserMenu(int usMenu, Member user) {
		System.out.println("-------------------------");
		switch(usMenu) {
		case 1 :
			checkProduct(user);
			break;

		case 2 :

			System.out.println("[이전으로 돌아갑니다.]");
			break;

		default :
			System.out.println("[잘못된 메뉴입니다.]");
		}
		System.out.println("-------------------------");

	}

	private static void checkProduct(Member user) {
		System.out.println("[제품을 조회합니다.]");
		System.out.println("유저 메뉴");
		
		int ckMenu = 0;
		do {
		printCheckMenu();
		ckMenu = scan.nextInt();
		scan.nextLine();
		runCheckMenu(ckMenu, user);
		
		}while(ckMenu != 7);
	}
		
	private static void runCheckMenu(int ckMenu, Member user) {
		switch (ckMenu) {
		/*case 1,2,3,4,5 : 
			check(ckMenu, user);
			break;

		case 6 :
			check(user);	// 메소드 오버로딩
			break;
			*/
		
		case 1,2,3,4,5,6 : 
			check(ckMenu, user);
			break;
			
		case 7 :
			System.out.println("[이전으로 돌아갑니다.]");
			break;
			
		default : 
			System.out.println("올바른 메뉴 선택");
			break;
		}
		
	}

	private static void check(int categoryNum, Member user) {
	
		// 제품 목록 조회
		// 카테고리 번호룰 이용해서 카테고리를 가져옴
		String category = Product.getCategory(categoryNum);
		int count = 0;					//해당 카테고리 제품 없으면 빠져나오려고
		
		System.out.println("[" + category + " 제품]");
		count = printProductList(list, category);
		
		if(count == 0) {
			System.out.println("[일치하는 제품이 없습니다.]");
			return;
		}
		// 제품을 선택
		System.out.println("[조회하려는 제품 코드 입력]");
		System.out.println("제품 코드 : ");
		String code = scan.next();
		
		
		//선택된 제품을 출력(예외처리)
		if(!printProduct(list, code)) {
			System.out.println("[등록되지 않은 제품입니다.]");
			return;
		}
		
		
		int ckDtMenu = 0;
		do {
		printCheckDetailMenu();
		ckDtMenu = scan.nextInt();
		scan.nextLine();
		runCheckDetailMenu(ckDtMenu, user, code);
		
		}while(ckDtMenu != 2);
		
		
		//
		
	}

	private static boolean printProduct(List<Product> list, String code) {
		for(Product p : list) {
			if(p.getCode().equals(code)) {
				System.out.println(p);
				return true;
			}
		}
		return false;	//반복문이 끝날 때까지 같은 코드를 못 찾으면
	}

	private static int printProductList(List<Product> list, String category) {
		int count = 0;
		for(Product p : list) {
			if("전체".equals(category)) {
				System.out.println(p);	//카테고리가 전체라면 모두 출력
				count++;		//얘는 안해도 상관없긴함
			}
			else if(p.getCategory().equals(category)) {
				System.out.println(p);	//아니라면 카테고리가 카테고리인 애들을 출력
				count++;
			}
				
		}
		return count;
		
	}
	
/*
	private static void check(Member user) {
		
		String code = null;
		
		// 제품 목록 조회
		int ckDtMenu = 0;
		do {
		printCheckDetailMenu();
		ckDtMenu = scan.nextInt();
		scan.nextLine();
		runCheckDetailMenu(ckDtMenu, user, code);
		
		}while(ckDtMenu != 2);
		// 제품을 선택
		
		//선택된 제품을 출력(예외처리)
		
		//
		
	}
*/
	
	private static void runCheckDetailMenu(int ckDtMenu, Member user, String code) {
		switch (ckDtMenu) {
		case 1 :
			buyProduct(user, code);
			break;

		case 2 :
			System.out.println("[이전으로 돌아갑니다.]");
			break;
			
		default : 
			System.out.println("올바른 메뉴 선택");
 			break;
		}
		
	}

	private static void buyProduct(Member user, String code) {
		
		Product p = getProduct(list, code);
		
		//없는 제품이면
		if(p == null) {			//한번 체크해서 null일 리는 없지만 한번 더 체크하는 게 좋음 ->실행하는 애 입장에서는 모를수있기에
			System.out.println("[등록되지 않은 제품입니다.]");
			return;
		}
		
		//재고가 없으면
		if(p.getAmount() == 0) {
			System.out.println("[남은 재고가 없습니다.]");
			return;
		}
		
		System.out.println("수량 : ");
		int amount = scan.nextInt();
		scan.nextLine();
		
		//음수 입력 시
		if(amount <= 0) {
			System.out.println("[수량은 0보다 커야 합니다.]");
			
		}
		
		//재고보다 많이 구매 시
		if(amount > p.getAmount()) {
			System.out.println("[재고량이 부족합니다.]");
			return;
		}
		
		PurchaseItem pi = new PurchaseItem(p, amount);
		user.addPurChaseItem(pi);
		p.setAmount(p.getAmount() - amount);
		System.out.println("[제품을 구매했습니다.]");
		
	}

	private static Product getProduct(List<Product> list, String code) {

		int index = list.indexOf(new Product(code, "", "", "", 0));
		if(index < 0) return null;
				
		return list.get(index);
	}

	private static void printCheckDetailMenu() {
		System.out.println("-------------------------");
		System.out.println("1. 제품 구매");
		System.out.println("2. 이전으로");
		System.out.println("-------------------------");
		System.out.print("번호 입력 : ");
		
	}

	private static void printCheckMenu() {
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

	private static void login() {
		//로그인 기능
		//아이디 비번 입력받음
		System.out.print("아이디 : ");
		String id = scan.next();
		
		System.out.print("비밀번호 : ");
		String pw = scan.next();
		
		//객체 생성
		Member member = new Member(id, pw);
		//객체 정보와 일치하는 회원정보(아이디, 비번) 있는지 확인해서 있으면 회원정보 가져옴
		
		Member user = getMember(members, member);
		
		//가져온 회원정보가 없으면 안내문구 출력 후 종료 : 아이디 or 비번이 틀림
		if(user == null) {
			System.out.println("[아이디 또는 비번이 일치하지 않습니다.]");
			return;
		}
		String authority = user.getAuthority();
		
		
		
		switch (authority) {
		case "사용자" : 
			runUser(user);			//구매를 위해 유저정보 매개변수로 넘겨야함
			break;
		case "관리자" : 
			runAdmin();
			break;
		default :
			System.out.println("[로그인에 실패하였습니다.]");
		}
		
	}

	private static Member getMember(List<Member> members, Member member) {
		if(members == null || members.isEmpty())return null;
		if(member == null) return null;
		int index = members.indexOf(member);
		if(index<0) return null;	//아이디 일치x
		Member user = members.get(index);
		if(user.getPw().equals(member.getPw()))	return user;	//비번이 일치
		return null; 	//일치x
	}

	private static void signUp() {
		// 회원 가입 정보를 입력(아이디, 비번, 비번확인)
		System.out.print("아이디 : ");
		String id = scan.next();
		
		System.out.print("비밀번호 : ");
		String pw = scan.next();
		
		System.out.print("비밀번호 확인 : ");
		String pw2 = scan.next();
		
		//비번과 비번확인이 일치하지 않으면 알림 후 종료
		if(!pw.equals(pw2)) {
			System.out.println("[비밀번호 왁인이 일치하지 않습니다.]");
			return;
		}
		
		// 입력받은 정보를 이용하여 객체 생성
		Member member = new Member(id, pw);
		
		// 생성한 객체가 등록되었는지 확인 후 없으면 추가 후 알림
		if(!members.contains(member)) {
			members.add(member);
			System.out.println("[회원 가입 완료]");
			return;
		}
		
		// 있으면 알림
		
		System.out.println("[중복되는 아이디가 있습니다.]");
		return;
		
		
		
	}

}
	
