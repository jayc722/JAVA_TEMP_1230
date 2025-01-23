package day017;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ex01_Server2 {

	static List<Record> list = new ArrayList<Record>();

	public static void main(String[] args) {
		// 숫자야구게임 구현
		// 단, 기록은 서버에 통신을 이용하여 저장
		// 기록은 영문 3자와 횟수를 기록
		// 기록이 같은 경우 먼저 등록된 순으로 순위를 출력

		//기록은 상위 5명만 출력

		int port = 5002;

		try {
			ServerSocket serverSocket = new ServerSocket(port);

			while(true) {			//여러번 접속해도 되게 
				Socket socket = serverSocket.accept();
				Server server = new Server(socket, list);
				server.run();
				
			}
		}catch (Exception e) {
			e.printStackTrace();		
		}

	}



}
