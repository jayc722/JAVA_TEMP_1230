package selfstudy.day021;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;





public class ClientP {

	private Socket socket;
	private Scanner scan;
	private ObjectInputStream ois;
	private ObjectOutputStream oos;
	
	
	public ClientP(Socket socket) {
		this.socket = socket;
		scan = new Scanner(System.in);
		
		if(socket == null)return;	
		
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
		System.out.println("2. 채팅 기록 확인");
		System.out.println("3. 종료");
		System.out.println("--------------------");
		System.out.print("메뉴 선택 : ");
		
	}
	
	
	private void runMenu(int menu) {
		System.out.println("--------------------");
		
		switch(menu) {
		case 1 :
			connect();
			break;
		case 2 :
			chatList();
			break;
		case 3 :
			break;
		default : 
			System.out.println("[잘못된 입력입니다.]");
		}
		
	}
	
	private void connect() {
		
		int menu = 0;
		do {
			printConnectMenu();
			
			menu = scan.nextInt();
			scan.nextLine();
		
			runConnectMenu(menu);				
			
			
		}while(menu != 3);
		
	}

	private void runConnectMenu(int menu) {
		System.out.println("--------------------");
		
		switch(menu) {
		case 1 :
			login();
			break;
		case 2 :
			signUp();
			break;
		case 3 :
			break;
		default : 
			System.out.println("[잘못된 입력입니다.]");
		}
		
	}


	private void login() {
		
		

		Account tmpAcc;
		Account acc;

		while(true) {
			tmpAcc = new Account(null, null, null, false);
			acc = new Account(null, null, null, false);

			System.out.print("아이디 입력 : ");
			String tmpId = scan.nextLine();
			tmpAcc.setId(tmpId); 
			System.out.print("비밀번호 입력 : ");
			String tmpPw = scan.nextLine();
			tmpAcc.setId(tmpPw); 

			try{
				oos.writeInt(1);
				oos.writeObject(tmpAcc);
				oos.flush();

				acc = (Account)ois.readObject();

				if(acc == null) {
					System.out.println("해당하는 아이디가 존재하지 않거나 비밀번호가 틀립니다.");
					System.out.println();
					continue;
				}

				System.out.println("[접속됐습니다.]");
				
			}catch (Exception e) {
				e.printStackTrace();
			}


				runChatMenu(acc);

		}
	}



	private void runChatMenu(Account acc) {
		
		
		
		
	}

	private void signUp() {
		Account tmpAcc = new Account(null, null, null, false);

		while(true) {
			System.out.print("아이디 입력 : ");
			String tmpId = scan.nextLine();
			tmpAcc.setId(tmpId); 

			try {
				oos.writeInt(0);
				oos.writeObject(tmpAcc);
				oos.flush();

				if(!ois.readBoolean()) {
					System.out.println("중복된 아이디입니다.");
					continue;
				}

				while(true) {
					System.out.print("패스워드 입력 : ");
					String tmpPw = scan.nextLine();
					if(tmpPw.length()<8) {
						System.out.println("패스워드는 8자리 이상으로 해 주세요.");
						continue;
					}
					tmpAcc.setPw(tmpPw); 
					break;
				}
				System.out.print("대화명 입력 : ");
				String tmpNN = scan.nextLine();
				tmpAcc.setName(tmpNN); 

				oos.writeObject(tmpAcc);
				oos.flush();

				if(ois.readBoolean()) {
					System.out.println("계정 생성 성공");
					System.out.println(tmpNN + "님 반갑습니다.");
					return;
				}

				System.out.println("계정 생성 실패");
				return;


			}catch (Exception e) {
				e.printStackTrace();
			}

		}

	}

	private void printConnectMenu() {

		System.out.println("--------------------");
		System.out.println("1. 로그인");
		System.out.println("2. 회원 가입");
		System.out.println("3. 뒤로가기");
		System.out.println("--------------------");
		System.out.print("메뉴 선택 : ");
		
	}

	private void chatList() {
		// TODO Auto-generated method stub
		
	}

	
	
	
	
}
