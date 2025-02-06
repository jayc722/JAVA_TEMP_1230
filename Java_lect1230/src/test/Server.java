package test;

import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class Server {

	public static void main(String[] args) throws UnknownHostException {
		int port = 3000;
		
		String serverIP = InetAddress.getLocalHost().getHostAddress();
		System.out.println(serverIP);
		
		
		try {
			//port 이용하여 서버소캣 생성
			ServerSocket serverSocket = new ServerSocket(port);
			//연결 될때까지 대기. 연결 되면 소캣 생성
			while(true) {
			Socket socket = serverSocket.accept();
			System.out.println("[연결 완료]");
			}
			}catch (Exception e) {
				// TODO: handle exception
			}

	}

}
