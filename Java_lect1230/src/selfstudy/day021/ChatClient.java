package selfstudy.day021;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;
import java.util.Scanner;

import lombok.AllArgsConstructor;


@AllArgsConstructor
public class ChatClient {

	private String name;
	private Socket socket;
	private List<Chat> list;//기존 채팅내역도 받아와야

	private final String EXIT = "EXIT";


	public void receive() {
		
		//day15소켓3 클라이언트에서 복붙
		//Thread t2 = new Thread(()->{		

			try(ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
 ) { //트라이 리소스로 하면 finally로 닫을 필요 x
				
				while(true) {
					//문자열 대신 chat 객체를 받고
					Chat chat = (Chat)ois.readObject();
					
					//채팅 내용이 exit와 같으면 종료
					if(chat.getChat().equals(EXIT))break;
					
					//받은 객체 출력
					System.out.println(chat);
				}

			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				System.out.println("[수신 기능을 종료합니다.]");
				//한쪽이 닫으면 닫기위해 일부러 예외 발생
			}

		//});
		//t2.start();
	}

	public void send() {

		Thread t1 = new Thread(()->{		
			Scanner scan = new Scanner(System.in);

			try {
				ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());

				System.out.println("[채팅을 시작합니다.]");
				System.out.println("[종료하려면 " + EXIT + " 입력]");
				
				
				while(true) {
					String str = scan.nextLine();
					//문자열이 아닌 chat의 객체 전송
					Chat chat = new Chat(str, this.name);

					oos.writeUTF(str);
					oos.flush();  

					if(str.equals(EXIT))break;		
					//채팅 기록에 추가
					
				}

			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				System.out.println("[전송 기능을 종료합니다.]");
			}

		});
		t1.start();

	}


	public void run() {


		//send와 receive를 이용해 호출
		//밖에서 하면 종료되는 순간 다시 시작

		//둘중 하나의 쓰레드를 제거(밑에 있는 쪽)
		//why? 제거 안하면 두 메소드가 쓰레드로 실행되기 때문에(콘솔창이 하나뿐) run메소드가 종료되면
		//메인 메뉴로 채팅이 끝나지 않은 상태에서 종료되기 때문


		send();
		receive();		

		/* receive();
		 * send();
		 * //순서라면 리시브쪽 쓰레드를 지워야
		 */
	}



}
