package test;

import java.net.InetAddress;
import java.net.Socket;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		int port = 3000;
		String serverIP = "192.168.40.45";
		
		try {
		Socket socket = new Socket(serverIP, port);
		System.out.println("[연결 완료]");
		
		}catch (Exception e) {
			// TODO: handle exception
		}
	}

}
