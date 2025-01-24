package ss.day018.copy;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class SS_Ex01_Client {
	
	
	static public Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		/*
		 * 은행 계좌 관리 프로그램
		 * -접속
		 * 	-은행. 계좌번호. 비밀번호
		 * -계좌 개설
		 * 	-은행. 이름. 계좌번호. 비밀번호. 비밀번호 확인
		 * -종료
		 * 	-예금조회
		 *  -입금
		 *  -출금
		 *  -이전
		 *  
		 * 주의사항
		 * 	-한 계좌에 여러명이 동시에 접근하는 경우
		 * 	-먼저 접근한 사람이 사용하도록
		 * 
		 * 
		 */
		
		//서버와 연결
		
		String ip = "127.0.0.1";
		
		int port = 5002;
		Socket socket = null;
		ObjectOutputStream oos;
		ObjectInputStream ois; 

		try {
			socket = new Socket(ip, port);
			System.out.println("[연결 성공!]");
			//IO스트림 생성
			oos = new ObjectOutputStream(socket.getOutputStream());
			ois = new ObjectInputStream(socket.getInputStream());
			
		}catch (Exception e) {
			System.out.println("[서버 연결 x]");
			return;
		}

		int menu;
		do {
			printMenu();

			menu = scan.nextInt();
			//생성한 IO스트림을 넘겨줌
			scan.nextLine();

			runMenu(menu, ois, oos);

		}while(menu != 3);



	}

	private static void runMenu(int menu, ObjectInputStream ois, ObjectOutputStream oos) {
		do {
			switch(menu) {
			case 1 :
				System.out.println("1. 접속");
				connect(ois, oos);
				break;
			case 2 :
				System.out.println("2. 계좌 개설");
				newAcc(ois, oos);
				break;
			case 3 :
				System.out.println("3. 종료");
				break;
			default : 
				System.out.println("잘못된 입력입니다.");


			}



		}while (menu != 3);

	}

	private static void connect(ObjectInputStream ois, ObjectOutputStream oos) {
		System.out.println("은행 입력");
		String bankName = scan.nextLine();
		System.out.println("계좌번호 입력");
		String account = scan.nextLine();
		System.out.println("비밀번호 네자리 입력");
		String pw = scan.nextLine();
		
		Bank bank = new Bank(bankName, account, pw);
		
		try {
			oos.writeInt(0);
			oos.writeObject(bank);
			oos.flush();
			if(!ois.readBoolean()) {
				System.out.println("일치하는 계좌가 없거나 잘못된 비밀번호입니다.");
				return;
			}
			else {
				bankMenu(bank, ois, oos);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static void bankMenu(Bank bank, ObjectInputStream ois, ObjectOutputStream oos) {

		printBankMenu();
		int menu = scan.nextInt();
		scan.nextLine();

		do {
			switch(menu) {
			case 1 :
				System.out.println("1. 예금 조회");
				accountView(bank, ois, oos);
				break;
			case 2 :
				System.out.println("2. 입금");
				deposit(bank, ois, oos);
				break;
			case 3 :
				System.out.println("3. 출금");
				withdraw(bank, ois, oos);
				break;
			case 4 :
				System.out.println("4. 이전");
				return;
			default : 
				System.out.println("잘못된 입력입니다.");
			}
		}while (menu != 4);
	}




	private static void withdraw(Bank bank, ObjectInputStream ois, ObjectOutputStream oos) {
		System.out.print("출금할 금액 입력 : ");
		int money = scan.nextInt();
		
		try {
			oos.writeInt(3);
			oos.writeInt(money);
			oos.flush();

			money = ois.readInt();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("잔고는 " + money + "원입니다.");
		
	}
		
	private static void deposit(Bank bank, ObjectInputStream ois, ObjectOutputStream oos) {
		System.out.print("입금할 금액 입력 : ");
		int money = scan.nextInt();
		
		try {
			oos.writeInt(2);
			oos.writeInt(money);
			oos.flush();

			money = ois.readInt();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("잔고는 " + money + "원입니다.");
		
	}

	private static void accountView(Bank bank, ObjectInputStream ois, ObjectOutputStream oos) {
		int money = 0;
		try {
			oos.writeInt(1);
			oos.flush();
			money = ois.readInt();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("잔고는 " + money + "원입니다.");

	}

	private static void printBankMenu() {
		System.out.println("--------------------");
		System.out.println("1. 예금 조회");
		System.out.println("2. 입금");
		System.out.println("3. 출금");
		System.out.println("4. 이전");
		System.out.println("--------------------");
		System.out.print("메뉴 선택 : ");

	}

	private static void newAcc(ObjectInputStream ois, ObjectOutputStream oos) {
		try {

			while(true) {


				System.out.println("은행 입력");
				String bankName = scan.nextLine();
				System.out.println("이름 입력");
				String name = scan.nextLine();
				System.out.println("계좌번호 입력");
		String account = scan.nextLine();
		String pw1, pw2 = null;

		while(true) {
			System.out.println("비밀번호 네자리 입력");
			pw1 = scan.nextLine();
			System.out.println("비밀번호 확인");
			pw2 = scan.nextLine();
			if(pw1.length()!= 4 || !pw1.equals(pw2)) {
				System.out.println("비밀번호가 네자리가 아니거나 재입력한 값이 다릅니다.");
				continue;
			}
			break;
		}

		Bank bank = new Bank(bankName, name, account, pw1);
			oos.writeInt(10);
			oos.writeObject(bank);
			oos.flush();
			if(ois.readBoolean()) {
				System.out.println("계좌 생성 완료");
				bank.print();
				break;
			}else {
				System.out.println("중복되는 계좌번호 혹은 허용되지 않는 양식의 계좌번호입니다.");
				continue;
			}
				
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}



	}

	private static void printMenu() {

		System.out.println("--------------------");
		System.out.println("1. 접속");
		System.out.println("2. 계좌 개설");
		System.out.println("3. 종료");
		System.out.println("--------------------");
		System.out.print("메뉴 선택 : ");

	}




	
}
