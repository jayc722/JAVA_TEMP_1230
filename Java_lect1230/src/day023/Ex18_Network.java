package day023;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Ex18_Network {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//port 설정
		//String ip = "127.0.0.1";
		int port = 3001;
		
		try {
			//port 이용하여 서버소캣 생성
			ServerSocket serverSocket = new ServerSocket(port);
			//연결 될때까지 대기. 연결 되면 소캣 생성
			Socket socket = serverSocket.accept();
			
			
			System.out.println("[연결 완료]");
			//통신을 통해 데이터를 주고받으면 됨
			ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("[프로그램 종료]");
		
		
		
		
		
		

	}

}
