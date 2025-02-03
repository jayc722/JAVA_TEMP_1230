package selfstudy.day021;

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
		if(socket == null || ois == null || oos == null || list == null)return;		

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
		case 0://회원가입
			break;
		case 1://로그인
			break;
		case 2://채팅 기록 확인
			break;
		case 3://
			break;
		case 4://
			break;
		default:
		}
	}

}
