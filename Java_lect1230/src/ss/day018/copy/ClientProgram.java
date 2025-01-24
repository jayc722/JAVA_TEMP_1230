package ss.day018.copy;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

import day018.Account;

public class ClientProgram {

	private Socket socket;
	private Scanner scan = new Scanner(System.in);
	private ObjectInputStream ois;
	private ObjectOutputStream oos;
	
	public ClientProgram(Socket socket) {
		this.socket = socket;
		this.scan = new Scanner(System.in);//this안써도됨
		
		if(socket == null || ois == null || oos == null)return;		//ois oos null은 사실 안따져도 되는데 프로그램 안정성을 위해...
		
		try {
		ois = new ObjectInputStream(socket.getInputStream());
		oos = new ObjectOutputStream(socket.getOutputStream());
		
		}catch(Exception e) {
			//e.printStackTrace();
		}
		
	}

	public void run() {
		if(socket == null) {
			System.out.println("서버 연결에 실패했습니다.");
			return;
		}
		
		int menu;
		do {
			printMenu();
			
			menu = scan.nextInt();
			scan.nextLine();
			
			runMenu(menu);				//oos ois static 이라 매개변수 안넘겨도
			
			
		}while(menu != 3);
		
	}

	private void printMenu() {
		// TODO Auto-generated method stub
		
	}

	private void runMenu(int menu) {
		// TODO Auto-generated method stub
		
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
		// TODO Auto-generated method stub
		Account account = inputAccount();
		System.out.println("[접속중]");
		System.out.println("[다른 사용자가 이용 중일 경우 대기해야 할 수 있습니다.]");
		
		//서버와 통신해서 account 일치 여부 확인 =>서버에게 account와 일치하는 계좌 정보 달라고 요청
		
		//일치하지 않으면 안내문구 후 종료

		int menu;
		do {
			printLoginMenu();

			menu = scan.nextInt();
			scan.nextLine();

			runLoginMenu(menu, account);
		}while(menu != 4);
	}

	private Account inputAccount() {
		// TODO Auto-generated method stub
		return null;
	}

	private void printLoginMenu() {
		// TODO Auto-generated method stub

	}

	private void runLoginMenu(int menu, Account account) {
		// TODO Auto-generated method stub

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

	private void deposit(Account account) {
		// TODO Auto-generated method stub
		
		
	}

	private void withdrawal(Account account) {
		// TODO Auto-generated method stub
		
	}

	private void check(Account account) {
		// TODO Auto-generated method stub
		
	}

	private void open() {
		// TODO Auto-generated method stub

	}

}
