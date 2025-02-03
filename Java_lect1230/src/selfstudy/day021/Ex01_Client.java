package selfstudy.day021;

import java.net.Socket;



public class Ex01_Client {
	
	/* 1대1 채팅 프로그램을 구현
	 * 채팅 기록을 관리하는 기능을 추가
	 * 
	 * 메뉴
	 * 	-접속
	 * 		-사용자 아이디를 입력하도록
	 * 		-EXIT를 채팅으로 보내면 채팅을 종료하도록 작성
	 * 	-채팅 기록 확인
	 * 	-종료
	 * 
	 * 
	 * user : 안녕하세요 (아이디와 문구 출력)
	 */

	public static void main(String[] args) {

		int port = 5003;
		String ip = "127.0.0.1";


		try(Socket socket = new Socket(ip, port);) {


			System.out.println("[서버와 연결되었습니다.]");


			ClientP program = new ClientP(socket);

			program.run();


		}catch (Exception e) {
			System.out.println("[서버와 연결되지 않아 프로그램을 종료합니다.]");
			e.printStackTrace();
		}




		
		
	}

}

