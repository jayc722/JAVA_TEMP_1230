package day015.socket4;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Client {
	
	
	private String id;
	private Socket socket;
	private final static String EXIT = "EXIT";
	
	//소켓으로 데이터 받아오는 기능
	public void recieve() {
		Thread t2 = new Thread(()->{
			
			try {
				ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
				
				while(true) {
					String id = ois.readUTF();	//id를 먼저 받고 채팅을 받음
					String chat = ois.readUTF();
					System.out.println("수신(EXIT : 종료) : " + chat);
					if(chat.equals(EXIT))break;
					
					System.out.println(id + " : " + chat);
				}
				
				System.out.println("[수신 기능을 종료합니다.]");
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		});
		t2.start();
	}//나한테만 exit 보내서 수신종료하게 해야
	
	//연결된 소켓으로 데이터를 전송하는 기능
	public void send() {
		
		Thread t1 = new Thread(()->{		//쓰레드 만드는 두 방법 중 하나인 Runnable 인터페이스 구현부 작성
			Scanner scan = new Scanner(System.in);
			
			try {
				ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
				//두줄로 썼던건 한줄로..
				
				System.out.print("종료하려면" + EXIT + " 입력하세요. ");
				while(true) {
				String chat = scan.nextLine();
				
				oos.writeUTF(id);
				oos.writeUTF(chat);
				oos.flush();  
				
				if(chat.equals(EXIT))break;		
				}
				System.out.println("[전송 기능을 종료합니다.]");
				
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		});
		t1.start();
	
	}
}

