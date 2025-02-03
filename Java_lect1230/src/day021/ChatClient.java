package day021;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.SocketException;
import java.util.List;
import java.util.Scanner;

import lombok.AllArgsConstructor;


@AllArgsConstructor
public class ChatClient {

	private String id;
	private Socket socket;
	private List<Chat> list;//기존 채팅내역도 받아와야

	private final String EXIT = "EXIT";


	public void receive() {
		
		//day15소켓3 클라이언트에서 복붙
		Thread t2 = new Thread(()->{		

			try(ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
 ) { //트라이 리소스로 하면 finally로 닫을 필요 x
				
				while(true) {
					//문자열 대신 chat 객체를 받고
					Chat chat = (Chat)ois.readObject();	//부모클래스 -> 자식 : 명시적으로 써야
					
					//채팅 내용이 exit와 같으면 종료
					if(chat.getChat().equals(EXIT))break;
					
					//받은 객체 출력
					System.out.println(chat);
					
					//객체를 채팅 내역에 추가
					list.add(chat);
				}

			//}catch(SocketException e) {
				//상대가 먼저 나가서
			}catch (Exception e) {
				//e.printStackTrace();
			//}finally {
				//System.out.println("[상대방이 나갔습니다. 종료하려면 \"" + EXIT + "\" 입력]");
				//한쪽이 닫으면 닫기위해 일부러 예외 발생
			}
			System.out.println("[상대방이 나갔습니다. 종료하려면 \"" + EXIT + "\" 입력]");

		});
		t2.start();
	}

	public void send() {

		//Thread t1 = new Thread(()->{		
			Scanner scan = new Scanner(System.in);

			try {
				ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());

				System.out.println("[채팅을 시작합니다.]");
				System.out.println("[종료하려면 " + EXIT + " 입력]");
				
				
				while(true) {
					
					if(socket == null || socket.isClosed()) throw new SocketException();
					//null 일때 빠져나가게
					
					String str = scan.nextLine();
					//문자열이 아닌 chat의 객체 전송

					Chat chat = new Chat(id, str);
					oos.writeObject(chat);
					oos.flush();  

					if(str.equals(EXIT))break;		
					//채팅 기록에 추가
					
				}

			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				System.out.println("[채팅을 종료합니다.]");
			}

		//});
		//t1.start();

	}


	public void run() {


		//send와 receive를 이용해 호출
		//밖에서 하면 종료되는 순간 다시 시작

		//둘중 하나의 쓰레드를 제거(밑에 있는 쪽)
		//why? 제거 안하면 두 메소드가 쓰레드로 실행되기 때문에(콘솔창이 하나뿐) run메소드가 종료되면
		//메인 메뉴로 채팅이 끝나지 않은 상태에서 종료되기 때문


		receive();		
		send();

		 /* send();
		 *  receive();
		 * //순서라면 센드쪽 쓰레드를 지워야
		 * //->  but 리시브를 먼저 해야 입력받은 menu 넘어오는걸 막을수있어서
		 */
	}



}
