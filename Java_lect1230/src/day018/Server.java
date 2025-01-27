package day018;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;

public class Server {

	
	private Socket socket;
	private ObjectInputStream ois;
	private ObjectOutputStream oos;
	private List<Account> list;
	
	public Server(Socket socket, List<Account> list) {
		// TODO Auto-generated constructor stub
		this.socket = socket;
		this.list = list;
		if(socket == null)return;		//ois oos null은 사실 안따져도 되는데 프로그램 안정성을 위해...

		try {
			ois = new ObjectInputStream(socket.getInputStream());
			oos = new ObjectOutputStream(socket.getOutputStream());

		}catch(Exception e) {
			//e.printStackTrace();
		}
	}

	public void run() {
		// TODO Auto-generated method stub
		if(socket == null || ois == null || oos == null || list == null)return;		//list가 비어있는건 괜찮은데 null이면 새로 작업할때 재할당돼서 공유가 안됨

		Thread t = new Thread(()->{		//쓰레드화 

			//메뉴 수신
			int menu = 0;
			try {
				do {
					
					//메뉴에 따라 기능을 실행
					menu = ois.readInt();
					runMenu(menu);
					
				}while(menu != 5);
				
			}catch (Exception e) {
				e.printStackTrace();
			}
		});
		t.start();
		//



	}


	private void runMenu(int menu) {
		switch(menu) {
		case 0://계좌 개설
			open();
			break;
		case 1://접속
			login();
			break;
		case 2://입금
			//deposit();
			depositAndWithdrawal(Type.입금);
			break;
		case 3://출금
			//withdrawal();
			depositAndWithdrawal(Type.출금);
			break;
		case 4://조회
			check();
			break;
		default:
		}
	}

	private void login() {
		try {
			//클라이언트가 보낸 계좌 정보를 가져옴
			Account account = (Account)ois.readObject();
			int index = list.indexOf(account);
			
			Account sendAccount = null; //null초기화
			if(index >= 0) {
				sendAccount = (Account)list.get(index).clone();	//클론 안하면 주소를 그대로 쓰기때문에 변경한내용 적용 안됨 ->일부러 클론 추가해줘야
			}													//지난예제에도 있음
			
			oos.writeObject(sendAccount);
			oos.flush();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
	}


	private void open() {
		try{
			// 계좌정보를 클라이언트에게 받아오고
			Account account = (Account) ois.readObject();

			boolean res = false;
			// 있는지 확인해서 없으면 추가
			if(list.contains(account)) {
				list.add(account);
				res = true;
			}
			// 추가 여부를 클라이언트에게 전송
			oos.writeBoolean(res);
			oos.flush();
		}catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	private void check() {
		try {
		// 계좌 정보를 클라이언트에게 받아옴
		Account account = (Account)ois.readObject();
		
		//받아온 계좌와 일치하는 계좌의 복사본을 생성해서 전송
		int index = list.indexOf(account);
		
		Account tmp = null;
		
		if(index>=0) tmp = (Account)list.get(index).clone();
		oos.writeObject(tmp);
		oos.flush();
			
		}catch (Exception e) {
			System.out.println("[조회 중 예외 발생]");
			e.printStackTrace();
		}
	}
	
	private void depositAndWithdrawal(Type type) {
		try {
			//계좌 정보와 입출금을 클라이언트에게 전달받음
			long money = ois.readLong();
			Account account = (Account)ois.readObject();

			long res = -1;		//잔액 보여주려고 boolean -> long 수정

			int index = list.indexOf(account);
			//입출금 정보도 올바른지 확인		//계좌 정보가 있는지 확인
			if(money <= 0 || index < 0) {  	//동기화를 위해 수정		

			//res = false;
			
			//클라이언트에게 결과 전송
			oos.writeLong(res);
			oos.flush();  

			return;				//바로 끝내기
			}


			//계좌에 금액을 추가하여 입출금 내역이 추가되도록 
			Account tmp = list.get(index);
			synchronized (tmp) {
				res = tmp.depositAndWithdrawal(money, type) ? tmp.getMoney() : -1; //확인 - > 성공했으면 잔액이 0일수는 없음
			}
								//동기화 중 다른사람 접속 막아야

			//클라이언트에게 결과 전송
			oos.writeLong(res);
			oos.flush();  
			Thread.sleep(500);  //그냥 작업 되는거같은 효과 주려고..
			
			}catch (Exception e) {
				String str = type.toString();
				System.out.println("[" + type + " 중 예외 발생]");
				e.printStackTrace();			
			}

		
		
		
	}
/*	//합쳐버림
	private void deposit() {
		try {
		//계좌 정보와 예금을 클라이언트에게 전달받음
		long money = ois.readLong();
		Account account = (Account)ois.readObject();

		long res = -1;		//잔액 보여주려고 boolean -> long 수정

		int index = list.indexOf(account);
		//예금 정보도 올바른지 확인		//계좌 정보가 있는지 확인
		if(money <= 0 || index < 0) {  	//동기화를 위해 수정		

		//res = false;
		
		//클라이언트에게 결과 전송
		oos.writeLong(res);
		oos.flush();  

		return;				//바로 끝내기
		}


		//계좌에 예금을 추가하여 입출금 내역이 추가되도록 
		Account tmp = list.get(index);
		synchronized (tmp) {
			res = tmp.deposit(money) ? tmp.getMoney() : -1; //확인 - > 성공했으면 잔액이 0일수는 없음
		}
							//동기화 중 다른사람 접속 막아야

		//클라이언트에게 결과 전송
		oos.writeLong(res);
		oos.flush();  
		Thread.sleep(500);  //그냥 작업 되는거같은 효과 주려고..
		
		}catch (Exception e) {
			System.out.println("[입금 중 예외 발생]");
			e.printStackTrace();			
		}

	}

	private void withdrawal() {
		try {
			//계좌 정보와 출금을 클라이언트에게 전달받음
			long money = ois.readLong();
			Account account = (Account)ois.readObject();

			long res = -1;		//잔액 보여주려고 boolean -> long 수정

			int index = list.indexOf(account);
			//출금 정보도 올바른지 확인		//계좌 정보가 있는지 확인
			if(money <= 0 || index < 0) {  	//동기화를 위해 수정		

		
			
			//클라이언트에게 결과 전송
			oos.writeLong(res);
			oos.flush();  

			return;				
			}


			//계좌에 출금을 추가하여 입출금 내역이 추가되도록 
			Account tmp = list.get(index);
			synchronized (tmp) {
				res = tmp.withdrawal(money) ? tmp.getMoney() : -1; //확인 - > 성공했으면 잔액이 0일수는 없음
			}
								//동기화 중 다른사람 접속 막아야

			//클라이언트에게 결과 전송
			oos.writeLong(res);
			oos.flush();  
			Thread.sleep(500);  //그냥 작업 되는거같은 효과 주려고..
			
			}catch (Exception e) {
				System.out.println("[출금 중 예외 발생]");
				e.printStackTrace();			
			}

	}
	*/
}
