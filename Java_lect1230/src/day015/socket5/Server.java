package day015.socket5;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Server {
	
	private List<Student> list;
	private Socket socket;
	
	//클라이언트 -> 서버에 기능 요청 -> 그에 맞게 서버가 동작
	public void run() {				
		Thread t = new Thread(() -> {
			try {
				ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
				ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
				
				//클라이언트가 메뉴를 보내면 서버는 메뉴를 수신
				
				int menu = ois.readInt();
				
				do {
				runMenu(menu, ois, oos);
				
				}while(menu != 5);
				
				//수신한 메뉴에 따라 작업이 달라지게 작성
				
			} catch (IOException e) {
				System.out.println("[클라이언트 연결 실페]");
				e.printStackTrace();
			}
			
			
		});
		t.start();
	}

	private synchronized void runMenu(int menu, ObjectInputStream ois, ObjectOutputStream oos) {	//동기화

		switch(menu) {
		case 1 : 
			insert(ois, oos);
			break;
		case 2 : 
			update();
			break;
		case 3 : 
			delete();
			break;
		case 4 : 
			search();
			break;
		default :
				



		}

	}

	private void search() {
		// TODO Auto-generated method stub
		
	}

	private void delete() {
		// TODO Auto-generated method stub
		
	}

	private void update() {
		// TODO Auto-generated method stub
		
	}

	private void insert(ObjectInputStream ois, ObjectOutputStream oos) {
		
		try {
			//클라이언트가 학생 정보를 보내줌
			Student std = (Student)ois.readObject();
			
			boolean res = true;
			//중복확인을 해서 있는 학생 정보면 클라이언트에게 false 전송
			if(list.contains(std)) res = false;
						
			//없으면 리스트에 추가 후 클라이언트에게 true 전송
			else list.add(std);
			
			oos.writeBoolean(res);
			oos.flush();
			
			
			System.out.println(list);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}


}
