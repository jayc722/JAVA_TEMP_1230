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

			//메뉴에 따라 기능을 실행
			menu = ois.readInt();
			runMenu(menu);

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
			deposit();
			break;
		case 3://출금
			withdrawal();
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

	private int check() {
		// TODO Auto-generated method stub
		Account tmp = (Account)ois.readObject();
		int index = list.indexOf(tmp);
		
		if(index<0)
		
		System.out.println(list.get(index).toString());
		return index;
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

	private void deposit() {
		// TODO Auto-generated method stub

	}

	private void withdrawal() {
		// TODO Auto-generated method stub

	}
}
