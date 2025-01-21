package day015.socket3;

import java.net.Socket;

public class Ex03_Client2 {
	public static void main(String[] args) {
	int port = 5001;
	String ip ="127.0.0.1";
	
	try {
		//소켓 생성
	Socket socket = new Socket(ip, port);
	
	System.out.println("[연결 성공]");
	
	//쓰레드 생성 : 콘솔에서 문자열을 입력받아 전송하는 쓰레드 > 소켓 통해서도 가능하지만 람다식으로도
	Client c = new Client(socket);
	c.recieve();
	c.send();

	
	}catch(Exception e) {
		e.printStackTrace();
	}
	
}
}
