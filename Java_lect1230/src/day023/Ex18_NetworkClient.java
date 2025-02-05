package day023;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Ex18_NetworkClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		//ip와 port 설정
		String ip = "127.0.0.1";		//내부 ip. 로컬은 되지만 다른 pc와는 접속 x
										//cmd 에서 ipconfig에서 확인해서 ip주소 써야
		//ip설정시 내부아이피로 설정하면 현PC에서 테스트할땐 동작되지만 여러 PC에서는 안됨
		int port = 3001;
		
		
		//ip, port 이용해서 소켓 생성
		
		//데이터 주고받음(원래는 쓰레드 이용해야 하지만 생략)
		try {
			//ip port 이용하여 서버소캣 생성
			Socket socket = new Socket(ip, port);
			
			
			System.out.println("[연결 완료]");
			//통신을 통해 데이터를 주고받으면 됨
			ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
			
			oos.writeUTF("안녕");
			oos.flush();
			Thread.sleep(1000);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("[프로그램 종료]");

	}

}
