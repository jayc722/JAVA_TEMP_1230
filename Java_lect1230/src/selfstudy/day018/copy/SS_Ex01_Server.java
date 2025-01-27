package selfstudy.day018.copy;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class SS_Ex01_Server {

	static List<Bank> list = new ArrayList<Bank>() ;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int port = 5002;

		try {
			ServerSocket serverSocket = new ServerSocket(port);

			while(true) {			//여러번 접속해도 되게 
				Socket socket = serverSocket.accept();
				Thread t = new Thread(()->{
					try {
						ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
						ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());			
						System.out.println("[연결 성공!]");



						while(true) {

							//메뉴를 입력받음(클라이언트에게) -> 
							int menu = ois.readInt();
							//메뉴에 따라 기능을 실행
							runMenu(menu, ois, oos);
						}
					}catch (Exception e) {
						System.out.println("[연결 해제]");
					}
				});
				t.start();
			}
		}catch (Exception e) {
			e.printStackTrace();		
		}

	}
	private static void runMenu(int menu, ObjectInputStream ois, ObjectOutputStream oos) {
		switch(menu) {
		case 0 :
			connect(ois, oos);
			System.out.println("접속");
			break;
		case 10 :
			newAcc(ois, oos);
			System.out.println("생성");
			break;
		}

	}
	private static void newAcc(ObjectInputStream ois, ObjectOutputStream oos) {
		while(true) {
		
		try {
			Bank bankInput = (Bank) ois.readObject();
			
			if(bankInput == null|| list.contains(bankInput)) {
				oos.writeBoolean(false);
				oos.flush();
				
			}
			else {
				list.add(bankInput);
				oos.writeBoolean(true);
				oos.flush();
				break;
			}
			
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		}
	}
	
	
	
	
	private static void connect(ObjectInputStream ois, ObjectOutputStream oos) {
		
		try {
			Bank bankInput = (Bank) ois.readObject();
			
			
			
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	
	
	
	
}