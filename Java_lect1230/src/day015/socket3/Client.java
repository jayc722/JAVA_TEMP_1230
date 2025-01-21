package day015.socket3;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

import lombok.AllArgsConstructor;

//client 클래스를 이용하여 서버와 클라이언트가 문자열을 주고받는 예제
//client 클래스를 이용한 1대1 채팅
@AllArgsConstructor
public class Client {
	
	private Socket socket;
	private final static String EXIT = "EXIT";
	
	//소켓으로 데이터 받아오는 기능
	public void recieve() {
		Thread t2 = new Thread(()->{
			
			try {
				ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
				
				while(true) {
					String str = ois.readUTF();
					System.out.println("수신(EXIT : 종료) : " + str);
					if(str.equals(EXIT))break;
				}
				
				System.out.println("[수신 기능을 종료합니다.]");
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		});
		t2.start();
	}
	//연결되 소켓으로 데이터를 전송하는 기능
	public void send() {
		
		Thread t1 = new Thread(()->{		//쓰레드 만드는 두 방법 중 하나인 Runnable 인터페이스 구현부 작성
			Scanner scan = new Scanner(System.in);
			
			try {
				ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
				//두줄로 썼던건 한줄로..
				
				while(true) {
				System.out.print("입력(EXIT : 종료) : ");
				String str = scan.nextLine();
				
				oos.writeUTF(str);
				oos.flush();  
				
				if(str.equals(EXIT))break;		
				}
				System.out.println("[전송 기능을 종료합니다.]");
				
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		});
		t1.start();
	
	}
}

