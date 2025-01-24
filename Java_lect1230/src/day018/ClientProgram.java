package day018;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.InputMismatchException;
import java.util.Scanner;


public class ClientProgram {

	private Socket socket;
	private Scanner scan;
	private ObjectInputStream ois;
	private ObjectOutputStream oos;
	
	public ClientProgram(Socket socket) {
		this.socket = socket;
		this.scan = new Scanner(System.in);//this안써도됨
		
		if(socket == null)return;		//ois oos null은 사실 안따져도 되는데 프로그램 안정성을 위해...
		
		try {
		ois = new ObjectInputStream(socket.getInputStream());
		oos = new ObjectOutputStream(socket.getOutputStream());
		
		}catch(Exception e) {
			//e.printStackTrace();
		}
		
	}

	public void run() {
		if(socket == null || ois == null || oos == null) {
			System.out.println("서버 연결에 실패했습니다.");
			return;
		}
		
		int menu = 0;
		do {
			printMenu();
			
			menu = scan.nextInt();
			scan.nextLine();
		
			runMenu(menu);				//oos ois static 이라 매개변수 안넘겨도
			
			
		}while(menu != 3);
		
	}

	private void printMenu() {

		System.out.println("--------------------");
		System.out.println("1. 접속");
		System.out.println("2. 계좌 개설");
		System.out.println("3. 종료");
		System.out.println("--------------------");
		System.out.print("메뉴 선택 : ");
	}

	private void runMenu(int menu) {
		System.out.println("--------------------");
		
		switch(menu) {
		case 1 :
			login();
			break;
		case 2 :
			open();
			break;
		case 3 :
			break;
		default : 
			System.out.println("잘못된 입력입니다.");
		}
		
	}
	
	private void login() {
		Account account = inputAccount();
		System.out.println("[접속중]");
		System.out.println("[다른 사용자가 같은 계정으로 이용 중일 경우 대기해야 할 수 있습니다.]");
		Account account2 = null;
		try {
		//서버와 통신해서 account 일치 여부 확인 =>서버에게 account와 일치하는 계좌 정보 달라고 요청
		oos.writeInt(1);
		oos.writeObject(account); //정보 건네줘야
		oos.flush();
		
		account2 = (Account)ois.readObject();
		
		}catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		
		//일치하지 않으면 안내문구 후 종료
		if(account2 == null) {
			System.out.println("[계좌 정보가 잘못 되었습니다.]");
			return;
		}
		
		
		System.out.println("[접속됐습니다.]");
		
		
		int menu = 0;
		do {
			
			
			printLoginMenu();
			menu = scan.nextInt();
			scan.nextLine();
			
			runLoginMenu(menu, account);
	

		}while(menu != 4);
	}

	private Account inputAccount() {
		String bankName;
		do {
			Bank.printBanks(); //for(Bank bank : Bank.values())System.out.println(bank + " ");
			System.out.println();
			System.out.println("은행 : ");
			bankName = scan.nextLine();
		}while(!Bank.check(bankName));		//올바른 은행 입력할때까지 시행

		System.out.print("이름 : ");
		String name = scan.nextLine();
		System.out.print("계좌번호 : ");
		String num = scan.nextLine();
		System.out.print("비밀번호 : ");
		String pw1 = scan.nextLine();

		return new Account(Bank.valueOf(bankName), num, name, pw1);
	}

	private void printLoginMenu() {
		System.out.println("--------------------");
		System.out.println("1. 예금");
		System.out.println("2. 출금");
		System.out.println("3. 조회");
		System.out.println("4. 이전");
		System.out.println("--------------------");
		System.out.print("메뉴 선택 : ");

	}

	private void runLoginMenu(int menu, Account account) {

		switch(menu) {
		case 1 :
			deposit(account);
			break;
		case 2 :
			withdrawal(account);
			break;
		case 3 :
			check(account);
			break;
		case 4 :
			break;
		default : 
			System.out.println("잘못된 입력입니다.");
		}
	}

	private void check(Account account) {
		// TODO Auto-generated method stub
		
		
		
	}
	
	
	
	private void deposit(Account account) {
		// TODO Auto-generated method stub


	}

	private void withdrawal(Account account) {
		// TODO Auto-generated method stub

	}


	private void open() {
		// 은행 이름 계좌번호 비밀번호
		Account account = inputAccount();		//깔끔해짐
		System.out.print("비밀번호 확인 : ");
		String pw2 = scan.nextLine();

		if(!account.getPw().equals(pw2)) {
			System.out.println("[비밀번호가 확인과 일치하지 않습니다.]");
			return;
		}


		try {
			//서버에 메뉴 전송(0번-open)
			oos.writeInt(0);

			//서버에게 (메뉴 번호와-runMenu에서)계좌정보를 전송
			oos.writeObject(account);
			oos.flush();

			if(ois.readBoolean())System.out.println("[계좌를 등록했습니다.]");
			else System.out.println("[계좌 등록에 실패했습니다.]");
		}catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}


	}

}
