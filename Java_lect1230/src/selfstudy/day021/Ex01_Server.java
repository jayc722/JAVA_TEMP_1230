package selfstudy.day021;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;


public class Ex01_Server {

	public static void main(String[] args) {
		
		int port = 5003;
		
		ServerSocket serverSocket;
		
		
		try {
			serverSocket = new ServerSocket(port);
		}catch (Exception e) {
			System.out.println("[예외가 발생하여 서버가 종료됩니다.]");
			e.printStackTrace();
			return;
		}
		//List<Account> list = new ArrayList<Account>();   //기본생성자로 해서 처음 생성해도 다른 클라이언트가 공유받을수있게
		List<Account> list;
		
		String fileName = "src/selfstudy/day021/data.txt";
		list = (List<Account>) load(fileName);		//형변환
		if(list == null) list = new ArrayList<Account>();
		while(true) {			//여러명 처리 가능하게
			save(fileName,list);			//클라이언트 접속 될때마다 기존데이터 저장(서버는 원래 꺼지는일이 없음)
		//클라이언트와 연결
		Socket socket;
		try {
			socket = serverSocket.accept();
			System.out.println("[클라이언트와 연결되었습니다.]");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("[예외가 발생하여 클라이언트와 연결을 종료합니다.]");
			e.printStackTrace();
			continue;// 조건식으로 ->run 건너뜀
		}
		
		//서버를 실행
		Server server = new Server(socket,list);
		server.run();
		}
	}

	//세이브로드 day014post에서 그대로 가져옮 -> 탬플릿 만들어둬서 그대로 가져와도됨
	private static Object load(String fileName) {

		try(FileInputStream fis = new FileInputStream(fileName);
			ObjectInputStream ois = new ObjectInputStream(fis)){
			return ois.readObject();
		} catch (Exception e) {
			System.out.println("-------------------");
			System.out.println("불러오기 실패");
			System.out.println("-------------------");
			e.printStackTrace();
		}
		return null;
	}

	
	private static void save(String fileName, Object obj) {
		try(FileOutputStream fos = new FileOutputStream(fileName);
			ObjectOutputStream oos = new ObjectOutputStream(fos)){
			oos.writeObject(obj);
		} catch (Exception e) {
			System.out.println("-----------------");
			System.out.println("저장하기 실패");
			System.out.println("-----------------");
			e.printStackTrace();
		}
	}


}
